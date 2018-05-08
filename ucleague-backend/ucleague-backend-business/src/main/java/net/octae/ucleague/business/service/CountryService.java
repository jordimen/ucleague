package net.octae.ucleague.business.service;

import net.octae.ucleague.domain.Country;

/**
 * The interface Country service.
 */
public interface CountryService {

    /**
     * Gets countries.
     *
     * @return the countries
     */
    Iterable<Country> getCountries();

}
