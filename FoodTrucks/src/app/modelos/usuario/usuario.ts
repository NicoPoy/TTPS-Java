import { Zona } from "../zona/zona";

export class Usuario {
    public nombre: string;
    public apellido: string;
    public username: string;
    public password: string;
    public tipocuenta: string;
    public zona: Zona;

    constructor (nombre: string, apellido: string, username: string, password: string, tipocuenta: string){
        this.nombre = nombre;
        this.apellido = apellido;
        this.username = username;
        this.password = password;
        this.tipocuenta = tipocuenta;
    }
    
}
