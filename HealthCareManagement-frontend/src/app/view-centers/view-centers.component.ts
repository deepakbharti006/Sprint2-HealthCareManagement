import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { DiagnosticCenter } from '../health-care-system';
import { TestService } from '../test.service';
import { Router, ActivatedRoute } from "@angular/router";

@Component({
  selector: 'app-view-centers',
  templateUrl: './view-centers.component.html',
  styleUrls: ['./view-centers.component.css']
})
export class ViewCentersComponent implements OnInit {

  centers: Observable<DiagnosticCenter[]>;
  constructor(private testService:TestService,
    private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.reloadData();
  }
  reloadData() {
    //this.centers = this.centerService.loadCenters();
    this.testService.loadCenters()
    .subscribe(data=>{
      this.centers=data;
      console.log(data);
    })
  }

  centerDetails(centerId:number){
    this.router.navigate(['details',centerId]);
  }

  appointmentdetails(centerId:number){
    this.router.navigate(['appdetails',centerId]);
  }

  addTest(centerId : number){
 this.router.navigate(['addTest',centerId]);

  }

}
