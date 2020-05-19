import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ViewCentersComponent } from './view-centers/view-centers.component';
import { Routes, RouterModule } from '@angular/router';
import { CenterDetailsComponent } from './center-details/center-details.component';
import { AddTestComponent } from './add-test/add-test.component';
import { ViewAppointmentComponent } from './view-appointment/view-appointment.component';

const routes : Routes = [
  {path:'view', component:ViewCentersComponent},
  {path:'details/:centerId', component:CenterDetailsComponent},
  {path:'addTest/:centerId', component:AddTestComponent},
  {path:'appdetails/:centerId', component: ViewAppointmentComponent}

]

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
