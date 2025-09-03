package org.practice.models;

import lombok.Data;

@Data
public class Order {
    private Long petId;
    private Integer quantity;
    private Long id;
    private String shipDate;
    private boolean complete;
    private String status;
}
