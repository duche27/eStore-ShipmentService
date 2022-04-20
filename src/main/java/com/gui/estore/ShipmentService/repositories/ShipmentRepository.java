package com.gui.estore.ShipmentService.repositories;


import com.gui.estore.ShipmentService.model.ShipmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShipmentRepository extends JpaRepository<ShipmentEntity, String> {

    Optional<ShipmentEntity> findByOrderId(String shipmentId);
}
