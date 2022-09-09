package guru.sfg.common.events;

import lombok.*;
import mishcma.springframework.msscbeerservice.web.model.BeerDto;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class BeerEvent implements Serializable {

    private static long serialVersionUID = 6909785319790012208L;

    private BeerDto beerDto;
}
