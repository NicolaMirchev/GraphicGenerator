import { Component, OnInit } from '@angular/core';
import { CoursesService } from 'src/app/services/courses.service';
import { CourseoptionsService } from 'src/app/services/courseoptions.service';
import { CourseOption } from 'src/app/models/courseOption';
import { MatDialog } from '@angular/material/dialog';
import { GenerategraphicDialogComponent } from './generategraphic-dialog/generategraphic-dialog.component';

@Component({
  selector: 'app-entercourses',
  templateUrl: './entercourses.component.html',
  styleUrls: ['./entercourses.component.css'],
})
export class EntercoursesComponent implements OnInit {
  selectedWeekday: string = '';
  hours = 13;
  minutes = 30;

  course = '';

  allCourses: string[] = [];
  allCourseOptions: CourseOption[] = [];

  constructor(
    private coursesService: CoursesService,
    private courseOptionsService: CourseoptionsService,
    public dialog: MatDialog
  ) {}

  ngOnInit(): void {
    this.allCourses = this.coursesService
      .getCourses()
      .sort((first, second) => first.localeCompare(second));
    this.allCourseOptions = this.courseOptionsService
      .getCourseOptions()
      .sort((first, second) =>
        first.nameOfTheCourse.localeCompare(second.nameOfTheCourse)
      );
  }

  submitCourse(value: any) {
    const course = value.course;
    this.coursesService.setCourse(course);
    this.allCourses.push(course);
    this.ngOnInit();

    this.course = '';
  }

  // The function remove given course and all course options related to it.
  removeCourse(value: any) {
    this.coursesService.removeCourse(value);

    // Filter all coure options and get those for with name of the course which is being removed.
    // Remove each of them.
    for (let courseOption of this.allCourseOptions.filter(
      (option) => option.nameOfTheCourse === value
    )) {
      this.courseOptionsService.removeCourseOption(courseOption);
    }
    this.ngOnInit();
  }

  addCourseOption(course: string) {
    const option: CourseOption = {
      nameOfTheCourse: course,
      startingHours: this.hours,
      startingMinutes: this.minutes,
      weekday: this.selectedWeekday,
    };

    this.courseOptionsService.setCourseOption(option);
    this.selectedWeekday = '';
    this.ngOnInit();
  }

  removeCourseOption(option: CourseOption) {
    this.courseOptionsService.removeCourseOption(option);
    this.ngOnInit();
  }

  openDialog() {
    const dialogRef = this.dialog.open(GenerategraphicDialogComponent);
  }
}
