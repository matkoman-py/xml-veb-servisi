<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:i="http://www.ftn.uns.ac.rs/interesovanje" version="2.0">
    
    <xsl:template match="/">
        <html>
            <head>
                <META content="text/html; charset=UTF-8" http-equiv="Content-Type"/>
                <title>Zahtev (XSLT)</title>
                <style type="text/css">
                    h1, h2 {text-align: center; margin:5px;}
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
                    body { font-family: Arial, sans-serif;
                    
                    }
                    u {    
                    text-decoration:underline;
                    text-decoration-style: dotted;
                    }
                    #small {
                    font-size:10px;
                    text-align: center;
                    margin-top: 5px;
                    margin-bottom: 100px;
                    }
                    ul{
                    list-style-type:none
                    }
                    
                    .underline{border-bottom:1px solid #000000; width:200px; padding-bottom:5px;}
                    
                </style>
            </head>
            <body>
                <h1>Iskazivanje interesovanja za vakcinisanje protiv COVID-19</h1>
                <p>Odaberite opciju:</p>
                <ul>
                    <li><xsl:value-of select="i:interesovanje/i:Podaci_o_primaocu/i:Drzavljanstvo"/></li>
                </ul>
                <br></br>
                
                <p>JMBG:</p>
                <p><u><xsl:value-of select="i:interesovanje/i:Podaci_o_primaocu/i:JMBG"/></u></p>
                <br></br>
                
                <p>Ime:</p>
                <p><u><xsl:value-of select="i:interesovanje/i:Podaci_o_primaocu/i:Ime"/></u></p>
                <br></br>

                <p>Prezime:</p>
                <p><u><xsl:value-of select="i:interesovanje/i:Podaci_o_primaocu/i:Prezime"/></u></p>
                <br></br>
                
                <p>Adresa elektronske poste:</p>
                <p><u><xsl:value-of select="i:interesovanje/i:Podaci_o_primaocu/i:Kontakt/i:Adresa_elektronske_poste"/></u></p>
                <br></br>

                <p>Broj mobilnog telefona (navesti broj u formatu 06X... bez razmaka i crtica):</p>
                <p><u><xsl:value-of select="i:interesovanje/i:Podaci_o_primaocu/i:Kontakt/i:Broj_mobilnog_telefona"/></u></p>
                <br></br>
                
                <p>Broj fiksnog telefona (navesti broj u formatu npr. 011... bez razmaka i crtica):</p>
                <p><u><xsl:value-of select="i:interesovanje/i:Podaci_o_primaocu/i:Kontakt/i:Broj_fiksnog_telefona"/></u></p>
                <br></br>

                <p>Odaberite lokaciju gde zelite da primite vakcinu (unesite opstinu):</p>
                <p><u>OVDE FALI!!!!!!!!!!</u></p>
                <br></br>
                
                <p>Iskazujem interesovanje da primim iskljucivo vakcinu sledecih proizvodjaca za
                    koji Agencija za lekove i medicinska sredstva potvrdi bezbednost, efikasnost i
                    kvalitet i izda dozvolu za upotrebu leka: 
                </p>
                <ul>
                    <li><xsl:value-of select="i:interesovanje/i:Odabir_vakcine"/></li>
                </ul>
                <p>Da li ste dobrovoljni davalac krvi?</p>
                <ul>
                    <li><xsl:value-of select="i:interesovanje/i:Podaci_o_primaocu/i:Davalac_krvi"/></li>
                </ul>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
