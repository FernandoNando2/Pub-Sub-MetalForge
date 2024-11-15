package com.itq.soa.publisher.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.itq.soa.publisher.dto.Ack;
import com.itq.soa.publisher.dto.Hub;
import com.itq.soa.publisher.dto.PurchaseRequest;
import com.itq.soa.publisher.async.ResponseThread;
import com.itq.soa.publisher.async.Task;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/publisher")
public class Publisher {

    private final List<Hub> subscribers = new ArrayList<>();

    @Autowired
    private Task task;

    // Endpoint de registro de suscripción
    @PostMapping("/hub")
    public Ack registerSubscriber(@RequestBody Hub hub) {
        subscribers.add(hub);
        Ack ack = new Ack();
        ack.setCode(200);
        ack.setDescription("Subscriber registered successfully");
        return ack;
    }

    // Endpoint para solicitudes de compra
    @PostMapping("/PurchaseRequest")
    public Ack createPurchaseRequest(@RequestBody PurchaseRequest purchaseRequest) {
        // Procesamiento básico de la solicitud
        System.out.println("Received Purchase Request: " + purchaseRequest);

        // Simulación de respuesta asincrónica
        ResponseThread responseThread = new ResponseThread(task);
        responseThread.start();

        Ack ack = new Ack();
        ack.setCode(200);
        ack.setDescription("Purchase request received and being processed");
        return ack;
    }

    // Método para obtener todos los suscriptores (opcional para depuración)
    public List<Hub> getSubscribers() {
        return subscribers;
    }
}
