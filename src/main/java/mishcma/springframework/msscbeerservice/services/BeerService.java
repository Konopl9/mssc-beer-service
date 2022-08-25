package mishcma.springframework.msscbeerservice.services;

import mishcma.springframework.msscbeerservice.web.model.BeerDto;
import mishcma.springframework.msscbeerservice.web.model.BeerPagedList;
import mishcma.springframework.msscbeerservice.web.model.BeerStyleEnum;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface BeerService {
    BeerDto getById(UUID beerId, Boolean showInventoryOnHand);

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID beerId, BeerDto beerDto);

    BeerPagedList listBeers(String beerName, BeerStyleEnum beerStyle, PageRequest of, Boolean showInventoryOnHand);

    BeerDto getByUpc(String upc);
}
