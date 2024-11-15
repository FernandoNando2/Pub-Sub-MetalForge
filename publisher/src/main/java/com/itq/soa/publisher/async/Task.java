package com.itq.soa.publisher.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.itq.soa.publisher.dto.Hub;
import com.itq.soa.publisher.dto.PurchaseRequest;
import com.itq.soa.publisher.service.Publisher;

import java.util.List;

@Component
public class Task {

    @Autowired
    private Publisher publisher;

    private final RestTemplate restTemplate = new RestTemplate();

    public void sendResponse() {
        // Recuperar suscriptores registrados
        List<Hub> subscribers = publisher.getSubscribers();

        // Simulación de envío de respuestas a cada suscriptor
        for (Hub subscriber : subscribers) {
            String callbackUrl = subscriber.getCallback();
            PurchaseRequest response = new PurchaseRequest();
            response.setProvider("Steel Supplier");
            response.setSteelQuality("A36");
            response.setTons(50);
            response.setPrice(5000);
            response.setUrgent(false);

            try {
                restTemplate.postForObject(callbackUrl, response, PurchaseRequest.class);
                System.out.println("Response sent to: " + callbackUrl);
            } catch (Exception e) {
                System.out.println("Failed to send response to: " + callbackUrl);
            }
        }
    }
}
