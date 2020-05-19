export class Test{
    testId:number;
    testName:string;
}

export class Users{
    userId: number;
    userPassword:string;
    userName:string;
    contactNo:number;
    userRole:string;
    emailId:string;
}

export class TestAppointment{
    testAppointmentId:number;
    testAppointmentDate:string;
    approved:boolean;
    users:Users[];
}

export class DiagnosticCenter {

    centerId:number;
    centerName:string;
    contactNo:string;
    test:Test[];
    appointment:TestAppointment[];
}

