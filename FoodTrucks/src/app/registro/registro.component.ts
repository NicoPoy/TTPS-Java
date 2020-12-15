import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Usuario } from 'src/app/modelos/usuario/usuario'
import { ApiService } from 'src/app/servicios/api.service'
import { AuthenticationService } from 'src/app/servicios/authentication.service'
import { Router } from '@angular/router';
import { ResponseI } from 'src/app/modelos/response/response-i'

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.css']
})

export class RegistroComponent implements OnInit {

  delay = ms => new Promise(res => setTimeout(res, ms));

  nuevoForm = new FormGroup({
    nombre: new FormControl('', [Validators.required, Validators.minLength(3)] ),
    apellido: new FormControl('', [Validators.required, Validators.minLength(3)] ),
    username: new FormControl('', [Validators.required, Validators.minLength(3)] ),
    password: new FormControl('', [Validators.required, Validators.minLength(3)] ),
    tipocuenta: new FormControl(''),
    zona: new FormControl ('1')
  })

  constructor( private api:ApiService, private auth: AuthenticationService, private router:Router ) { }

  ngOnInit(): void { }

  async postForm( form:Usuario ){
    this.api.crearUsuario(form).subscribe(data => console.log(data) );
    console.log( "Se registro el usuario correctamente");

    await this.sleep(200);

    this.auth.login(form).subscribe(data => {
      let dataResponse: ResponseI = data;
      if (dataResponse.status == "ok") {
        localStorage.setItem("token", dataResponse.token);
        localStorage.setItem("userType", dataResponse.type);
        this.router.navigate(['/home']);
      }
    });

  }

  sleep(ms) {
    return new Promise((resolve) => {
      setTimeout(resolve, ms);
    });
  }

  
}
