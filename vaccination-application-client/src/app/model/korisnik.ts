import { SelectType } from './select';

export interface KorisnikDTO {
  drzavljanstvo?: SelectType;
  ime?: string;
  prezime?: string;
  imeRoditelja?: string;
  jmbg?: string;
  brojPasosa?: string;
  pol?: SelectType;
  datumRodjenja?: Date;
  mestoRodjenja?: string;
  ulicaIBroj?: string;
  mestoZivota?: string;
  opstina?: string;
  email?: string;
  mobilni?: string;
  fiksni?: string;
  sifra?: string;
}
