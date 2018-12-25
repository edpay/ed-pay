import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Institution } from '../models/institution';

@Injectable()
export class InstitutionsService {

  instituionsURL = 'assets/test.json';
  constructor(private http: HttpClient) { }

  getInstitutions() {
    return this.http.get<Institution[]>(this.instituionsURL, {observe: 'response'});
  }
}
