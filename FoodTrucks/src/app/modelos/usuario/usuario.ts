export class Usuario {
    public nombre: string;
    public apellido: string;
    public username: string;
    public password: string;
    public foodtrucker: boolean;
    public organizador: boolean;

    constructor (nombre: string, apellido: string, username: string, password: string, foodtrucker:boolean, organizador:boolean){
        this.nombre = nombre;
        this.apellido = apellido;
        this.username = username;
        this.password = password;
        this.foodtrucker = foodtrucker;
        this.organizador = organizador;
    }
    
}
