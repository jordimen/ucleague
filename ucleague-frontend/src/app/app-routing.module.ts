import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { TeamListComponent } from './team/team-list/team-list.component';
import { TeamFormComponent } from './team/team-form/team-form.component';

const routes: Routes = [
  { path: '', redirectTo: '/teams', pathMatch: 'full' },
  { path: 'teams', component: TeamListComponent },
  { path: 'team/new', component: TeamFormComponent },
  { path: 'team/:id', component: TeamFormComponent },
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
