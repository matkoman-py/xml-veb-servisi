<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:zzs="http://www.ftn.uns.ac.rs/zahtev_zelenog_sertifikata" version="2.0">
    
    <xsl:template match="p">
        <p>
            <xsl:apply-templates/> 
        </p>
    </xsl:template>
    
    
    <xsl:template match="u">
        <u>
            <xsl:apply-templates/> 
        </u>
    </xsl:template>
    
    <xsl:template match="em">
        <e>
            <xsl:apply-templates/> 
        </e>
    </xsl:template>
    
    <xsl:template match="s">
        <s>
            <xsl:apply-templates/> 
        </s>
    </xsl:template>
    
    <xsl:template match="br">
        <br>
            <xsl:apply-templates/> 
        </br>
    </xsl:template>
    
    <xsl:template match="h1">
        <h1>
            <xsl:apply-templates/> 
        </h1>
    </xsl:template>
    
    
    <xsl:template match="ul">
        <ul>
            <xsl:apply-templates/>
        </ul>
    </xsl:template>
    
    <xsl:template match="li">
        <li>
            <xsl:apply-templates/>
        </li>    
    </xsl:template>
    
    
    
    <xsl:template match="h1[@class='ql-align-center']">
        <h1 text-align="center">
            <xsl:apply-templates/> 
        </h1>
    </xsl:template>
    
    <xsl:template match="p[@class='ql-align-center']">
        <p text-align="center">
            <xsl:apply-templates/> 
        </p>
    </xsl:template>
    
    
    <xsl:template match="strong">
        <strong>
            <xsl:apply-templates/> 
        </strong>
    </xsl:template>
    
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
                    
                    .underline{border-bottom:1px solid #000000; width:200px; padding-bottom:5px;}
                    
                </style>
            </head>
            <body>
                <h1><b>Zahtev</b></h1>
                <h2><b>za izdavanje digitalnog sertifikata</b></h2>
                <p>U skladu sa odredbom Republike Srbije o izdavanju digitalnog zelenog
                    sertifikata kao potvrde o izvrsenoj vakcinaciji protiv COVID-19, rezultatima
                    testiranja na zaraznu bolest SARS-CoV-2 ili oporavku od bolesti COVID-19,
                    podnosim zahtev za izdavanje digitalnog zelenog sertifikata. 
                </p>
                <p>Ime i prezime: <u><xsl:value-of select="zzs:zahtev/zzs:Podnosilac_zahteva/zzs:Ime_i_prezime"/></u></p>
                <p>Datum rodjenja: <u><xsl:value-of select="zzs:zahtev/zzs:Podnosilac_zahteva/zzs:Datum_rodjenja"/></u></p>
                <p>Pol: <u><xsl:value-of select="zzs:zahtev/zzs:Podnosilac_zahteva/zzs:Pol"/></u></p>
                <p>Jedinsteni maticni broj gradjanina: <u><xsl:value-of select="zzs:zahtev/zzs:Podnosilac_zahteva/zzs:Jedinstveni_maticni_broj_gradjana"/></u></p>
                <p>Broj pasosa: <u><xsl:value-of select="zzs:zahtev/zzs:Podnosilac_zahteva/zzs:Broj_pasosa"/></u></p>
                <p>Razlog za podnosenje zahteva:</p>
                <xsl:apply-templates select="zzs:zahtev/zzs:Informacije_o_zahtevu[1]/zzs:Razlog[1]"/> 
                <p id="small">(navesti sto precizniji razlog za podnosenje zahteva za izdavanje digitalnog pasosa)</p>
                <br>
                </br>
                <p>U <u><xsl:value-of select="zzs:zahtev/zzs:Informacije_o_zahtevu/zzs:Mesto"/>,</u></p>
                <br></br>
                <p>Dana <u><xsl:value-of select="zzs:zahtev/zzs:Informacije_o_zahtevu/zzs:Datum_izdavanja"/> godine</u></p>
          </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
