import {
  Component,
  OnInit
} from '@angular/core';
import {
  UserDocumentsService
} from './services/user-documents.service';

@Component({
  selector: 'app-user-documents',
  templateUrl: './user-documents.component.html',
  styleUrls: ['./user-documents.component.css']
})
export class UserDocumentsComponent implements OnInit {

  content: any;
  blob: any;
  documentNames: string[] = [];
  constructor(
    private userDocumentsService: UserDocumentsService,
  ) {}

  ngOnInit(): void {
    this.userDocumentsService.getAllDocuments(localStorage.getItem('jmbg')!).subscribe((data) => {
      this.documentNames = data;
    });
  }

  downloadPDF(docName: string): void {
    let forSend: string = "";

    if(docName.startsWith("Zahtev")) forSend = docName.split(' ')[1];
    else forSend = localStorage.getItem('jmbg')!;

    this.userDocumentsService.getPDF(forSend, this.getDocType(docName)).subscribe((data) => {
      this.blob = new Blob([data], {
        type: 'application/pdf'
      });

      const url = window.URL.createObjectURL(this.blob);
      const link = document.createElement('a');

      if (link.download === undefined) return
      
      link.setAttribute('href', url);
      link.setAttribute('download', 'fileName.pdf');
      link.style.visibility = 'hidden';
      document.body.appendChild(link);
      link.click();
      document.body.removeChild(link);

    });
  }

  downloadHTML(docName: string): void {
    let forSend: string = "";

    if(docName.startsWith("Zahtev")) forSend = docName.split(' ')[1];
    else forSend = localStorage.getItem('jmbg')!;
    
    this.userDocumentsService.getHTML(forSend, this.getDocType(docName)).subscribe((data) => {
      this.blob = new Blob([data], {
        type: 'application/pdf'
      });

      const url = window.URL.createObjectURL(this.blob);
      const link = document.createElement('a');

      if (link.download === undefined) return
      
      link.setAttribute('href', url);
      link.setAttribute('download', 'fileName.html');
      link.style.visibility = 'hidden';
      document.body.appendChild(link);
      link.click();
      document.body.removeChild(link);

    });
  }

  display(docName: string): void {
    let forSend: string = "";

    if(docName.startsWith("Zahtev")) forSend = docName.split(' ')[1];
    else forSend = localStorage.getItem('jmbg')!;

    this.userDocumentsService.getPDF(forSend, this.getDocType(docName)).subscribe((data) => {
      this.blob = new Blob([data], {
        type: 'application/pdf'
      });
      const url = window.URL.createObjectURL(this.blob);
      window.open(url, '_blank');
    });
  }

  getDocType(docName: string): string{
    if(docName === 'Interesovanje') return 'interesovanje';
    if(docName === 'Potvrda') return 'potvrda';
    if(docName === 'Saglasnost') return 'saglasnost';
    if(docName.startsWith('Zahtev')) return 'zahtev';
    if(docName === 'Zeleni sertifikat') return 'zeleni';
    return '';
  }
}
