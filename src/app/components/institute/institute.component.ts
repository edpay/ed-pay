import { Component, OnInit, Input } from '@angular/core';
import { Institution } from 'src/app/models/institution';

@Component({
  selector: 'app-institute',
  templateUrl: './institute.component.html',
  styleUrls: ['./institute.component.scss']
})
export class InstituteComponent implements OnInit {

  @Input() selInstitute: Institution;

  constructor() { }

  ngOnInit() {
  }

}
