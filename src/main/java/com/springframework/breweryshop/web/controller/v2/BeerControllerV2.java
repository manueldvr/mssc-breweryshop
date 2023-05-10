package com.springframework.breweryshop.web.controller.v2;

import com.springframework.breweryshop.web.model.v2.BeerDtoV2;
import com.springframework.breweryshop.web.services.v2.BeerServiceV2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 *
 */
@RequestMapping("api/v2/beer")
@RestController
public class BeerControllerV2 {

    private final BeerServiceV2 beerServiceV2;


    public BeerControllerV2(BeerServiceV2 beerService) {
        this.beerServiceV2 = beerService;
    }

    /**
     * Get beer id method. Path and name arguments mapping is redundant in this case.
     * path example: "api/v1/beer/345"
     * @param beerId
     * @return BeerDto
     */
    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDtoV2> getBeer(@PathVariable("beerId") UUID beerId) {
        return new ResponseEntity<BeerDtoV2>(this.beerServiceV2.getBeerById(beerId), HttpStatus.OK);
    }

    /**
     *  Handle post to create a new Beer.
     * TODO: 09/05/2023 add hostname to URL.
     * @param beerDto
     * @return
     */
    @PostMapping
    public ResponseEntity handlePost(@RequestBody BeerDtoV2 beerDto) {
        BeerDtoV2 savedBeer = this.beerServiceV2.saveNewBeer(beerDto);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "api/v1/beer/" + savedBeer.getId().toString());
        return  new ResponseEntity<BeerDtoV2>(headers, HttpStatus.CREATED);
    }

    /**
     * Handle update by id with a request body.
     * @param beerId
     * @param
     * @return No Content (204), accepted, nothing wrong.
     */
    @PutMapping("/{beerId}")
    public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId, @RequestBody BeerDtoV2 beerDto){
        this.beerServiceV2.updateBeer(beerId, beerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    /**
     * Delete beer by id
     * @param
     */
    @DeleteMapping({"/beerdId"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID beerId) {
        this.beerServiceV2.deleteById(beerId);
    }
}
