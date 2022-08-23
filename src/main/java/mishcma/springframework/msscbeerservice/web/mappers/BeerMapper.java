package mishcma.springframework.msscbeerservice.web.mappers;

import mishcma.springframework.msscbeerservice.domain.Beer;
import mishcma.springframework.msscbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = DateMapper.class)
public interface BeerMapper {

    BeerDto BeerToBeerDto(Beer beer);

    Beer BeerDtoToBeer(BeerDto beerDto);
}
