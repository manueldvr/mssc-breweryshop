package com.springframework.breweryshop.web.domain;

import com.springframework.breweryshop.web.model.v2.BeerStyle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;


/**
 * Beer entity of the persistence tier.
 * */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Beer {


    private UUID id;

    private String beerName;

    private BeerStyle beerStyle;

    private Long upc;

    private Timestamp createDate;
    private Timestamp lastUpdatedDate;

}
