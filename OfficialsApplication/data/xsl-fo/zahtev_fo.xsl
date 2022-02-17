<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:zzs="http://www.ftn.uns.ac.rs/zahtev_zelenog_sertifikata"
    xmlns:fo="http://www.w3.org/1999/XSL/Format" version="2.0">
    
    <xsl:template match="/">
        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master master-name="bookstore-page">
                    <fo:region-body margin="0.75in"/>
                </fo:simple-page-master>
            </fo:layout-master-set>
            
            <fo:page-sequence master-reference="bookstore-page">
                <fo:flow flow-name="xsl-region-body">
                    <fo:block font-family="sans-serif" font-size="2em" font-weight="bold" padding="10px" text-align="center">
                        ZAHTEV
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="1.5em" font-weight="bold" padding="10px" text-align="center">
                        ZA IZDAVANJE ZELENOG SERTIFIKATA
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="1em" padding="10px">
                        U skladu sa odredbom Republike Srbije o izdavanju digitalnog zelenog sertifikata kao potvrde o izvrsenoj vakcinaciji protiv COVID-19, rezultatima testiranja na zaraznu bolest SARS-CoV-2 ili oporavku od bolesti COVID-19, podnosim zahtev za izdavanje digitalnog zelenog sertifikata.
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="1em" padding="10px">
                        <fo:inline>
                            Ime i prezime:
                        </fo:inline>
                        <fo:inline border-bottom-style="dotted">
                            <xsl:value-of select="zzs:zahtev/zzs:Podnosilac_zahteva/zzs:Ime_i_prezime"/>
                        </fo:inline>
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="1em" padding="10px">
                        <fo:inline>
                            Datum rodjenja:
                        </fo:inline>
                        <fo:inline border-bottom-style="dotted">
                            <xsl:value-of select="zzs:zahtev/zzs:Podnosilac_zahteva/zzs:Datum_rodjenja"/>
                        </fo:inline>
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="1em" padding="10px">
                        <fo:inline>
                            Pol:
                        </fo:inline>
                        <fo:inline border-bottom-style="dotted">
                            <xsl:value-of select="zzs:zahtev/zzs:Podnosilac_zahteva/zzs:Pol"/>
                        </fo:inline>
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="1em" padding="10px">
                        <fo:inline>
                            Jedinstveni maticni broj gradjana:
                        </fo:inline>
                        <fo:inline border-bottom-style="dotted">
                            <xsl:value-of select="zzs:zahtev/zzs:Podnosilac_zahteva/zzs:Jedinstveni_maticni_broj_gradjana"/>
                        </fo:inline>
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="1em" padding="10px">
                        <fo:inline>
                            Broj pasosa:
                        </fo:inline>
                        <fo:inline border-bottom-style="dotted">
                            <xsl:value-of select="zzs:zahtev/zzs:Podnosilac_zahteva/zzs:Broj_pasosa"/>
                        </fo:inline>
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="1em" padding="10px">
                        <fo:inline>
                            Razlog za podnosenje zahteva:
                        </fo:inline> 
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="1em" padding="10px">
                        <fo:inline border-bottom-style="dotted">
                            <xsl:value-of select="zzs:zahtev/zzs:Informacije_o_zahtevu/zzs:Razlog"/>
                        </fo:inline>
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="10px" text-align="center">
                        (navesti sto precizniji razlog za podnosenje zahteva za izdavanje digitalnog pasosa)
             
                    
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="1em" padding="10px" margin-top="50px">
                        <fo:inline>
                            U
                        </fo:inline>
                        <fo:inline border-bottom-style="dotted">
                            <xsl:value-of select="zzs:zahtev/zzs:Informacije_o_zahtevu/zzs:Mesto"/>,
                        </fo:inline>
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="1em" padding="10px" >
                        <fo:inline>
                            Dana
                        </fo:inline>
                        <fo:inline border-bottom-style="dotted">
                            <xsl:value-of select="zzs:zahtev/zzs:Informacije_o_zahtevu/zzs:Datum_izdavanja"/> godine
                        </fo:inline>
                    </fo:block>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
</xsl:stylesheet>