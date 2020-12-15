import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router'
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Usuario } from 'src/app/modelos/usuario/usuario'
import { ApiService } from 'src/app/servicios/api.service'

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.css']
})

export class RegistroComponent implements OnInit {

  nuevoForm = new FormGroup({
    nombre: new FormControl('', [Validators.required, Validators.minLength(3)] ),
    apellido: new FormControl('', [Validators.required, Validators.minLength(3)] ),
    username: new FormControl('', [Validators.required, Validators.minLength(3)] ),
    password: new FormControl('', [Validators.required, Validators.minLength(3)] ),
    foodtrucker: new FormControl(''),
    organizador: new FormControl(''),
    zona: new FormControl ('1')
  })

  constructor( private api:ApiService ) { }

  ngOnInit(): void {
  }

  postForm( form ){
    this.api.crearUsuario(form).subscribe(data => console.log(data) );
  }

}
