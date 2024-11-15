package com.itq.soa.suscriber.service;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itq.soa.suscriber.dto.Ack;
import com.itq.soa.suscriber.dto.PurchaseRequest;

@RestController
public class Suscriber {

    @PostMapping(value = "/listener/responsePurchase")
    public Ack getRespondePurchase(@RequestBody PurchaseRequest request) {
        System.out.println("Received purchase response: " + request);

        // Procesar la respuesta aquí
        Ack ack = new Ack();
        ack.setCode(200);
        ack.setDescription("Response processed successfully");
        return ack;
    }
}
