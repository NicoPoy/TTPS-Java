import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { elementAt } from 'rxjs/operators';
import { Foodtruck } from '../modelos/foodtruck/foodtruck.model';
import { TipoDeServicio } from '../modelos/tipoDeServicio/tipo-de-servicio';
import { ApiService } from '../servicios/api.service';

@Component({
  selector: 'app-act-foodtruck',
  templateUrl: './act-foodtruck.component.html',
  styleUrls: ['./act-foodtruck.component.css']
})
export class ActFoodtruckComponent implements OnInit {

  listaServicios: TipoDeServicio[];
  foodTruck: Foodtruck;
  
  editarFoodtruckForm = new FormGroup({
    nombre: new FormControl( ),
    url: new FormControl( ),
    whatsapp: new FormControl( ),
    twitter: new FormControl( ),
    instagram: new FormControl( ),
    descripcion: new FormControl( ),
  })
  
  constructor( private api:ApiService, private router:Router, private actRoute: ActivatedRoute ) {
    if( localStorage.getItem("token") == null || localStorage.getItem("token") == "null" ){
      this.router.navigate(['/login']); } 
  }

  ngOnInit(): void {

    if( localStorage.getItem("token") == null || localStorage.getItem("token") == "null" ){
      this.router.navigate(['/login']); }

    this.actRoute.paramMap.subscribe(params => {
      let idFoodTruck = params.get('id');

      this.api.getFoodTruck(idFoodTruck).subscribe(data => {
      
      this.foodTruck = data;

      this. editarFoodtruckForm.setControl('nombre', new FormControl(this.foodTruck.nombre,[Validators.required, Validators.minLength(3)] ));
      this. editarFoodtruckForm.setControl('url', new FormControl(this.foodTruck.url,[Validators.required, Validators.minLength(3)] ));
      this. editarFoodtruckForm.setControl('whatsapp', new FormControl(this.foodTruck.whatsapp,[Validators.required, Validators.minLength(3)] ));
      this. editarFoodtruckForm.setControl('twitter', new FormControl(this.foodTruck.twitter,[Validators.required, Validators.minLength(3)] ));
      this. editarFoodtruckForm.setControl('instagram', new FormControl(this.foodTruck.instagram,[Validators.required, Validators.minLength(3)] ));
      this. editarFoodtruckForm.setControl('descripcion', new FormControl(this.foodTruck.descripcion,[Validators.required, Validators.minLength(3)] ));

      this.api.getTiposDeServicio().subscribe( dataTipos => {
        this.listaServicios = dataTipos;
        
        this.listaServicios.map( elem =>  
          this.editarFoodtruckForm.addControl(elem.nombre, new FormControl('')) );
          for (let tipo of this.foodTruck.tipos) { 
            this. editarFoodtruckForm.setControl(tipo.nombre, new FormControl(true) ); }  
        } );

    } ); 
    } );
  
  }

  editarFoodtruckPut( form: Foodtruck ){
    console.log("entro al metodo")
  }
}
