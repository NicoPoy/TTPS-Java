import { Component, OnInit } from '@angular/core';
import { Usuario } from '../modelos/usuario/usuario';
import { ApiService } from 'src/app/servicios/api.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-editar-perfil',
  templateUrl: './editar-perfil.component.html',
  styleUrls: ['./editar-perfil.component.css']
})
export class EditarPerfilComponent implements OnInit {

  u = Usuario;

  constructor(private api:ApiService, private router:Router) { }

  ngOnInit(): void {
    if( localStorage.getItem("token") == null || localStorage.getItem("token") == "null" ){
      this.router.navigate(['/login']);
    }
    //this.u = this.api.getUsuario(+localStorage.getItem("userID"));
  }

}
