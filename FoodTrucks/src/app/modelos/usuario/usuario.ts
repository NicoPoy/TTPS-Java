export class Usuario {
    public nombre: string;
    public apellido: string;
    public username: string;
    public password: string;
    //public tipocuenta: string;

    constructor (nombre: string, apellido: string, username: string, password: string){
        this.nombre = nombre;
        this.apellido = apellido;
        this.username = username;
        this.password = password;
    }
    
}
