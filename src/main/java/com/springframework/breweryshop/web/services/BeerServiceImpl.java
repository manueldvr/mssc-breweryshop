package com.springframework.breweryshop.web.services;

import com.springframework.breweryshop.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * BeerService Implementation of BeerService.
 * @version 1
 */
@Service
public class BeerServiceImpl implements BeerService{

    /**
     * Get
     * @param beerId
     * @return
     */
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder().id(UUID.randomUUID()).beerName("Galaxy Cat").beerStyle("Pale Ale").upc(1l).build();
    }

    /**
     * Save new Beer
     * @param beerDto
     * @return new beer
     */
    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return BeerDto.builder().id(UUID.randomUUID()).beerName("Bud").beerStyle("Blonde").upc(2L).build();
    }

    /**
     * Update Beer
     *
     * @param beerId
     * @param beerDto
     */
    @Override
    public void updateBeer(UUID beerId, BeerDto beerDto) {
        //todo impl:
    }
}
