package akr.trainingmicro.msscbrewery.web.mappers;

import org.mapstruct.Mapper;

import akr.trainingmicro.msscbrewery.domain.Beer;
import akr.trainingmicro.msscbrewery.web.model.BeerDto;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

	BeerDto beerToBeerDto(Beer beer);
	
	Beer beerDtoToBeer(BeerDto beerDto);
	
}
