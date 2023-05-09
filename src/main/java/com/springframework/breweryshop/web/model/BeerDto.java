package com.springframework.breweryshop.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


/**
 * Beer DTO
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {

    private UUID id;

    private String beerName;

    private String beerStyle;

    private Long upc;
}
