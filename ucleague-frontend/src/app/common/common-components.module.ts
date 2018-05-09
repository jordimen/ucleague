import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ReactiveFormsModule } from '@angular/forms';

import { MaterialModule } from '../material/material.module';

import { CountrySelectorComponent } from './component/country-selector/country-selector.component';
import { CountryService } from './country.service';
import { NotificationPanelComponent } from './component/notification-panel/notification-panel.component';
import { ErrorService } from './error.service';

@NgModule({
  imports: [
    MaterialModule,
    ReactiveFormsModule,
    CommonModule
  ],
  exports: [
    CountrySelectorComponent,
    NotificationPanelComponent
  ],
  declarations: [
    CountrySelectorComponent,
    NotificationPanelComponent
  ],
  providers: [
    CountryService,
    ErrorService
  ]
})
export class CommonComponentsModule { }
