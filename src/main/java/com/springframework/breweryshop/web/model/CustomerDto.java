package com.springframework.breweryshop.web.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Customer DTO from model.
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDto {


    private UUID uuid;

    @NotBlank
    @Size(min = 3, message = "{validation.name.size.too_short}")
    @Size(max = 100, message = "{validation.name.size.too_long}")
    private String name;
}
