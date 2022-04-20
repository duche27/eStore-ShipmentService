package com.gui.estore.ShipmentService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "shipments", schema = "public")
public class ShipmentEntity {

    @Id
    @Column(unique = true)
    public String shipmentId;
    public String orderId;
    public String shipmentStatus;
}
