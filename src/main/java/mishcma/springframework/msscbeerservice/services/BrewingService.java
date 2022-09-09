package mishcma.springframework.msscbeerservice.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mishcma.springframework.msscbeerservice.config.JMSConfig;
import mishcma.springframework.msscbeerservice.domain.Beer;
import mishcma.springframework.msscbeerservice.events.BrewBeerEvent;
import mishcma.springframework.msscbeerservice.repositories.BeerRepository;
import mishcma.springframework.msscbeerservice.services.inventory.BeerInventoryService;
import mishcma.springframework.msscbeerservice.web.mappers.BeerMapper;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BrewingService {

    private final BeerRepository beerRepository;
    private final BeerInventoryService beerInventoryService;
    private JmsTemplate jmsTemplate;
    private BeerMapper beerMapper;

    @Scheduled(fixedRate = 5000)
    public void checkForLorEmpty() {
        List<Beer> beers = beerRepository.findAll();

        beers.forEach(beer -> {
            Integer invQOH = beerInventoryService.getOnhandInventory(beer.getId());
            log.debug("Min Onhand is: " + beer.getMinOnHand());
            log.debug("Inventory is: " + invQOH);

            if (beer.getMinOnHand() >= invQOH) {
                jmsTemplate.convertAndSend(JMSConfig.BREWING_REQUEST_QUEUE, new BrewBeerEvent(beerMapper.beerToBeerDto(beer)));
            }
        });
    }
}
