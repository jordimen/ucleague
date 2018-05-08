package net.octae.ucleague.ws.controller;

import net.octae.ucleague.business.service.CountryService;
import net.octae.ucleague.business.service.util.EntityConverter;
import net.octae.ucleague.ws.dto.CountryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Country controller.
 */
@RestController
@RequestMapping(path = "/country")
public class CountryController {

    @Autowired
    private EntityConverter entityConverter;

    @Autowired
    private CountryService countryService;

    /**
     * Gets countries.
     *
     * @return the countries
     */
    @GetMapping
    public Iterable<CountryDTO> getCountries() {
        return entityConverter.convert(countryService.getCountries(), CountryDTO.class);
    }

}
