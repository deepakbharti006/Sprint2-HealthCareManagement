import { Component, OnInit } from '@angular/core';
import { Test } from '../health-care-system';
import { TestService } from '../test.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-add-test',
  templateUrl: './add-test.component.html',
  styleUrls: ['./add-test.component.css']
})
export class AddTestComponent implements OnInit {
  info : string;
  errorInfo : string;
  centerId :number;
  test: Test = new Test();

  constructor(private testService : TestService, private route : ActivatedRoute, private router : Router) { }

  ngOnInit() {
    this.centerId = this.route.snapshot.params['centerId'];
    
  }

  addTest(){
    this.testService.addTest(this.centerId,this.test).subscribe((data)=>{
      console.log(data);
      this.info = data;
      alert(data);
      this.router.navigate(['details',this.centerId]);
    },
    error => {
      this.info = undefined;
      this.errorInfo = error.error; 
      console.log(this.errorInfo);
      alert("Test already exists");
    } );
  }
}
