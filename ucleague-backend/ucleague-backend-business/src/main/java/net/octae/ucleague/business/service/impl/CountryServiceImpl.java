package net.octae.ucleague.business.service.impl;

import net.octae.ucleague.business.service.CountryService;
import net.octae.ucleague.business.service.util.EntityConverter;
import net.octae.ucleague.domain.Country;
import net.octae.ucleague.persistence.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Country service.
 */
@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private EntityConverter entityConverter;

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public Iterable<Country> getCountries() {
        return entityConverter.convert(countryRepository.findAllByOrderByNameAsc(), Country.class);
    }

}
