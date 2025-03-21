package com.getrosoft.courier.tracking_idgen.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TrackingIdGenRequestData {

    @NotNull(message = "Origin country ID is required.")
    @Pattern(regexp = "^[A-Z]{2}$", message = "Origin country ID must be a valid ISO 3166-1 alpha-2 code.")
    private String originCountryId;

    @NotNull(message = "Destination country ID is required.")
    @Pattern(regexp = "^[A-Z]{2}$", message = "Destination country ID must be a valid ISO 3166-1 alpha-2 code.")
    private String destinationCountryId;

    @NotNull(message = "Weight is required.")
    @DecimalMin(value = "0.001", message = "Weight must be greater than 0.")
    @Digits(integer = 10, fraction = 3, message = "Weight must have up to three decimal places.")
    private Double weight;

    @NotNull(message = "Created at timestamp is required.")
    private OffsetDateTime createdAt;

    @NotNull(message = "Customer ID is required.")
    private UUID customerId;

    @NotBlank(message = "Customer name is required.")
    @Size(max = 100, message = "Customer name cannot exceed 100 characters.")
    private String customerName;

    @NotBlank(message = "Customer slug is required.")
    @Pattern(regexp = "^[a-z0-9]+(-[a-z0-9]+)*$", message = "Customer slug must be in kebab-case.")
    private String customerSlug;
}



