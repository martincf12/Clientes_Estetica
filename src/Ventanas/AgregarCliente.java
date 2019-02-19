package Ventanas;

import java.io.*;

public class AgregarCliente {

    FileInputStream entrada;
    FileOutputStream salida;
    File archivo;
     
   private String nombyap;
   private String domicilio;
   private String t_fijo;
   private String t_cel;
   private String mail;
   private String profes;
   private String profes_lugar;
   private String dn;
   private String mn;
   private String an;
   private String medico;
   private String alergico;
   private String diabetico;
   private String trat_dietetico;
   private String c_partos;
   private String ten_art;
   private String ant_hormo;
   private String tempera;
   private String inter_quir;
   private String tabaco;
   private String alcohol;
   private String normal;
   private String fluente;
   private String sensible;
   private String seco_alip;
   private String seco_deshi;
   private String xero;
   private String textura;
   private String color;
   private String pigme;
   private String Local;
   private String cicat;
   private String Loca_cic;
   private String Lesion;
   private String De_Bioti;
   private String Indu_sol;
   private String parpados;
   private String peribuca;
   private String frente;
   private String nasoge;
   private String preiauri;
   private String tonici;
   private String danio_sol;
   private String flaci;
   private String cara;
   private String malar;
   private String bozo;
   private String mento;
   private String se_depi;
   private String hirsu;
   private String hipertri;
   private String seco;
   private String graso;
   private String eritema;
   private String les_eri;
   private String alope;
   private String tipo_alop;
   private String onico;
   private String antece_onico;
   private String descama;
   private String unias;
   private String pitiri;
   private String pruri;
   private String excor;
   private String celuli;
   private String tipo_celu;
   private String loca_celu;
   private String estrias;
   private String loca_estri;
   private String acne_tipo_estri;
   private String tiempo_evol;
   private String ante_here_estri;
   private String lesi_elem;
   private String loca_lesi_elem;
   private String rosa_tipo;
   private String tiempo_evol_rosa;
   private String loca_rosa;
   private String ante_here_rosa;
   private String piel_sen;
   private String querato;
   private String elasto;
   private String otras_alter;
   private String invol_edad;
   private String trat_dermat;
   private String trat_cosmet;
   private String arriba_ombli;
   private String abajo_ombli;
   private String braz_der;
   private String braz_izq;
   private String cade;
   private String talla;
   private String peso;
   private String t1;
   private String t2;
   private String t3;
   private String t4;
   private String t5;
   private String t6;
   private String t7;
   private String t8;
   private String t9;
   private String t10;
   private String t11;
   private String t12;
   private String t13;
   private String t14;
   private String t15;
   private String t16;
   private String t17;
   private String t18;
   private String t19;
   private int p1;
   private int p2;
   private int p3;
   private int p4;
   private int p5;
   private int p6;
   private int p7;
   private int p8;
   private int p9;
   private int p10;
   private int p11;
   private int p12;
   private int p13;
   private int p14;
   private int p15;
   private int p16;
   private int p17;
   private int p18;
   private int p19;
   private int d1;
   private int d2;
   private int d3;
   private int d4;
   private int d5;
   private int d6;
   private int d7;
   private int d8;
   private int d9;
   private int d10;
   private int d11;
   private int d12;
   private int d13;
   private int d14;
   private int d15;
   private int d16;
   private int d17;
   private int d18;
   private int d19;
   private int d_TOT;
   private int h1;
   private int h2;
   private int h3;
   private int h4;
   private int h5;
   private int h6;
   private int h7;
   private int h8;
   private int h9;
   private int h10;
   private int h11;
   private int h12;
   private int h13;
   private int h14;
   private int h15;
   private int h16;
   private int h17;
   private int h18;
   private int h19;
   private int h_TOT;
   private String fo_nomb;
   
       AgregarCliente(String nombyap, String domicilio, String t_fijo, String t_cel, String mail, String profes, String profes_lugar, String dn, String mn, String an, 
                      String medico, String alergico, String diabetico, String trat_dietetico,String c_partos, String ten_art, String ant_hormo, String tempera,
                      String inter_quir, String tabaco, String alcohol, String normal, String fluente, String sensible, String seco_alpi,
                      String seco_deshi, String xreo, String textura, String color, String pigme, String Local, String cicat, String Loca_cic,
                      String Lesion, String De_Bioti, String Indu_sol, String parpados, String peribuca, String frente, String nasoge,
                      String periauri, String tonici, String danio_sol, String flaci, String cara, String malar, String bozo, String mento,
                      String se_depi, String hirsu, String hipertri, String seco, String graso, String eritema, String les_eri,
                      String alope, String tipo_alope, String onico, String antece_onico, String descama, String unias, String pitiri,
                      String pruri, String excor, String celuli, String tipo_celu, String loca_celu, String estrias, String loca_estri,
                      String acne_tipo_estri, String tiempo_evol, String ante_here_estri, String lesi_elem, String loca_lesi_elem,
                      String rosa_tipo, String tiempo_evol_rosa, String loca_rosa, String ante_here_rosa, String piel_sen, String querato,
                      String elasto, String otras_alter, String invol_edad, String trat_dermat, String trat_cosmet, String arriba_ombli,
                      String abajo_ombli, String braz_der, String braz_izq, String cade, String talla, String peso, String t1,String t2,String t3,
                      String t4,String t5,String t6,String t7,String t8,String t9,String t10,String t11,String t12,String t13,String t14,String t15,
                      String t16,String t17,String t18,String t19,int p1,int p2,int p3,int p4,int p5,int p6,int p7,int p8,int p9,int p10,
                      int p11,int p12,int p13,int p14,int p15,int p16,int p17,int p18,int p19,int d1,int d2,int d3,int d4,int d5,int d6,int d7,int d8,int d9,
                      int d10,int d11,int d12,int d13,int d14,int d15,int d16,int d17,int d18,int d19, int d_TOT,int h1,int h2,int h3,
                      int h4,int h5,int h6,int h7,int h8,int h9,int h10,int h11,int h12,int h13,int h14,int h15,int h16,int h17,
                      int h18,int h19,int h_TOT, String fo_nomb) 
       {
            this.nombyap = nombyap;
            this.domicilio = domicilio;
            this.t_fijo = t_fijo;
            this.t_cel = t_cel;
            this.mail = mail;
            this.profes = profes;
            this.profes_lugar = profes_lugar;
            this.dn = dn;
            this.mn = mn;
            this.an = an;
            this.medico = medico;
            this.alergico = alergico;
            this.diabetico = diabetico;
            this.trat_dietetico = trat_dietetico;
            this.c_partos = c_partos;
            this.ten_art = ten_art;
            this.tempera = tempera;
            this.inter_quir = inter_quir;
            this.tabaco = tabaco;
            this.alcohol = alcohol;  
        }

   public String GuardarIMG(File archivo, byte[] bytesIMG)
   {
       String respuesta= null;
       try
       {
           salida= new FileOutputStream(archivo);
           salida.write(bytesIMG);
           respuesta = "Imagen Cargada con Exito";
       }
       catch(IOException e)
       {
       }
       return respuesta;
   }
   
    public String getNombyap() {
        return nombyap;
    }

    public void setNombyap(String nombyap) {
        this.nombyap = nombyap;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getT_fijo() {
        return t_fijo;
    }

    public void setT_fijo(String t_fijo) {
        this.t_fijo = t_fijo;
    }

    public String getT_cel() {
        return t_cel;
    }

    public void setT_cel(String t_cel) {
        this.t_cel = t_cel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getProfes() {
        return profes;
    }

    public void setProfes(String profes) {
        this.profes = profes;
    }

    public String getProfes_lugar() {
        return profes_lugar;
    }

    public void setProfes_lugar(String profes_lugar) {
        this.profes_lugar = profes_lugar;
    } 
     public String getDn()
    {
         return dn;
    } 
     
    public void setDn(String dn)
    {
        this.dn = dn;
    }
         public String getMn()
    {
         return mn;
    } 
     
    public void setMn(String mn)
    {
        this.mn = mn;
    }
         public String getMedico()
    {
         return medico;
    } 
     
    public void setMedico(String medico)
    {
        this.medico = medico;
    }
          public String getAlergico()
    {
         return alergico;
    } 
     
    public void setAlergico(String alergico)
    {
        this.alergico = alergico;
    }

    /**
     * @return the diabetico
     */
    public String getDiabetico() {
        return diabetico;
    }

    /**
     * @param diabetico the diabetico to set
     */
    public void setDiabetico(String diabetico) {
        this.diabetico = diabetico;
    }

    /**
     * @return the trat_dietetico
     */
    public String getTrat_dietetico() {
        return trat_dietetico;
    }

    /**
     * @param trat_dietetico the trat_dietetico to set
     */
    public void setTrat_dietetico(String trat_dietetico) {
        this.trat_dietetico = trat_dietetico;
    }
    
    /**
     * @return the c_partos
     */
    public String getC_partos() {
        return c_partos;
    }

    /**
     * @param c_partos the c_partos to set
     */
    public void setC_partos(String c_partos) {
        this.c_partos = c_partos;
    }
    
    
    /**
     * @return the ten_art
     */
    public String getTen_art() {
        return ten_art;
    }

    /**
     * @param ten_art the ten_art to set
     */
    public void setTen_art(String ten_art) {
        this.ten_art = ten_art;
    }
    /**
     * @return the ant_hormo
     */
    public String getAnt_hormo() {
        return ant_hormo;
    }

    /**
     * @param ant_hormo the ant_hormo to set
     */
    public void setAnt_hormo(String ant_hormo) {
        this.ant_hormo = ant_hormo;
    }

    /**
     * @return the tempera
     */
    public String getTempera() {
        return tempera;
    }

    /**
     * @param tempera the tempera to set
     */
    public void setTempera(String tempera) {
        this.tempera = tempera;
    }

    /**
     * @return the inter_quir
     */
    public String getInter_quir() {
        return inter_quir;
    }

    /**
     * @param inter_quir the inter_quir to set
     */
    public void setInter_quir(String inter_quir) {
        this.inter_quir = inter_quir;
    }

    /**
     * @return the tabaco
     */
    public String getTabaco() {
        return tabaco;
    }

    /**
     * @param tabaco the tabaco to set
     */
    public void setTabaco(String tabaco) {
        this.tabaco = tabaco;
    }

    /**
     * @return the alcohol
     */
    public String getAlcohol() {
        return alcohol;
    }

    /**
     * @param alcohol the alcohol to set
     */
    public void setAlcohol(String alcohol) {
        this.alcohol = alcohol;
    }
    
     /**
     * @return the normal
     */
    public String getNormal() {
        return normal;
    }

    /**
     * @param normal the normal to set
     */
    public void setNormal(String normal) {
        this.normal = normal;
    }

    /**
     * @return the fluente
     */
    public String getFluente() {
        return fluente;
    }

    /**
     * @param fluente the fluente to set
     */
    public void setFluente(String fluente) {
        this.fluente = fluente;
    }

    /**
     * @return the sensible
     */
    public String getSensible() {
        return sensible;
    }

    /**
     * @param sensible the sensible to set
     */
    public void setSensible(String sensible) {
        this.sensible = sensible;
    }

    /**
     * @return the seco_alip
     */
    public String getSeco_alip() {
        return seco_alip;
    }

    /**
     * @param seco_alip the seco_alip to set
     */
    public void setSeco_alip(String seco_alip) {
        this.seco_alip = seco_alip;
    }

    /**
     * @return the seco_deshi
     */
    public String getSeco_deshi() {
        return seco_deshi;
    }

    /**
     * @param seco_deshi the seco_deshi to set
     */
    public void setSeco_deshi(String seco_deshi) {
        this.seco_deshi = seco_deshi;
    }

    /**
     * @return the xero
     */
    public String getXero() {
        return xero;
    }

    /**
     * @param xero the xero to set
     */
    public void setXero(String xero) {
        this.xero = xero;
    }

    /**
     * @return the textura
     */
    public String getTextura() {
        return textura;
    }

    /**
     * @param textura the textura to set
     */
    public void setTextura(String textura) {
        this.textura = textura;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the pigme
     */
    public String getPigme() {
        return pigme;
    }

    /**
     * @param pigme the pigme to set
     */
    public void setPigme(String pigme) {
        this.pigme = pigme;
    }

    /**
     * @return the Local
     */
    public String getLocal() {
        return Local;
    }

    /**
     * @param Local the Local to set
     */
    public void setLocal(String Local) {
        this.Local = Local;
    }

    /**
     * @return the cicat
     */
    public String getCicat() {
        return cicat;
    }

    /**
     * @param cicat the cicat to set
     */
    public void setCicat(String cicat) {
        this.cicat = cicat;
    }

    /**
     * @return the Loca_cic
     */
    public String getLoca_cic() {
        return Loca_cic;
    }

    /**
     * @param Loca_cic the Loca_cic to set
     */
    public void setLoca_cic(String Loca_cic) {
        this.Loca_cic = Loca_cic;
    }

    /**
     * @return the Lesion
     */
    public String getLesion() {
        return Lesion;
    }

    /**
     * @param Lesion the Lesion to set
     */
    public void setLesion(String Lesion) {
        this.Lesion = Lesion;
    }

    /**
     * @return the De_Bioti
     */
    public String getDe_Bioti() {
        return De_Bioti;
    }

    /**
     * @param De_Bioti the De_Bioti to set
     */
    public void setDe_Bioti(String De_Bioti) {
        this.De_Bioti = De_Bioti;
    }

    /**
     * @return the Indu_sol
     */
    public String getIndu_sol() {
        return Indu_sol;
    }

    /**
     * @param Indu_sol the Indu_sol to set
     */
    public void setIndu_sol(String Indu_sol) {
        this.Indu_sol = Indu_sol;
    }

    /**
     * @return the parpados
     */
    public String getParpados() {
        return parpados;
    }

    /**
     * @param parpados the parpados to set
     */
    public void setParpados(String parpados) {
        this.parpados = parpados;
    }

    /**
     * @return the peribuca
     */
    public String getPeribuca() {
        return peribuca;
    }

    /**
     * @param peribuca the peribuca to set
     */
    public void setPeribuca(String peribuca) {
        this.peribuca = peribuca;
    }

    /**
     * @return the frente
     */
    public String getFrente() {
        return frente;
    }

    /**
     * @param frente the frente to set
     */
    public void setFrente(String frente) {
        this.frente = frente;
    }

    /**
     * @return the nasoge
     */
    public String getNasoge() {
        return nasoge;
    }

    /**
     * @param nasoge the nasoge to set
     */
    public void setNasoge(String nasoge) {
        this.nasoge = nasoge;
    }

    /**
     * @return the preiauri
     */
    public String getPreiauri() {
        return preiauri;
    }

    /**
     * @param preiauri the preiauri to set
     */
    public void setPreiauri(String preiauri) {
        this.preiauri = preiauri;
    }

    /**
     * @return the tonici
     */
    public String getTonici() {
        return tonici;
    }

    /**
     * @param tonici the tonici to set
     */
    public void setTonici(String tonici) {
        this.tonici = tonici;
    }

    /**
     * @return the danio_sol
     */
    public String getDanio_sol() {
        return danio_sol;
    }

    /**
     * @param danio_sol the danio_sol to set
     */
    public void setDanio_sol(String danio_sol) {
        this.danio_sol = danio_sol;
    }

    /**
     * @return the flaci
     */
    public String getFlaci() {
        return flaci;
    }

    /**
     * @param flaci the flaci to set
     */
    public void setFlaci(String flaci) {
        this.flaci = flaci;
    }

    /**
     * @return the cara
     */
    public String getCara() {
        return cara;
    }

    /**
     * @param cara the cara to set
     */
    public void setCara(String cara) {
        this.cara = cara;
    }

    /**
     * @return the malar
     */
    public String getMalar() {
        return malar;
    }

    /**
     * @param malar the malar to set
     */
    public void setMalar(String malar) {
        this.malar = malar;
    }

    /**
     * @return the bozo
     */
    public String getBozo() {
        return bozo;
    }

    /**
     * @param bozo the bozo to set
     */
    public void setBozo(String bozo) {
        this.bozo = bozo;
    }

    /**
     * @return the mento
     */
    public String getMento() {
        return mento;
    }

    /**
     * @param mento the mento to set
     */
    public void setMento(String mento) {
        this.mento = mento;
    }

    /**
     * @return the se_depi
     */
    public String getSe_depi() {
        return se_depi;
    }

    /**
     * @param se_depi the se_depi to set
     */
    public void setSe_depi(String se_depi) {
        this.se_depi = se_depi;
    }

    /**
     * @return the hirsu
     */
    public String getHirsu() {
        return hirsu;
    }

    /**
     * @param hirsu the hirsu to set
     */
    public void setHirsu(String hirsu) {
        this.hirsu = hirsu;
    }

    /**
     * @return the hipertri
     */
    public String getHipertri() {
        return hipertri;
    }

    /**
     * @param hipertri the hipertri to set
     */
    public void setHipertri(String hipertri) {
        this.hipertri = hipertri;
    }

    /**
     * @return the seco
     */
    public String getSeco() {
        return seco;
    }

    /**
     * @param seco the seco to set
     */
    public void setSeco(String seco) {
        this.seco = seco;
    }

    /**
     * @return the graso
     */
    public String getGraso() {
        return graso;
    }

    /**
     * @param graso the graso to set
     */
    public void setGraso(String graso) {
        this.graso = graso;
    }

    /**
     * @return the eritema
     */
    public String getEritema() {
        return eritema;
    }

    /**
     * @param eritema the eritema to set
     */
    public void setEritema(String eritema) {
        this.eritema = eritema;
    }

    /**
     * @return the les_eri
     */
    public String getLes_eri() {
        return les_eri;
    }

    /**
     * @param les_eri the les_eri to set
     */
    public void setLes_eri(String les_eri) {
        this.les_eri = les_eri;
    }

    /**
     * @return the alope
     */
    public String getAlope() {
        return alope;
    }

    /**
     * @param alope the alope to set
     */
    public void setAlope(String alope) {
        this.alope = alope;
    }

    /**
     * @return the tipo_alop
     */
    public String getTipo_alop() {
        return tipo_alop;
    }

    /**
     * @param tipo_alop the tipo_alop to set
     */
    public void setTipo_alop(String tipo_alop) {
        this.tipo_alop = tipo_alop;
    }

    /**
     * @return the onico
     */
    public String getOnico() {
        return onico;
    }

    /**
     * @param onico the onico to set
     */
    public void setOnico(String onico) {
        this.onico = onico;
    }

    /**
     * @return the antece_onico
     */
    public String getAntece_onico() {
        return antece_onico;
    }

    /**
     * @param antece_onico the antece_onico to set
     */
    public void setAntece_onico(String antece_onico) {
        this.antece_onico = antece_onico;
    }

    /**
     * @return the descama
     */
    public String getDescama() {
        return descama;
    }

    /**
     * @param descama the descama to set
     */
    public void setDescama(String descama) {
        this.descama = descama;
    }

    /**
     * @return the unias
     */
    public String getUnias() {
        return unias;
    }

    /**
     * @param unias the unias to set
     */
    public void setUnias(String unias) {
        this.unias = unias;
    }

    /**
     * @return the pitiri
     */
    public String getPitiri() {
        return pitiri;
    }

    /**
     * @param pitiri the pitiri to set
     */
    public void setPitiri(String pitiri) {
        this.pitiri = pitiri;
    }

    /**
     * @return the pruri
     */
    public String getPruri() {
        return pruri;
    }

    /**
     * @param pruri the pruri to set
     */
    public void setPruri(String pruri) {
        this.pruri = pruri;
    }

    /**
     * @return the excor
     */
    public String getExcor() {
        return excor;
    }

    /**
     * @param excor the excor to set
     */
    public void setExcor(String excor) {
        this.excor = excor;
    }

    /**
     * @return the celuli
     */
    public String getCeluli() {
        return celuli;
    }

    /**
     * @param celuli the celuli to set
     */
    public void setCeluli(String celuli) {
        this.celuli = celuli;
    }

    /**
     * @return the tipo_celu
     */
    public String getTipo_celu() {
        return tipo_celu;
    }

    /**
     * @param tipo_celu the tipo_celu to set
     */
    public void setTipo_celu(String tipo_celu) {
        this.tipo_celu = tipo_celu;
    }

    /**
     * @return the loca_celu
     */
    public String getLoca_celu() {
        return loca_celu;
    }

    /**
     * @param loca_celu the loca_celu to set
     */
    public void setLoca_celu(String loca_celu) {
        this.loca_celu = loca_celu;
    }

    /**
     * @return the estrias
     */
    public String getEstrias() {
        return estrias;
    }

    /**
     * @param estrias the estrias to set
     */
    public void setEstrias(String estrias) {
        this.estrias = estrias;
    }

    /**
     * @return the loca_estri
     */
    public String getLoca_estri() {
        return loca_estri;
    }

    /**
     * @param loca_estri the loca_estri to set
     */
    public void setLoca_estri(String loca_estri) {
        this.loca_estri = loca_estri;
    }

    /**
     * @return the acne_tipo_estri
     */
    public String getAcne_tipo_estri() {
        return acne_tipo_estri;
    }

    /**
     * @param acne_tipo_estri the acne_tipo_estri to set
     */
    public void setAcne_tipo_estri(String acne_tipo_estri) {
        this.acne_tipo_estri = acne_tipo_estri;
    }

    /**
     * @return the tiempo_evol
     */
    public String getTiempo_evol() {
        return tiempo_evol;
    }

    /**
     * @param tiempo_evol the tiempo_evol to set
     */
    public void setTiempo_evol(String tiempo_evol) {
        this.tiempo_evol = tiempo_evol;
    }

    /**
     * @return the ante_here_estri
     */
    public String getAnte_here_estri() {
        return ante_here_estri;
    }

    /**
     * @param ante_here_estri the ante_here_estri to set
     */
    public void setAnte_here_estri(String ante_here_estri) {
        this.ante_here_estri = ante_here_estri;
    }

    /**
     * @return the lesi_elem
     */
    public String getLesi_elem() {
        return lesi_elem;
    }

    /**
     * @param lesi_elem the lesi_elem to set
     */
    public void setLesi_elem(String lesi_elem) {
        this.lesi_elem = lesi_elem;
    }

    /**
     * @return the loca_lesi_elem
     */
    public String getLoca_lesi_elem() {
        return loca_lesi_elem;
    }

    /**
     * @param loca_lesi_elem the loca_lesi_elem to set
     */
    public void setLoca_lesi_elem(String loca_lesi_elem) {
        this.loca_lesi_elem = loca_lesi_elem;
    }

    /**
     * @return the rosa_tipo
     */
    public String getRosa_tipo() {
        return rosa_tipo;
    }

    /**
     * @param rosa_tipo the rosa_tipo to set
     */
    public void setRosa_tipo(String rosa_tipo) {
        this.rosa_tipo = rosa_tipo;
    }

    /**
     * @return the tiempo_evol_rosa
     */
    public String getTiempo_evol_rosa() {
        return tiempo_evol_rosa;
    }

    /**
     * @param tiempo_evol_rosa the tiempo_evol_rosa to set
     */
    public void setTiempo_evol_rosa(String tiempo_evol_rosa) {
        this.tiempo_evol_rosa = tiempo_evol_rosa;
    }

    /**
     * @return the loca_rosa
     */
    public String getLoca_rosa() {
        return loca_rosa;
    }

    /**
     * @param loca_rosa the loca_rosa to set
     */
    public void setLoca_rosa(String loca_rosa) {
        this.loca_rosa = loca_rosa;
    }

    /**
     * @return the ante_here_rosa
     */
    public String getAnte_here_rosa() {
        return ante_here_rosa;
    }

    /**
     * @param ante_here_rosa the ante_here_rosa to set
     */
    public void setAnte_here_rosa(String ante_here_rosa) {
        this.ante_here_rosa = ante_here_rosa;
    }

    /**
     * @return the piel_sen
     */
    public String getPiel_sen() {
        return piel_sen;
    }

    /**
     * @param piel_sen the piel_sen to set
     */
    public void setPiel_sen(String piel_sen) {
        this.piel_sen = piel_sen;
    }

    /**
     * @return the querato
     */
    public String getQuerato() {
        return querato;
    }

    /**
     * @param querato the querato to set
     */
    public void setQuerato(String querato) {
        this.querato = querato;
    }

    /**
     * @return the elasto
     */
    public String getElasto() {
        return elasto;
    }

    /**
     * @param elasto the elasto to set
     */
    public void setElasto(String elasto) {
        this.elasto = elasto;
    }

    /**
     * @return the otras_alter
     */
    public String getOtras_alter() {
        return otras_alter;
    }

    /**
     * @param otras_alter the otras_alter to set
     */
    public void setOtras_alter(String otras_alter) {
        this.otras_alter = otras_alter;
    }

    /**
     * @return the invol_edad
     */
    public String getInvol_edad() {
        return invol_edad;
    }

    /**
     * @param invol_edad the invol_edad to set
     */
    public void setInvol_edad(String invol_edad) {
        this.invol_edad = invol_edad;
    }

    /**
     * @return the trat_dermat
     */
    public String getTrat_dermat() {
        return trat_dermat;
    }

    /**
     * @param trat_dermat the trat_dermat to set
     */
    public void setTrat_dermat(String trat_dermat) {
        this.trat_dermat = trat_dermat;
    }

    /**
     * @return the trat_cosmet
     */
    public String getTrat_cosmet() {
        return trat_cosmet;
    }

    /**
     * @param trat_cosmet the trat_cosmet to set
     */
    public void setTrat_cosmet(String trat_cosmet) {
        this.trat_cosmet = trat_cosmet;
    }

    /**
     * @return the arriba_ombli
     */
    public String getArriba_ombli() {
        return arriba_ombli;
    }

    /**
     * @param arriba_ombli the arriba_ombli to set
     */
    public void setArriba_ombli(String arriba_ombli) {
        this.arriba_ombli = arriba_ombli;
    }

    /**
     * @return the abajo_ombli
     */
    public String getAbajo_ombli() {
        return abajo_ombli;
    }

    /**
     * @param abajo_ombli the abajo_ombli to set
     */
    public void setAbajo_ombli(String abajo_ombli) {
        this.abajo_ombli = abajo_ombli;
    }

    /**
     * @return the braz_der
     */
    public String getBraz_der() {
        return braz_der;
    }

    /**
     * @param braz_der the braz_der to set
     */
    public void setBraz_der(String braz_der) {
        this.braz_der = braz_der;
    }

    /**
     * @return the braz_izq
     */
    public String getBraz_izq() {
        return braz_izq;
    }

    /**
     * @param braz_izq the braz_izq to set
     */
    public void setBraz_izq(String braz_izq) {
        this.braz_izq = braz_izq;
    }

    /**
     * @return the cade
     */
    public String getCade() {
        return cade;
    }

    /**
     * @param cade the cade to set
     */
    public void setCade(String cade) {
        this.cade = cade;
    }

    /**
     * @return the talla
     */
    public String getTalla() {
        return talla;
    }

    /**
     * @param talla the talla to set
     */
    public void setTalla(String talla) {
        this.talla = talla;
    }

    /**
     * @return the peso
     */
    public String getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(String peso) {
        this.peso = peso;
    }
    
        /**
     * @return the t1
     */
    public String getT1() {
        return t1;
    }

    /**
     * @param t1 the t1 to set
     */
    public void setT1(String t1) {
        this.t1 = t1;
    }

    /**
     * @return the t2
     */
    public String getT2() {
        return t2;
    }

    /**
     * @param t2 the t2 to set
     */
    public void setT2(String t2) {
        this.t2 = t2;
    }

    /**
     * @return the t3
     */
    public String getT3() {
        return t3;
    }

    /**
     * @param t3 the t3 to set
     */
    public void setT3(String t3) {
        this.t3 = t3;
    }

    /**
     * @return the t4
     */
    public String getT4() {
        return t4;
    }

    /**
     * @param t4 the t4 to set
     */
    public void setT4(String t4) {
        this.t4 = t4;
    }

    /**
     * @return the t5
     */
    public String getT5() {
        return t5;
    }

    /**
     * @param t5 the t5 to set
     */
    public void setT5(String t5) {
        this.t5 = t5;
    }

    /**
     * @return the t6
     */
    public String getT6() {
        return t6;
    }

    /**
     * @param t6 the t6 to set
     */
    public void setT6(String t6) {
        this.t6 = t6;
    }

    /**
     * @return the t7
     */
    public String getT7() {
        return t7;
    }

    /**
     * @param t7 the t7 to set
     */
    public void setT7(String t7) {
        this.t7 = t7;
    }

    /**
     * @return the t8
     */
    public String getT8() {
        return t8;
    }

    /**
     * @param t8 the t8 to set
     */
    public void setT8(String t8) {
        this.t8 = t8;
    }

    /**
     * @return the t9
     */
    public String getT9() {
        return t9;
    }

    /**
     * @param t9 the t9 to set
     */
    public void setT9(String t9) {
        this.t9 = t9;
    }

    /**
     * @return the t10
     */
    public String getT10() {
        return t10;
    }

    /**
     * @param t10 the t10 to set
     */
    public void setT10(String t10) {
        this.t10 = t10;
    }

    /**
     * @return the t11
     */
    public String getT11() {
        return t11;
    }

    /**
     * @param t11 the t11 to set
     */
    public void setT11(String t11) {
        this.t11 = t11;
    }

    /**
     * @return the t12
     */
    public String getT12() {
        return t12;
    }

    /**
     * @param t12 the t12 to set
     */
    public void setT12(String t12) {
        this.t12 = t12;
    }

    /**
     * @return the t13
     */
    public String getT13() {
        return t13;
    }

    /**
     * @param t13 the t13 to set
     */
    public void setT13(String t13) {
        this.t13 = t13;
    }

    /**
     * @return the t14
     */
    public String getT14() {
        return t14;
    }

    /**
     * @param t14 the t14 to set
     */
    public void setT14(String t14) {
        this.t14 = t14;
    }

    /**
     * @return the t15
     */
    public String getT15() {
        return t15;
    }

    /**
     * @param t15 the t15 to set
     */
    public void setT15(String t15) {
        this.t15 = t15;
    }

    /**
     * @return the t16
     */
    public String getT16() {
        return t16;
    }

    /**
     * @param t16 the t16 to set
     */
    public void setT16(String t16) {
        this.t16 = t16;
    }

    /**
     * @return the t17
     */
    public String getT17() {
        return t17;
    }

    /**
     * @param t17 the t17 to set
     */
    public void setT17(String t17) {
        this.t17 = t17;
    }

    /**
     * @return the t18
     */
    public String getT18() {
        return t18;
    }

    /**
     * @param t18 the t18 to set
     */
    public void setT18(String t18) {
        this.t18 = t18;
    }

    /**
     * @return the t19
     */
    public String getT19() {
        return t19;
    }

    /**
     * @param t19 the t19 to set
     */
    public void setT19(String t19) {
        this.t19 = t19;
    }

    /**
     * @return the p1
     */
    public int getP1() {
        return p1;
    }

    /**
     * @param p1 the p1 to set
     */
    public void setP1(int p1) {
        this.p1 = p1;
    }

    /**
     * @return the p2
     */
    public int getP2() {
        return p2;
    }

    /**
     * @param p2 the p2 to set
     */
    public void setP2(int p2) {
        this.p2 = p2;
    }

    /**
     * @return the p3
     */
    public int getP3() {
        return p3;
    }

    /**
     * @param p3 the p3 to set
     */
    public void setP3(int p3) {
        this.p3 = p3;
    }

    /**
     * @return the p4
     */
    public int getP4() {
        return p4;
    }

    /**
     * @param p4 the p4 to set
     */
    public void setP4(int p4) {
        this.p4 = p4;
    }

    /**
     * @return the p5
     */
    public int getP5() {
        return p5;
    }

    /**
     * @param p5 the p5 to set
     */
    public void setP5(int p5) {
        this.p5 = p5;
    }

    /**
     * @return the p6
     */
    public int getP6() {
        return p6;
    }

    /**
     * @param p6 the p6 to set
     */
    public void setP6(int p6) {
        this.p6 = p6;
    }

    /**
     * @return the p7
     */
    public int getP7() {
        return p7;
    }

    /**
     * @param p7 the p7 to set
     */
    public void setP7(int p7) {
        this.p7 = p7;
    }

    /**
     * @return the p8
     */
    public int getP8() {
        return p8;
    }

    /**
     * @param p8 the p8 to set
     */
    public void setP8(int p8) {
        this.p8 = p8;
    }

    /**
     * @return the p9
     */
    public int getP9() {
        return p9;
    }

    /**
     * @param p9 the p9 to set
     */
    public void setP9(int p9) {
        this.p9 = p9;
    }

    /**
     * @return the p10
     */
    public int getP10() {
        return p10;
    }

    /**
     * @param p10 the p10 to set
     */
    public void setP10(int p10) {
        this.p10 = p10;
    }

    /**
     * @return the p11
     */
    public int getP11() {
        return p11;
    }

    /**
     * @param p11 the p11 to set
     */
    public void setP11(int p11) {
        this.p11 = p11;
    }

    /**
     * @return the p12
     */
    public int getP12() {
        return p12;
    }

    /**
     * @param p12 the p12 to set
     */
    public void setP12(int p12) {
        this.p12 = p12;
    }

    /**
     * @return the p13
     */
    public int getP13() {
        return p13;
    }

    /**
     * @param p13 the p13 to set
     */
    public void setP13(int p13) {
        this.p13 = p13;
    }

    /**
     * @return the p14
     */
    public int getP14() {
        return p14;
    }

    /**
     * @param p14 the p14 to set
     */
    public void setP14(int p14) {
        this.p14 = p14;
    }

    /**
     * @return the p15
     */
    public int getP15() {
        return p15;
    }

    /**
     * @param p15 the p15 to set
     */
    public void setP15(int p15) {
        this.p15 = p15;
    }

    /**
     * @return the p16
     */
    public int getP16() {
        return p16;
    }

    /**
     * @param p16 the p16 to set
     */
    public void setP16(int p16) {
        this.p16 = p16;
    }

    /**
     * @return the p17
     */
    public int getP17() {
        return p17;
    }

    /**
     * @param p17 the p17 to set
     */
    public void setP17(int p17) {
        this.p17 = p17;
    }

    /**
     * @return the p18
     */
    public int getP18() {
        return p18;
    }

    /**
     * @param p18 the p18 to set
     */
    public void setP18(int p18) {
        this.p18 = p18;
    }

    /**
     * @return the p19
     */
    public int getP19() {
        return p19;
    }

    /**
     * @param p19 the p19 to set
     */
    public void setP19(int p19) {
        this.p19 = p19;
    }

    /**
     * @return the d1
     */
    public int getD1() {
        return d1;
    }

    /**
     * @param d1 the d1 to set
     */
    public void setD1(int d1) {
        this.d1 = d1;
    }

    /**
     * @return the d2
     */
    public int getD2() {
        return d2;
    }

    /**
     * @param d2 the d2 to set
     */
    public void setD2(int d2) {
        this.d2 = d2;
    }

    /**
     * @return the d3
     */
    public int getD3() {
        return d3;
    }

    /**
     * @param d3 the d3 to set
     */
    public void setD3(int d3) {
        this.d3 = d3;
    }

    /**
     * @return the d4
     */
    public int getD4() {
        return d4;
    }

    /**
     * @param d4 the d4 to set
     */
    public void setD4(int d4) {
        this.d4 = d4;
    }

    /**
     * @return the d5
     */
    public int getD5() {
        return d5;
    }

    /**
     * @param d5 the d5 to set
     */
    public void setD5(int d5) {
        this.d5 = d5;
    }

    /**
     * @return the d6
     */
    public int getD6() {
        return d6;
    }

    /**
     * @param d6 the d6 to set
     */
    public void setD6(int d6) {
        this.d6 = d6;
    }

    /**
     * @return the d7
     */
    public int getD7() {
        return d7;
    }

    /**
     * @param d7 the d7 to set
     */
    public void setD7(int d7) {
        this.d7 = d7;
    }

    /**
     * @return the d8
     */
    public int getD8() {
        return d8;
    }

    /**
     * @param d8 the d8 to set
     */
    public void setD8(int d8) {
        this.d8 = d8;
    }

    /**
     * @return the d9
     */
    public int getD9() {
        return d9;
    }

    /**
     * @param d9 the d9 to set
     */
    public void setD9(int d9) {
        this.d9 = d9;
    }

    /**
     * @return the d10
     */
    public int getD10() {
        return d10;
    }

    /**
     * @param d10 the d10 to set
     */
    public void setD10(int d10) {
        this.d10 = d10;
    }

    /**
     * @return the d11
     */
    public int getD11() {
        return d11;
    }

    /**
     * @param d11 the d11 to set
     */
    public void setD11(int d11) {
        this.d11 = d11;
    }

    /**
     * @return the d12
     */
    public int getD12() {
        return d12;
    }

    /**
     * @param d12 the d12 to set
     */
    public void setD12(int d12) {
        this.d12 = d12;
    }

    /**
     * @return the d13
     */
    public int getD13() {
        return d13;
    }

    /**
     * @param d13 the d13 to set
     */
    public void setD13(int d13) {
        this.d13 = d13;
    }

    /**
     * @return the d14
     */
    public int getD14() {
        return d14;
    }

    /**
     * @param d14 the d14 to set
     */
    public void setD14(int d14) {
        this.d14 = d14;
    }

    /**
     * @return the d15
     */
    public int getD15() {
        return d15;
    }

    /**
     * @param d15 the d15 to set
     */
    public void setD15(int d15) {
        this.d15 = d15;
    }

    /**
     * @return the d16
     */
    public int getD16() {
        return d16;
    }

    /**
     * @param d16 the d16 to set
     */
    public void setD16(int d16) {
        this.d16 = d16;
    }

    /**
     * @return the d17
     */
    public int getD17() {
        return d17;
    }

    /**
     * @param d17 the d17 to set
     */
    public void setD17(int d17) {
        this.d17 = d17;
    }

    /**
     * @return the d18
     */
    public int getD18() {
        return d18;
    }

    /**
     * @param d18 the d18 to set
     */
    public void setD18(int d18) {
        this.d18 = d18;
    }

    /**
     * @return the d19
     */
    public int getD19() {
        return d19;
    }

    /**
     * @param d19 the d19 to set
     */
    public void setD19(int d19) {
        this.d19 = d19;
    }

    /**
     * @return the d_TOT
     */
    public int getD_TOT() {
        return d_TOT;
    }

    /**
     * @param d_TOT the d_TOT to set
     */
    public void setD_TOT(int d_TOT) {
        this.d_TOT = d_TOT;
    }

    /**
     * @return the h1
     */
    public int getH1() {
        return h1;
    }

    /**
     * @param h1 the h1 to set
     */
    public void setH1(int h1) {
        this.h1 = h1;
    }

    /**
     * @return the h2
     */
    public int getH2() {
        return h2;
    }

    /**
     * @param h2 the h2 to set
     */
    public void setH2(int h2) {
        this.h2 = h2;
    }

    /**
     * @return the h3
     */
    public int getH3() {
        return h3;
    }

    /**
     * @param h3 the h3 to set
     */
    public void setH3(int h3) {
        this.h3 = h3;
    }

    /**
     * @return the h4
     */
    public int getH4() {
        return h4;
    }

    /**
     * @param h4 the h4 to set
     */
    public void setH4(int h4) {
        this.h4 = h4;
    }

    /**
     * @return the h5
     */
    public int getH5() {
        return h5;
    }

    /**
     * @param h5 the h5 to set
     */
    public void setH5(int h5) {
        this.h5 = h5;
    }

    /**
     * @return the h6
     */
    public int getH6() {
        return h6;
    }

    /**
     * @param h6 the h6 to set
     */
    public void setH6(int h6) {
        this.h6 = h6;
    }

    /**
     * @return the h7
     */
    public int getH7() {
        return h7;
    }

    /**
     * @param h7 the h7 to set
     */
    public void setH7(int h7) {
        this.h7 = h7;
    }

    /**
     * @return the h8
     */
    public int getH8() {
        return h8;
    }

    /**
     * @param h8 the h8 to set
     */
    public void setH8(int h8) {
        this.h8 = h8;
    }

    /**
     * @return the h9
     */
    public int getH9() {
        return h9;
    }

    /**
     * @param h9 the h9 to set
     */
    public void setH9(int h9) {
        this.h9 = h9;
    }

    /**
     * @return the h10
     */
    public int getH10() {
        return h10;
    }

    /**
     * @param h10 the h10 to set
     */
    public void setH10(int h10) {
        this.h10 = h10;
    }

    /**
     * @return the h11
     */
    public int getH11() {
        return h11;
    }

    /**
     * @param h11 the h11 to set
     */
    public void setH11(int h11) {
        this.h11 = h11;
    }

    /**
     * @return the h12
     */
    public int getH12() {
        return h12;
    }

    /**
     * @param h12 the h12 to set
     */
    public void setH12(int h12) {
        this.h12 = h12;
    }

    /**
     * @return the h13
     */
    public int getH13() {
        return h13;
    }

    /**
     * @param h13 the h13 to set
     */
    public void setH13(int h13) {
        this.h13 = h13;
    }

    /**
     * @return the h14
     */
    public int getH14() {
        return h14;
    }

    /**
     * @param h14 the h14 to set
     */
    public void setH14(int h14) {
        this.h14 = h14;
    }

    /**
     * @return the h15
     */
    public int getH15() {
        return h15;
    }

    /**
     * @param h15 the h15 to set
     */
    public void setH15(int h15) {
        this.h15 = h15;
    }

    /**
     * @return the h16
     */
    public int getH16() {
        return h16;
    }

    /**
     * @param h16 the h16 to set
     */
    public void setH16(int h16) {
        this.h16 = h16;
    }

    /**
     * @return the h17
     */
    public int getH17() {
        return h17;
    }

    /**
     * @param h17 the h17 to set
     */
    public void setH17(int h17) {
        this.h17 = h17;
    }

    /**
     * @return the h18
     */
    public int getH18() {
        return h18;
    }

    /**
     * @param h18 the h18 to set
     */
    public void setH18(int h18) {
        this.h18 = h18;
    }

    /**
     * @return the h19
     */
    public int getH19() {
        return h19;
    }

    /**
     * @param h19 the h19 to set
     */
    public void setH19(int h19) {
        this.h19 = h19;
    }

    /**
     * @return the h_TOT
     */
    public int getH_TOT() {
        return h_TOT;
    }

    /**
     * @param h_TOT the h_TOT to set
     */
    public void setH_TOT(int h_TOT) {
        this.h_TOT = h_TOT;
    }
    
    
}
