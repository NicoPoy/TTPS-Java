import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.css']
})
export class RegistroComponent implements OnInit {

  nuevoForm = new FormGroup({
    nombre: new FormControl('', [Validators.required, Validators.minLength(3)] ),
    apellido: new FormControl('', [Validators.required, Validators.minLength(3)] ),
    correo: new FormControl('', Validators.required)
  })

  constructor() { }

  ngOnInit(): void {
  }

  postForm(form: usuario){

  }

}
