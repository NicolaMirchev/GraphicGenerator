import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './core/header/header.component';
import { FooterComponent } from './core/footer/footer.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgMaterialModule } from './material/ng-material/ng-material.module';
import { HomeInfoComponent } from './views/home-info/home-info.component';
import { EntercoursesComponent } from './views/graphic/entercourses/entercourses.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { GenerategraphicDialogComponent } from './views/graphic/entercourses/generategraphic-dialog/generategraphic-dialog.component';
import { ShowGraphicComponent } from './views/graphic/show-graphic/show-graphic.component';
import { SpinnerComponent } from './views/spinner/spinner.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    HomeInfoComponent,
    EntercoursesComponent,
    GenerategraphicDialogComponent,
    ShowGraphicComponent,
    SpinnerComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    NgMaterialModule,
    FormsModule,
    BrowserModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
