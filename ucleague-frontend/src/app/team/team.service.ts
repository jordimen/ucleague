import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { HttpErrorResponse } from '@angular/common/http';

import { environment } from '../../environments/environment';
import { Team, TeamInput, Championship } from './team';
import { PaginationPage } from './pagination';

import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { catchError } from 'rxjs/operators';
import { ErrorObservable } from 'rxjs/observable/ErrorObservable';
import { ErrorService } from '../common/error.service';

@Injectable()
export class TeamService {

  private url = `${environment.apiUrl}/team`;

  constructor(private http: HttpClient, private errorService: ErrorService) { }

  saveOrUpdateTeam(teamInput: TeamInput): Observable<Team> {
    if (teamInput.id) {
      const putUrl = `${this.url}/${teamInput.id}`;
      return this.http.put<Team>(putUrl, teamInput).pipe(
        catchError(this.handleError<Team>(`newTeam ${teamInput}`)));
    } else {
      const postUrl = `${this.url}`;
      return this.http.post<Team>(postUrl, teamInput).pipe(
        catchError(this.handleError<Team>(`newTeam ${teamInput}`)));
    }
  }

  getTeamsByName(name: string): Observable<PaginationPage<Team>> {
    const params = new HttpParams()
      .set('name', name)
      .set('page', '0')
      .set('size', `${Number.MAX_VALUE}`)
      .set('sort', 'name,asc');
    return this.http.get<PaginationPage<Team>>(this.url, { params }).pipe(
      catchError(this.handleError<PaginationPage<Team>>('getTeams')));
  }

  getTeams(sort: string, order: string, page: number, size: number): Observable<PaginationPage<Team>> {
    const params = new HttpParams()
      .set('page', `${page}`)
      .set('size', `${size}`)
      .set('sort', sort == null ? '' : `${sort},${order}`);
    return this.http.get<PaginationPage<Team>>(this.url, { params }).pipe(
      catchError(this.handleError<PaginationPage<Team>>('getTeams')));
  }

  getTeam(teamId: number): Observable<Team> {
    const getUrl = `${this.url}/${teamId}`;
    return this.http.get<Team>(getUrl).pipe(
      catchError(this.handleError<Team>(`getTeam id=${teamId}`)));
  }

  deleteTeam(team: Team): Observable<{}> {
    const deleteUrl = `${this.url}/${team.id}`;
    return this.http.delete(deleteUrl, {}).pipe(
      catchError(this.handleError<Team>(`deleteTeam id=${team.id}`))
    );
  }

  updateChampionships(team: Team): Observable<{}> {
    const putChampionshipsUrl = `${this.url}/${team.id}/championship`;
    return this.http.put(putChampionshipsUrl, team.championships).pipe(
      catchError(this.handleError<Team>(`updateChampionships id=${team.id}`))
    );
  }

  /**
   * Handle Http operation that failed.
   * Let the app continue.
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      this.errorService.notify('Application error');
      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

}
