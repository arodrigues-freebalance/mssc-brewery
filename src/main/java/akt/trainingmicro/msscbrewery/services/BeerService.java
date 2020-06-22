package akt.trainingmicro.msscbrewery.services;

import java.util.UUID;

import akt.trainingmicro.msscbrewery.web.model.BeerDto;

public interface BeerService {

    BeerDto getBeerById(UUID beerId);

    BeerDto saveNewBeer(BeerDto beerDto);

    void updateBeer(UUID beerId, BeerDto beerDto);

    void deleteById(UUID beerId);	
	
}
