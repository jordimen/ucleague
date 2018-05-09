import { Component, OnInit, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material';
import { Championship } from '../../team';

@Component({
  selector: 'ucleague-team-championships-detail',
  templateUrl: './team-championships-detail.component.html',
  styleUrls: ['./team-championships-detail.component.css']
})
export class TeamChampionshipsDetailComponent {

  name: string;
  championships: Championship[] = [];

  constructor(public dialogRef: MatDialogRef<TeamChampionshipsDetailComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any) {
      this.name = data.name;
      this.championships = data.championships;
    }

  onNoClick(): void {
    this.dialogRef.close();
  }

}
