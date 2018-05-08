import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ReactiveFormsModule } from '@angular/forms';

import { MaterialModule } from '../material/material.module';

import { CountrySelectorComponent } from './country-selector/country-selector.component';
import { CountryService } from './country-selector/country.service';

@NgModule({
  imports: [
    MaterialModule,
    ReactiveFormsModule,
    CommonModule
  ],
  exports: [
    CountrySelectorComponent
  ],
  declarations: [CountrySelectorComponent],
  providers: [
    CountryService
  ]
})
export class CommonComponentsModule { }
