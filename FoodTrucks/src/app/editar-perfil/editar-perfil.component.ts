import { Component, OnInit } from '@angular/core';
import { Usuario } from '../modelos/usuario/usuario';
import { ApiService } from 'src/app/servicios/api.service';
import { Router } from '@angular/router';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-editar-perfil',
  templateUrl: './editar-perfil.component.html',
  styleUrls: ['./editar-perfil.component.css']
})
export class EditarPerfilComponent implements OnInit {

  u: Usuario;

  actUsuarioForm = new FormGroup({
        nombre: new FormControl(),
        apellido: new FormControl(),
        username: new FormControl(),
        password: new FormControl(),
  });

  constructor(private api:ApiService, private router:Router) { }

  ngOnInit(): void {
    
    if( localStorage.getItem("token") == null || localStorage.getItem("token") == "null" ){
      this.router.navigate(['/login']);
    }

    this.api.getUsuario(localStorage.getItem("userID")).subscribe(data => {
      
      this.u = data;

      this.actUsuarioForm.setControl('nombre', new FormControl(this.u.nombre,[Validators.required, Validators.minLength(3)] ));
      this.actUsuarioForm.setControl('apellido', new FormControl(this.u.apellido,[Validators.required, Validators.minLength(3)] ));
      this.actUsuarioForm.setControl('username', new FormControl(this.u.username,[Validators.required, Validators.minLength(3)] ));
      this.actUsuarioForm.setControl('password', new FormControl(this.u.password,[Validators.required, Validators.minLength(3)] ));

      /* this.actUsuarioForm = new FormGroup({
        nombre: new FormControl(this.u.nombre, [Validators.required, Validators.minLength(3)] ),
        apellido: new FormControl(this.u.apellido, [Validators.required, Validators.minLength(3)] ),
        username: new FormControl(this.u.username, [Validators.required, Validators.minLength(3)] ),
        password: new FormControl(this.u.password, [Validators.required, Validators.minLength(3)] ),
      }) */
    
    });   

  }

  async editarUsuarioForm(form: Usuario){
    this.api.editarUsuario(form).subscribe( data => console.log(data) );
    //this.router.navigate(['/home']);
  }

}
