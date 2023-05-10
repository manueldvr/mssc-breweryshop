package com.springframework.breweryshop.web.model.v2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Beer DTO, new version for API DTO. Change to the model
 * @version 2
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDtoV2 {

    private UUID id;

    private String beerName;

    private BeerStyle beerStyle;

    private Long upc;
}
