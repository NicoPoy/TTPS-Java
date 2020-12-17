import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable, Subject } from 'rxjs';
import { map } from 'rxjs/operators';
import { environment as env } from 'src/environments/environment';
import { Usuario } from 'src/app/modelos/usuario/usuario';

@Injectable({ providedIn: 'root' })

export class AuthenticationService {
    private currentUserSubject: BehaviorSubject<Usuario>;
    public currentUser: Observable<Usuario>;

    constructor(private http: HttpClient) {
        this.currentUserSubject = new BehaviorSubject<Usuario>(JSON.parse(localStorage.getItem('currentUser')));
        this.currentUser = this.currentUserSubject.asObservable();
    }

    public get currentUserValue(): Usuario {
        return this.currentUserSubject.value;
    }

    login(form:Usuario):Observable<any> {
        return this.http.post<any>(`${env.url}ttps-spring/auth/login`, form )
            .pipe(map(credentials => {
                if (credentials && credentials.token) {
                    this.currentUserSubject.next(credentials);
                }
                return credentials;
        }   ));
    }

    logout() {
        this.currentUserSubject.next(null);
        localStorage.setItem("token", null);
        localStorage.setItem("status", "ok");
        localStorage.setItem("userID", null);
        localStorage.setItem("userType", "publico");
        localStorage.setItem("user", null);
    }

}