import { Injectable } from '@angular/core';
import { CourseOption } from '../models/courseOption';

@Injectable({
  providedIn: 'root',
})
export class CourseoptionsService {
  constructor() {}

  // The function find the index of given course option, by comparing each field of given object
  // in the array of course options, removes it and reassign the array in the storage.
  removeCourseOption(courseOption: CourseOption) {
    let courseOptions = this.getCourseOptions();
    courseOptions.splice(
      courseOptions.findIndex(
        (c) =>
          c.nameOfTheCourse == courseOption.nameOfTheCourse &&
          c.startingHours == courseOption.startingHours &&
          c.startingMinutes == courseOption.startingMinutes &&
          c.weekDay == courseOption.weekDay
      ),
      1
    );
    this.setLocalStorageCourseOptionsArray(courseOptions);
  }
  clearAllOptions() {
    localStorage.removeItem('courseOptions');
  }

  // The function accept array of course options and set it in the local storage.
  setLocalStorageCourseOptionsArray(courseOptions: CourseOption[]) {
    localStorage.setItem('courseOptions', JSON.stringify(courseOptions));
  }

  //The return array of course options if there are in the local storage, or empty array if there are not.
  getCourseOptions(): CourseOption[] {
    if (localStorage.getItem('courseOptions') != null) {
      return JSON.parse(localStorage.getItem('courseOptions') ?? '');
    } else {
      return [];
    }
  }

  // The function accept a cours option object and add it to the collection in the local storage.
  setCourseOption(courseOption: CourseOption) {
    let existingEntries = this.getCourseOptions();
    existingEntries.push(courseOption);
    this.setLocalStorageCourseOptionsArray(existingEntries);
  }
}
