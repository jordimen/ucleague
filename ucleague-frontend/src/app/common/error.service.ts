import { Injectable } from '@angular/core';
import { Subject } from 'rxjs/Subject';
import { ErrorMessage } from './error';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class ErrorService {

  private subject = new Subject<ErrorMessage>();

  constructor() { }

  getError(): Observable<any> {
    return this.subject.asObservable();
  }

  notify(message: string) {
    this.subject.next(<ErrorMessage>{ message: message });
  }

  clear() {
    this.subject.next();
  }

}
