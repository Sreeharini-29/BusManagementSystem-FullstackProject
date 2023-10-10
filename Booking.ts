import { User } from "./User";


export class Booking{
    bookingId:number=0;
    source:string=" ";
    booked_seats:number=0;
    destination:string="";
    journeyDate!: Date;
    bookingDate!:Date;
    totalBookingCost:number=0;
    user():User{throw new Error('Method not implemented.');};
}