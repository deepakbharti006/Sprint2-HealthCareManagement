import { Component, OnInit } from '@angular/core';
import { DiagnosticCenter, Test } from '../health-care-system';
import { ActivatedRoute, Router } from '@angular/router';
import { TestService } from '../test.service';

@Component({
  selector: 'app-center-details',
  templateUrl: './center-details.component.html',
  styleUrls: ['./center-details.component.css']
})
export class CenterDetailsComponent implements OnInit {
  info : String;
  errorInfo : String;
  centerId:number;
  center:DiagnosticCenter;
  test:Test[];
 
  constructor(private route: ActivatedRoute,private router: Router,
    private testService:TestService) { }

  ngOnInit(){
    this.center=new DiagnosticCenter();
      this.centerId = this.route.snapshot.params['centerId'];
      this.diagnosticCenterDetails(this.centerId);
  }

  diagnosticCenterDetails(centerId : number){
    this.testService.getCenter(this.centerId)
      .subscribe(data => {
        console.log(data);
        this.center = data;
    });
  }

  removeTest(testId : number){
    this.testService.removeTest(testId).subscribe(
      data=>{
        console.log(data);
        this.info = data;
        alert(data);
        this.diagnosticCenterDetails(this.centerId);
      },
      error => {
        this.errorInfo = error.error; 
        console.log(this.errorInfo);
        alert("Test not found");
      });
  }


  addTest(centerId :number){
    this.router.navigate(['addTest',centerId]);
  }

}
