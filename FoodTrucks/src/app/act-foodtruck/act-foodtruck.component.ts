import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Foodtruck } from '../modelos/foodtruck/foodtruck.model';
import { TipoDeServicio } from '../modelos/tipoDeServicio/tipo-de-servicio';
import { ApiService } from '../servicios/api.service';

@Component({
  selector: 'app-act-foodtruck',
  templateUrl: './act-foodtruck.component.html',
  styleUrls: ['./act-foodtruck.component.css']
})
export class ActFoodtruckComponent implements OnInit {

  idFoodTruck: string;
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
      this.idFoodTruck = params.get('id');

      this.api.getFoodTruck(this.idFoodTruck).subscribe(data => {
      
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

  async editarFoodtruckPut( form: Foodtruck ){

    let selectServicios: Array<TipoDeServicio> = [];

    this.listaServicios.map( elem => {
      if ( this.editarFoodtruckForm.controls[elem.nombre].value ) {
        selectServicios.push(elem);
      };
    });

    let ft = new Foodtruck (null,form.nombre, form.descripcion, form.instagram, form.twitter, form.whatsapp, form.url, selectServicios);
    this.api.editarFoodTruck(ft, this.idFoodTruck).subscribe( data => { console.log(data) })

    await this.sleep(500);
    this.router.navigate(['/foodtruck/'+this.idFoodTruck]);

  }

  sleep(ms) {
    return new Promise((resolve) => {
      setTimeout(resolve, ms);
    });
  }

}
