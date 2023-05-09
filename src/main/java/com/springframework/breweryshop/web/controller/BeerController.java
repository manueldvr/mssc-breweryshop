package com.springframework.breweryshop.web.controller;

import com.springframework.breweryshop.web.model.BeerDto;
import com.springframework.breweryshop.web.services.BeerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Beer Controller class.
 * Use BeerService as service layer.
 * @version 1
 */
@RequestMapping("api/v1/beer")
@RestController
public class BeerController {

    private final BeerService beerService;


    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    /**
     * Get beer id method. Path and name arguments mapping is redundant in this case.
     * path example: "api/v1/beer/345"
     * @param beerId
     * @return BeerDto
     */
    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId) {
        return new ResponseEntity<BeerDto>(this.beerService.getBeerById(beerId), HttpStatus.OK);
    }

    /**
     *  Handle post to create a new Beer.
     * TODO: 09/05/2023 add hostname to URL.
     * @param beerDto
     * @return
     */
    @PostMapping
    public ResponseEntity handlePost(BeerDto beerDto) {
        BeerDto savedBeer = this.beerService.saveNewBeer(beerDto);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "api/v1/beer" + savedBeer.getId().toString());
        return  new ResponseEntity<BeerDto>(headers, HttpStatus.CREATED);
    }
}
