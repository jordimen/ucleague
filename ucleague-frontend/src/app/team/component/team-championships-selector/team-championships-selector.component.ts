import { Component, OnInit, Input } from '@angular/core';
import { Championship } from '../../team';

@Component({
  selector: 'ucleague-team-championships-selector',
  templateUrl: './team-championships-selector.component.html',
  styleUrls: ['./team-championships-selector.component.css']
})
export class TeamChampionshipsSelectorComponent implements OnInit {

  readonly fromYear = 1990;
  readonly toYear = new Date().getFullYear();
  readonly years = Array.from(new Array(this.toYear - this.fromYear + 1), (val, index) => this.fromYear + index);

  @Input() championships: Championship[] = [];

  constructor() {
  }

  ngOnInit() {
  }

  isChampionshipYear(year: number) {
    return this.championships.find(element => element.year === year);
  }

  updateChampionshipYear(year: number) {
    if (this.isChampionshipYear(year)) {
      // remove championship
      this.removeChampionship(year);
    } else {
      // add championship
      this.addChampionship(year);
    }
  }

  addChampionship(year: number) {
    this.championships.push(new Championship(year));
  }

  removeChampionship(year: number) {
    const championship = this.championships.find(item => item.year === year);
    const championshipIndex = this.championships.indexOf(championship, 0);
    if (championshipIndex > -1) {
      this.championships.splice(championshipIndex, 1);
    }
  }
}
