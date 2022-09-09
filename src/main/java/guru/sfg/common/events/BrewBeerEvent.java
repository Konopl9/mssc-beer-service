package guru.sfg.common.events;

import lombok.NoArgsConstructor;
import mishcma.springframework.msscbeerservice.web.model.BeerDto;

@NoArgsConstructor
public class BrewBeerEvent extends BeerEvent {

    public BrewBeerEvent(BeerDto beerDto) {
        super(beerDto);
    }
}
