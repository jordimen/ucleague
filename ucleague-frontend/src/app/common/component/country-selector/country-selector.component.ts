import { Component, OnInit, Input, EventEmitter, Output, OnChanges, SimpleChanges } from '@angular/core';
import { FormControl, FormGroup, Validator } from '@angular/forms';
import { Observable } from 'rxjs/Observable';
import { startWith, map, debounceTime, distinctUntilChanged, switchMap, filter } from 'rxjs/operators';

import { CountryService } from '../..//country.service';
import { Country } from '../../country';

@Component({
  selector: 'ucleague-country-selector',
  templateUrl: './country-selector.component.html',
  styleUrls: ['./country-selector.component.css']
})
export class CountrySelectorComponent implements OnInit, OnChanges {

  @Input() country: Country;
  @Output() countrySelected: EventEmitter<Country> = new EventEmitter<Country>();

  countrySelectorCtrl = new FormControl();
  filteredCountries: Observable<Country[]>;
  countries: Observable<Country[]>;

  constructor(private countryService: CountryService) {

    if (this.country) {
      this.countrySelectorCtrl.setValue(this.country.name);
    }

    this.countries = this.countryService.getCountries();

    this.filteredCountries = this.countrySelectorCtrl.valueChanges
      .pipe(
        startWith<string | Country>(''),
        debounceTime(200),
        distinctUntilChanged(),
        filter(value => value !== null),
        map(value => typeof value === 'string' ? value : value.name),
        switchMap(name => this.filter(name || ''))
      );
  }

  ngOnInit() {
  }

  ngOnChanges(changes: SimpleChanges) {
    this.countrySelectorCtrl.setValue(changes.country.currentValue);
  }

  filter(name: string): Observable<Country[]> {
    return this.countries.pipe(map(response => response.filter(country =>
      country.name.toLowerCase().indexOf(name.toLowerCase()) === 0)
    ));
  }

  getCountryName(country?: Country): string | undefined {
    return country ? country.name : undefined;
  }

  selectCountry(country: Country) {
    this.country = country;
    this.countrySelected.emit(country);
  }

}
