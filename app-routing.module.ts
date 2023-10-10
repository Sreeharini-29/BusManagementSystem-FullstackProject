import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BusListComponent } from './bus-list/bus-list.component';
import { CreateBusComponent } from './create-bus/create-bus.component';
import { ViewBusComponent } from './view-bus/view-bus.component';
import {UpdateBusComponent} from'./update-bus/update-bus.component';
import { SigninComponent } from './signin/signin.component';
import { SignupComponent } from './signup/signup.component';
import { AuthguardService } from './authguard.service';
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
import { BookingComponent } from './booking/booking.component';
import { CreateBookingComponent } from './create-booking/create-booking.component';
import { ViewBookingComponent } from './view-booking/view-booking.component';

import { AboutUsComponent } from './about-us/about-us.component';
import { ViewUserComponent } from './view-user/view-user.component';
const routes: Routes = [
  {path:'',redirectTo:'home',pathMatch:'full'},
  {path:'home',component:HomeComponent},
  {path: 'see-all-buses', component: BusListComponent,canActivate: [AuthguardService]},
  {path: 'create-bus', component: CreateBusComponent,canActivate: [AuthguardService]},
  //{path: '', redirectTo: 'buses', pathMatch: 'full'},
  {path: 'update-bus/:id', component: UpdateBusComponent,canActivate: [AuthguardService]},
  {path: 'view-bus-details/:id', component: ViewBusComponent,canActivate: [AuthguardService]},
  {path:'signin', component: SigninComponent},
  {path:'signup', component: SignupComponent},
  {path:'see-all-routes',component:RouteComponent,canActivate: [AuthguardService]},
{path:'create-route',component:CreateRouteComponent,canActivate: [AuthguardService]},
{path:'view-route-details/:routeId',component:ViewRouteComponent,canActivate: [AuthguardService]},
{path:'update-route/:routeId',component:UpdateRouteComponent,canActivate: [AuthguardService]},
{path:'see-all-agency',component:TravelAgencyComponent,canActivate: [AuthguardService]},
{path:'create-agency',component:CreateAgencyComponent,canActivate: [AuthguardService]},
{path:'view-agency-details/:agencyId',component:ViewAgencyComponent,canActivate: [AuthguardService]},
{path:'update-agency/:agencyId',component:UpdateAgencyComponent,canActivate: [AuthguardService]},
{path:'see-all-feedback',component:FeedbackComponent,canActivate: [AuthguardService]},
{path:'view-feedback/:id',component:ViewfeedbackComponent,canActivate:[AuthguardService]},
{path:'see-all-booking',component:BookingComponent,canActivate:[AuthguardService]},
{path:'create-booking/:id',component:CreateBookingComponent,canActivate:[AuthguardService]},
{path:'view-booking-details/:id',component:ViewBookingComponent,canActivate:[AuthguardService]},
{path:'feedback',component:CreatefeedbackComponent,canActivate:[AuthguardService]},
{path:'view-user-details/:id',component:ViewUserComponent,canActivate:[AuthguardService]},
{path:'aboutus',component:AboutUsComponent,canActivate:[AuthguardService]}
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
