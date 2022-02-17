import { SelectType } from './select';

export interface SaglasnostDTO {
  ime?: string;
  prezime?: string;
  imeRoditelja?: string;
  jmbg?: string;
  pol?: SelectType;
  datumRodjenja?: Date;
  mestoRodjenja?: string;
  ulicaIBroj?: string;
  mestoZivota?: string;
  opstina?: string;
  email?: string;
  mobilni?: string;
  fiksni?: string;
  zanimanje?: SelectType;
  radniStatus?: SelectType;
  socijalnaZastita?: string;
  sedisteSocZastite?: string;
  vakcina?: SelectType;
}
