import { Injectable } from '@angular/core';
import { Usuario } from 'src/app/modelos/usuario/usuario';
import { ResponseI } from 'src/app/modelos/response/response-i';
import { HttpClient, HttpHeaders } from '@angular/common/http'
import { Observable } from 'rxjs';
import { environment as env } from 'src/environments/environment';
import { LoginComponent } from '../login/login.component';
import { Foodtruck } from '../modelos/foodtruck/foodtruck.model';
import { Subject } from 'rxjs';

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

  iniciarSesion(form:Usuario):Observable<ResponseI>{
    return this.http.post<ResponseI>( `${env.url}ttps-spring/auth/login`, form)
  }

  //DATOS DE PRUEBA QUE HAY QUE BORRAR owo
  mejoresft: Foodtruck[];
  ft1: Foodtruck; ft2: Foodtruck;
  stringAux1: string[]; stringAux2: string[];

  mejoresFoodTrucks(){ //todavia no anda, tiene datos de prueba.


    this.stringAux1 = [];
    this.stringAux1.push("Cerveza");
    this.stringAux1.push("Mani");
    this.ft1 = new Foodtruck(1,"Camioncito", "Es un camion.", "@insta_random", "@twitter_random", "+56438937298", "https://www.camioncito.com", this.stringAux1);

    
    this.stringAux2 = [];
    this.stringAux2.push("Hamburguesas");
    this.stringAux2.push("Panchos");
    this.ft2 = new Foodtruck(2,"Camionsote", "Alta máquina.", "@insta_uwu", "@twitter_uwu", "1543337638743980", "http://www.camionsote.gov.ar", this.stringAux2);
  
    this.mejoresft = [];
    this.mejoresft.push(this.ft1);
    this.mejoresft.push(this.ft2);


    return this.mejoresft;

  }

  getFoodTruck(idft: number){ //todavia no anda, tiene datos de prueba.
  
    this.stringAux1 = [];
    this.stringAux1.push("Coca-Cola");
    this.stringAux1.push("Pepsi");
    this.stringAux1.push("Manaos");
    this.ft1 = new Foodtruck(3,"Camionazo", "Autobot.", "@un_insta", "@un_twitter", "+4874837434919", "https://www.camionazo.com/owo", this.stringAux1);

    return this.ft1;
  
  }

  FoodTrucksDeUsuario(id: number){ //todavia no anda, tiene datos de prueba.

    this.stringAux1 = [];
    this.stringAux1.push("BBBBBB");
    this.stringAux1.push("BBBBB");
    this.ft1 = new Foodtruck(4,"BBBBB", "BBBBB.", "BBBBB", "BBBBB", "BBBBB", "BBBBB", this.stringAux1);

    
    this.stringAux2 = [];
    this.stringAux2.push("CCCCC");
    this.stringAux2.push("CCCCC");
    this.ft2 = new Foodtruck(5,"CCCCC", "CCCCC", "CCCCC", "CCCCC", "CCCCC", "CCCCC", this.stringAux2);
  
    this.mejoresft = [];
    this.mejoresft.push(this.ft1);
    this.mejoresft.push(this.ft2);


    return this.mejoresft;

  }

}
