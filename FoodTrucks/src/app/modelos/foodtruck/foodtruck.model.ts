import { TipoDeServicio } from "../tipoDeServicio/tipo-de-servicio";

export class Foodtruck {

    public id: number;
    public nombre: string;
    public descripcion: string;
    public instagram: string;
    public twitter: string;
    public whatsapp: string;
    public url: string;
    public tipos:any;

    constructor (i: number, n: string, d: string, ig: string, t: string, w: string, u: string, s:any ){
        this.id = i;
        this.nombre = n;
        this.descripcion = d;
        this.instagram = ig;
        this.twitter = t;
        this.whatsapp = w;
        this.url = u;
        this.tipos = s;
    }

}