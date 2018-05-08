import { Component, OnInit, Input } from '@angular/core';
import { FormControl, FormGroup, Validator } from '@angular/forms';
import { Observable } from 'rxjs/Observable';
import { startWith, map, debounceTime, distinctUntilChanged, switchMap } from 'rxjs/operators';

import { CountryService } from './country.service';
import { Country } from './country';

@Component({
  selector: 'app-country-selector',
  templateUrl: './country-selector.component.html',
  styleUrls: ['./country-selector.component.css']
})
export class CountrySelectorComponent implements OnInit {

  @Input() country: Country;

  countryCtrl = new FormControl();
  filteredCountries: Observable<Country[]>;
  countries: Observable<Country[]>;

  constructor(private countryService: CountryService) {

    if (this.country) {
      this.countryCtrl.setValue(this.country.name);
    }

    this.countries = this.countryService.getCountries();

    this.filteredCountries = this.countryCtrl.valueChanges
      .pipe(
        startWith<string | Country>(''),
        debounceTime(200),
        distinctUntilChanged(),
        map(value => typeof value === 'string' ? value : value.name),
        switchMap(name => this.filter(name || ''))
      );
  }

  ngOnInit() {
  }

  filter(name: string): Observable<Country[]> {
    return this.countries.pipe(map(response => response.filter(country =>
      country.name.toLowerCase().indexOf(name.toLowerCase()) === 0)
    ));
  }

  getCountryName(country?: Country): string | undefined {
    return country ? country.name : undefined;
  }

  setCountry(country: Country) {
    this.countryCtrl.setValue(country);
  }

  getCountry(): Country {
    return this.countryCtrl.value;
  }

}
