import { BrowserModule } from '@angular/platform-browser';
import { NgModule, NO_ERRORS_SCHEMA } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms'
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MDBBootstrapModule } from 'angular-bootstrap-md'
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { HomeComponent } from './components/home/home.component';
import { AboutComponent } from './components/about/about.component';
import { SearchboxComponent } from './components/searchbox/searchbox.component';
import { InstitutionsComponent } from './components/institutions/institutions.component';
import { InstitutionsService } from './services/institutions.service';
import { InstituteComponent } from './components/institute/institute.component';
import { ApplyFormComponent } from './components/apply-form/apply-form.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    AboutComponent,
    SearchboxComponent,
    InstitutionsComponent,
    InstituteComponent,
    ApplyFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule, ReactiveFormsModule,
    HttpClientModule,
    MDBBootstrapModule.forRoot()
  ],
  providers: [ InstitutionsService ],
  bootstrap: [AppComponent],
  schemas: [NO_ERRORS_SCHEMA ]
})
export class AppModule { }
