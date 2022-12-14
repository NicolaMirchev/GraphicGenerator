import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
})
export class HeaderComponent implements OnInit {
  constructor(private router: Router) {}

  ngOnInit(): void {}

  navigateHome(): void {
    this.router.navigateByUrl('/home');
  }

  navigateEneterCourses(): void {
    this.router.navigateByUrl('/entercourses');
  }
  navigateMySchedule() {
    this.router.navigateByUrl('/mygraphic');
  }
}
