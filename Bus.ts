import { Route } from "./Route";
import { TravelAgency } from "./TravelAgency";
import { Booking } from "./Booking";
import { Feedback } from "./Feedback";
export class Bus{
    
    busId:number=0;
    drivername:string="";
    source:string="";
    destination :string="";
    totalnumberofseats:number=0;
    availableseats:number=0;
    busnumber:string="";
    busAgencyName:string="";
    isACbus :boolean=false;
    ticketPrice:number=0;
    rating:number=0;
  bookings: Booking[];
    travelAgency():TravelAgency{throw new Error('Method not implemented.');};
    route():Route{throw new Error('Method not implemented.');}
    booking():Booking{throw new Error('Method not implemented.');}
    feedback():Feedback{throw new Error('Method not implemented.');}
}