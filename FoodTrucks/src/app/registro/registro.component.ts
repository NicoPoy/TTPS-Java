import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Usuario } from 'src/app/modelos/usuario/usuario'
import { ApiService } from 'src/app/servicios/api.service'
import { AuthenticationService } from 'src/app/servicios/authentication.service'
import { Router } from '@angular/router';
import { ResponseI } from 'src/app/modelos/response/response-i'
import { Zona } from '../modelos/zona/zona';

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.css']
})

export class RegistroComponent implements OnInit {
  zonas: Zona[];

  delay = ms => new Promise(res => setTimeout(res, ms));

  nuevoForm = new FormGroup({
    nombre: new FormControl('', [Validators.required, Validators.minLength(3)] ),
    apellido: new FormControl('', [Validators.required, Validators.minLength(3)] ),
    username: new FormControl('', [Validators.required, Validators.minLength(3)] ),
    password: new FormControl('', [Validators.required, Validators.minLength(3)] ),
    tipocuenta: new FormControl('', [Validators.required] ),
    zona: new FormControl(''),
  })

  constructor( private api:ApiService, private auth: AuthenticationService, private router:Router ) { }

  ngOnInit(): void {
    if( localStorage.getItem("token") != null && localStorage.getItem("token") != "null" ){
      this.router.navigate(['/home']);
    }

    this.api.getZonas().subscribe( data => {
      this.zonas = data;
      //this.zonas.map( elem =>  this.nuevoForm.addControl(elem.nombre, new FormControl('')) );
    });

   }

  async postForm( form:Usuario ){

    form.zona = new Zona(this.nuevoForm.controls['zona'].value, null)
    this.api.crearUsuario(form).subscribe(data => console.log(data) );

    //Logeo Automatico
    await this.sleep(800);
    console.log( "Se registro el usuario correctamente");
    this.auth.login(form).subscribe(data => {
      let dataResponse: ResponseI = data;
        localStorage.setItem("token", dataResponse.token);
        localStorage.setItem("status", dataResponse.status);
        localStorage.setItem("userType", dataResponse.type);
        localStorage.setItem("userID", dataResponse.userID);
        localStorage.setItem("user", form.username);
        this.router.navigate(['/home']);
    });

  }

  sleep(ms) {
    return new Promise((resolve) => {
      setTimeout(resolve, ms);
    });
  }


}
