<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:izv="http://www.ftn.uns.ac.rs/Izvestaj_o_imunizaciji" version="2.0">
    
    <xsl:template match="/">
        <html>
            <head>
                <title>Izvestaj (XSLT)</title>
                <style type="text/css">
                    h1 {text-align: center;}
                    table {
                    font-family: serif;
                    border-collapse: collapse;
                    margin: 50px auto 50px auto;
                    width: 90%;
                    }
                    th, td {
                    text-align: left;
                    padding: 30px;
                    border: 1px solid darkgrey;
                    }
                    th {
                    font-family: sans-serif;
                    color: white;
                    border: 1px solid darkgrey;
                    }
                    tr { border: 1px solid darkgrey; }
                    body { font-family: sans-serif; }
                    
                </style>
            </head>
            <body>
                <h1>Izvestaj o imunizaciji</h1>
                <p>Izvestaj se odnosi na period od <b><xsl:value-of select="izv:Izvestaj_o_imunizaciji/izv:Period/izv:Datum_od"/></b> do <b><xsl:value-of select="izv:Izvestaj_o_imunizaciji/izv:Period/izv:Datum_do"/></b></p>
                <p>U napomenutom vremenskom intervalu je:</p>
                <ul>
                    <li>Podneto <b><xsl:value-of select="izv:Izvestaj_o_imunizaciji/izv:Broj_podnetih_interesovanja"/></b> dokumenta o interesovanju za vakcinu</li>
                    <li>Primeljeno <b><xsl:value-of select="izv:Izvestaj_o_imunizaciji/izv:Zeleni_sertifikat_info/izv:Broj_primljenih_zahteva"/></b> zahteva za digitalni zeleni sertifikat, od kojih je <b><xsl:value-of select="izv:Izvestaj_o_imunizaciji/izv:Zeleni_sertifikat_info/izv:Broj_izdatih_sertifikata"/></b> izdato</li>
                </ul>
                <p>Dato je <b><xsl:value-of select="izv:Izvestaj_o_imunizaciji/izv:Doza_info/izv:Broj_datih_doza"/></b> doza vakcine protiv covid-19 virusa u sledecoj kolicini:</p>
                <table style="border: 1px">
                    <tr>
                        <td><b>Redni broj doze</b></td>
                        <td><b>Broj datih doza</b></td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td><xsl:value-of select="izv:Izvestaj_o_imunizaciji/izv:Doza_info/izv:Broj_date_prve_doze"/></td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td><xsl:value-of select="izv:Izvestaj_o_imunizaciji/izv:Doza_info/izv:Broj_date_druge_doze"/></td>
                    </tr>
                </table>
                <p>Raspodela po proizvodjacima je:</p>
                <ul>
                    <li><b>Pfizer, BioNTech - <xsl:value-of select="izv:Izvestaj_o_imunizaciji/izv:Proizvodjaci_info/izv:Broj_doza_Pfizer_BioNTech"/> </b>doza</li>
                    <li><b>Sinopharm - <xsl:value-of select="izv:Izvestaj_o_imunizaciji/izv:Proizvodjaci_info/izv:Broj_doza_Sinopharm"/></b> doza</li>
                    <li><b>Sputnik V - <xsl:value-of select="izv:Izvestaj_o_imunizaciji/izv:Proizvodjaci_info/izv:Broj_doza_SputnikV"/></b> doza</li>
                    <li><b>AstraZenece, Oxford - <xsl:value-of select="izv:Izvestaj_o_imunizaciji/izv:Proizvodjaci_info/izv:Broj_doza_AstraZeneca"/></b>  doza</li>
                </ul>
                <p>Datum izdavanja: <u><xsl:value-of select="substring-before(izv:Izvestaj_o_imunizaciji/izv:Datum_izdavanja,'T')"/></u> godine</p>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
