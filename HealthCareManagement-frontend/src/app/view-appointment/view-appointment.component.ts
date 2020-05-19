import { Component, OnInit } from '@angular/core';
  import { DiagnosticCenter, Test, TestAppointment } from '../health-care-system';
  import { ActivatedRoute, Router } from '@angular/router';
  import { TestService } from '../test.service';

@Component({
  selector: 'app-view-appointment',
  templateUrl: './view-appointment.component.html',
  styleUrls: ['./view-appointment.component.scss']
})
export class ViewAppointmentComponent implements OnInit {

    info : String;
    errorInfo : String;
    centerId:number;
    center:DiagnosticCenter;
    testAppointment:TestAppointment;
    testAppointmentId: number;
   
    constructor(private route: ActivatedRoute,private router: Router,
      private testService:TestService) { }
  
    ngOnInit(){
      this.center=new DiagnosticCenter();
        this.centerId = this.route.snapshot.params['centerId'];
        this.diagnosticCenterDetails(this.centerId);
        this.testAppointment=new TestAppointment();
        this.testAppointmentId = this.route.snapshot.params['testAppointmentId'];
    }
  
    diagnosticCenterDetails(centerId : number){
      this.testService.getCenter(this.centerId)
        .subscribe(data => {
          console.log(data);
          this.center = data;
      });
  }
  approveAppointment(testAppointmentId : number){
    this.testService.approveappointment(testAppointmentId).subscribe(
      data=>{
        console.log(data);
        this.info = data;
        alert(data);
        console.log(data);
        this.diagnosticCenterDetails(this.centerId);
      });
      error => {
        this.errorInfo = error.error; 
        console.log(this.errorInfo);
        alert("Appointment not found");
      };
  }

}
  