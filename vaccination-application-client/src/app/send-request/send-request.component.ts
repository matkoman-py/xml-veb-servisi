import {
  Component,
  OnInit
} from '@angular/core';
import {
  SendRequestService
} from './service/send-request.service';

@Component({
  selector: 'app-send-request',
  templateUrl: './send-request.component.html',
  styleUrls: ['./send-request.component.css'],
  providers: [SendRequestService]
})
export class SendRequestComponent implements OnInit {

  constructor(private sendRequestService: SendRequestService) {}

  polovi = [{
      name: 'Musko',
      value: 'Musko'
    },
    {
      name: 'Zensko',
      value: 'Zensko'
    },
  ];

  text: string = "";
  ime_i_prezime: string = "";
  pol = {
    name: '',
    value: ''
  };
  datum_rodjenja: Date = new Date();
  broj_pasosa: Number | undefined = undefined;
  mesto: string = "";

  config = {
    toolbar: [
      ['bold', 'italic', 'underline', 'strike'], // toggled buttons
      [{
        'header': 1
      }], // custom button values
      [{
        'list': 'bullet'
      }],
      [{
        'align': 'center'
      }],
    ]
  }
  ngOnInit(): void {}

  onChange() {
    var today = new Date();
    var dd = String(today.getDate()).padStart(2, '0');
    var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
    var yyyy = today.getFullYear();

    let datum_izdavanja = yyyy + '-' + mm + '-' + dd;
    console.log(datum_izdavanja);
    var searchKeyword = "<br>";
    var startingIndices = [];
    var indexOccurence = this.text.indexOf(searchKeyword, 0);


    var day = this.datum_rodjenja.toLocaleDateString().split('/')[2] + "-" +
      this.datum_rodjenja.toLocaleDateString().split('/')[0] + "-" +
      this.datum_rodjenja.toLocaleDateString().split('/')[1];
    if (this.datum_rodjenja.toLocaleDateString().split('/')[0].length === 1) {
      day = this.datum_rodjenja.toLocaleDateString().split('/')[2] + "-" +
        +"0" + this.datum_rodjenja.toLocaleDateString().split('/')[0] + "-" +
        this.datum_rodjenja.toLocaleDateString().split('/')[1];
    }

    if (this.datum_rodjenja.toLocaleDateString().split('/')[1].length === 1) {
      day = this.datum_rodjenja.toLocaleDateString().split('/')[2] + "-" +
        this.datum_rodjenja.toLocaleDateString().split('/')[0] + "-" +
        +"0" + this.datum_rodjenja.toLocaleDateString().split('/')[1];
    }

    if (this.datum_rodjenja.toLocaleDateString().split('/')[1].length === 1 && this.datum_rodjenja.toLocaleDateString().split('/')[0].length === 1) {
      day = this.datum_rodjenja.toLocaleDateString().split('/')[2] + "-" +
        +"0" + this.datum_rodjenja.toLocaleDateString().split('/')[0] + "-" +
        +"0" + this.datum_rodjenja.toLocaleDateString().split('/')[1];
    }



    console.log(day)
    while (indexOccurence >= 0) {
      startingIndices.push(indexOccurence);

      indexOccurence = this.text.indexOf(searchKeyword, indexOccurence + 1);
    }
    console.log(this.text)
    console.log(startingIndices.length);
    let richText: string = this.text.split("<br>").join("<br></br>").toString();

    let xml = `<zzs:zahtev xmlns:zzs="http://www.ftn.uns.ac.rs/zahtev_zelenog_sertifikata" xmlns:pred="http://www.ftn.uns.ac.rs/predicate/" about="">
    <zzs:Podnosilac_zahteva>
        <zzs:Ime_i_prezime property="pred:ime_i_prezime" datatype="xs:string">${this.ime_i_prezime}</zzs:Ime_i_prezime>
        <zzs:Datum_rodjenja>${day}</zzs:Datum_rodjenja>
        <zzs:Pol>${this.pol.name}</zzs:Pol>
        <zzs:Jedinstveni_maticni_broj_gradjana property="pred:jmbg" datatype="xs:string">313131313131</zzs:Jedinstveni_maticni_broj_gradjana>
        <zzs:Broj_pasosa property="pred:broj_pasosa" datatype="xs:string">${this.broj_pasosa}</zzs:Broj_pasosa>
    </zzs:Podnosilac_zahteva>
    <zzs:Informacije_o_zahtevu>
        <zzs:Razlog>aefasfa</zzs:Razlog>
        <zzs:Mesto>${this.mesto}</zzs:Mesto>
        <zzs:Datum_izdavanja property="pred:datum" datatype="xs:date">${datum_izdavanja}</zzs:Datum_izdavanja>
    </zzs:Informacije_o_zahtevu>
</zzs:zahtev>`;
    console.log(xml);
    this.sendRequestService.postRequest(xml).subscribe(res => {
      console.log(res);
    })
  }
}
