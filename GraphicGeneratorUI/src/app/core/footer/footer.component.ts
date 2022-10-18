import { Component, OnInit } from '@angular/core';
import { TimePicker } from '@syncfusion/ej2-angular-calendars';
import { TimeInterval } from 'rxjs/internal/operators/timeInterval';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css'],
})
export class FooterComponent implements OnInit {
  year: number = new Date().getFullYear();

  constructor() {}

  ngOnInit(): void {}
}
