package com.springframework.breweryshop.web.services;

import com.springframework.breweryshop.web.model.BeerDto;
import java.util.UUID;

public interface BeerService {

    BeerDto getBeerById(UUID beerId);

    BeerDto saveNewBeer(BeerDto beerDto);
}
