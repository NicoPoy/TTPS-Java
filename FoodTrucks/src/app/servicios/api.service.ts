import { Injectable } from '@angular/core';
import { Usuario } from 'src/app/modelos/usuario/usuario';
import { ResponseI } from 'src/app/modelos/response/response-i';
import { HttpClient, HttpHeaders } from '@angular/common/http'
import { Observable } from 'rxjs';
import { environment as env } from 'src/environments/environment';
import { LoginComponent } from '../login/login.component';
import { Foodtruck } from '../modelos/foodtruck/foodtruck.model';
import { Subject } from 'rxjs';
import { TipoDeServicio } from '../modelos/tipoDeServicio/tipo-de-servicio';
import { collectExternalReferences } from '@angular/compiler';
import { connectableObservableDescriptor } from 'rxjs/internal/observable/ConnectableObservable';

@Injectable({
  providedIn: 'root'
})

@Injectable({ providedIn: 'root' })

export class ApiService {

 
  constructor(private http: HttpClient) { }

  crearUsuario(form:Usuario):Observable<ResponseI>{
    if (form.tipocuenta == "foodtrucker") {
      return this.http.post<ResponseI>( `${env.url}ttps-spring/foodtruckers`, form)
    } else {
      return this.http.post<ResponseI>( `${env.url}ttps-spring/organizadores`, form) }
  }

  crearFoodTruck(form: Foodtruck):Observable<Foodtruck>{  
    return this.http.post<any>(`${env.url}ttps-spring/foodtrucks/`+localStorage.getItem("userID"), form, 
    { headers: { 'token':localStorage.getItem("token") } } )
    
  }

  iniciarSesion(form:Usuario):Observable<ResponseI>{
    return this.http.post<ResponseI>( `${env.url}ttps-spring/auth/login`, form)
  }
  
  getTiposDeServicio():Observable<TipoDeServicio[]> {
    return this.http.get<TipoDeServicio[]>(`${env.url}ttps-spring/tiposdeservicios`)
  }

  mejoresFoodTrucks():Observable<Foodtruck[]>{ 
    return this.http.get<Foodtruck[]>(`${env.url}ttps-spring/foodtrucks`)
  }

  getFoodTruck(idft: string):Observable<Foodtruck> { 
    return this.http.get<any>(`${env.url}ttps-spring/foodtrucks/buscar`,  { headers: { 'token':localStorage.getItem("token"), 'foodTruckID':idft } } )    
  }

  FoodTrucksDeUsuario(id: string):Observable<Foodtruck[]>{ 
    return this.http.get<Foodtruck[]>(`${env.url}ttps-spring/foodtrucks/`+id, { headers: { 'token':localStorage.getItem("token")} } )
  }

  esMiFoodTruck(idFt: string, idUs: string){ //todavia no anda, tiene datos de prueba.
    return true;
  }

  getUsuario(idu: string):Observable<Usuario> {
    let tipo: string = localStorage.getItem("userType");
    if(tipo == "foodtrucker"){
      return this.http.get<any>(`${env.url}ttps-spring/foodtruckers/`+idu,  { headers: { 'token':localStorage.getItem("token")} } )    
    }
    else{
      return this.http.get<any>(`${env.url}ttps-spring/organizadores/`+idu,  { headers: { 'token':localStorage.getItem("token")} } )    
    }  
  }

  editarUsuario(u: Usuario):Observable<Usuario>{
     return this.http.put<Usuario>(`${env.url}ttps-spring/foodtruckers/`+localStorage.getItem("userID"), u, { headers: { 'token': localStorage.getItem("token") } });
  }

}
