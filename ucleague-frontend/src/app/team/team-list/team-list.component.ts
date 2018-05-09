import { Component, OnInit, ViewChild, EventEmitter } from '@angular/core';
import { Router } from '@angular/router';

import { MatTableDataSource, MatPaginator, MatSort, MatTable, MatDialog } from '@angular/material';

import { merge } from 'rxjs/observable/merge';
import { Observable } from 'rxjs/Observable';
import { map, startWith, catchError, switchMap } from 'rxjs/operators';
import { of } from 'rxjs/observable/of';

import { Team } from '../team';
import { PaginationPage } from '../pagination';
import { TeamService } from '../team.service';
import { TeamChampionshipsDetailComponent } from '../view/team-championships-detail/team-championships-detail.component';
import { emit } from 'cluster';

@Component({
  selector: 'ucleague-teams',
  templateUrl: './team-list.component.html',
  styleUrls: ['./team-list.component.css']
})
export class TeamListComponent implements OnInit {

  displayedColumns = ['id', 'name', 'country', 'totalChampionships', 'actions'];
  dataSource = new MatTableDataSource();

  // Pagination
  totalLength: number;
  pageSize = 5;
  pageIndex = 1;
  pageSizeOptions: number[] = [5, 10, 25, 50, 100];

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  teams: Team[];
  teamsPage: PaginationPage<Team>;

  constructor(private router: Router, private teamService: TeamService,
    private dialog: MatDialog) {
  }

  ngOnInit() {

    // If the user changes the sort order, reset back to the first page.
    this.sort.sortChange.subscribe(() => this.paginator.pageIndex = 0);

    merge(this.sort.sortChange, this.paginator.page).subscribe(() => this.refreshTable());

    this.refreshTable();
  }

  getTeams(sort: string, order: string, page: number, size: number): Observable<PaginationPage<Team>> {
    return this.teamService.getTeams(sort, order, page, size);
  }

  deleteTeam(team: Team): void {
    this.teamService.deleteTeam(team).subscribe(() => this.refreshTable());
  }

  refreshTable() {

    merge(startWith({}))
    .pipe(
      switchMap((value: {}, index: number) => {
        return this.getTeams(this.sort.active,
          this.sort.direction,
          this.paginator.pageIndex,
          this.paginator.pageSize == null ? this.pageSize : this.paginator.pageSize);
      }),
      map(data => {
        this.totalLength = data.totalElements;
        return data.content;
      }),
      catchError(() => {
        return of([]);
      })
    ).subscribe(data => this.dataSource.data = data);

  }

  openDialog(team: Team): void {
    const dialogRef = this.dialog.open(TeamChampionshipsDetailComponent, {
      data: { name: team.name, championships: team.championships }
    });

    dialogRef.afterClosed().subscribe(result => {
      this.teamService.updateChampionships(team).subscribe(() => this.refreshTable());
    });
  }

}
