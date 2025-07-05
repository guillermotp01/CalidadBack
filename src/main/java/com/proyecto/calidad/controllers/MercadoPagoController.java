package com.proyecto.calidad.controllers;

import com.proyecto.calidad.models.DTO.CompraGeneral;
import com.proyecto.calidad.services.MercadoPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.mercadopago.resources.preference.Preference;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/mercadoPago")
@CrossOrigin("*")
public class MercadoPagoController {

    @Autowired
    private MercadoPagoService mercadoPagoService;

    @PostMapping("/crear-preferencia")
    public ResponseEntity<Map<String, String>> crearPreferencia(@RequestBody CompraGeneral compra) {
        Preference preference = mercadoPagoService.crearPreferencia(compra);

        if (preference == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "No se pudo crear la preferencia"));
        }

        Map<String, String> response = new HashMap<>();
        response.put("id", preference.getId());
        response.put("initPoint", preference.getInitPoint());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/notificacion-pago")
    public String recibirNotificacionPago(@RequestParam String payment_id,
                                          @RequestParam String status,
                                          @RequestParam String external_reference,
                                          @RequestParam String merchant_order_id) {
        // Lógica para manejar la notificación del estado del pago
        System.out.println("Pago recibido: " + payment_id);
        System.out.println("Estado del pago: " + status);
        // Procesar la notificación y redirigir al cliente si es necesario
        return "Pago procesado correctamente";
    }
}
