import { Component, OnInit, Input, Output, ViewChild, AfterViewInit } from '@angular/core';
import { FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

import { TeamService } from '../team.service';
import { Team, TeamInput } from '../team';
import { CountrySelectorComponent } from '../../common-components/country-selector/country-selector.component';
import { Country } from '../../common-components/country-selector/country';

@Component({
  selector: 'ucleague-team-form',
  templateUrl: './team-form.component.html',
  styleUrls: ['./team-form.component.css']
})
export class TeamFormComponent implements OnInit {

  team: Team = new Team();
  form: FormGroup;

  constructor(private route: ActivatedRoute,
    private router: Router,
    private fb: FormBuilder,
    private teamService: TeamService) {

      this.form = fb.group({
        name: ['', [Validators.required, Validators.minLength(4), Validators.maxLength(24)]],
        logo: ['']
      });

      this.initializeTeam();
  }

  ngOnInit(): void {
  }

  get name() {
    return this.form.get('name');
  }

  countrySelected(country: Country) {
    this.team.country = country;
  }

  rivalTeamSelected(team: Team) {
    this.team.rival = team;
  }

  onSubmit() {
    this.teamService.saveOrUpdateTeam(this.getTeamInput()).subscribe();
    this.router.navigate(['teams']);
  }

  getTeamInput(): TeamInput {
    const formModel = this.form.value;
    const team: TeamInput = {
      id: this.team.id,
      name: formModel.name as string,
      countryCode: this.team.country.code,
      rivalId: this.team.rival.id
    };
    return team;
  }

  initializeTeam(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    if (id > 0) {
      this.teamService.getTeam(id).subscribe(team => {
        this.form.patchValue(team);
        this.team = team;
      });
    }
  }
}
