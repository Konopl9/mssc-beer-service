package guru.sfg.common.events;

import lombok.NoArgsConstructor;
import mishcma.springframework.msscbeerservice.web.model.BeerDto;

@NoArgsConstructor
public class NewInventoryEvent extends BeerEvent {

    public NewInventoryEvent(BeerDto beerDto) {
        super(beerDto);
    }
}
