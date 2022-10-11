import { importProvidersFrom, Injectable } from '@angular/core';


@Injectable({
  providedIn: 'root'
})
export class UserdataService {

  constructor() { }
  

  clearCourses(){
    localStorage.removeItem('courses');
  }

  // The function accept array of courses and set it in the local storage.
  setLocalStorageCourseArray(courses : unknown){
    localStorage.setItem('courses', JSON.stringify(courses));
  }

  //The return array of courses if there are in the local storage, or null if there are not.
  getCourses() {
    if(localStorage.getItem('courses') != null){
      return JSON.parse(localStorage.getItem("courses") ?? '') ;
    }
    else{
      return [];
    }
  }

  // The function accept a course model and add it to the collection in the local storage.
  setCourse(course : unknown){
    let existingEntries = this.getCourses();
      existingEntries.push(course);
    this.setLocalStorageCourseArray(existingEntries);
  }


}
