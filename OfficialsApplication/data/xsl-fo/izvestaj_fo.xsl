<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:b="www.ftn.uns.ac.rs/Izvestaj_o_imunizaciji"
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
                        IZVESTAJ O IMUNIZACIJI
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="1em" padding="10px">
                        <fo:inline>
                            Izvestaj se odnosi na period od
                        </fo:inline>
                        <fo:inline font-weight="bold">
                            <xsl:value-of select="b:Izvestaj_o_imunizaciji/b:Period/b:Datum_od"/>
                        </fo:inline>
                        <fo:inline>
                            do
                        </fo:inline>
                        <fo:inline font-weight="bold">
                            <xsl:value-of select="b:Izvestaj_o_imunizaciji/b:Period/b:Datum_do"/>
                        </fo:inline>
                    </fo:block>
                    <fo:block>
                        U napomenutom vremenskom intervalu je:
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="1em" padding="7px" text-indent="12mm">
                        •   Podneto <fo:inline font-weight="bold">
                            <xsl:value-of select="b:Izvestaj_o_imunizaciji/b:Broj_podnetih_interesovanja"/>
                        </fo:inline> dokumenta o interesovanju za vakcinu
                     
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="1em" padding="7px" text-indent="12mm">
                        •   Primljeno <fo:inline font-weight="bold">
                            <xsl:value-of select="b:Izvestaj_o_imunizaciji/b:Zeleni_sertifikat_info/b:Broj_primljenih_zahteva"/>
                        </fo:inline> zahteva za digitalni zeleni sertifikat, od kojih je izdato <fo:inline font-weight="bold">
                            <xsl:value-of select="b:Izvestaj_o_imunizaciji/b:Zeleni_sertifikat_info/b:Broj_izdatih_zahteva"/>
                        </fo:inline>
                        
                    </fo:block>
                    
                    <fo:block>
                        Dato je <fo:inline font-weight="bold">
                            <xsl:value-of select="b:Izvestaj_o_imunizaciji/b:Doza_info/b:Broj_datih_doza"/>
                        </fo:inline> doza vakcine protiv covid-19 virusa u sledecoj kolicini:
                    </fo:block>
                    
                    <fo:block margin-top="10px">
                        
                        <fo:table>
                            <fo:table-body>
                                <fo:table-row>
                                    <fo:table-cell border="solid 0.1mm black" padding="30px" text-align="center">
                                        <fo:block font-weight="bold">Redni broj doze</fo:block>
                                    </fo:table-cell >
                                    <fo:table-cell border="solid 0.1mm black" padding="30px" text-align="center">
                                        <fo:block font-weight="bold">Broj datih doza</fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                                <fo:table-row>
                                    <fo:table-cell border="solid 0.1mm black" padding="30px" text-align="center">
                                        <fo:block>1</fo:block>
                                    </fo:table-cell >
                                    <fo:table-cell border="solid 0.1mm black" padding="30px" text-align="center">
                                        <fo:block><xsl:value-of select="b:Izvestaj_o_imunizaciji/b:Doza_info/b:Broj_date_prve_doze"/></fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                                <fo:table-row>
                                    <fo:table-cell border="solid 0.1mm black" padding="30px" text-align="center">
                                        <fo:block>2</fo:block>
                                    </fo:table-cell >
                                    <fo:table-cell border="solid 0.1mm black" padding="30px" text-align="center">
                                        <fo:block><xsl:value-of select="b:Izvestaj_o_imunizaciji/b:Doza_info/b:Broj_date_prve_doze"/></fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                            </fo:table-body>
                        </fo:table>                         
                    </fo:block>
                    <fo:block margin-top="40px">
                        Raspodela po proizvodjacima je:
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="1em" padding="7px" text-indent="12mm">
                        •    <fo:inline font-weight="bold">
                            Pfizer, BioNTech - <xsl:value-of select="b:Izvestaj_o_imunizaciji/b:Proizvodjaci_info/b:Broj_doza_Pfizer_BioNTech"/>
                        </fo:inline> doza
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="1em" padding="7px" text-indent="12mm">
                        •    <fo:inline font-weight="bold">
                            Sinopharm - <xsl:value-of select="b:Izvestaj_o_imunizaciji/b:Proizvodjaci_info/b:Broj_doza_Sinopharm"/>
                        </fo:inline> doza
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="1em" padding="7px" text-indent="12mm">
                        •    <fo:inline font-weight="bold">
                            Sputnik V - <xsl:value-of select="b:Izvestaj_o_imunizaciji/b:Proizvodjaci_info/b:Broj_doza_SputnikV"/>
                        </fo:inline> doza
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="1em" padding="7px" text-indent="12mm">
                        •    <fo:inline font-weight="bold">
                            AstraZenece, Oxford - <xsl:value-of select="b:Izvestaj_o_imunizaciji/b:Proizvodjaci_info/b:Broj_doza_AstraZeneca"/>
                        </fo:inline> doza
                    </fo:block>
                    <fo:block>
                        Datum izdavanja: <fo:inline text-decoration="underline">
                            <xsl:value-of select="b:Izvestaj_o_imunizaciji/b:Datum_izdavanja"/>
                        </fo:inline> godine
                    </fo:block>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
</xsl:stylesheet>