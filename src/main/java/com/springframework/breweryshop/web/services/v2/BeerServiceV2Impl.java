package com.springframework.breweryshop.web.services.v2;

import com.springframework.breweryshop.web.model.v2.BeerDtoV2;

import java.util.UUID;

public class BeerServiceV2Impl implements BeerServiceV2{
    /**
     * @param beerId
     * @return
     */
    @Override
    public BeerDtoV2 getBeerById(UUID beerId) {
        return null;
    }

    /**
     * @param beerDto
     * @return
     */
    @Override
    public BeerDtoV2 saveNewBeer(BeerDtoV2 beerDto) {
        return null;
    }

    /**
     * @param beerId
     * @param beerDto
     */
    @Override
    public void updateBeer(UUID beerId, BeerDtoV2 beerDto) {

    }

    /**
     * @param beerId
     */
    @Override
    public void deleteById(UUID beerId) {

    }
}
