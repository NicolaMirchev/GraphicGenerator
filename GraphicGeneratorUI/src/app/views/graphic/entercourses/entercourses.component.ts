import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { CoursesService } from 'src/app/services/courses.service';
import { enableRipple } from '@syncfusion/ej2-base';

enableRipple(true);

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
  addCourse = this.fb.group({
    name: '',
  });

  constructor(private fb: FormBuilder, private service: CoursesService) {}

  ngOnInit(): void {
    this.allCourses = this.service.getCourses();
  }

  submitCourse(value: any) {
    const course = value.course;
    this.service.setCourse(course);
    this.allCourses.push(course);
    this.ngOnInit();

    this.course = '';
  }
  removeCourse(value: any) {
    const course = value.course;
    this.service.removeCourse(course);

    this.ngOnInit();
  }
}
