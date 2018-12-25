import { Component, OnInit, ViewChild } from '@angular/core';
import { Institution } from 'src/app/models/institution';
import { InstitutionsService } from 'src/app/services/institutions.service';
import { ModalDirective } from 'angular-bootstrap-md';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
  providers: []
})
export class HomeComponent implements OnInit {

  @ViewChild('LoginModal') LoginModal: ModalDirective;

  institutions: Institution[];

  selectedInstitute: Institution;

  constructor(private insService: InstitutionsService, private router: Router) {
  }

  ngOnInit() {
    this.insService.getInstitutions().subscribe(res => {
      this.institutions = res.body;
    })
  }

  showIns(institute: Institution) {
    this.LoginModal.show();
    this.selectedInstitute = institute;
  }

  applyForm(institite: Institution) {
    this.router.navigate(['/apply', { id: institite.id }]);
  }
}
