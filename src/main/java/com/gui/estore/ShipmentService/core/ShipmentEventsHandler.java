package com.gui.estore.ShipmentService.core;

import com.gui.estore.ShipmentService.model.ShipmentEntity;
import com.gui.estore.ShipmentService.repositories.ShipmentRepository;
import com.gui.estore.core.events.OrderShippedEvent;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.messaging.interceptors.ExceptionHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ShipmentEventsHandler {

    ShipmentRepository shipmentRepository;

    public ShipmentEventsHandler(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    @EventHandler
    public void on(OrderShippedEvent event) {

        ShipmentEntity shipmentEntity = new ShipmentEntity();

        BeanUtils.copyProperties(event, shipmentEntity);

        try {
            shipmentRepository.save(shipmentEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // lanza la excepción controlada si no persiste shipmentEntity
    // sin persistir nada, es transaccional
    @ExceptionHandler(resultType = Exception.class)
    private void handle(Exception exception) throws Exception {
        throw exception;
    }

    @ExceptionHandler(resultType = IllegalArgumentException.class)
    private void handle(IllegalArgumentException exception) throws IllegalArgumentException {
//        throw IllegalArgumentException;
    }
}
