import { importProvidersFrom, Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class CoursesService {
  constructor() {}

  // The function find the index of given course in the array of courses, removes it and reassign the array in the storage.
  removeCourse(course: string) {
    let courses = this.getCourses();
    courses.splice(
      courses.findIndex((c) => c == course),
      1
    );
    this.setLocalStorageCourseArray(courses);
  }
  clearCourses() {
    localStorage.removeItem('courses');
  }

  // The function accept array of courses and set it in the local storage.
  setLocalStorageCourseArray(courses: string[]) {
    localStorage.setItem('courses', JSON.stringify(courses));
  }

  //The return array of courses if there are in the local storage, or null if there are not.
  getCourses(): string[] {
    if (localStorage.getItem('courses') != null) {
      return JSON.parse(localStorage.getItem('courses') ?? '');
    } else {
      return [];
    }
  }

  // The function accept a course model and add it to the collection in the local storage.
  setCourse(course: string) {
    let existingEntries = this.getCourses();
    existingEntries.push(course);
    this.setLocalStorageCourseArray(existingEntries);
  }
}
