

export interface ZzsPodnosilacZahteva {
    Ime_i_prezime: string;
    Datum_rodjenja: string;
    Pol: string;
    Jedinstveni_maticni_broj_gradjana: string;
    Broj_pasosa: string;
}


export interface ZzsInformacijeOZahtevu {
    Razlog: string;
    Mesto: string;
    Datum_izdavanja: string;
}

export interface Zahtev {
    about: string;
    Podnosilac_zahteva: ZzsPodnosilacZahteva;
    Informacije_o_zahtevu: ZzsInformacijeOZahtevu;
}