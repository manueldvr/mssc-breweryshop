package com.springframework.breweryshop.web.mappers;

import com.springframework.breweryshop.web.domain.Beer;
import com.springframework.breweryshop.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDto BeerToBeerDto(Beer aBeer);

    Beer BeerDtoToBeer(BeerDto aBeerDto);
}
