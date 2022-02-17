<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:fo="http://www.w3.org/1999/XSL/Format"
    xmlns:zel="http://www.ftn.uns.ac.rs/zelenisertifikat" version="2.0">
    
    <xsl:template match="/">
        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master master-name="bookstore-page">
                    <fo:region-body margin="0.75in"/>
                </fo:simple-page-master>
            </fo:layout-master-set>
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
                    width: 100%;
                    }
                    
                    td 
                    {
                    text-align: center; 
                    vertical-align: middle;
                    }
                    
                    
                    body { font-family: Arial, sans-serif;
                    
                    }
                    u {    
                    text-decoration:underline;
                    text-decoration-style: dotted;
                    }
                    p.small {
                    font-size:12px;
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
                    left: 10px;
                    }
                    
                    p.header {
                    text-align:right;
                    font-size:12px;
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
                    
                    .icon-small i {
                    float: left;
                    margin-right: 10px;
                    /* ... */
                    }
                    
                    .underline{border-bottom:1px solid #000000; width:200px; padding-bottom:5px;}
                    
                    #header
                    {
                    position:relative;
                    min-width: 200px;
                    }
                    
                    #left
                    {
                    position:absolute;
                    width: 100px;
                    top: 0;
                    left: 0;
                    }
                    
                    #right
                    {
                    position:absolute;
                    width: 100px;    
                    top: 0;
                    right: 0;
                    }
                    
                    table.mid td + td { border-left:2px solid black; }
                    
                    
                </style>
            </head>
            <body>
                <table>
                    <tr>
                        <td><p style="text-align:left;"><img alt="Embedded Image" src="https://upload.wikimedia.org/wikipedia/commons/thumb/0/0f/Coat_of_arms_of_Serbia_small.svg/150px-Coat_of_arms_of_Serbia_small.svg.png" width="100" height="100"></img></p>
                        </td>
                        <td><p style="text-align:right;"><img width="100" height="100">
                            <xsl:attribute name="src">
                                <xsl:value-of select="zel:zeleni_sertifikat/zel:qr_kod"/>
                            </xsl:attribute>
                        </img></p>
                        </td>
                    </tr>
                </table>
                <h1>DIGITALNI ZELENI SERTIFIKAT</h1>
                <h3>Potvrda o izvrsenoj vakcinaciji protiv COVID-19 i rezultatima testiranja</h3>
                <h1>DIGITAL GREEN CERTIFICATE</h1>
                <h3>Certiicate of vaccination against COVID-19 and test results</h3>
                
                
                <br></br>
                <table>
                    <tr>
                        <td><div style="height: 50px; overflow:hidden; font-size:12px; text-align:left;">
                            Broj sertifikata/Certificate ID: <xsl:value-of select="/zel:zeleni_sertifikat/zel:broj_sertifikata[1]"/>
                        </div></td>
                        
                    </tr>
                    <tr>
                        <td><div style="height: 50px; overflow:hidden; font-size:12px; text-align:left;">
                            Datum i vreme izdavanja sertifikata/Certificate isuing date and time: <xsl:value-of select="substring-before(/zel:zeleni_sertifikat/zel:datum_izdavanja, 'T')"/> <xsl:text> </xsl:text> <xsl:value-of select="substring-after(/zel:zeleni_sertifikat/zel:datum_izdavanja, 'T')"/>
                        </div></td>
                    </tr>
                    <tr>
                        <td><div style="height: 50px; overflow:hidden; font-size:12px; text-align:left;">
                            Ime i prezime/Name and surname: <xsl:value-of select="/zel:zeleni_sertifikat/zel:podaci_o_pacijentu[1]/zel:ime_prezime[1]"/>
                        </div></td>
                    </tr>
                    <tr>
                        <td><div style="height: 50px; overflow:hidden; font-size:12px; text-align:left;">
                            Pol/Gener: <xsl:value-of select="/zel:zeleni_sertifikat/zel:podaci_o_pacijentu[1]/zel:pol[1]"/>
                        </div></td>
                    </tr>
                    <tr>
                        <td><div style="height: 50px; overflow:hidden; font-size:12px; text-align:left;">
                            Datum rodjenja/Date of birth: <xsl:value-of select="/zel:zeleni_sertifikat/zel:podaci_o_pacijentu[1]/zel:datum_rodjenja[1]"/>
                        </div></td>
                    </tr>
                    <tr>
                        <td><div style="height: 50px; overflow:hidden; font-size:12px; text-align:left;">
                            JMBG/Personal No./EBS: <xsl:value-of select="/zel:zeleni_sertifikat/zel:podaci_o_pacijentu[1]/zel:jmbg[1]"/>
                        </div></td>
                    </tr>
                    <tr>
                        <td><div style="height: 50px; overflow:hidden; font-size:12px; text-align:left;">
                            Broj pasosa/Passport No.: <xsl:value-of select="/zel:zeleni_sertifikat/zel:podaci_o_pacijentu[1]/zel:broj_pasosa"/>
                        </div></td>
                    </tr>
                </table>
                <table>
                    <tr>
                        <th style="border-top:2px solid black; text-align:center">Vakcinacija/Vaccination</th>
                    </tr>
                </table>
                <table class="mid">
                    
                    <tr>
                        <td><b>Doza/Dose: 1/2</b></td>
                        <td><b>Doza/Dose: 2/2</b></td>
                    </tr>
                    <tr>
                        <td style="padding-bottom:10px"><b>Tip/Type:</b></td>
                        <td style="padding-bottom:10px"><b>Tip/Type:</b></td>
                    </tr>
                    <tr>
                        <td style="padding-bottom:10px"><xsl:value-of select="/zel:zeleni_sertifikat/zel:podaci_o_vakcinaciji[1]/zel:tip[1]"/></td>
                        <td style="padding-bottom:10px"><xsl:value-of select="/zel:zeleni_sertifikat/zel:podaci_o_vakcinaciji[2]/zel:tip[1]"/></td>
                    </tr>
                    <tr>
                        <td><b>Datum/Date:</b> <xsl:value-of select="/zel:zeleni_sertifikat/zel:podaci_o_vakcinaciji[1]/zel:datum[1]"/></td>
                        <td><b>Datum/Date:</b> <xsl:value-of select="/zel:zeleni_sertifikat/zel:podaci_o_vakcinaciji[2]/zel:datum[1]"/></td>
                    </tr>
                    <tr>
                        <td><b>Zdravstvena ustanova/Healt care Institution:ššššššššššššššššђђђђђђђђђђђђђђђђђђђђђђђђђђ</b></td>
                        <td><b>Zdravstvena ustanova/Healt care Institution:</b></td>
                    </tr>
                    <tr>
                        <td style="padding-bottom:10px; border-bottom:2px solid black"><xsl:value-of select="/zel:zeleni_sertifikat/zel:podaci_o_vakcinaciji[1]/zel:zdravstvena_ustanova[1]"/></td>
                        <td style="padding-bottom:10px; border-bottom:2px solid black"><xsl:value-of select="/zel:zeleni_sertifikat/zel:podaci_o_vakcinaciji[2]/zel:zdravstvena_ustanova[1]"/></td>
                    </tr>
                </table>
                <p style="text-align:right"><b>Digitalni potpis/Digitally signed by:</b></p>
                <table>
                    <tr>
                        <td style="width:100px; padding-right:5px;"><p style="text-align:left;"><img src="https://data.gov.rs/s/avatars/2e/7864606e35474b98eb147395fecb72-100.png" width="75" height="75"></img></p>
                        </td>
                        <td><p style="text-align:left; font-size:10px"><b>Sertifikat izdaje:</b><br></br>Institut za javno zdravlje Srbije<br></br>"Dr Milan Jovanovic Batut"<br></br><b>Certificate issued by:</b><br></br>Institute of Public Health of Serbia<br></br>"Dr Milan Jovanovic Batut"</p>
                        </td>
                        <td><p style="text-align:left;"><img src="https://upload.wikimedia.org/wikipedia/commons/thumb/0/0f/Coat_of_arms_of_Serbia_small.svg/150px-Coat_of_arms_of_Serbia_small.svg.png" width="75" height="75"></img></p>
                        </td>
                        <td><p style="text-align:left; font-size:10px">REPUBLIKA SRBIJA<br></br>Vlada Republike Srbije<br></br>Kancelarija za informacione<br></br>tehnologije i elektronsku upravu<br></br>Nemanjina 11, BEOGRAD <br></br>Datum:<xsl:value-of select="substring-before(/zel:zeleni_sertifikat/zel:datum_izdavanja, 'T')"/></p>
                            
                        </td>
                    </tr>
                </table>
                
                <img width="100" height="100">
                    <xsl:attribute name="src">
                        <xsl:value-of select="zel:zeleni_sertifikat/zel:qr_kod"/>
                    </xsl:attribute>
                </img>
            </body>
        </html>
        </fo:root>
    </xsl:template>
</xsl:stylesheet>
