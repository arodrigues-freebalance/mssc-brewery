package akr.trainingmicro.msscbrewery.web.controller.v2;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import akr.trainingmicro.msscbrewery.services.V2.BeerServiceV2;
import akr.trainingmicro.msscbrewery.web.model.v2.BeerDtoV2;


@Validated
@RequestMapping("/api/v2/beer")
@RestController
public class BeerControllerV2 {

    private final BeerServiceV2 beerServiceV2;

    public BeerControllerV2(BeerServiceV2 beerServiceV2) {
        this.beerServiceV2 = beerServiceV2;
    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDtoV2> getBeer(@NotNull @PathVariable("beerId") UUID beerId){

        return new ResponseEntity<>(beerServiceV2.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping // POST - create new beer
    public ResponseEntity<BeerDtoV2> handlePost(@NotNull @RequestBody BeerDtoV2 beerDtoV2){

        BeerDtoV2 savedDto = beerServiceV2.saveNewBeer(beerDtoV2);

        HttpHeaders headers = new HttpHeaders();
        //todo add hostname to url
        headers.add("Location", "/api/v2/beer/" + savedDto.getId().toString());

        return new ResponseEntity<BeerDtoV2>(headers, HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"})
    public ResponseEntity<BeerDtoV2> handleUpdate(@PathVariable("beerId") UUID beerId,@Valid @RequestBody BeerDtoV2 beerDtoV2){

        beerServiceV2.updateBeer(beerId, beerDtoV2);

        return new ResponseEntity<BeerDtoV2>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID beerId){
        beerServiceV2.deleteById(beerId);
    }

} 