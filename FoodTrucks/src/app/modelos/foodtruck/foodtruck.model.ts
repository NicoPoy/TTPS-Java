export class Foodtruck {

    public id: number;
    public nombre: string;
    public descripcion: string;
    public instagram: string;
    public twitter: string;
    public whatsapp: string;
    public url: string;
    public servicios: string[];

    constructor (i: number, n: string, d: string, ig: string, t: string, w: string, u: string, s: string[]){

        this.id = i;
        this.nombre = n;
        this.descripcion = d;
        this.instagram = ig;
        this.twitter = t;
        this.whatsapp = w;
        this.url = u;
        this.servicios = s;
    
    }
}