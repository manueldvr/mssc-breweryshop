package com.springframework.breweryshop.web.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.UUID;


/**
 * Beer DTO
 * @see lombok.Lombok
 * @see javax validation constraints - Bean Validation.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {

    @Null
    private UUID id;

    /**The annotated element must not be null and must contain at least one non-whitespace character.*/
    @NotBlank
    private String beerName;

    @NotBlank
    private String beerStyle;

    @Positive
    private Long upc;

    private OffsetDateTime createDate;

    private OffsetDateTime lastUpdatedDate;
}
