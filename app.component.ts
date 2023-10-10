import { Component } from '@angular/core';
import { UserService } from './user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'busManagementSystem';

  constructor(public userService : UserService,private router:Router){

  }
  logOut() {
    var status=confirm("Are you sure you want to logout?");
    if(status==true){
    sessionStorage.removeItem('loginStatus')
    sessionStorage.removeItem('email')
    sessionStorage.removeItem('userRole')
    sessionStorage.removeItem('userName')
    sessionStorage.removeItem('userId')
    this.router.navigate(['home']);
  }
  else{
    this.router.navigate(['see-all-buses']);
   }
  
}


}
