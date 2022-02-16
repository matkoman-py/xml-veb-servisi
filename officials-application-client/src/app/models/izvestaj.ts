

    export interface IzvPeriod {
        Datum_od: string;
        Datum_do: string;
    }

    export interface IzvZeleniSertifikatInfo {
        Broj_primljenih_zahteva: number;
        Broj_izdatih_sertifikata: number;
    }

    export interface IzvDozaInfo {
        Broj_datih_doza: number;
        Broj_date_prve_doze: number;
        Broj_date_druge_doze: number;
    }

    export interface IzvProizvodjaciInfo {
        Broj_doza_Pfizer_BioNTech: number;
        Broj_doza_Sinopharm: number;
        Broj_doza_SputnikV: number;
        Broj_doza_AstraZeneca: number;
    }

    export interface IzvIzvestajOImunizaciji {
        Period: IzvPeriod;
        Broj_podnetih_interesovanja: number;
        Zeleni_sertifikat_info: IzvZeleniSertifikatInfo;
        Doza_info: IzvDozaInfo;
        Proizvodjaci_info: IzvProizvodjaciInfo;
        Datum_izdavanja: Date;
    }

