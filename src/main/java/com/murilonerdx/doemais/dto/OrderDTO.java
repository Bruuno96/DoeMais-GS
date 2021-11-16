package com.murilonerdx.doemais.dto;

import java.time.LocalDateTime;

import com.murilonerdx.doemais.entities.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Long id;
    private LocalDateTime moment;

    ProductDTO product;

    public OrderDTO(Order entity) {
        id = entity.getId();
        moment = entity.getMoment();
    }

}


