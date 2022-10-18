import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Graphic } from 'src/app/models/graphic';
import { GraphicService } from 'src/app/services/graphic.service';

@Component({
  selector: 'app-show-graphic',
  templateUrl: './show-graphic.component.html',
  styleUrls: ['./show-graphic.component.css'],
})
export class ShowGraphicComponent implements OnInit {
  graphic: Graphic = this.graphicService.getGraphicFromLC();
  displayedColumns: string[] = ['weekday', 'course', 'startingTime'];

  // Values for different weekdays, so to use them in a comparator function.
  sorter: { [key: string]: number } = {
    Monday: 1,
    Tuesday: 2,
    Wednesday: 3,
    Thursday: 4,
    Friday: 5,
    Saturday: 6,
    Sunday: 7,
  };

  constructor(
    private graphicService: GraphicService,
    private readonly router: Router
  ) {}

  ngOnInit(): void {
    if (this.graphic != null) {
      this.graphic.courses.sort(
        (first, second) =>
          this.sorter[first.weekday] - this.sorter[second.weekday]
      );
      this.graphic.courses.sort((first, second) => {
        if (first.weekday == second.weekday) {
          return first.startingHours - second.startingHours;
        }
        return 0;
      });
    }
  }

  navigateToEnterCourses() {
    this.router.navigateByUrl('/entercourses');
  }
}
