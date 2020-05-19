import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { ViewCentersComponent } from './view-centers/view-centers.component';
import { CenterDetailsComponent } from './center-details/center-details.component';
import { AddTestComponent } from './add-test/add-test.component';
import { FormsModule } from "@angular/forms";
import { ViewAppointmentComponent } from './view-appointment/view-appointment.component';
@NgModule({
  declarations: [
    AppComponent,
    ViewCentersComponent,
    CenterDetailsComponent,
    AddTestComponent,
    ViewAppointmentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
