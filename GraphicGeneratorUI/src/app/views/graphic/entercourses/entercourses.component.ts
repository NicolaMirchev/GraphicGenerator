import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { UserdataService } from 'src/app/services/userdata.service';

@Component({
  selector: 'app-entercourses',
  templateUrl: './entercourses.component.html',
  styleUrls: ['./entercourses.component.css']
})
export class EntercoursesComponent implements OnInit {
  
  course = '';

  allCourses = this.service.getCourses(); 

  addCourse = this.fb.group({
    name : ''
  })

  constructor(private fb : FormBuilder,private service : UserdataService) { }

  ngOnInit(): void {
  }

  submitCourse(value : any){
    console.log(value.course);
    this.service.setCourse(value.course);
  }
}
