import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Test, TestAppointment } from './health-care-system';

@Injectable({
  providedIn: 'root'
})
export class TestService {

  baseUrl="http://localhost:8082/";
  constructor(private http:HttpClient) { }

  loadCenters(): Observable<any>{
    return this.http.get(this.baseUrl+"centers");
  }

  getCenter(centerId: number): Observable<any> {
    return this.http.get(this.baseUrl+"center/"+centerId);
  }

  removeTest(testId : number): Observable<any>{
    return this.http.delete(this.baseUrl+"removeTest/"+testId,{responseType: 'text'});
  }

  public addTest(centerId: number, test: Test){

    return this.http.post(this.baseUrl+"addTest/"+centerId,test,{responseType: 'text'});
  }
  public approveappointment(testAppointmentId: number): Observable<any>{

    return this.http.put("http://localhost:8082/approveAppointment/"+testAppointmentId,{responseType: 'text'});
  }
}
