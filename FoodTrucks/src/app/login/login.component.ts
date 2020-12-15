import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Usuario } from 'src/app/modelos/usuario/usuario'
import { ApiService } from 'src/app/servicios/api.service'
import { AuthenticationService } from 'src/app/servicios/authentication.service'
import { ResponseI } from '../modelos/response/response-i';

import { HttpHeaders } from '@angular/common/http'

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {

  loginForm = new FormGroup({
    username: new FormControl('', [Validators.required, Validators.minLength(3)] ),
    password: new FormControl('', [Validators.required, Validators.minLength(3)] )
  })

  constructor( private api:ApiService, private auth:AuthenticationService, private router:Router ) { }

  ngOnInit(): void { 
    if( localStorage.getItem("token") != "null" ){
      this.router.navigate(['/home']);
    }
  }

  postForm( form:Usuario ){
     this.auth.login(form).subscribe(data => {
      let dataResponse: ResponseI = data;
      if (dataResponse.status == "ok") {
        localStorage.setItem("token", dataResponse.token);
        localStorage.setItem("userType", dataResponse.type);
        this.router.navigate(['/home']);
      }
    });
  }


}
