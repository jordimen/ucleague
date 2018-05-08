import { Component, OnInit, Input, Output, EventEmitter, OnChanges, SimpleChanges } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Observable } from 'rxjs/Observable';
import { startWith, debounceTime, distinctUntilChanged, map, switchMap, filter } from 'rxjs/operators';
import { PaginationPage } from '../../pagination';

import { Team } from '../../team';
import { TeamService } from '../../team.service';

@Component({
  selector: 'ucleague-team-selector',
  templateUrl: './team-selector.component.html',
  styleUrls: ['./team-selector.component.css']
})
export class TeamSelectorComponent implements OnInit, OnChanges {

  @Input() placeholder: String;
  @Input() team: Team;
  @Output() teamSelected: EventEmitter<Team> = new EventEmitter<Team>();

  teamSelectorCtrl = new FormControl();
  filteredTeams: Observable<Team[]>;
  teams: Observable<PaginationPage<Team>>;

  constructor(private teamService: TeamService) {

    this.teams = this.teamService.getTeamsByName('');

    this.filteredTeams = this.teamSelectorCtrl.valueChanges
      .pipe(
        startWith<string | Team>(''),
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
    this.teamSelectorCtrl.setValue(changes.team.currentValue);
  }

  filter(name: string): Observable<Team[]> {
    return this.teams.pipe(
      map(response => response.content),
      map(response => response.filter(team =>
        team.name.toLowerCase().indexOf(name.toLowerCase()) === 0)
    ));
  }

  getTeamName(team?: Team): string | undefined {
    return team ? team.name : undefined;
  }

  selectTeam(team: Team) {
    this.team = team;
    this.teamSelected.emit(team);
  }

}
