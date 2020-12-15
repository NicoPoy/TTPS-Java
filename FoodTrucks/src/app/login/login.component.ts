import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Usuario } from 'src/app/modelos/usuario/usuario'
import { ApiService } from 'src/app/servicios/api.service'
import { AuthenticationService } from 'src/app/servicios/authentication.service'
import { AppComponent } from 'src/app/app.component'

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

  ngOnInit(): void { }

  postForm( form:Usuario ){
     this.auth.login(form).subscribe(data => console.log(data) );   
  }


}
