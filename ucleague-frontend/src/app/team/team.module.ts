import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from '../app-routing.module';
import { ReactiveFormsModule } from '@angular/forms';

import { MaterialModule } from '../material/material.module';

import { CommonComponentsModule } from '../common-components/common-components.module';

import { TeamListComponent } from './team-list/team-list.component';
import { TeamService } from './team.service';
import { TeamFormComponent } from './team-form/team-form.component';

@NgModule({
  imports: [
    CommonModule,
    MaterialModule,
    HttpClientModule,
    AppRoutingModule,
    ReactiveFormsModule,
    CommonComponentsModule
  ],
  declarations: [
    TeamListComponent,
    TeamFormComponent
  ],
  providers: [
    TeamService
  ]
})
export class TeamModule { }
