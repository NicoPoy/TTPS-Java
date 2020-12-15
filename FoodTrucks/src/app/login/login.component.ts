import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Usuario } from 'src/app/modelos/usuario/usuario'
import { ApiService } from 'src/app/servicios/api.service'

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

  constructor( private api:ApiService ) { }

  ngOnInit(): void {
  }

  postForm( form:Usuario ){
    this.api.iniciarSesion(form).subscribe(data => console.log(data) );
  }
  
}
