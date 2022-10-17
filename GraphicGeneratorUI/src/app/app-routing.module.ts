import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EntercoursesComponent } from './views/graphic/entercourses/entercourses.component';
import { ShowGraphicComponent } from './views/graphic/show-graphic/show-graphic.component';
import { HomeInfoComponent } from './views/home-info/home-info.component';
import { SpinnerComponent } from './views/spinner/spinner.component';

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomeInfoComponent, pathMatch: 'full' },
  { path: 'entercourses', component: EntercoursesComponent, pathMatch: 'full' },
  { path: 'mygraphic', component: ShowGraphicComponent, pathMatch: 'full' },
  { path: 'spinner', component: SpinnerComponent, pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
