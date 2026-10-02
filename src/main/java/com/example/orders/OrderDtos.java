package com.example.orders;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public final class OrderDtos {
    private OrderDtos() { }

    public record CreateOrderRequest(
            @NotBlank String customerId,
            @NotNull @Positive BigDecimal amount) { }

    public record OrderResponse(
            UUID id, String customerId, BigDecimal amount, OrderStatus status, Instant createdAt) {
        static OrderResponse from(Order o) {
            return new OrderResponse(o.getId(), o.getCustomerId(), o.getAmount(), o.getStatus(), o.getCreatedAt());
        }
    }
}
