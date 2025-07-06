package com.proyecto.calidad.services;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;

import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.preference.*;
import com.proyecto.calidad.models.DTO.CompraGeneral;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.preference.Preference;

@Service
public class MercadoPagoService {

    public MercadoPagoService(@Value("${mercadopago.access-token}") String accessToken) {
        // Configura Mercado Pago apenas se construye el servicio
        MercadoPagoConfig.setAccessToken(accessToken);
    }
    public Preference crearPreferencia(CompraGeneral compra) {
        try {
            // Calcular el precio unitario
            BigDecimal precioUnitario = BigDecimal.valueOf(compra.precioTotal() / compra.cantidadBoletos())
                    .setScale(2, RoundingMode.HALF_UP); // Redondeo correcto

            if (precioUnitario.compareTo(BigDecimal.ZERO) <= 0) {
                throw new IllegalArgumentException("El precio unitario debe ser mayor que cero.");
            }

            if (compra.cantidadBoletos() <= 0) {
                throw new IllegalArgumentException("La cantidad de boletos debe ser mayor que cero.");
            }

            PreferencePayerRequest payer = PreferencePayerRequest.builder()
                    .email(compra.email())  // usa el nuevo campo
                    .build();

            // Crear el ítem de la preferencia
            PreferenceItemRequest itemRequest = PreferenceItemRequest.builder()
                    .title(compra.nombre()) // Nombre del producto/servicio
                    .description(compra.descripcion()) // Descripción de la compra
                    .quantity(compra.cantidadBoletos()) // Cantidad de boletos
                    .currencyId("PEN") // Moneda
                    .unitPrice(precioUnitario) // Precio unitario
                    .build();

            // Configurar las URLs de retorno
            PreferenceBackUrlsRequest backUrls = PreferenceBackUrlsRequest.builder()
                    .success("https://ecommerce-pi-five.vercel.app/misCompras/success")  // cambiar la url pero no puede ser local
                    .pending("https://ecommerce-pi-five.vercel.app/misCompras/pending")
                    .failure("https://ecommerce-pi-five.vercel.app/misCompras/failure")
                    .build();

            // Crear la preferencia
            PreferenceRequest preferenceRequest = PreferenceRequest.builder()
                    .items(Collections.singletonList(itemRequest))
                    .backUrls(backUrls)
                    .payer(payer)
                    .build();

            // Crear cliente de preferencia
            PreferenceClient client = new PreferenceClient();

            // Crear la preferencia en Mercado Pago
            return client.create(preferenceRequest);

        } catch (MPApiException e) {
            System.out.println("API Error al crear la preferencia:");
            System.out.println("Status: " + e.getStatusCode());
            System.out.println("Content: " + e.getApiResponse().getContent()); // <--- esto es lo importante
            e.printStackTrace();
            return null;
        } catch (MPException e) {
            System.out.println("MPException general:");
            e.printStackTrace();
            return null;
        }
    }
}