import { Injectable } from '@angular/core';
import { Usuario } from 'src/app/modelos/usuario/usuario';
import { ResponseI } from 'src/app/modelos/response/response-i';
import { HttpClient, HttpHeaders } from '@angular/common/http'
import { Observable } from 'rxjs';
import { environment as env } from 'src/environments/environment';
import { LoginComponent } from '../login/login.component';
@Injectable({
  providedIn: 'root'
})
export class ApiService {

  postFoodTrucker:string = "http://localhost:8080/ttps-spring/foodtruckers";
  postOrganizador:string = "/ttps-spring/organizadores";

  constructor(private http: HttpClient) { }

  crearUsuario(form:Usuario):Observable<ResponseI>{
    if (form.tipocuenta == "foodtrucker") {
      return this.http.post<ResponseI>( `${env.url}ttps-spring/foodtruckers`, form)
    } else {
      return this.http.post<ResponseI>( `${env.url}ttps-spring/organizadores`, form) }
  }

  iniciarSesion(form:Usuario):Observable<ResponseI>{
    return this.http.post<ResponseI>( `${env.url}ttps-spring/auth/login`, form)
  }

}
