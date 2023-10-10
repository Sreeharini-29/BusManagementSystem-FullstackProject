import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Booking } from './Booking';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BookingService {
 
  createBooking(obj : Booking,busId:number,userId:number): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}/bookingticket/${busId}/${userId}`, obj);
  }
  getbookingByuserId() {
    throw new Error('Method not implemented.');
  }
  private baseURL = "http://localhost:8080/busBooking.com";
  getfeedbackList: any;

  constructor(private httpClient: HttpClient) { }

  getbookingById(bookingId : number) : Observable<Booking> {
    return this.httpClient.get<Booking>(`${this.baseURL}/getbooking/${bookingId}`);

  }

//  getbookingsByUserId(userId:number):Observable<Booking> {
//    return this.httpClient.get<Booking>(`${this.baseURL}/getbooking/user/${userId}');

//  }

   getbookingList(): Observable<Booking[]>{
  return this.httpClient.get<Booking[]>(`${this.baseURL}/getAllBookings`);
}
deleteBookingById(bookingId:number):Observable<Booking>{
  return this.httpClient.delete<Booking>(`${this.baseURL}/deleteBookingbybookingId/${bookingId}`);
}

 }
