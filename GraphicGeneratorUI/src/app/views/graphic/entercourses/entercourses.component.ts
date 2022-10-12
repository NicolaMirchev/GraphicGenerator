import { Component, OnInit } from '@angular/core';
import { CoursesService } from 'src/app/services/courses.service';
import { CourseoptionsService } from 'src/app/services/courseoptions.service';
import { CourseOption } from 'src/app/models/courseOption';

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
    private courseOptionsService: CourseoptionsService
  ) {}

  ngOnInit(): void {
    this.allCourses = this.coursesService.getCourses();
    this.allCourseOptions = this.courseOptionsService.getCourseOptions();
  }

  submitCourse(value: any) {
    const course = value.course;
    this.coursesService.setCourse(course);
    this.allCourses.push(course);
    this.ngOnInit();

    this.course = '';
  }
  removeCourse(value: any) {
    const course = value.course;
    this.coursesService.removeCourse(course);

    this.ngOnInit();
  }

  addCourseOption(course: string) {
    const option: CourseOption = {
      nameOfTheCourse: course,
      startingHours: this.hours,
      startingMinutes: this.minutes,
      weekDay: this.selectedWeekday,
    };

    this.courseOptionsService.setCourseOption(option);
    this.selectedWeekday = '';
    this.ngOnInit();
  }
}
