<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:zzs="www.ftn.uns.ac.rs/zahtev_zelenog_sertifikata"
    xmlns:fo="http://www.w3.org/1999/XSL/Format" version="2.0">
    
    <xsl:template match="p">
        <fo:block font-size="10px">
            <xsl:apply-templates/> 
        </fo:block>
    </xsl:template>
    
    
    <xsl:template match="u">
        <fo:inline text-decoration="underline">
            <xsl:apply-templates/> 
        </fo:inline>
    </xsl:template>
    
    <xsl:template match="em">
        <fo:inline font-style="italic">
            <xsl:apply-templates/> 
        </fo:inline>
    </xsl:template>
    
    <xsl:template match="s">
        <fo:inline text-decoration="line-through">
            <xsl:apply-templates/> 
        </fo:inline>
    </xsl:template>
    
    <xsl:template match="br">
        <fo:block linefeed-treatment="preserve">
            <xsl:value-of select="'&#x2028;'"/>
            <xsl:apply-templates/> 
        </fo:block>
    </xsl:template>
    
    <xsl:template match="h1">
        <fo:block font-size="2em" font-weight="bold">
            <xsl:apply-templates/> 
        </fo:block>
    </xsl:template>
    
    
    <xsl:template match="ul">
        <fo:list-block padding="4pt">
            <xsl:apply-templates/>
        </fo:list-block>
    </xsl:template>
    
    <xsl:template match="li">
        <fo:list-item>
            <fo:list-item-label end-indent="label-end()">
                <fo:block>&#x02022;</fo:block>
            </fo:list-item-label>
            <fo:list-item-body start-indent="body-start()">
                <fo:block>
                    <xsl:apply-templates/>
                </fo:block>
            </fo:list-item-body>
        </fo:list-item>    
    </xsl:template>
    
    
    
    <xsl:template match="h1[@class='ql-align-center']">
        <fo:block font-size="2em" font-weight="bold" text-align="center">
            <xsl:apply-templates/> 
        </fo:block>
    </xsl:template>
    
    <xsl:template match="p[@class='ql-align-center']">
        <fo:block font-size="10px" text-align="center">
            <xsl:apply-templates/> 
        </fo:block>
    </xsl:template>
    
    
    <xsl:template match="strong">
        <fo:inline font-weight="bold">
            <xsl:apply-templates/> 
        </fo:inline>
    </xsl:template>
    
    
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
                        ZA IZDAVANJE ZELENOG SERTIF
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
                        <xsl:apply-templates select="zzs:zahtev/zzs:Informacije_o_zahtevu[1]/zzs:Razlog[1]"/> 
                        
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