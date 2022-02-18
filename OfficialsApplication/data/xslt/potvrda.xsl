<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:pot="http://www.ftn.uns.ac.rs/potvrda_o_vakcinaciji" version="2.0">

    <xsl:template match="/">
        <html>
            <head>
                <META content="text/html; charset=UTF-8" http-equiv="Content-Type"/>
                <title>Zahtev (XSLT)</title>
                <style type="text/css">
                    h1 {text-align: center; margin:5px;}
                    h2 {
                    text-align: center;
                    margin:5px;
                    font-size:30px;
                    }
                    h3 {
                    text-align:center;
                    color:gray;
                    text-size:10px;
                    margin-top:5px;
                    text-size:15px;
                    }
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
                    p.small {
                    font-size:10px;
                    margin-top: 2px;
                    color:gray;
                    }

                    .header img {
                    float: left;
                    width: 100px;
                    height: 100px;
                    background: #555;
                    }

                    .header h1 {
                    position: relative;
                    top: 18px;
                    left: 100px;
                    }

                    p.header {
                    text-align:right;
                    font-size:15px;
                    font-weight: bold;
                    }
                    .header div {
                    text-align: center;
                    vertical-align: middle;
                    line-height: 90px;
                    }
                    p.form {
                    margin-bottom:5px;
                    }

                    .underline{border-bottom:1px solid #000000; width:200px; padding-bottom:5px;}

                </style>
            </head>
            <body>

                <p class="header"><b>INSTITUT ZA JAVNO ZDRAVLJE DR MILAN JOVANOVIC BATUT</b></p>
                <img src="https://data.gov.rs/s/avatars/2e/7864606e35474b98eb147395fecb72-100.png"></img>
                <p class="form">Sifra potvrde vakcine: <xsl:value-of select="pot:Potvrda/pot:Sifra_potvrde"/></p>
                <p class="small">Confirmation code:</p>
                <h2>POTVRDA O IZVRESNOJ VAKCINACIJI PROTIV COVID-19</h2>
                <h3>CONFIRMATION OF THE <b>COVID-19</b> VACCINATION</h3>
                <p class="form">Ime i prezime: <xsl:value-of select="pot:Potvrda/pot:pacijent[1]/pot:Ime_i_prezime"/></p>
                <p class="small">First and Last Name:</p>

                <p class="form">Pol: <xsl:value-of select="pot:Potvrda/pot:pacijent/pot:Pol"/></p>
                <xsl:if test="pot:Potvrda/pot:pacijent/pot:Pol='Musko'">
                    <p class="small">Gender: Male</p>
                </xsl:if>
                <xsl:if test="pot:Potvrda/pot:pacijent/pot:Pol='Zensko'">
                    <p class="small">Gender: Female</p>
                </xsl:if>
                <p class="form">Datum davanja i broj serije prve doze vakcine: <xsl:value-of select="/pot:Potvrda/pot:Vakcinacija_info[1]/pot:Prva_doza[1]/pot:Datum_vakcine[1]"/>, serija: <xsl:value-of select="/pot:Potvrda/pot:Vakcinacija_info[1]/pot:Prva_doza[1]/pot:Serija_vakcine"/></p>
                <p class="small">Vaccination Date:</p>
                <p class="form">Datum davanja i broj serije druge doze vakcine: <xsl:value-of select="/pot:Potvrda/pot:Vakcinacija_info[1]/pot:Druga_doza[1]/pot:Datum_vakcine[1]"/>, serija: <xsl:value-of select="/pot:Potvrda/pot:Vakcinacija_info[1]/pot:Druga_doza[1]/pot:Serija_vakcine"/></p>
                <p class="small">Second Vaccination Date:</p>
                <p class="form">Naziv vakcine: <xsl:value-of select="/pot:Potvrda/pot:Vakcinacija_info[1]/pot:Naziv_vakcine[1]"/></p>
                <p class="small">Name of vaccine:</p>
                <p class="form">Datum izdavanja potvrde: <xsl:value-of select="/pot:Potvrda/pot:Vakcinacija_info[1]/pot:Datum_izdavanja[1]"/></p>
                <p class="small">Confirmation Release Date:</p>

                <p class="header"><b><xsl:value-of select="/pot:Potvrda/pot:Vakcinacija_info[1]/pot:Zdravstvena_ustanova[1]"/></b></p>
                <p class="header small">Medical institution</p>
                <p style="text-align:right;"><img width="100" height="100">
                    <xsl:attribute name="src">
                        <xsl:value-of select="/pot:Potvrda/pot:Qr_kod[1]"/>
                    </xsl:attribute>
                </img></p>
                <p class="form">Ova potvrda vazi bez potpisa i pecata</p>
                <p class="small">This certificate is valid without signatures and seals</p>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>