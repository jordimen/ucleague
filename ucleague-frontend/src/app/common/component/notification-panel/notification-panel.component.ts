import { Component, OnInit } from '@angular/core';
import { ErrorMessage } from '../../error';
import { ErrorService } from '../../error.service';

@Component({
  selector: 'ucleague-notification-panel',
  templateUrl: './notification-panel.component.html',
  styleUrls: ['./notification-panel.component.css']
})
export class NotificationPanelComponent implements OnInit {

  errorMessages: ErrorMessage[] = [];

  constructor(private errorService: ErrorService) { }

  ngOnInit() {
    this.errorService.getError().subscribe((errorMessage: ErrorMessage) => {
      if (!errorMessage) {
        this.errorMessages = [];
        return;
      }

      this.errorMessages.push(errorMessage);
    });
  }

  removeError(errorMessage: ErrorMessage) {
    this.errorMessages = this.errorMessages.filter(x => x !== errorMessage);
  }

}
