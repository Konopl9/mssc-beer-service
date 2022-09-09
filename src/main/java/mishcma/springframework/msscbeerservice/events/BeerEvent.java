package mishcma.springframework.msscbeerservice.events;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import mishcma.springframework.msscbeerservice.web.model.BeerDto;

import java.io.Serializable;

@Data
@RequiredArgsConstructor
@Builder
public class BeerEvent implements Serializable {

    private static long serialVersionUID = 6909785319790012208L;

    private final BeerDto beerDto;
}
