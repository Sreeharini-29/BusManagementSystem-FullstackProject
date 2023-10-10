import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BusListComponent } from './bus-list/bus-list.component';
import { CreateBusComponent } from './create-bus/create-bus.component';
import { UpdateBusComponent } from './update-bus/update-bus.component';
import { ViewBusComponent } from './view-bus/view-bus.component';
import { SigninComponent } from './signin/signin.component';
import { SignupComponent } from './signup/signup.component';
import { NgxPaginationModule} from 'ngx-pagination';
import { HomeComponent } from './home/home.component';

import { RouteComponent } from './routeclass/route.component';
import { CreateRouteComponent } from './create-route/create-route.component';
import { ViewRouteComponent } from './view-route/view-route.component';
import { UpdateRouteComponent } from './update-route/update-route.component';
import { TravelAgencyComponent } from './travel-agency/travel-agency.component';
import { CreateAgencyComponent } from './create-agency/create-agency.component';
import { ViewAgencyComponent } from './view-agency/view-agency.component';
import { UpdateAgencyComponent } from './update-agency/update-agency.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { CreatefeedbackComponent } from './create-feedback/createfeedback.component';

import { ViewfeedbackComponent } from './view-feedback/viewfeedback.component';
import { RouterModule } from '@angular/router';
import { BookingComponent } from './booking/booking.component';
import { CreateBookingComponent } from './create-booking/create-booking.component';
import { ViewBookingComponent } from './view-booking/view-booking.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { ViewUserComponent } from './view-user/view-user.component';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    AppComponent,
    BusListComponent,
    CreateBusComponent,
    UpdateBusComponent,
    ViewBusComponent,
    SigninComponent,
    SignupComponent,
    HomeComponent,
    
    RouteComponent,
    CreateRouteComponent,
    ViewRouteComponent,
    UpdateRouteComponent,
    TravelAgencyComponent,
    CreateAgencyComponent,
    ViewAgencyComponent,
    UpdateAgencyComponent,
    FeedbackComponent,
    CreatefeedbackComponent,
    
    ViewfeedbackComponent,
   BookingComponent,
   CreateBookingComponent,
   ViewBookingComponent,
   AboutUsComponent,
   ViewUserComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgxPaginationModule,
    RouterModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
