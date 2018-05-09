import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from '../app-routing.module';
import { ReactiveFormsModule } from '@angular/forms';

import { MaterialModule } from '../material/material.module';

import { CommonComponentsModule } from '../common/common-components.module';

import { TeamListComponent } from './team-list/team-list.component';
import { TeamService } from './team.service';
import { TeamFormComponent } from './team-form/team-form.component';
import { TeamSelectorComponent } from './component/team-selector/team-selector.component';
import { TeamChampionshipsDetailComponent } from './view/team-championships-detail/team-championships-detail.component';
import { TeamChampionshipsSelectorComponent } from './component/team-championships-selector/team-championships-selector.component';

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
    TeamFormComponent,
    TeamSelectorComponent,
    TeamChampionshipsDetailComponent,
    TeamChampionshipsSelectorComponent
  ],
  entryComponents: [
    TeamChampionshipsDetailComponent
  ],
  providers: [
    TeamService
  ]
})
export class TeamModule { }
