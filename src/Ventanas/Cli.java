package Ventanas;

import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Cli extends javax.swing.JFrame {
    
    private DefaultTableModel model;
    int cont = 0;
    String jeliminarCli;
    String b;
    
    public Cli() {
        initComponents();
        FECHASNAC();
        MostrardiaProfes();
        MostrarCumples();
        MostrarInterfaz();
        MostrarDatos();       
    }
    @Override
    public Image getIconImage()
    {
       Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/vcICONO.jpg"));
       return retValue; 
    }
        
    private void MostrarInterfaz()
    {
        String data[][]={};
        String col[] = {"Nombre y Apellido","Domicilio","Telefono","Celular","Email","Profesión","Lugar","Fecha Nacimiento","Derivado","Alérgico/a",
            "Diabético/a","Trat. Dietético","Nro. Partos","Tensión Arterial","Ant. Hormonales","Temperamento","Inter. Quir.","Tabaco",
            "Alcohol","Normal","Fluente","Sensible","S. Alipico","S. Deshidratado","Xerodermico","Textura","Color","Pigmentos","Localizacion",
            "Cicatrices","Localizacion","Lesiones","Pliegues y Arrugas","Inducidas por Sol","Parpados","Peribucales","Frente","Nasogeniano",
            "Preauriculares","Tonicidad","Daño Solar","Flacidez","Cara","Malar","Bozo","Mentoniano","Se depila","Hirsutamo","Hipertricosis",
            "Seco","Graso","Eritema","Lesiones","Alopecias","Tipo","Onicopatias","Antecedentes","Descamación","Uñas","Pitiriasis","Prurito",
            "Excoriaciones","Celulitis","Tipo","Localización","Estrías","Localización","Acné Tipo","Tiempo Evolución","Ante. Hereditarios",
            "Les. Elementales","Localización","Rosácea Tipo","Tiempo Evol.","Localización","Ante. Hereditarios","Piel Senil","Quera. Acniticas",
            "Elasto. Solar","Otras Alteraciones","Involución","Trat. Dermato.","Trat. Cosme.","Arriba Ombligo","Abajo Ombligo","B. Derecho",
            "B. Izquierdo","Caderas","Talla","Peso","Tratamiento 1","Precio","Debe","Haber","Tratamiento 2","Precio","Debe","Haber","Tratamiento 3","Precio","Debe","Haber",
            "Tratamiento 4","Precio","Debe","Haber","Tratamiento 5","Precio","Debe","Haber","Tratamiento 6","Precio","Debe","Haber","Tratamiento 7","Precio","Debe","Haber",
            "Tratamiento 8","Precio","Debe","Haber","Tratamiento 9","Precio","Debe","Haber","Tratamiento 10","Precio","Debe","Haber","Tratamiento 11","Precio","Debe","Haber",
            "Tratamiento 12","Precio","Debe","Haber","Tratamiento 13","Precio","Debe","Haber","Tratamiento 14","Precio","Debe","Haber","Tratamiento 15","Precio","Debe","Haber",
            "Tratamiento 16","Precio","Debe","Haber","Tratamiento 17","Precio","Debe","Haber","Tratamiento 18","Precio","Debe","Haber","Tratamiento 19","Precio","Debe","Haber",
            "Total Debe", "Total Haber","Foto"};
        model = new DefaultTableModel(data,col);
        jTable1_Cilentes_Mostrar.setModel(model);
    }
    
    private void Eliminar()
    {
        String btns [] ={"Si","Cancelar"};
        AgCliente p = new AgCliente();
        File url = new File(p.ubicacion+jeliminarCli+".txt");
        try {
            FileInputStream cerrar = new FileInputStream(url);
            cerrar.close();
            System.gc();
            
            int seguro = JOptionPane.showOptionDialog(rootPane, "Esta seguro de eliminar el cliente?", "Eliminacion", 0, 0, null, btns, null);
            
            if (seguro == JOptionPane.YES_OPTION)
            {
                url.delete();
                JOptionPane.showMessageDialog(rootPane, "Cliente eliminado.");
                MostrarInterfaz();
                MostrarDatos();
            }else
            {
                
            }
            
        } catch (HeadlessException | IOException e) 
        {
        }
    }
    
    private void MostrarCumples()
    {
        String data[][]={};
        String col[] = {"Nombre y Apellido","Celular","Email"};
        model = new DefaultTableModel(data,col);
        jTableCUMPLES.setModel(model);
        
            String barra = File.separator;
            String ubicacion = System.getProperty("user.dir")+barra+"ClientesRegistro"+barra;
            File contenedor = new File(ubicacion);
            File[] registros = contenedor.listFiles();
           
            Date fecha_actual = new Date();
            DateFormat dateFormatdd = new SimpleDateFormat("dd");
            String dia_act = dateFormatdd.format(fecha_actual);
            DateFormat dateFormatmm = new SimpleDateFormat("MM");
            String mes_act = dateFormatmm.format(fecha_actual);
            
        for (File registro : registros) {
            File url = new File(ubicacion + registro.getName());
            try
            {
                FileInputStream fis = new FileInputStream(url);
                Properties mostrar = new Properties();
                mostrar.load(fis);
                
                String d_n = mostrar.getProperty("dn");
                String m_n = mostrar.getProperty("mn");
                
                if(mes_act.equals(m_n)&&(dia_act.equals(d_n))){
                    String filas [] = {mostrar.getProperty("NyA"),mostrar.getProperty("Cel"),mostrar.getProperty("mail")};
                    model.addRow(filas);
                }
                
            }catch(IOException e)
            {}
        }   
        
    }

    private void MostrarDatos() 
    {
        String barra = File.separator;
        String ubicacion = System.getProperty("user.dir")+barra+"ClientesRegistro"+barra;
        File contenedor = new File(ubicacion);
        File[] registros = contenedor.listFiles();
            
        for (File registro : registros) {
            File url = new File(ubicacion + registro.getName());
            try
            {
                FileInputStream fis = new FileInputStream(url);
                Properties mostrar = new Properties();
                mostrar.load(fis);
                String d_naci = mostrar.getProperty("dn");
                String m_naci = mostrar.getProperty("mn");
                String y_naci = mostrar.getProperty("an");
                String comple_naci = (d_naci+"/"+m_naci+"/"+y_naci);
                
                String precio_uno = mostrar.getProperty("p1");
                String haber_uno = mostrar.getProperty("h1");
                int precio_1 = Integer.parseInt(precio_uno);
                int haber_1 = Integer.parseInt(haber_uno);
                int debe_1 = precio_1 - haber_1;
                String debe_uno = String.valueOf(debe_1);
                
                String precio_dos = mostrar.getProperty("p2");
                String haber_dos = mostrar.getProperty("h2");
                int precio_2 = Integer.parseInt(precio_dos);
                int haber_2 = Integer.parseInt(haber_dos);
                int debe_2 = precio_2 - haber_2;
                String debe_dos = String.valueOf(debe_2);
                
                String precio_tres = mostrar.getProperty("p3");
                String haber_tres = mostrar.getProperty("h3");
                int precio_3 = Integer.parseInt(precio_tres);
                int haber_3 = Integer.parseInt(haber_tres);
                int debe_3 = precio_3 - haber_3;
                String debe_tres = String.valueOf(debe_3);
                
                String precio_cuatro = mostrar.getProperty("p4");
                String haber_cuatro = mostrar.getProperty("h4");
                int precio_4 = Integer.parseInt(precio_cuatro);
                int haber_4 = Integer.parseInt(haber_cuatro);
                int debe_4 = precio_4 - haber_4;
                String debe_cuatro = String.valueOf(debe_4);
                
                String precio_cinco = mostrar.getProperty("p5");
                String haber_cinco = mostrar.getProperty("h5");
                int precio_5 = Integer.parseInt(precio_cinco);
                int haber_5 = Integer.parseInt(haber_cinco);
                int debe_5 = precio_5 - haber_5;
                String debe_cinco = String.valueOf(debe_5);
                
                String precio_seis = mostrar.getProperty("p6");
                String haber_seis = mostrar.getProperty("h6");
                int precio_6 = Integer.parseInt(precio_seis);
                int haber_6 = Integer.parseInt(haber_seis);
                int debe_6 = precio_6 - haber_6;
                String debe_seis = String.valueOf(debe_6);
                
                String precio_siete = mostrar.getProperty("p7");
                String haber_siete = mostrar.getProperty("h7");
                int precio_7 = Integer.parseInt(precio_siete);
                int haber_7 = Integer.parseInt(haber_siete);
                int debe_7 = precio_7 - haber_7;
                String debe_siete = String.valueOf(debe_7);
                
                String precio_ocho = mostrar.getProperty("p8");
                String haber_ocho = mostrar.getProperty("h8");
                int precio_8 = Integer.parseInt(precio_ocho);
                int haber_8 = Integer.parseInt(haber_ocho);
                int debe_8 = precio_8 - haber_8;
                String debe_ocho = String.valueOf(debe_8);
                
                String precio_nueve = mostrar.getProperty("p9");
                String haber_nueve = mostrar.getProperty("h9");
                int precio_9 = Integer.parseInt(precio_nueve);
                int haber_9 = Integer.parseInt(haber_nueve);
                int debe_9 = precio_9 - haber_9;
                String debe_nueve = String.valueOf(debe_9);
                
                String precio_diez = mostrar.getProperty("p10");
                String haber_diez = mostrar.getProperty("h10");
                int precio_10 = Integer.parseInt(precio_diez);
                int haber_10 = Integer.parseInt(haber_diez);
                int debe_10 = precio_10 - haber_10;
                String debe_diez = String.valueOf(debe_10);
                
                String precio_once = mostrar.getProperty("p11");
                String haber_once = mostrar.getProperty("h11");
                int precio_11 = Integer.parseInt(precio_once);
                int haber_11 = Integer.parseInt(haber_once);
                int debe_11 = precio_11 - haber_11;
                String debe_once = String.valueOf(debe_11);
                
                String precio_doce = mostrar.getProperty("p12");
                String haber_doce = mostrar.getProperty("h12");
                int precio_12 = Integer.parseInt(precio_doce);
                int haber_12 = Integer.parseInt(haber_doce);
                int debe_12 = precio_12 - haber_12;
                String debe_doce = String.valueOf(debe_12);
                
                String precio_trece = mostrar.getProperty("p13");
                String haber_trece = mostrar.getProperty("h13");
                int precio_13 = Integer.parseInt(precio_trece);
                int haber_13 = Integer.parseInt(haber_trece);
                int debe_13 = precio_13 - haber_13;
                String debe_trece = String.valueOf(debe_13);
                
                String precio_catorce = mostrar.getProperty("p14");
                String haber_catorce = mostrar.getProperty("h14");
                int precio_14 = Integer.parseInt(precio_catorce);
                int haber_14 = Integer.parseInt(haber_catorce);
                int debe_14 = precio_14 - haber_14;
                String debe_catorce = String.valueOf(debe_14);
                
                String precio_quince = mostrar.getProperty("p15");
                String haber_quince = mostrar.getProperty("h15");
                int precio_15 = Integer.parseInt(precio_quince);
                int haber_15 = Integer.parseInt(haber_quince);
                int debe_15 = precio_15 - haber_15;
                String debe_quince = String.valueOf(debe_15);
                
                String precio_dieciseis = mostrar.getProperty("p16");
                String haber_dieciseis = mostrar.getProperty("h16");
                int precio_16 = Integer.parseInt(precio_dieciseis);
                int haber_16 = Integer.parseInt(haber_dieciseis);
                int debe_16 = precio_16 - haber_16;
                String debe_dieciseis = String.valueOf(debe_16);
                
                String precio_diecisiete = mostrar.getProperty("p17");
                String haber_diecisiete = mostrar.getProperty("h17");
                int precio_17 = Integer.parseInt(precio_diecisiete);
                int haber_17 = Integer.parseInt(haber_diecisiete);
                int debe_17 = precio_17 - haber_17;
                String debe_diecisiete = String.valueOf(debe_17);
                
                String precio_dieciocho = mostrar.getProperty("p18");
                String haber_dieciocho = mostrar.getProperty("h18");
                int precio_18 = Integer.parseInt(precio_dieciocho);
                int haber_18 = Integer.parseInt(haber_dieciocho);
                int debe_18 = precio_18 - haber_18;
                String debe_dieciocho = String.valueOf(debe_18);
                
                String precio_diecinueve = mostrar.getProperty("p19");
                String haber_diecinueve = mostrar.getProperty("h19");
                int precio_19 = Integer.parseInt(precio_diecinueve);
                int haber_19 = Integer.parseInt(haber_diecinueve);
                int debe_19 = precio_19 - haber_19;
                String debe_diecinueve = String.valueOf(debe_19);
                
                int debe_total = debe_1+debe_2+debe_3+debe_4+debe_5+debe_6+debe_7+debe_8+debe_9+debe_10+debe_11+debe_12+debe_13
                        +debe_14+debe_15+debe_16+debe_17+debe_18+debe_19;
                String d_total = String.valueOf(debe_total);
                
                int haber_total = haber_1+haber_2+haber_3+haber_4+haber_5+haber_6+haber_7+haber_8+haber_9+haber_10+haber_11+haber_12+haber_13
                        +haber_14+haber_15+haber_16+haber_17+haber_18+haber_19;
                String h_total = String.valueOf(haber_total);
                
                String filas [] = {
                mostrar.getProperty("NyA"),
                mostrar.getProperty("Dom"),
                mostrar.getProperty("Fijo"),
                mostrar.getProperty("Cel"),
                mostrar.getProperty("mail"),
                mostrar.getProperty("PROF"),
                mostrar.getProperty("Prof_Lugar"),
                (comple_naci),
                mostrar.getProperty("medico"),
                mostrar.getProperty("alergico"),
                mostrar.getProperty("diabetes"),
                mostrar.getProperty("tratam_diete"),
                mostrar.getProperty("c_partos"),
                mostrar.getProperty("ten_art"),
                mostrar.getProperty("ant_hormo"),
                mostrar.getProperty("tempera"),
                mostrar.getProperty("inter_quir"),
                mostrar.getProperty("tabaco"),
                mostrar.getProperty("alcohol"),
                mostrar.getProperty("normal"),
                mostrar.getProperty("fluente"),
                mostrar.getProperty("sensi"),
                mostrar.getProperty("secoalip"),
                mostrar.getProperty("secodeshi"),
                mostrar.getProperty("xero"),
                mostrar.getProperty("texuta"),
                mostrar.getProperty("color"),
                mostrar.getProperty("pigme"),
                mostrar.getProperty("local"),
                mostrar.getProperty("cicat"),
                mostrar.getProperty("locacic"),
                mostrar.getProperty("lesion"),
                mostrar.getProperty("debioti"),
                mostrar.getProperty("indu_sol"),
                mostrar.getProperty("parpad"),
                mostrar.getProperty("peribuca"),
                mostrar.getProperty("frente"),
                mostrar.getProperty("nasoge"),
                mostrar.getProperty("periauri"),
                mostrar.getProperty("tonici"),
                mostrar.getProperty("daniosol"),
                mostrar.getProperty("flaci"),
                mostrar.getProperty("cara"),
                mostrar.getProperty("malar"),
                mostrar.getProperty("bozo"),
                mostrar.getProperty("mento"),
                mostrar.getProperty("sedepi"),
                mostrar.getProperty("hirsu"),
                mostrar.getProperty("hipertri"),
                mostrar.getProperty("seco"),
                mostrar.getProperty("graso"),
                mostrar.getProperty("erite"),
                mostrar.getProperty("leseri"),
                mostrar.getProperty("alope"),
                mostrar.getProperty("tipoalope"),
                mostrar.getProperty("onico"),
                mostrar.getProperty("anteonico"),
                mostrar.getProperty("descama"),
                mostrar.getProperty("unias"),
                mostrar.getProperty("pitiri"),
                mostrar.getProperty("pruri"),
                mostrar.getProperty("excor"),
                mostrar.getProperty("celuli"),
                mostrar.getProperty("tipocelu"),
                mostrar.getProperty("locacelu"),
                mostrar.getProperty("estria"),
                mostrar.getProperty("locaestri"),
                mostrar.getProperty("acnetipoestri"),
                mostrar.getProperty("tiempoevol"),
                mostrar.getProperty("antehereestri"),
                mostrar.getProperty("lesielem"),
                mostrar.getProperty("localesielem"),
                mostrar.getProperty("rosatipo"),
                mostrar.getProperty("tiempoevolrosa"),
                mostrar.getProperty("locarosa"),
                mostrar.getProperty("antehererosa"),
                mostrar.getProperty("pielsen"),
                mostrar.getProperty("querato"),
                mostrar.getProperty("elasto"),
                mostrar.getProperty("otrasalter"),
                mostrar.getProperty("involedad"),
                mostrar.getProperty("tratderma"),
                mostrar.getProperty("tratcosme"),
                mostrar.getProperty("arribaomb"),
                mostrar.getProperty("abajoomb"),
                mostrar.getProperty("bder"),
                mostrar.getProperty("bizq"),
                mostrar.getProperty("cade"),
                mostrar.getProperty("talla"),
                mostrar.getProperty("peso"),
                mostrar.getProperty("t1"),
                mostrar.getProperty("p1"),
                (debe_uno),
                mostrar.getProperty("h1"),
                mostrar.getProperty("t2"),
                mostrar.getProperty("p2"),
                (debe_dos),
                mostrar.getProperty("h2"),
                mostrar.getProperty("t3"),
                mostrar.getProperty("p3"),
                (debe_tres),
                mostrar.getProperty("h3"),
                mostrar.getProperty("t4"),
                mostrar.getProperty("p4"),
                (debe_cuatro),
                mostrar.getProperty("h4"),
                mostrar.getProperty("t5"),
                mostrar.getProperty("p5"),
                (debe_cinco),
                mostrar.getProperty("h5"),
                mostrar.getProperty("t6"),
                mostrar.getProperty("p6"),
                (debe_seis),
                mostrar.getProperty("h6"),
                mostrar.getProperty("t7"),
                mostrar.getProperty("p7"),
                (debe_siete),
                mostrar.getProperty("h7"),
                mostrar.getProperty("t8"),
                mostrar.getProperty("p8"),
                (debe_ocho),
                mostrar.getProperty("h8"),
                mostrar.getProperty("t9"),
                mostrar.getProperty("p9"),
                (debe_nueve),
                mostrar.getProperty("h9"),
                mostrar.getProperty("t10"),
                mostrar.getProperty("p10"),
                (debe_diez),
                mostrar.getProperty("h10"),
                mostrar.getProperty("t11"),
                mostrar.getProperty("p11"),
                (debe_once),
                mostrar.getProperty("h11"),
                mostrar.getProperty("t12"),
                mostrar.getProperty("p12"),
                (debe_doce),
                mostrar.getProperty("h12"),
                mostrar.getProperty("t13"),
                mostrar.getProperty("p13"),
                (debe_trece),
                mostrar.getProperty("h13"),
                mostrar.getProperty("t14"),
                mostrar.getProperty("p14"),
                (debe_catorce),
                mostrar.getProperty("h14"),
                mostrar.getProperty("t15"),
                mostrar.getProperty("p15"),
                (debe_quince),
                mostrar.getProperty("h15"),
                mostrar.getProperty("t16"),
                mostrar.getProperty("p16"),
                (debe_dieciseis),
                mostrar.getProperty("h16"),
                mostrar.getProperty("t17"),
                mostrar.getProperty("p17"),
                (debe_diecisiete),
                mostrar.getProperty("h17"),
                mostrar.getProperty("t18"),
                mostrar.getProperty("p18"),
                (debe_dieciocho),
                mostrar.getProperty("h18"),
                mostrar.getProperty("t19"),
                mostrar.getProperty("p19"),
                (debe_diecinueve),
                mostrar.getProperty("h19"),
                (d_total),
                (h_total),
                mostrar.getProperty("fo_nomb")};
                model.addRow(filas);
            }catch(IOException e){}
        }    
    }
    
    private void MostrardiaProfes()
    {
        String data[][]={};
        String col[] = {"Nombre y Apellido","Profesión","Celular"};
        model = new DefaultTableModel(data,col);
        jTableDIADE.setModel(model);
        
         AgCliente p;
            String barra = File.separator;
            String ubicacion = System.getProperty("user.dir")+barra+"ClientesRegistro"+barra;
            File contenedor = new File(ubicacion);
            File[] registros = contenedor.listFiles();

            Date fecha_actual = new Date();
            DateFormat dateFormatdd = new SimpleDateFormat("dd");
            String dia_act = dateFormatdd.format(fecha_actual);
            DateFormat dateFormatmm = new SimpleDateFormat("MM");
            String mes_act = dateFormatmm.format(fecha_actual);
            
            for (File registro : registros) {
            File url = new File(ubicacion + registro.getName());
            try
            {
                FileInputStream fis = new FileInputStream(url);
                Properties mostrar = new Properties();
                mostrar.load(fis);
                
                String d_prof = mostrar.getProperty("PROF");
                
                switch (d_prof)
                {
                    case "Actor/Actriz": d_prof = "0205";
                    break;
                    case "Fonoaudiologa/o": d_prof = "1205";
                    break;
                    case "Periodista": d_prof = "0706";
                    break;
                    case "Bioquimica/o": d_prof = "1506";
                    break;
                    case "Ingeniera/o": d_prof  = "1606";
                    break;
                    case "Locutor/a": d_prof = "0307";
                    break;
                    case "Abogada/o": d_prof = "2908";
                    break;
                    case "Secretaria/o": d_prof = "0309";
                    break;
                    case "Maestra/o": d_prof = "1109";
                    break;
                    case "Profesor/a": d_prof = "1709";
                    break;
                    case "Fotografa/o": d_prof = "2109";
                    break;
                    case "Cosmetologa/o": d_prof = "2109";
                    break;
                    case "Odontologa/o": d_prof = "0310";
                    break;
                    case "Farmaceutioca/o": d_prof = "1210";
                    break;
                    case "Psicologa/o": d_prof = "1310";
                    break;
                    case "Contador/a" : d_prof = "1712";
                    break;
                    default : d_prof = "nada";
                    break;
                }
                if (d_prof.equals(dia_act+mes_act))
                {
                    String filas [] = {
                    mostrar.getProperty("NyA"),
                    mostrar.getProperty("PROF"),
                    mostrar.getProperty("Cel")};
                    model.addRow(filas);
                }
            }catch(IOException e){}
        } 
            
        
    }
    
    private void Editar()
    {
        String barra = File.separator;
        String ubicacion = System.getProperty("user.dir")+barra+"ClientesRegistro"+barra;
        
        if (jTextFieldNyA_INTRO.getText().equals(""))
        {
            JOptionPane.showMessageDialog(rootPane, "No se puede Guardar un cliente sin Nombre!");
        }else
        {
            try 
            {
                try (FileWriter permite_escrito = new FileWriter(ubicacion+jTextFieldNyA_INTRO.getText()+".txt")) {
                    String nya = "NyA=";
                    String dom = "Dom=";
                    String fijo = "Fijo=";
                    String celu = "Cel=";
                    String email = "mail=";
                    String profes = "PROF=";
                    String lugar = "Prof_Lugar=";
                    String dia = "dn=";
                    String mes = "mn=";
                    String anio = "an=";
                    String medic = "medico=";
                    String alergi = "alergico=";
                    String diabe = "diabetes=";
                    String tra_dia = "tratam_diete=";
                    String partos = "c_partos=";
                    String arte = "ten_art=";
                    String hormo = "ant_hormo=";
                    String temp = "tempera=";
                    String int_qui = "inter_quir=";
                    String tab = "tabaco=";
                    String alco = "alcohol=";
                    String norma = "normal=";
                    String flue = "fluente=";
                    String sensib = "sensi=";
                    String secali = "secoalip=";
                    String secdes = "secodeshi=";
                    String xer = "xero=";
                    String tex = "texuta=";
                    String colo = "color=";
                    String pig = "pigme=";
                    String locali = "local=";
                    String cica = "cicat=";
                    String localiz = "locacic=";
                    String lesi = "lesion=";
                    String debiotip = "debioti=";
                    String in_sol = "indu_sol=";
                    String parp = "parpad=";
                    String peri = "peribuca=";
                    String fren = "frente=";
                    String naso = "nasoge=";
                    String periaur = "periauri=";
                    String toni = "tonici=";
                    String danisol = "daniosol=";
                    String flaci = "flaci=";
                    String caraa = "cara=";
                    String mala = "malar=";
                    String boz = "bozo=";
                    String men = "mento=";
                    String sdep = "sedepi=";
                    String hirsuta = "hirsu=";
                    String hiper = "hipertri=";
                    String sseco = "seco=";
                    String gras = "graso=";
                    String eri = "erite=";
                    String leser = "leseri=";
                    String alo = "alope=";
                    String tialo = "tipoalope=";
                    String oni = "onico=";
                    String anoni = "anteonico=";
                    String desc = "descama=";
                    String uni = "unias=";
                    String piti = "pitiri=";
                    String pru = "pruri=";
                    String exc = "excor=";
                    String celulit = "celuli=";
                    String ticelu = "tipocelu=";
                    String locelu = "locacelu=";
                    String estri = "estria=";
                    String loestri = "locaestri=";
                    String acnetip = "acnetipoestri=";
                    String tievolu = "tiempoevol=";
                    String anthere = "antehereestri=";
                    String leelem = "lesielem=";
                    String locleselem = "localesielem=";
                    String rotipo = "rosatipo=";
                    String tierosa = "tiempoevolrosa=";
                    String locrosa = "locarosa=";
                    String antherrosa = "antehererosa=";
                    String pisen = "pielsen=";
                    String quer = "querato=";
                    String elas = "elasto=";
                    String otalter = "otrasalter=";
                    String involed = "involedad=";
                    String trar_der = "tratderma=";
                    String tra_cos = "tratcosme=";
                    String arromb = "arribaomb=";
                    String abomb = "abajoomb=";
                    String bdere= "bder=";
                    String bizqui = "bizq=";
                    String cad = "cade=";
                    String tal = "talla=";
                    String pes = "peso=";
                    String t1 = "t1=";
                    String t2 = "t2=";
                    String t3 = "t3=";
                    String t4 = "t4=";
                    String t5 = "t5=";
                    String t6 = "t6=";
                    String t7 = "t7=";
                    String t8 = "t8=";
                    String t9 = "t9=";
                    String t10 = "t10=";
                    String t11 = "t11=";
                    String t12 = "t12=";
                    String t13 = "t13=";
                    String t14 = "t14=";
                    String t15 = "t15=";
                    String t16 = "t16=";
                    String t17 = "t17=";
                    String t18 = "t18=";
                    String t19 = "t19=";
                    String p1 = "p1=";
                    String p2 = "p2=";
                    String p3 = "p3=";
                    String p4 = "p4=";
                    String p5 = "p5=";
                    String p6 = "p6=";
                    String p7 = "p7=";
                    String p8 = "p8=";
                    String p9 = "p9=";
                    String p10 = "p10=";
                    String p11 = "p11=";
                    String p12 = "p12=";
                    String p13 = "p13=";
                    String p14 = "p14=";
                    String p15 = "p15=";
                    String p16 = "p16=";
                    String p17 = "p17=";
                    String p18 = "p18=";
                    String p19 = "p19=";
                    String d1 = "d1=";
                    String d2 = "d2=";
                    String d3 = "d3=";
                    String d4 = "d4=";
                    String d5 = "d5=";
                    String d6 = "d6=";
                    String d7 = "d7=";
                    String d8 = "d8=";
                    String d9 = "d9=";
                    String d10 = "d10=";
                    String d11 = "d11=";
                    String d12 = "d12=";
                    String d13 = "d13=";
                    String d14 = "d14=";
                    String d15 = "d15=";
                    String d16 = "d16=";
                    String d17 = "d17=";
                    String d18 = "d18=";
                    String d19 = "d19=";
                    String d_TOT = "d_TOT=";
                    String h1 = "h1=";
                    String h2 = "h2=";
                    String h3 = "h3=";
                    String h4 = "h4=";
                    String h5 = "h5=";
                    String h6 = "h6=";
                    String h7 = "h7=";
                    String h8 = "h8=";
                    String h9 = "h9=";
                    String h10 = "h10=";
                    String h11 = "h11=";
                    String h12 = "h12=";
                    String h13 = "h13=";
                    String h14 = "h14=";
                    String h15 = "h15=";
                    String h16 = "h16=";
                    String h17 = "h17=";
                    String h18 = "h18=";
                    String h19 = "h19=";
                    String h_TOT = "h_TOT=";
                    String fo_nomb = "fo_nomb=";
                    
                    PrintWriter guardar = new PrintWriter(permite_escrito);
                    
                    guardar.println(nya+jTextFieldNyA_INTRO.getText());
                    guardar.println(dom+jTextFieldDOMIC_INTRO.getText());
                    guardar.println(fijo+jTextFieldT_FIJO_INTRO.getText());
                    guardar.println(celu+jTextFieldCEL_INTRO.getText());
                    guardar.println(email+jTextFieldCORREO_INTRO.getText());
                    guardar.println(profes+(String)jComboBoxPROFESION_SEL.getSelectedItem());
                    guardar.println(lugar+jTextFieldTRAB_LUGAR_INTRO.getText());
                    guardar.println(dia+(String)jComboBoxDIA_NAC.getSelectedItem());
                    guardar.println(mes+(String)jComboBoxMES_NAC.getSelectedItem());
                    guardar.println(anio+(String)jComboBoxYEAR_NAC.getSelectedItem());
                    guardar.println(medic+jTextFieldDERIV_DOC.getText());
                    guardar.println(alergi+(String)jbtalergia.getSelectedItem());
                    guardar.println(diabe+(String)jbtdiabetes.getSelectedItem());
                    guardar.println(tra_dia+jTextFieldTRAT_DIET_INTRO.getText());
                    guardar.println(partos+(String)jComboBoxPARTOS.getSelectedItem());
                    guardar.println(arte+jTextFieldTENSION_INTRO.getText());
                    guardar.println(hormo+jTextFieldANT_HOR_INTRO.getText());
                    guardar.println(temp+jTextFieldTEMPERAMENTO_INTRO.getText());
                    guardar.println(int_qui+(String)jComboBoxINTQUIRU_INTRO.getSelectedItem());
                    guardar.println(tab+(String)jbtcigarro.getSelectedItem());
                    guardar.println(alco+(String)jbtalcohol.getSelectedItem());
                    guardar.println(norma+(String)jComboBoxBIOT_NORMAL.getSelectedItem());
                    guardar.println(flue+(String)jComboBoxBIOT_FLUENtE.getSelectedItem());
                    guardar.println(sensib+(String)jComboBoxBIOT_SENSIBLE.getSelectedItem());
                    guardar.println(secali+(String)jComboBoxBIOT_ALIPICO.getSelectedItem());
                    guardar.println(secdes+(String)jComboBoxBIOT_DESHI.getSelectedItem());
                    guardar.println(xer+(String)jComboBoxBIOT_XERO.getSelectedItem());
                    guardar.println(tex+(String)jComboBoxBT_TEXT.getSelectedItem());
                    guardar.println(colo+jTextFieldBT_COLOR.getText());
                    guardar.println(pig+jTextFieldBT_PIGMEN.getText());
                    guardar.println(locali+jTextFieldBT_LOCAL_PIG.getText());
                    guardar.println(cica+jTextFieldBT_CICAT.getText());
                    guardar.println(localiz+jTextFieldBT_LOCAL_CICA.getText());
                    guardar.println(lesi+jTextFieldBT_LESION.getText());
                    guardar.println(debiotip+jTextFieldBT_PLIYARR.getText());
                    guardar.println(in_sol+jTextField1.getText());
                    guardar.println(parp+(String)jComboBoxBT_LOCA_PARP.getSelectedItem());
                    guardar.println(peri+(String)jComboBoxBT_LOC_PERIBU.getSelectedItem());
                    guardar.println(fren+(String)jComboBoxBT_LOC_FRENTE.getSelectedItem());
                    guardar.println(naso+(String)jComboBoxBT_LOCA_NASO.getSelectedItem());
                    guardar.println(periaur+(String)jComboBoxBT_LOCA_PREAURI.getSelectedItem());
                    guardar.println(toni+(String)jComboBoxBT_CUE_TON.getSelectedItem());
                    guardar.println(danisol+(String)jComboBoxBT_CUE_DASOL.getSelectedItem());
                    guardar.println(flaci+(String)jComboBoxBT_CUE_FLA.getSelectedItem());
                    guardar.println(caraa+(String)jComboBoxBT_CARA.getSelectedItem());
                    guardar.println(mala+(String)jComboBoxBT_MALAR.getSelectedItem());
                    guardar.println(boz+(String)jComboBoxBT_BOZO.getSelectedItem());
                    guardar.println(men+(String)jComboBoxBT_MENTO.getSelectedItem());
                    guardar.println(sdep+(String)jComboBoxBT_SEDEP.getSelectedItem());
                    guardar.println(hirsuta+(String)jComboBoxBT_HIRSU.getSelectedItem());
                    guardar.println(hiper+(String)jComboBoxBT_HIPER.getSelectedItem());
                    guardar.println(sseco+(String)jComboBoxCC_SECO.getSelectedItem());
                    guardar.println(gras+(String)jComboBoxCC_GRAS.getSelectedItem());
                    guardar.println(eri+(String)jComboBoxCC_ERIT.getSelectedItem());
                    guardar.println(leser+(String)jComboBoxCC_LESI.getSelectedItem());
                    guardar.println(alo+(String)jComboBoxCC_ALO.getSelectedItem());
                    guardar.println(tialo+(String)jComboBoxCC_TIPO.getSelectedItem());
                    guardar.println(oni+(String)jComboBoxCC_ONI.getSelectedItem());
                    guardar.println(anoni+(String)jComboBoxCC_ANTECE.getSelectedItem());
                    guardar.println(desc+(String)jComboBoxCC_DESCA.getSelectedItem());
                    guardar.println(uni+(String)jComboBoxCC_UNIA.getSelectedItem());
                    guardar.println(piti+(String)jComboBoxCC_PITI.getSelectedItem());
                    guardar.println(pru+(String)jComboBoxCC_PRUR.getSelectedItem());
                    guardar.println(exc+(String)jComboBoxCC_EXCO.getSelectedItem());
                    guardar.println(celulit+(String)jComboBox1.getSelectedItem());
                    guardar.println(ticelu+jTextField2.getText());
                    guardar.println(locelu+jTextField4.getText());
                    guardar.println(estri+(String)jComboBox2.getSelectedItem());
                    guardar.println(loestri+jTextField3.getText());
                    guardar.println(acnetip+jTextField5.getText());
                    guardar.println(tievolu+jTextField6.getText());
                    guardar.println(anthere+jTextField7.getText());
                    guardar.println(leelem+jTextField8.getText());
                    guardar.println(locleselem+jTextField9.getText());
                    guardar.println(rotipo+jTextField10.getText());
                    guardar.println(tierosa+jTextField11.getText());
                    guardar.println(locrosa+jTextField12.getText());
                    guardar.println(antherrosa+jTextField13.getText());
                    guardar.println(pisen+(String)jComboBox3.getSelectedItem());
                    guardar.println(quer+(String)jComboBox4.getSelectedItem());
                    guardar.println(elas+(String)jComboBox5.getSelectedItem());
                    guardar.println(otalter+jTextField14.getText());
                    guardar.println(involed+jTextField15.getText());
                    guardar.println(trar_der+jTextField16.getText());
                    guardar.println(tra_cos+jTextField17.getText());
                    guardar.println(arromb+jTextField18.getText());
                    guardar.println(abomb+jTextField19.getText());
                    guardar.println(bdere+jTextField20.getText());
                    guardar.println(bizqui+jTextField21.getText());
                    guardar.println(cad+jTextField22.getText());
                    guardar.println(tal+jTextField23.getText());
                    guardar.println(pes+jTextField24.getText());
                    guardar.println(t1+jTextField_TRAT_1.getText());
                    guardar.println(t2+jTextField_TRAT_2.getText());
                    guardar.println(t3+jTextField_TRAT_3.getText());
                    guardar.println(t4+jTextField_TRAT_4.getText());
                    guardar.println(t5+jTextField_TRAT_5.getText());
                    guardar.println(t6+jTextField_TRAT_6.getText());
                    guardar.println(t7+jTextField_TRAT_7.getText());
                    guardar.println(t8+jTextField_TRAT_8.getText());
                    guardar.println(t9+jTextField_TRAT_9.getText());
                    guardar.println(t10+jTextField_TRAT_10.getText());
                    guardar.println(t11+jTextField_TRAT_11.getText());
                    guardar.println(t12+jTextField_TRAT_12.getText());
                    guardar.println(t13+jTextField_TRAT_13.getText());
                    guardar.println(t14+jTextField_TRAT_14.getText());
                    guardar.println(t15+jTextField_TRAT_15.getText());
                    guardar.println(t16+jTextField_TRAT_16.getText());
                    guardar.println(t17+jTextField_TRAT_17.getText());
                    guardar.println(t18+jTextField_TRAT_18.getText());
                    guardar.println(t19+jTextField_TRAT_19.getText());
                    if ("".equals(jTextField_PRECIO_1.getText()))
                    { guardar.println(p1+"0"); }
                    else
                    { guardar.println(p1+jTextField_PRECIO_1.getText()); }
                    if ("".equals(jTextField_PRECIO_2.getText()))
                    { guardar.println(p2+"0"); }
                    else
                    { guardar.println(p2+jTextField_PRECIO_2.getText()); }
                    if ("".equals(jTextField_PRECIO_3.getText()))
                    { guardar.println(p3+"0"); }
                    else
                    { guardar.println(p3+jTextField_PRECIO_3.getText()); }
                    if ("".equals(jTextField_PRECIO_4.getText()))
                    { guardar.println(p4+"0"); }
                    else
                    { guardar.println(p4+jTextField_PRECIO_4.getText()); }
                    if ("".equals(jTextField_PRECIO_5.getText()))
                    { guardar.println(p5+"0"); }
                    else
                    { guardar.println(p5+jTextField_PRECIO_5.getText()); }
                    if ("".equals(jTextField_PRECIO_6.getText()))
                    { guardar.println(p6+"0"); }
                    else
                    { guardar.println(p6+jTextField_PRECIO_6.getText()); }
                    if ("".equals(jTextField_PRECIO_7.getText()))
                    { guardar.println(p7+"0"); }
                    else
                    { guardar.println(p7+jTextField_PRECIO_7.getText()); }
                    if ("".equals(jTextField_PRECIO_8.getText()))
                    { guardar.println(p8+"0"); }
                    else
                    { guardar.println(p8+jTextField_PRECIO_8.getText()); }
                    if ("".equals(jTextField_PRECIO_9.getText()))
                    { guardar.println(p9+"0"); }
                    else
                    { guardar.println(p9+jTextField_PRECIO_9.getText()); }
                    if ("".equals(jTextField_PRECIO_10.getText()))
                    { guardar.println(p10+"0"); }
                    else
                    { guardar.println(p10+jTextField_PRECIO_10.getText()); }
                    if ("".equals(jTextField_PRECIO_11.getText()))
                    { guardar.println(p11+"0"); }
                    else
                    { guardar.println(p11+jTextField_PRECIO_11.getText()); }
                    if ("".equals(jTextField_PRECIO_12.getText()))
                    { guardar.println(p12+"0"); }
                    else
                    { guardar.println(p12+jTextField_PRECIO_12.getText()); }
                    if ("".equals(jTextField_PRECIO_13.getText()))
                    { guardar.println(p13+"0"); }
                    else
                    { guardar.println(p13+jTextField_PRECIO_13.getText()); }
                    if ("".equals(jTextField_PRECIO_14.getText()))
                    { guardar.println(p14+"0"); }
                    else
                    { guardar.println(p14+jTextField_PRECIO_14.getText()); }
                    if ("".equals(jTextField_PRECIO_15.getText()))
                    { guardar.println(p15+"0"); }
                    else
                    { guardar.println(p15+jTextField_PRECIO_15.getText()); }
                    if ("".equals(jTextField_PRECIO_16.getText()))
                    { guardar.println(p16+"0"); }
                    else
                    { guardar.println(p16+jTextField_PRECIO_16.getText()); }
                    if ("".equals(jTextField_PRECIO_17.getText()))
                    { guardar.println(p17+"0"); }
                    else
                    { guardar.println(p17+jTextField_PRECIO_17.getText()); }
                    if ("".equals(jTextField_PRECIO_18.getText()))
                    { guardar.println(p18+"0"); }
                    else
                    { guardar.println(p18+jTextField_PRECIO_18.getText()); }
                    if ("".equals(jTextField_PRECIO_19.getText()))
                    { guardar.println(p19+"0"); }
                    else
                    { guardar.println(p19+jTextField_PRECIO_19.getText()); }
                    guardar.println(d1+jTextField_DEBE_1.getText());
                    guardar.println(d2+jTextField_DEBE_2.getText());
                    guardar.println(d3+jTextField_DEBE_3.getText());
                    guardar.println(d4+jTextField_DEBE_4.getText());
                    guardar.println(d5+jTextField_DEBE_5.getText());
                    guardar.println(d6+jTextField_DEBE_6.getText());
                    guardar.println(d7+jTextField_DEBE_7.getText());
                    guardar.println(d8+jTextField_DEBE_8.getText());
                    guardar.println(d9+jTextField_DEBE_9.getText());
                    guardar.println(d10+jTextField_DEBE_10.getText());
                    guardar.println(d11+jTextField_DEBE_11.getText());
                    guardar.println(d12+jTextField_DEBE_12.getText());
                    guardar.println(d13+jTextField_DEBE_13.getText());
                    guardar.println(d14+jTextField_DEBE_14.getText());
                    guardar.println(d15+jTextField_DEBE_15.getText());
                    guardar.println(d16+jTextField_DEBE_16.getText());
                    guardar.println(d17+jTextField_DEBE_17.getText());
                    guardar.println(d18+jTextField_DEBE_18.getText());
                    guardar.println(d19+jTextField_DEBE_19.getText());
                    guardar.println(d_TOT+jTextField_DEBE_TOT.getText());
                    if ("".equals(jTextField_HABER_1.getText()))
                    { guardar.println(h1+"0"); }
                    else
                    { guardar.println(h1+jTextField_HABER_1.getText()); }
                    if ("".equals(jTextField_HABER_2.getText()))
                    { guardar.println(h2+"0"); }
                    else
                    { guardar.println(h2+jTextField_HABER_2.getText()); }
                    if ("".equals(jTextField_HABER_3.getText()))
                    { guardar.println(h3+"0"); }
                    else
                    { guardar.println(h3+jTextField_HABER_3.getText()); }
                    if ("".equals(jTextField_HABER_4.getText()))
                    { guardar.println(h4+"0"); }
                    else
                    { guardar.println(h4+jTextField_HABER_4.getText()); }
                    if ("".equals(jTextField_HABER_5.getText()))
                    { guardar.println(h5+"0"); }
                    else
                    { guardar.println(h5+jTextField_HABER_5.getText()); }
                    if ("".equals(jTextField_HABER_6.getText()))
                    { guardar.println(h6+"0"); }
                    else
                    { guardar.println(h6+jTextField_HABER_6.getText()); }
                    if ("".equals(jTextField_HABER_7.getText()))
                    { guardar.println(h7+"0"); }
                    else
                    { guardar.println(h7+jTextField_HABER_7.getText()); }
                    if ("".equals(jTextField_HABER_8.getText()))
                    { guardar.println(h8+"0"); }
                    else
                    { guardar.println(h8+jTextField_HABER_8.getText()); }
                    if ("".equals(jTextField_HABER_9.getText()))
                    { guardar.println(h9+"0"); }
                    else
                    { guardar.println(h9+jTextField_HABER_9.getText()); }
                    if ("".equals(jTextField_HABER_10.getText()))
                    { guardar.println(h10+"0"); }
                    else
                    { guardar.println(h10+jTextField_HABER_10.getText()); }
                    if ("".equals(jTextField_HABER_11.getText()))
                    { guardar.println(h11+"0"); }
                    else
                    { guardar.println(h11+jTextField_HABER_11.getText()); }
                    if ("".equals(jTextField_HABER_12.getText()))
                    { guardar.println(h12+"0"); }
                    else
                    { guardar.println(h12+jTextField_HABER_12.getText()); }
                    if ("".equals(jTextField_HABER_13.getText()))
                    { guardar.println(h13+"0"); }
                    else
                    { guardar.println(h13+jTextField_HABER_13.getText()); }
                    if ("".equals(jTextField_HABER_14.getText()))
                    { guardar.println(h14+"0"); }
                    else
                    { guardar.println(h14+jTextField_HABER_14.getText()); }
                    if ("".equals(jTextField_HABER_15.getText()))
                    { guardar.println(h15+"0"); }
                    else
                    { guardar.println(h15+jTextField_HABER_15.getText()); }
                    if ("".equals(jTextField_HABER_16.getText()))
                    { guardar.println(h16+"0"); }
                    else
                    { guardar.println(h16+jTextField_HABER_16.getText()); }
                    if ("".equals(jTextField_HABER_17.getText()))
                    { guardar.println(h17+"0"); }
                    else
                    { guardar.println(h17+jTextField_HABER_17.getText()); }
                    if ("".equals(jTextField_HABER_18.getText()))
                    { guardar.println(h18+"0"); }
                    else
                    { guardar.println(h18+jTextField_HABER_18.getText()); }
                    if ("".equals(jTextField_HABER_19.getText()))
                    { guardar.println(h19+"0"); }
                    else
                    { guardar.println(h19+jTextField_HABER_19.getText()); }
                    guardar.println(h_TOT+jTextField_HABER_TOT.getText());
                    guardar.println(fo_nomb+nombrefoto);
                }
                JOptionPane.showMessageDialog(rootPane, "Editado con éxito.");
                MostrarInterfaz();
                MostrarDatos();
            } catch (HeadlessException | IOException e) 
            {
            }
        }
    }
    
    private void FECHASNAC ()
    {
        for(int f=1900;f<=2050;f++) {
            jComboBoxYEAR_NAC.addItem(String.valueOf(f));
        }
        for(int f=1;f<=12;f++) {
            if (f < 10){
                jComboBoxMES_NAC.addItem("0"+String.valueOf(f));
            }else
            {
                jComboBoxMES_NAC.addItem(String.valueOf(f));
            }
        }
        for(int f=1;f<=31;f++) {
            if (f < 10){
                jComboBoxDIA_NAC.addItem("0"+String.valueOf(f));
            }else
            {
            jComboBoxDIA_NAC.addItem(String.valueOf(f));}
        }
        
    }
    
    private void DEBE_A_FAVOR()
    {
        String pre1 = jTextField_PRECIO_1.getText();
        String pre2 = jTextField_PRECIO_2.getText();
        String pre3 = jTextField_PRECIO_3.getText();
        String pre4 = jTextField_PRECIO_4.getText();
        String pre5 = jTextField_PRECIO_5.getText();
        String pre6 = jTextField_PRECIO_6.getText();
        String pre7 = jTextField_PRECIO_7.getText();
        String pre8 = jTextField_PRECIO_8.getText();
        String pre9 = jTextField_PRECIO_9.getText();
        String pre10 = jTextField_PRECIO_10.getText();
        String pre11 = jTextField_PRECIO_11.getText();
        String pre12 = jTextField_PRECIO_12.getText();
        String pre13 = jTextField_PRECIO_13.getText();
        String pre14 = jTextField_PRECIO_14.getText();
        String pre15 = jTextField_PRECIO_15.getText();
        String pre16 = jTextField_PRECIO_16.getText();
        String pre17 = jTextField_PRECIO_17.getText();
        String pre18 = jTextField_PRECIO_18.getText();
        String pre19 = jTextField_PRECIO_19.getText();
        
        int pre_1 = Integer.parseInt(pre1);
        int pre_2 = Integer.parseInt(pre2);
        int pre_3 = Integer.parseInt(pre3);
        int pre_4 = Integer.parseInt(pre4);
        int pre_5 = Integer.parseInt(pre5);
        int pre_6 = Integer.parseInt(pre6);
        int pre_7 = Integer.parseInt(pre7);
        int pre_8 = Integer.parseInt(pre8);
        int pre_9 = Integer.parseInt(pre9);
        int pre_10 = Integer.parseInt(pre10);
        int pre_11 = Integer.parseInt(pre11);
        int pre_12 = Integer.parseInt(pre12);
        int pre_13 = Integer.parseInt(pre13);
        int pre_14 = Integer.parseInt(pre14);
        int pre_15 = Integer.parseInt(pre15);
        int pre_16 = Integer.parseInt(pre16);
        int pre_17 = Integer.parseInt(pre17);
        int pre_18 = Integer.parseInt(pre18);
        int pre_19 = Integer.parseInt(pre19);
        
        int pre_total = pre_1+pre_2+pre_3+pre_4+pre_5+pre_6+pre_7+pre_8+pre_9+pre_10+pre_11+pre_12+pre_13+pre_14+pre_15+pre_16
                        +pre_17+pre_18+pre_19;
        
        String hab = jTextField_HABER_TOT.getText();
        int hab_1 = Integer.parseInt(hab);
        int totaliz = pre_total - hab_1;
        if((totaliz) > 0)
        {   
            String hab_deb = String.valueOf(totaliz);
            jTextFieldA_PAGAR.setText(hab_deb);
            jTextFieldA_FAVOR.setText("0");
        }else
        {
            jTextFieldA_PAGAR.setText("0");
            totaliz = totaliz * (-1);
            String deb_hab = String.valueOf(totaliz);
            jTextFieldA_FAVOR.setText(deb_hab);
        }
    }
    
    public void Error_Garrafal(KeyEvent evt)
    {       
            char c=evt.getKeyChar();                   
          if((Character.isLetter(c))||((c!='0')&&(c!='1')&&(c!='2')&&(c!='3')&&(c!='4')
                &&(c!='5')&&(c!='6')&&(c!='7')&&(c!='8')&&(c!='9')&&(c!=KeyEvent.VK_BACK_SPACE)&&(c!=KeyEvent.VK_DELETE)))
          {
              getToolkit().beep();            
              evt.consume();             
              JOptionPane.showMessageDialog(null, "Ingresa solo Números!");             
          } 
    }
    
    public void Error_Garrafal_2(KeyEvent evt)
    {
            char c=evt.getKeyChar();           
          if((!(Character.isLetterOrDigit(c)))&&((c!='/')&&(c!='.')&&(c!='-')&&(c!='+')&&(c!=KeyEvent.VK_BACK_SPACE)&&(c!='*')&&(c!=KeyEvent.VK_DELETE)))
          {
            getToolkit().beep();             
            evt.consume();  
            JOptionPane.showMessageDialog(null, "   Letras, Números y los siguientes\n"
                    + " caracteres especiales estan permitidos:\n "
                    + "                    /  -  .  +  *");   
          }     
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPaneDIADE = new javax.swing.JScrollPane();
        jTableDIADE = new javax.swing.JTable();
        jScrollPaneCUMPLES = new javax.swing.JScrollPane();
        jTableCUMPLES = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1CLIENTES_MOSTRAR = new javax.swing.JScrollPane();
        jTable1_Cilentes_Mostrar = new javax.swing.JTable();
        jfiltobusqueda = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButtonELIMINAR = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPaneOPCIONESCLIENTE = new javax.swing.JTabbedPane();
        jPanelINFOPERS = new javax.swing.JPanel();
        jComboBoxPROFESION_SEL = new javax.swing.JComboBox<>();
        jTextFieldTRAB_LUGAR_INTRO = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldCORREO_INTRO = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jComboBoxDIA_NAC = new javax.swing.JComboBox<>();
        jComboBoxMES_NAC = new javax.swing.JComboBox<>();
        jComboBoxYEAR_NAC = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldCEL_INTRO = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldT_FIJO_INTRO = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldDOMIC_INTRO = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextFieldNyA_INTRO = new javax.swing.JTextField();
        jLabelNyA_INFPERS = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        fotocliente = new javax.swing.JScrollPane();
        jLabel78 = new javax.swing.JLabel();
        jLabelFONDOINFPERS = new javax.swing.JLabel();
        jTextField25 = new javax.swing.JTextField();
        jPanelANTECEDE = new javax.swing.JPanel();
        jComboBoxINTQUIRU_INTRO = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jTextFieldTEMPERAMENTO_INTRO = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextFieldANT_HOR_INTRO = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jTextFieldTENSION_INTRO = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jTextFieldTRAT_DIET_INTRO = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jComboBoxPARTOS = new javax.swing.JComboBox<>();
        jTextFieldDERIV_DOC = new javax.swing.JTextField();
        jbtcigarro = new javax.swing.JComboBox<>();
        jbtalcohol = new javax.swing.JComboBox<>();
        jbtdiabetes = new javax.swing.JComboBox<>();
        jbtalergia = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanelSEMIOCUT = new javax.swing.JPanel();
        jComboBoxBT_LOC_FRENTE = new javax.swing.JComboBox<>();
        jComboBoxBT_LOC_PERIBU = new javax.swing.JComboBox<>();
        jComboBoxBT_LOCA_PREAURI = new javax.swing.JComboBox<>();
        jComboBoxBT_LOCA_NASO = new javax.swing.JComboBox<>();
        jComboBoxBT_LOCA_PARP = new javax.swing.JComboBox<>();
        jComboBoxBT_CARA = new javax.swing.JComboBox<>();
        jComboBoxBT_BOZO = new javax.swing.JComboBox<>();
        jComboBoxBT_SEDEP = new javax.swing.JComboBox<>();
        jComboBoxBT_HIPER = new javax.swing.JComboBox<>();
        jComboBoxBT_HIRSU = new javax.swing.JComboBox<>();
        jComboBoxBT_MENTO = new javax.swing.JComboBox<>();
        jComboBoxBT_MALAR = new javax.swing.JComboBox<>();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jComboBoxBT_CUE_TON = new javax.swing.JComboBox<>();
        jComboBoxBT_CUE_FLA = new javax.swing.JComboBox<>();
        jComboBoxBT_CUE_DASOL = new javax.swing.JComboBox<>();
        jLabel36 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jTextFieldBT_PLIYARR = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jTextFieldBT_LOCAL_CICA = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jTextFieldBT_CICAT = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jTextFieldBT_LESION = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jTextFieldBT_LOCAL_PIG = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jTextFieldBT_PIGMEN = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jTextFieldBT_COLOR = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jComboBoxBT_TEXT = new javax.swing.JComboBox<>();
        jLabel46 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jComboBoxBIOT_ALIPICO = new javax.swing.JComboBox<>();
        jComboBoxBIOT_DESHI = new javax.swing.JComboBox<>();
        jComboBoxBIOT_XERO = new javax.swing.JComboBox<>();
        jComboBoxBIOT_SENSIBLE = new javax.swing.JComboBox<>();
        jComboBoxBIOT_FLUENtE = new javax.swing.JComboBox<>();
        jComboBoxBIOT_NORMAL = new javax.swing.JComboBox<>();
        jLabel98 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jPanelSEMIOCUT_MAS = new javax.swing.JPanel();
        jComboBoxCC_SECO = new javax.swing.JComboBox<>();
        jComboBoxCC_ERIT = new javax.swing.JComboBox<>();
        jComboBoxCC_ALO = new javax.swing.JComboBox<>();
        jComboBoxCC_ONI = new javax.swing.JComboBox<>();
        jComboBoxCC_GRAS = new javax.swing.JComboBox<>();
        jComboBoxCC_LESI = new javax.swing.JComboBox<>();
        jComboBoxCC_TIPO = new javax.swing.JComboBox<>();
        jComboBoxCC_PRUR = new javax.swing.JComboBox<>();
        jComboBoxCC_EXCO = new javax.swing.JComboBox<>();
        jComboBoxCC_ANTECE = new javax.swing.JComboBox<>();
        jComboBoxCC_DESCA = new javax.swing.JComboBox<>();
        jComboBoxCC_PITI = new javax.swing.JComboBox<>();
        jComboBoxCC_UNIA = new javax.swing.JComboBox<>();
        jLabel56 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel65 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel71 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel73 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel74 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel75 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel76 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel77 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jLabel79 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jLabel80 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel81 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel82 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        jLabelFONDOSEMMAS = new javax.swing.JLabel();
        jPanelMEDIDAS = new javax.swing.JPanel();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jTextField18 = new javax.swing.JTextField();
        jTextField19 = new javax.swing.JTextField();
        jTextField20 = new javax.swing.JTextField();
        jTextField21 = new javax.swing.JTextField();
        jTextField22 = new javax.swing.JTextField();
        jLabel106 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        jTextField23 = new javax.swing.JTextField();
        jTextField24 = new javax.swing.JTextField();
        jLabel109 = new javax.swing.JLabel();
        jLabelFONDOMEDIDAS = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jTextField_HABER_1 = new javax.swing.JTextField();
        jTextField_TRAT_1 = new javax.swing.JTextField();
        jTextField_DEBE_1 = new javax.swing.JTextField();
        jTextField_PRECIO_1 = new javax.swing.JTextField();
        jTextField_TRAT_6 = new javax.swing.JTextField();
        jTextField_DEBE_6 = new javax.swing.JTextField();
        jTextField_PRECIO_6 = new javax.swing.JTextField();
        jTextField_HABER_6 = new javax.swing.JTextField();
        jTextField_TRAT_7 = new javax.swing.JTextField();
        jTextField_DEBE_7 = new javax.swing.JTextField();
        jTextField_PRECIO_7 = new javax.swing.JTextField();
        jTextField_HABER_7 = new javax.swing.JTextField();
        jTextField_TRAT_8 = new javax.swing.JTextField();
        jTextField_DEBE_8 = new javax.swing.JTextField();
        jTextField_PRECIO_8 = new javax.swing.JTextField();
        jTextField_HABER_8 = new javax.swing.JTextField();
        jTextField_TRAT_9 = new javax.swing.JTextField();
        jTextField_DEBE_9 = new javax.swing.JTextField();
        jTextField_PRECIO_9 = new javax.swing.JTextField();
        jTextField_HABER_9 = new javax.swing.JTextField();
        jTextField_TRAT_10 = new javax.swing.JTextField();
        jTextField_DEBE_10 = new javax.swing.JTextField();
        jTextField_PRECIO_10 = new javax.swing.JTextField();
        jTextField_HABER_10 = new javax.swing.JTextField();
        jTextField_TRAT_11 = new javax.swing.JTextField();
        jTextField_DEBE_11 = new javax.swing.JTextField();
        jTextField_PRECIO_11 = new javax.swing.JTextField();
        jTextField_HABER_11 = new javax.swing.JTextField();
        jTextField_TRAT_12 = new javax.swing.JTextField();
        jTextField_DEBE_12 = new javax.swing.JTextField();
        jTextField_PRECIO_12 = new javax.swing.JTextField();
        jTextField_HABER_12 = new javax.swing.JTextField();
        jTextField_TRAT_13 = new javax.swing.JTextField();
        jTextField_DEBE_13 = new javax.swing.JTextField();
        jTextField_PRECIO_13 = new javax.swing.JTextField();
        jTextField_HABER_13 = new javax.swing.JTextField();
        jTextField_TRAT_14 = new javax.swing.JTextField();
        jTextField_DEBE_14 = new javax.swing.JTextField();
        jTextField_PRECIO_14 = new javax.swing.JTextField();
        jTextField_HABER_14 = new javax.swing.JTextField();
        jTextField_TRAT_15 = new javax.swing.JTextField();
        jTextField_DEBE_15 = new javax.swing.JTextField();
        jTextField_PRECIO_15 = new javax.swing.JTextField();
        jTextField_HABER_15 = new javax.swing.JTextField();
        jTextField_TRAT_16 = new javax.swing.JTextField();
        jTextField_DEBE_16 = new javax.swing.JTextField();
        jTextField_PRECIO_16 = new javax.swing.JTextField();
        jTextField_HABER_16 = new javax.swing.JTextField();
        jTextField_TRAT_17 = new javax.swing.JTextField();
        jTextField_DEBE_17 = new javax.swing.JTextField();
        jTextField_PRECIO_17 = new javax.swing.JTextField();
        jTextField_HABER_17 = new javax.swing.JTextField();
        jTextField_DEBE_TOT = new javax.swing.JTextField();
        jTextField_HABER_TOT = new javax.swing.JTextField();
        jTextField_TRAT_19 = new javax.swing.JTextField();
        jTextField_PRECIO_19 = new javax.swing.JTextField();
        jTextField_DEBE_19 = new javax.swing.JTextField();
        jTextField_HABER_19 = new javax.swing.JTextField();
        jTextField_TRAT_18 = new javax.swing.JTextField();
        jTextField_DEBE_18 = new javax.swing.JTextField();
        jTextField_PRECIO_18 = new javax.swing.JTextField();
        jTextField_HABER_18 = new javax.swing.JTextField();
        jTextField_TRAT_5 = new javax.swing.JTextField();
        jTextField_DEBE_5 = new javax.swing.JTextField();
        jTextField_PRECIO_5 = new javax.swing.JTextField();
        jTextField_HABER_5 = new javax.swing.JTextField();
        jTextField_TRAT_4 = new javax.swing.JTextField();
        jTextField_PRECIO_4 = new javax.swing.JTextField();
        jTextField_DEBE_4 = new javax.swing.JTextField();
        jTextField_HABER_4 = new javax.swing.JTextField();
        jTextField_TRAT_3 = new javax.swing.JTextField();
        jTextField_PRECIO_3 = new javax.swing.JTextField();
        jTextField_DEBE_3 = new javax.swing.JTextField();
        jTextField_HABER_3 = new javax.swing.JTextField();
        jTextField_TRAT_2 = new javax.swing.JTextField();
        jTextField_PRECIO_2 = new javax.swing.JTextField();
        jTextField_DEBE_2 = new javax.swing.JTextField();
        jTextField_HABER_2 = new javax.swing.JTextField();
        jTextFieldNOMBRE = new javax.swing.JTextField();
        jLabel116 = new javax.swing.JLabel();
        jTextFieldA_PAGAR = new javax.swing.JTextField();
        jTextFieldA_FAVOR = new javax.swing.JTextField();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setResizable(false);
        setSize(new java.awt.Dimension(1100, 688));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBackground(new java.awt.Color(255, 0, 0));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(1100, 688));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableDIADE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPaneDIADE.setViewportView(jTableDIADE);

        jPanel1.add(jScrollPaneDIADE, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 60, 420, 460));

        jTableCUMPLES.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTableCUMPLES.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableCUMPLES.setSelectionBackground(new java.awt.Color(0, 125, 0));
        jTableCUMPLES.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableCUMPLES.getTableHeader().setReorderingAllowed(false);
        jScrollPaneCUMPLES.setViewportView(jTableCUMPLES);

        jPanel1.add(jScrollPaneCUMPLES, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 540, 270));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Hoy es el día de :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 30, -1, 25));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/vc400x400.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, -1, -1));

        jButton1.setBackground(new java.awt.Color(0, 102, 0));
        jButton1.setFont(new java.awt.Font("Consolas", 1, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Atras");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 620, 125, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Hoy cumplen años :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, -1, 25));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1100x688-green-wallpaper-hd.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jTabbedPane1.addTab("Cumpleaños y Día", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1CLIENTES_MOSTRAR.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1CLIENTES_MOSTRAR.setToolTipText("");

        jTable1_Cilentes_Mostrar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable1_Cilentes_Mostrar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable1_Cilentes_Mostrar.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1_Cilentes_Mostrar.setAutoscrolls(false);
        jTable1_Cilentes_Mostrar.setGridColor(new java.awt.Color(0, 0, 0));
        jTable1_Cilentes_Mostrar.setName(""); // NOI18N
        jTable1_Cilentes_Mostrar.setSelectionBackground(new java.awt.Color(0, 153, 0));
        jTable1_Cilentes_Mostrar.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1_Cilentes_Mostrar.getTableHeader().setReorderingAllowed(false);
        jTable1_Cilentes_Mostrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1_Cilentes_MostrarMouseClicked(evt);
            }
        });
        jTable1_Cilentes_Mostrar.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jTable1_Cilentes_MostrarInputMethodTextChanged(evt);
            }
        });
        jScrollPane1CLIENTES_MOSTRAR.setViewportView(jTable1_Cilentes_Mostrar);

        jPanel2.add(jScrollPane1CLIENTES_MOSTRAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 1070, 550));

        jfiltobusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jfiltobusquedaKeyTyped(evt);
            }
        });
        jPanel2.add(jfiltobusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 300, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Buscar :");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 125, 30));

        jButtonELIMINAR.setBackground(new java.awt.Color(255, 51, 0));
        jButtonELIMINAR.setFont(new java.awt.Font("Consolas", 1, 11)); // NOI18N
        jButtonELIMINAR.setForeground(new java.awt.Color(255, 255, 255));
        jButtonELIMINAR.setText("Eliminar");
        jButtonELIMINAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonELIMINARActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonELIMINAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 20, 125, 30));

        jButton2.setBackground(new java.awt.Color(0, 102, 0));
        jButton2.setFont(new java.awt.Font("Consolas", 1, 11)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Atras");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 620, 125, 30));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1100x688-green-wallpaper-hd.jpg"))); // NOI18N
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 1100, 750));

        jTabbedPane1.addTab("Resumen Clientes", jPanel2);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPaneOPCIONESCLIENTE.setBackground(new java.awt.Color(255, 255, 255));

        jPanelINFOPERS.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBoxPROFESION_SEL.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ND", "Actor/Actriz", "Fonoaudiologa/o", "Periodista", "Bioquimica/o", "Ingeniera/o", "Locutor/a", "Abogada/o", "Secretaria/o", "Maestra/o", "Profesor/a", "Fotografa/o", "Cosmetologa/o", "Odontologa/o", "Farmaceutioca/o", "Psicologa/o", "Contador/a" }));
        jPanelINFOPERS.add(jComboBoxPROFESION_SEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, 150, 30));
        jPanelINFOPERS.add(jTextFieldTRAB_LUGAR_INTRO, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 320, 150, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Lugar :");
        jPanelINFOPERS.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 320, 125, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Profesión :");
        jPanelINFOPERS.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 125, 30));

        jTextFieldCORREO_INTRO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCORREO_INTROActionPerformed(evt);
            }
        });
        jPanelINFOPERS.add(jTextFieldCORREO_INTRO, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 300, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Correo Electrónico : ");
        jPanelINFOPERS.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 125, 30));

        jPanelINFOPERS.add(jComboBoxDIA_NAC, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 50, 25));

        jPanelINFOPERS.add(jComboBoxMES_NAC, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, 50, 25));

        jComboBoxYEAR_NAC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxYEAR_NACActionPerformed(evt);
            }
        });
        jPanelINFOPERS.add(jComboBoxYEAR_NAC, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, 70, 25));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Fecha de Nacimiento :");
        jPanelINFOPERS.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 125, 25));

        jTextFieldCEL_INTRO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCEL_INTROActionPerformed(evt);
            }
        });
        jPanelINFOPERS.add(jTextFieldCEL_INTRO, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 300, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Celular :");
        jPanelINFOPERS.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 120, 30));
        jPanelINFOPERS.add(jTextFieldT_FIJO_INTRO, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 300, 30));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Teléfono Fijo :");
        jPanelINFOPERS.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 120, 30));

        jTextFieldDOMIC_INTRO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDOMIC_INTROActionPerformed(evt);
            }
        });
        jPanelINFOPERS.add(jTextFieldDOMIC_INTRO, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 300, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Domicilio :");
        jPanelINFOPERS.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 120, 30));

        jTextFieldNyA_INTRO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNyA_INTROActionPerformed(evt);
            }
        });
        jPanelINFOPERS.add(jTextFieldNyA_INTRO, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 300, 30));

        jLabelNyA_INFPERS.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelNyA_INFPERS.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNyA_INFPERS.setText("Nombre y Apellido : ");
        jPanelINFOPERS.add(jLabelNyA_INFPERS, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 120, 30));

        jButton3.setBackground(new java.awt.Color(0, 102, 0));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Agregar Foto");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanelINFOPERS.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 330, -1, -1));

        fotocliente.setMaximumSize(new java.awt.Dimension(300, 300));
        fotocliente.setViewportView(jLabel78);

        jPanelINFOPERS.add(fotocliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 30, 290, 280));

        jLabelFONDOINFPERS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/orig_1050x650.jpg"))); // NOI18N
        jPanelINFOPERS.add(jLabelFONDOINFPERS, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jTextField25.setText("jTextField25");
        jPanelINFOPERS.add(jTextField25, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 400, -1, -1));

        jTabbedPaneOPCIONESCLIENTE.addTab("Información Personal", jPanelINFOPERS);

        jPanelANTECEDE.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBoxINTQUIRU_INTRO.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        jPanelANTECEDE.add(jComboBoxINTQUIRU_INTRO, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 350, -1, 25));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Intervenciones Quirúrgicas :");
        jPanelANTECEDE.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 160, 25));
        jPanelANTECEDE.add(jTextFieldTEMPERAMENTO_INTRO, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, 300, 25));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Temperamento :");
        jPanelANTECEDE.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 125, 25));
        jPanelANTECEDE.add(jTextFieldANT_HOR_INTRO, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 300, 25));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Antecedentes Hormonales : ");
        jPanelANTECEDE.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 160, 25));

        jTextFieldTENSION_INTRO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTENSION_INTROActionPerformed(evt);
            }
        });
        jPanelANTECEDE.add(jTextFieldTENSION_INTRO, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 300, 25));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Tensión Arterial : ");
        jPanelANTECEDE.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 125, 25));
        jPanelANTECEDE.add(jTextFieldTRAT_DIET_INTRO, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 300, 25));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Tratamientos Dietéticos :");
        jPanelANTECEDE.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 150, 25));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Cantidad de Partos :");
        jPanelANTECEDE.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 125, 25));

        jComboBoxPARTOS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        jComboBoxPARTOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPARTOSActionPerformed(evt);
            }
        });
        jPanelANTECEDE.add(jComboBoxPARTOS, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, 60, 25));

        jTextFieldDERIV_DOC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDERIV_DOCActionPerformed(evt);
            }
        });
        jPanelANTECEDE.add(jTextFieldDERIV_DOC, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 300, 25));

        jbtcigarro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "SI" }));
        jPanelANTECEDE.add(jbtcigarro, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 390, -1, 25));

        jbtalcohol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "SI" }));
        jPanelANTECEDE.add(jbtalcohol, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 430, -1, 25));

        jbtdiabetes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "SI" }));
        jPanelANTECEDE.add(jbtdiabetes, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, -1, 25));

        jbtalergia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "SI" }));
        jPanelANTECEDE.add(jbtalergia, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, -1, 25));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Derivado/a por el Dr :");
        jPanelANTECEDE.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 125, 25));

        jLabel88.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(255, 255, 255));
        jLabel88.setText("Alérgico/a :");
        jPanelANTECEDE.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, 25));

        jLabel89.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel89.setForeground(new java.awt.Color(255, 255, 255));
        jLabel89.setText("Diabético/a :");
        jPanelANTECEDE.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 25));

        jLabel90.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel90.setForeground(new java.awt.Color(255, 255, 255));
        jLabel90.setText("Tabaco :");
        jPanelANTECEDE.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, -1, 25));

        jLabel91.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel91.setForeground(new java.awt.Color(255, 255, 255));
        jLabel91.setText("Alcohol :");
        jPanelANTECEDE.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, -1, 25));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/orig_1050x650.jpg"))); // NOI18N
        jPanelANTECEDE.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 590));

        jTabbedPaneOPCIONESCLIENTE.addTab("Antecedentes", jPanelANTECEDE);

        jPanelSEMIOCUT.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBoxBT_LOC_FRENTE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "SI" }));
        jComboBoxBT_LOC_FRENTE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxBT_LOC_FRENTEActionPerformed(evt);
            }
        });
        jPanelSEMIOCUT.add(jComboBoxBT_LOC_FRENTE, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 210, -1, 25));

        jComboBoxBT_LOC_PERIBU.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "SI" }));
        jComboBoxBT_LOC_PERIBU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxBT_LOC_PERIBUActionPerformed(evt);
            }
        });
        jPanelSEMIOCUT.add(jComboBoxBT_LOC_PERIBU, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 180, -1, 25));

        jComboBoxBT_LOCA_PREAURI.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "SI" }));
        jPanelSEMIOCUT.add(jComboBoxBT_LOCA_PREAURI, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 240, -1, 25));

        jComboBoxBT_LOCA_NASO.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "SI" }));
        jPanelSEMIOCUT.add(jComboBoxBT_LOCA_NASO, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 210, -1, 25));

        jComboBoxBT_LOCA_PARP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "SI" }));
        jPanelSEMIOCUT.add(jComboBoxBT_LOCA_PARP, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 180, -1, 25));

        jComboBoxBT_CARA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "SI" }));
        jPanelSEMIOCUT.add(jComboBoxBT_CARA, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 360, -1, 25));

        jComboBoxBT_BOZO.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "SI" }));
        jPanelSEMIOCUT.add(jComboBoxBT_BOZO, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 390, -1, 25));

        jComboBoxBT_SEDEP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "SI" }));
        jPanelSEMIOCUT.add(jComboBoxBT_SEDEP, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 420, -1, 25));

        jComboBoxBT_HIPER.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "SI" }));
        jPanelSEMIOCUT.add(jComboBoxBT_HIPER, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 450, -1, 25));

        jComboBoxBT_HIRSU.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "SI" }));
        jPanelSEMIOCUT.add(jComboBoxBT_HIRSU, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 420, -1, 25));

        jComboBoxBT_MENTO.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "SI" }));
        jPanelSEMIOCUT.add(jComboBoxBT_MENTO, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 390, -1, 25));

        jComboBoxBT_MALAR.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "SI" }));
        jPanelSEMIOCUT.add(jComboBoxBT_MALAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 360, -1, 25));

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Hirsutamo :");
        jPanelSEMIOCUT.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 420, -1, 25));

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Hipertricosis :");
        jPanelSEMIOCUT.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 450, -1, 25));

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Cara :");
        jPanelSEMIOCUT.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 360, -1, 25));

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Vello :");
        jPanelSEMIOCUT.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 340, -1, 25));

        jComboBoxBT_CUE_TON.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "SI" }));
        jPanelSEMIOCUT.add(jComboBoxBT_CUE_TON, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 280, -1, 25));

        jComboBoxBT_CUE_FLA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "SI" }));
        jPanelSEMIOCUT.add(jComboBoxBT_CUE_FLA, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 310, -1, 25));

        jComboBoxBT_CUE_DASOL.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "SI" }));
        jPanelSEMIOCUT.add(jComboBoxBT_CUE_DASOL, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 280, -1, 25));

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Se depila :");
        jPanelSEMIOCUT.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 420, -1, 25));

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Bozo :");
        jPanelSEMIOCUT.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 390, -1, 25));

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Malar :");
        jPanelSEMIOCUT.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 360, -1, 25));

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Mentoniano :");
        jPanelSEMIOCUT.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 390, -1, 25));

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Daño Solar :");
        jPanelSEMIOCUT.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 280, 70, 25));

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Flacidez :");
        jPanelSEMIOCUT.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 310, 70, 25));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Tonicidad :");
        jPanelSEMIOCUT.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 280, 70, 25));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Cuello :");
        jPanelSEMIOCUT.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 260, -1, 25));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Localizaciòn :");
        jPanelSEMIOCUT.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 150, -1, 25));
        jPanelSEMIOCUT.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 100, 150, 25));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Inducidas por el sol :");
        jPanelSEMIOCUT.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 100, -1, 25));
        jPanelSEMIOCUT.add(jTextFieldBT_PLIYARR, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 60, 400, 25));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("De acuerdo al biotipo :");
        jPanelSEMIOCUT.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, -1, 25));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Pliegues y Arrugas :");
        jPanelSEMIOCUT.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, -1, 25));
        jPanelSEMIOCUT.add(jTextFieldBT_LOCAL_CICA, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 430, 180, 25));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Localizaciòn :");
        jPanelSEMIOCUT.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, -1, 25));
        jPanelSEMIOCUT.add(jTextFieldBT_CICAT, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 390, 180, 25));

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("Cicatrices :");
        jPanelSEMIOCUT.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, -1, 25));

        jTextFieldBT_LESION.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldBT_LESIONActionPerformed(evt);
            }
        });
        jPanelSEMIOCUT.add(jTextFieldBT_LESION, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 470, 180, 25));

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Lesiones :");
        jPanelSEMIOCUT.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, -1, 25));
        jPanelSEMIOCUT.add(jTextFieldBT_LOCAL_PIG, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, 180, 25));

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("Localizaciòn :");
        jPanelSEMIOCUT.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, 25));
        jPanelSEMIOCUT.add(jTextFieldBT_PIGMEN, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 180, 25));

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("Pigmentos :");
        jPanelSEMIOCUT.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 70, 25));
        jPanelSEMIOCUT.add(jTextFieldBT_COLOR, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 180, 25));

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("Color :");
        jPanelSEMIOCUT.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 50, 25));

        jComboBoxBT_TEXT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Untuosa", "Aspera", "Turgencia", "Lisa", "Rugosa" }));
        jComboBoxBT_TEXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxBT_TEXTActionPerformed(evt);
            }
        });
        jPanelSEMIOCUT.add(jComboBoxBT_TEXT, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, -1, 25));

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("Textura :");
        jPanelSEMIOCUT.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 125, 25));

        jLabel83.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(255, 255, 255));
        jLabel83.setText("Sensible :");
        jPanelSEMIOCUT.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 60, 25));

        jComboBoxBIOT_ALIPICO.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "SI" }));
        jPanelSEMIOCUT.add(jComboBoxBIOT_ALIPICO, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, 60, 25));

        jComboBoxBIOT_DESHI.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "SI" }));
        jPanelSEMIOCUT.add(jComboBoxBIOT_DESHI, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, 60, 25));

        jComboBoxBIOT_XERO.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "SI" }));
        jPanelSEMIOCUT.add(jComboBoxBIOT_XERO, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 60, 25));

        jComboBoxBIOT_SENSIBLE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "SI" }));
        jPanelSEMIOCUT.add(jComboBoxBIOT_SENSIBLE, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 60, 25));

        jComboBoxBIOT_FLUENtE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "SI" }));
        jPanelSEMIOCUT.add(jComboBoxBIOT_FLUENtE, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 60, 25));

        jComboBoxBIOT_NORMAL.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "SI" }));
        jPanelSEMIOCUT.add(jComboBoxBIOT_NORMAL, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 60, 25));

        jLabel98.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel98.setForeground(new java.awt.Color(255, 255, 255));
        jLabel98.setText("Nasogeniano :");
        jPanelSEMIOCUT.add(jLabel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 210, -1, 25));

        jLabel101.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel101.setForeground(new java.awt.Color(255, 255, 255));
        jLabel101.setText("Frente :");
        jPanelSEMIOCUT.add(jLabel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 210, -1, 25));

        jLabel100.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel100.setForeground(new java.awt.Color(255, 255, 255));
        jLabel100.setText("Peribucales :");
        jPanelSEMIOCUT.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 180, -1, 25));

        jLabel97.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel97.setForeground(new java.awt.Color(255, 255, 255));
        jLabel97.setText("Pàrpados : ");
        jPanelSEMIOCUT.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 180, -1, 25));

        jLabel94.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel94.setForeground(new java.awt.Color(255, 255, 255));
        jLabel94.setText("Seco Alipico :");
        jPanelSEMIOCUT.add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, -1, 25));

        jLabel99.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel99.setForeground(new java.awt.Color(255, 255, 255));
        jLabel99.setText("Preauriculares :");
        jPanelSEMIOCUT.add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 240, -1, 25));

        jLabel93.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel93.setForeground(new java.awt.Color(255, 255, 255));
        jLabel93.setText("Fluente :");
        jPanelSEMIOCUT.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 60, 25));

        jLabel95.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel95.setForeground(new java.awt.Color(255, 255, 255));
        jLabel95.setText("Seco Deshidratado :");
        jPanelSEMIOCUT.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, -1, 25));

        jLabel92.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel92.setForeground(new java.awt.Color(255, 255, 255));
        jLabel92.setText("Normal :");
        jPanelSEMIOCUT.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 60, 25));

        jLabel96.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel96.setForeground(new java.awt.Color(255, 255, 255));
        jLabel96.setText("Xerodermico :");
        jPanelSEMIOCUT.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, -1, 25));

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("Biotipo cutáneo :");
        jPanelSEMIOCUT.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 125, 25));

        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/orig_1050x650.jpg"))); // NOI18N
        jPanelSEMIOCUT.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1050, 600));

        jTabbedPaneOPCIONESCLIENTE.addTab("Semiología Cutanea", jPanelSEMIOCUT);

        jPanelSEMIOCUT_MAS.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBoxCC_SECO.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "SI" }));
        jPanelSEMIOCUT_MAS.add(jComboBoxCC_SECO, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, -1, 25));

        jComboBoxCC_ERIT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "SI" }));
        jPanelSEMIOCUT_MAS.add(jComboBoxCC_ERIT, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, -1, 25));

        jComboBoxCC_ALO.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "SI" }));
        jPanelSEMIOCUT_MAS.add(jComboBoxCC_ALO, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, -1, 25));

        jComboBoxCC_ONI.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "SI" }));
        jPanelSEMIOCUT_MAS.add(jComboBoxCC_ONI, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, -1, 25));

        jComboBoxCC_GRAS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "SI" }));
        jPanelSEMIOCUT_MAS.add(jComboBoxCC_GRAS, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, -1, 25));

        jComboBoxCC_LESI.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "SI" }));
        jPanelSEMIOCUT_MAS.add(jComboBoxCC_LESI, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, -1, 25));

        jComboBoxCC_TIPO.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "SI" }));
        jPanelSEMIOCUT_MAS.add(jComboBoxCC_TIPO, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, -1, 25));

        jComboBoxCC_PRUR.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "SI" }));
        jPanelSEMIOCUT_MAS.add(jComboBoxCC_PRUR, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, -1, 25));

        jComboBoxCC_EXCO.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "SI" }));
        jPanelSEMIOCUT_MAS.add(jComboBoxCC_EXCO, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, -1, 25));

        jComboBoxCC_ANTECE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "SI" }));
        jPanelSEMIOCUT_MAS.add(jComboBoxCC_ANTECE, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, -1, 25));

        jComboBoxCC_DESCA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "SI" }));
        jPanelSEMIOCUT_MAS.add(jComboBoxCC_DESCA, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, -1, 25));

        jComboBoxCC_PITI.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "SI" }));
        jComboBoxCC_PITI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCC_PITIActionPerformed(evt);
            }
        });
        jPanelSEMIOCUT_MAS.add(jComboBoxCC_PITI, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, -1, 25));

        jComboBoxCC_UNIA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "SI" }));
        jPanelSEMIOCUT_MAS.add(jComboBoxCC_UNIA, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, -1, 25));

        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setText("Esquema corporal :");
        jPanelSEMIOCUT_MAS.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, 25));

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setText("Descamaciòn :");
        jPanelSEMIOCUT_MAS.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, -1, 25));

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("Pitiriasis :");
        jPanelSEMIOCUT_MAS.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, -1, 25));

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setText("Uñas :");
        jPanelSEMIOCUT_MAS.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, -1, 25));

        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("Onicopatias :");
        jPanelSEMIOCUT_MAS.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, -1, 25));

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("Prurito :");
        jPanelSEMIOCUT_MAS.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, -1, 25));

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("Excoriaciones :");
        jPanelSEMIOCUT_MAS.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, -1, 25));

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setText("Antecedentes :");
        jPanelSEMIOCUT_MAS.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, -1, 25));

        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setText("Lesiones : ");
        jPanelSEMIOCUT_MAS.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, -1, 25));

        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setText("Tipo :");
        jPanelSEMIOCUT_MAS.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, -1, 25));

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setText("Graso :");
        jPanelSEMIOCUT_MAS.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, -1, 25));

        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 255, 255));
        jLabel60.setText("Eritema :");
        jPanelSEMIOCUT_MAS.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, -1, 25));

        jLabel61.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(255, 255, 255));
        jLabel61.setText("Alopecias :");
        jPanelSEMIOCUT_MAS.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, -1, 25));

        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(255, 255, 255));
        jLabel62.setText("Seco :");
        jPanelSEMIOCUT_MAS.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, -1, 25));

        jLabel63.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(255, 255, 255));
        jLabel63.setText("Cuero Cabelludo :");
        jPanelSEMIOCUT_MAS.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, 25));

        jLabel64.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(255, 255, 255));
        jLabel64.setText("Celulitis :");
        jPanelSEMIOCUT_MAS.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, -1, 25));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "SI" }));
        jPanelSEMIOCUT_MAS.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, -1, 25));

        jLabel65.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(255, 255, 255));
        jLabel65.setText("Tipo :");
        jPanelSEMIOCUT_MAS.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 390, -1, 25));
        jPanelSEMIOCUT_MAS.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 390, 300, 25));

        jLabel66.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(255, 255, 255));
        jLabel66.setText("Localización :");
        jPanelSEMIOCUT_MAS.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 510, -1, 25));
        jPanelSEMIOCUT_MAS.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 510, 200, 25));

        jLabel67.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(255, 255, 255));
        jLabel67.setText("Localización :");
        jPanelSEMIOCUT_MAS.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 430, -1, 25));
        jPanelSEMIOCUT_MAS.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 430, 300, 25));

        jLabel68.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(255, 255, 255));
        jLabel68.setText("ACNÉ :");
        jPanelSEMIOCUT_MAS.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, -1, 25));

        jLabel69.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(255, 255, 255));
        jLabel69.setText("Tipo :");
        jPanelSEMIOCUT_MAS.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 50, -1, 25));
        jPanelSEMIOCUT_MAS.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 50, 300, 25));

        jLabel70.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(255, 255, 255));
        jLabel70.setText("Estrías :");
        jPanelSEMIOCUT_MAS.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 470, -1, 25));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "SI" }));
        jPanelSEMIOCUT_MAS.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 470, -1, 25));

        jLabel71.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(255, 255, 255));
        jLabel71.setText("Tiempo de Evolución :");
        jPanelSEMIOCUT_MAS.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 90, -1, 25));
        jPanelSEMIOCUT_MAS.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 90, 300, 25));

        jLabel72.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(255, 255, 255));
        jLabel72.setText("Antecedentes Hereditarios :");
        jPanelSEMIOCUT_MAS.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, -1, 25));
        jPanelSEMIOCUT_MAS.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 130, 300, 25));

        jLabel73.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(255, 255, 255));
        jLabel73.setText("Lesiones Elementales :");
        jPanelSEMIOCUT_MAS.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 170, -1, 25));
        jPanelSEMIOCUT_MAS.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 170, 300, 25));

        jLabel74.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(255, 255, 255));
        jLabel74.setText("Localización :");
        jPanelSEMIOCUT_MAS.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 210, -1, 25));
        jPanelSEMIOCUT_MAS.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 210, 300, 25));

        jLabel75.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(255, 255, 255));
        jLabel75.setText("ROSÁCEA tipo :");
        jPanelSEMIOCUT_MAS.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 250, -1, 25));
        jPanelSEMIOCUT_MAS.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 250, 300, 25));

        jLabel76.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(255, 255, 255));
        jLabel76.setText("Tiempo de evolución :");
        jPanelSEMIOCUT_MAS.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 290, -1, 25));
        jPanelSEMIOCUT_MAS.add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 290, 300, 25));

        jLabel77.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(255, 255, 255));
        jLabel77.setText("Localización :");
        jPanelSEMIOCUT_MAS.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 330, -1, 25));
        jPanelSEMIOCUT_MAS.add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 330, 300, 25));

        jLabel79.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(255, 255, 255));
        jLabel79.setText("Antecedentes Hereditarios :");
        jPanelSEMIOCUT_MAS.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 370, -1, 25));
        jPanelSEMIOCUT_MAS.add(jTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 370, 300, 25));

        jLabel80.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(255, 255, 255));
        jLabel80.setText("Piel Senil :");
        jPanelSEMIOCUT_MAS.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 410, -1, 25));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "SI" }));
        jPanelSEMIOCUT_MAS.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 410, -1, 25));

        jLabel81.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(255, 255, 255));
        jLabel81.setText("Queratosis Actinicas :");
        jPanelSEMIOCUT_MAS.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 410, -1, 25));

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "SI" }));
        jPanelSEMIOCUT_MAS.add(jComboBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 410, -1, 25));

        jLabel82.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(255, 255, 255));
        jLabel82.setText("Elastosis Solar :");
        jPanelSEMIOCUT_MAS.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 410, -1, 25));

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "SI" }));
        jPanelSEMIOCUT_MAS.add(jComboBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 410, -1, 25));

        jLabel84.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(255, 255, 255));
        jLabel84.setText("Otras Alteraciónes :");
        jPanelSEMIOCUT_MAS.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 450, -1, 25));

        jLabel85.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(255, 255, 255));
        jLabel85.setText("Involución segun la edad :");
        jPanelSEMIOCUT_MAS.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 480, -1, 25));

        jLabel86.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(255, 255, 255));
        jLabel86.setText("Tratamientos Dermatológicos :");
        jPanelSEMIOCUT_MAS.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 510, -1, 25));

        jLabel87.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(255, 255, 255));
        jLabel87.setText("Tratamientos Cosméticos :");
        jPanelSEMIOCUT_MAS.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 540, -1, 25));
        jPanelSEMIOCUT_MAS.add(jTextField14, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 450, 300, 25));
        jPanelSEMIOCUT_MAS.add(jTextField15, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 480, 300, 25));
        jPanelSEMIOCUT_MAS.add(jTextField16, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 510, 300, 25));
        jPanelSEMIOCUT_MAS.add(jTextField17, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 540, 300, 25));

        jLabelFONDOSEMMAS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/orig_1050x650.jpg"))); // NOI18N
        jPanelSEMIOCUT_MAS.add(jLabelFONDOSEMMAS, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 590));

        jTabbedPaneOPCIONESCLIENTE.addTab("...", jPanelSEMIOCUT_MAS);

        jPanelMEDIDAS.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel102.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel102.setForeground(new java.awt.Color(255, 255, 255));
        jLabel102.setText("Arriba Ombligo :");
        jPanelMEDIDAS.add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, 25));

        jLabel103.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel103.setForeground(new java.awt.Color(255, 255, 255));
        jLabel103.setText("Abajo Ombligo :");
        jPanelMEDIDAS.add(jLabel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, 25));

        jLabel104.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel104.setForeground(new java.awt.Color(255, 255, 255));
        jLabel104.setText("Brazo Derecho :");
        jPanelMEDIDAS.add(jLabel104, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, 25));

        jLabel105.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel105.setForeground(new java.awt.Color(255, 255, 255));
        jLabel105.setText("Brazo Izquierdo :");
        jPanelMEDIDAS.add(jLabel105, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, 25));
        jPanelMEDIDAS.add(jTextField18, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 300, 25));
        jPanelMEDIDAS.add(jTextField19, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 300, 25));
        jPanelMEDIDAS.add(jTextField20, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 300, 25));
        jPanelMEDIDAS.add(jTextField21, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 300, 25));
        jPanelMEDIDAS.add(jTextField22, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 300, 25));

        jLabel106.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel106.setForeground(new java.awt.Color(255, 255, 255));
        jLabel106.setText("Caderas :");
        jPanelMEDIDAS.add(jLabel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, 25));

        jLabel107.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel107.setForeground(new java.awt.Color(255, 255, 255));
        jLabel107.setText("Talla :");
        jPanelMEDIDAS.add(jLabel107, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, 25));

        jLabel108.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel108.setForeground(new java.awt.Color(255, 255, 255));
        jLabel108.setText("Peso :");
        jPanelMEDIDAS.add(jLabel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, 25));
        jPanelMEDIDAS.add(jTextField23, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 300, 25));
        jPanelMEDIDAS.add(jTextField24, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, 100, 25));

        jLabel109.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel109.setForeground(new java.awt.Color(255, 255, 255));
        jLabel109.setText("Kg.");
        jPanelMEDIDAS.add(jLabel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, -1, 25));

        jLabelFONDOMEDIDAS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/orig_1050x650.jpg"))); // NOI18N
        jPanelMEDIDAS.add(jLabelFONDOMEDIDAS, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 590));

        jTabbedPaneOPCIONESCLIENTE.addTab("Medidas", jPanelMEDIDAS);

        jPanel3.add(jTabbedPaneOPCIONESCLIENTE, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1050, 610));

        jButton5.setBackground(new java.awt.Color(0, 102, 0));
        jButton5.setFont(new java.awt.Font("Consolas", 1, 11)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Atras");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 620, 125, 30));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1100x688-green-wallpaper-hd.jpg"))); // NOI18N
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jButton4.setBackground(new java.awt.Color(0, 102, 102));
        jButton4.setFont(new java.awt.Font("Consolas", 1, 11)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Guardar");
        jButton4.setEnabled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(935, 620, 125, 30));

        jTabbedPane1.addTab("Editar Cliente", jPanel3);

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField_HABER_1.setBackground(new java.awt.Color(153, 255, 153));
        jTextField_HABER_1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField_HABER_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_HABER_1ActionPerformed(evt);
            }
        });
        jTextField_HABER_1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_HABER_1KeyTyped(evt);
            }
        });
        jPanel4.add(jTextField_HABER_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 40, 90, 25));

        jTextField_TRAT_1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_TRAT_1KeyTyped(evt);
            }
        });
        jPanel4.add(jTextField_TRAT_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 400, 25));

        jTextField_DEBE_1.setEditable(false);
        jTextField_DEBE_1.setBackground(new java.awt.Color(255, 153, 153));
        jTextField_DEBE_1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField_DEBE_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_DEBE_1ActionPerformed(evt);
            }
        });
        jPanel4.add(jTextField_DEBE_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 40, 90, 25));

        jTextField_PRECIO_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_PRECIO_1ActionPerformed(evt);
            }
        });
        jTextField_PRECIO_1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_PRECIO_1KeyTyped(evt);
            }
        });
        jPanel4.add(jTextField_PRECIO_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, 90, 25));

        jTextField_TRAT_6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_TRAT_6KeyTyped(evt);
            }
        });
        jPanel4.add(jTextField_TRAT_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 400, 25));

        jTextField_DEBE_6.setEditable(false);
        jTextField_DEBE_6.setBackground(new java.awt.Color(255, 153, 153));
        jTextField_DEBE_6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField_DEBE_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_DEBE_6ActionPerformed(evt);
            }
        });
        jPanel4.add(jTextField_DEBE_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 190, 90, 25));

        jTextField_PRECIO_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_PRECIO_6ActionPerformed(evt);
            }
        });
        jTextField_PRECIO_6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_PRECIO_6KeyTyped(evt);
            }
        });
        jPanel4.add(jTextField_PRECIO_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 190, 90, 25));

        jTextField_HABER_6.setBackground(new java.awt.Color(153, 255, 153));
        jTextField_HABER_6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField_HABER_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_HABER_6ActionPerformed(evt);
            }
        });
        jTextField_HABER_6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_HABER_6KeyTyped(evt);
            }
        });
        jPanel4.add(jTextField_HABER_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 190, 90, 25));

        jTextField_TRAT_7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_TRAT_6KeyTyped(evt);
            }
        });
        jPanel4.add(jTextField_TRAT_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 400, 25));

        jTextField_DEBE_7.setEditable(false);
        jTextField_DEBE_7.setBackground(new java.awt.Color(255, 153, 153));
        jTextField_DEBE_7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField_DEBE_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_DEBE_7ActionPerformed(evt);
            }
        });
        jPanel4.add(jTextField_DEBE_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 220, 90, 25));

        jTextField_PRECIO_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_PRECIO_7ActionPerformed(evt);
            }
        });
        jTextField_PRECIO_7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_PRECIO_7KeyTyped(evt);
            }
        });
        jPanel4.add(jTextField_PRECIO_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 220, 90, 25));

        jTextField_HABER_7.setBackground(new java.awt.Color(153, 255, 153));
        jTextField_HABER_7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField_HABER_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_HABER_7ActionPerformed(evt);
            }
        });
        jTextField_HABER_7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_HABER_7KeyTyped(evt);
            }
        });
        jPanel4.add(jTextField_HABER_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 220, 90, 25));

        jTextField_TRAT_8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_TRAT_15KeyTyped(evt);
            }
        });
        jPanel4.add(jTextField_TRAT_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 400, 25));

        jTextField_DEBE_8.setEditable(false);
        jTextField_DEBE_8.setBackground(new java.awt.Color(255, 153, 153));
        jTextField_DEBE_8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField_DEBE_8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_DEBE_8ActionPerformed(evt);
            }
        });
        jPanel4.add(jTextField_DEBE_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 250, 90, 25));

        jTextField_PRECIO_8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_PRECIO_8ActionPerformed(evt);
            }
        });
        jTextField_PRECIO_8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_PRECIO_8KeyTyped(evt);
            }
        });
        jPanel4.add(jTextField_PRECIO_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 250, 90, 25));

        jTextField_HABER_8.setBackground(new java.awt.Color(153, 255, 153));
        jTextField_HABER_8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField_HABER_8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_HABER_8ActionPerformed(evt);
            }
        });
        jTextField_HABER_8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_HABER_8KeyTyped(evt);
            }
        });
        jPanel4.add(jTextField_HABER_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 250, 90, 25));

        jTextField_TRAT_9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_TRAT_15KeyTyped(evt);
            }
        });
        jPanel4.add(jTextField_TRAT_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 400, 25));

        jTextField_DEBE_9.setEditable(false);
        jTextField_DEBE_9.setBackground(new java.awt.Color(255, 153, 153));
        jTextField_DEBE_9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField_DEBE_9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_DEBE_9ActionPerformed(evt);
            }
        });
        jPanel4.add(jTextField_DEBE_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 280, 90, 25));

        jTextField_PRECIO_9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_PRECIO_9ActionPerformed(evt);
            }
        });
        jTextField_PRECIO_9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_PRECIO_9KeyTyped(evt);
            }
        });
        jPanel4.add(jTextField_PRECIO_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 280, 90, 25));

        jTextField_HABER_9.setBackground(new java.awt.Color(153, 255, 153));
        jTextField_HABER_9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField_HABER_9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_HABER_9ActionPerformed(evt);
            }
        });
        jTextField_HABER_9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_HABER_9KeyTyped(evt);
            }
        });
        jPanel4.add(jTextField_HABER_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 280, 90, 25));

        jTextField_TRAT_10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_TRAT_15KeyTyped(evt);
            }
        });
        jPanel4.add(jTextField_TRAT_10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 400, 25));

        jTextField_DEBE_10.setEditable(false);
        jTextField_DEBE_10.setBackground(new java.awt.Color(255, 153, 153));
        jTextField_DEBE_10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField_DEBE_10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_DEBE_10ActionPerformed(evt);
            }
        });
        jPanel4.add(jTextField_DEBE_10, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 310, 90, 25));

        jTextField_PRECIO_10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_PRECIO_10ActionPerformed(evt);
            }
        });
        jTextField_PRECIO_10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_PRECIO_10KeyTyped(evt);
            }
        });
        jPanel4.add(jTextField_PRECIO_10, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 310, 90, 25));

        jTextField_HABER_10.setBackground(new java.awt.Color(153, 255, 153));
        jTextField_HABER_10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField_HABER_10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_HABER_10ActionPerformed(evt);
            }
        });
        jTextField_HABER_10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_HABER_10KeyTyped(evt);
            }
        });
        jPanel4.add(jTextField_HABER_10, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 310, 90, 25));

        jTextField_TRAT_11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_TRAT_15KeyTyped(evt);
            }
        });
        jPanel4.add(jTextField_TRAT_11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 400, 25));

        jTextField_DEBE_11.setEditable(false);
        jTextField_DEBE_11.setBackground(new java.awt.Color(255, 153, 153));
        jTextField_DEBE_11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField_DEBE_11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_DEBE_11ActionPerformed(evt);
            }
        });
        jPanel4.add(jTextField_DEBE_11, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 340, 90, 25));

        jTextField_PRECIO_11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_PRECIO_11ActionPerformed(evt);
            }
        });
        jTextField_PRECIO_11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_PRECIO_11KeyTyped(evt);
            }
        });
        jPanel4.add(jTextField_PRECIO_11, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 340, 90, 25));

        jTextField_HABER_11.setBackground(new java.awt.Color(153, 255, 153));
        jTextField_HABER_11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField_HABER_11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_HABER_11ActionPerformed(evt);
            }
        });
        jTextField_HABER_11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_HABER_11KeyTyped(evt);
            }
        });
        jPanel4.add(jTextField_HABER_11, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 340, 90, 25));

        jTextField_TRAT_12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_TRAT_15KeyTyped(evt);
            }
        });
        jPanel4.add(jTextField_TRAT_12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 400, 25));

        jTextField_DEBE_12.setEditable(false);
        jTextField_DEBE_12.setBackground(new java.awt.Color(255, 153, 153));
        jTextField_DEBE_12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField_DEBE_12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_DEBE_12ActionPerformed(evt);
            }
        });
        jPanel4.add(jTextField_DEBE_12, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 370, 90, 25));

        jTextField_PRECIO_12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_PRECIO_12ActionPerformed(evt);
            }
        });
        jTextField_PRECIO_12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_PRECIO_12KeyTyped(evt);
            }
        });
        jPanel4.add(jTextField_PRECIO_12, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 370, 90, 25));

        jTextField_HABER_12.setBackground(new java.awt.Color(153, 255, 153));
        jTextField_HABER_12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField_HABER_12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_HABER_12ActionPerformed(evt);
            }
        });
        jTextField_HABER_12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_HABER_12KeyTyped(evt);
            }
        });
        jPanel4.add(jTextField_HABER_12, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 370, 90, 25));

        jTextField_TRAT_13.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_TRAT_15KeyTyped(evt);
            }
        });
        jPanel4.add(jTextField_TRAT_13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 400, 25));

        jTextField_DEBE_13.setEditable(false);
        jTextField_DEBE_13.setBackground(new java.awt.Color(255, 153, 153));
        jTextField_DEBE_13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField_DEBE_13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_DEBE_13ActionPerformed(evt);
            }
        });
        jPanel4.add(jTextField_DEBE_13, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 400, 90, 25));

        jTextField_PRECIO_13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_PRECIO_13ActionPerformed(evt);
            }
        });
        jTextField_PRECIO_13.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_PRECIO_13KeyTyped(evt);
            }
        });
        jPanel4.add(jTextField_PRECIO_13, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 400, 90, 25));

        jTextField_HABER_13.setBackground(new java.awt.Color(153, 255, 153));
        jTextField_HABER_13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField_HABER_13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_HABER_13ActionPerformed(evt);
            }
        });
        jTextField_HABER_13.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_HABER_13KeyTyped(evt);
            }
        });
        jPanel4.add(jTextField_HABER_13, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 400, 90, 25));

        jTextField_TRAT_14.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_TRAT_15KeyTyped(evt);
            }
        });
        jPanel4.add(jTextField_TRAT_14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 400, 25));

        jTextField_DEBE_14.setEditable(false);
        jTextField_DEBE_14.setBackground(new java.awt.Color(255, 153, 153));
        jTextField_DEBE_14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField_DEBE_14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_DEBE_14ActionPerformed(evt);
            }
        });
        jPanel4.add(jTextField_DEBE_14, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 430, 90, 25));

        jTextField_PRECIO_14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_PRECIO_14ActionPerformed(evt);
            }
        });
        jTextField_PRECIO_14.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_PRECIO_14KeyTyped(evt);
            }
        });
        jPanel4.add(jTextField_PRECIO_14, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 430, 90, 25));

        jTextField_HABER_14.setBackground(new java.awt.Color(153, 255, 153));
        jTextField_HABER_14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField_HABER_14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_HABER_14ActionPerformed(evt);
            }
        });
        jTextField_HABER_14.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_HABER_14KeyTyped(evt);
            }
        });
        jPanel4.add(jTextField_HABER_14, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 430, 90, 25));

        jTextField_TRAT_15.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_TRAT_15KeyTyped(evt);
            }
        });
        jPanel4.add(jTextField_TRAT_15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 400, 25));

        jTextField_DEBE_15.setEditable(false);
        jTextField_DEBE_15.setBackground(new java.awt.Color(255, 153, 153));
        jTextField_DEBE_15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField_DEBE_15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_DEBE_15ActionPerformed(evt);
            }
        });
        jPanel4.add(jTextField_DEBE_15, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 460, 90, 25));

        jTextField_PRECIO_15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_PRECIO_15ActionPerformed(evt);
            }
        });
        jTextField_PRECIO_15.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_PRECIO_15KeyTyped(evt);
            }
        });
        jPanel4.add(jTextField_PRECIO_15, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 460, 90, 25));

        jTextField_HABER_15.setBackground(new java.awt.Color(153, 255, 153));
        jTextField_HABER_15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField_HABER_15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_HABER_15ActionPerformed(evt);
            }
        });
        jTextField_HABER_15.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_HABER_15KeyTyped(evt);
            }
        });
        jPanel4.add(jTextField_HABER_15, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 460, 90, 25));

        jTextField_TRAT_16.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_TRAT_15KeyTyped(evt);
            }
        });
        jPanel4.add(jTextField_TRAT_16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 400, 25));

        jTextField_DEBE_16.setEditable(false);
        jTextField_DEBE_16.setBackground(new java.awt.Color(255, 153, 153));
        jTextField_DEBE_16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField_DEBE_16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_DEBE_16ActionPerformed(evt);
            }
        });
        jPanel4.add(jTextField_DEBE_16, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 490, 90, 25));

        jTextField_PRECIO_16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_PRECIO_16ActionPerformed(evt);
            }
        });
        jTextField_PRECIO_16.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_PRECIO_16KeyTyped(evt);
            }
        });
        jPanel4.add(jTextField_PRECIO_16, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 490, 90, 25));

        jTextField_HABER_16.setBackground(new java.awt.Color(153, 255, 153));
        jTextField_HABER_16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField_HABER_16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_HABER_16ActionPerformed(evt);
            }
        });
        jTextField_HABER_16.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_HABER_16KeyTyped(evt);
            }
        });
        jPanel4.add(jTextField_HABER_16, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 490, 90, 25));

        jTextField_TRAT_17.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_TRAT_15KeyTyped(evt);
            }
        });
        jPanel4.add(jTextField_TRAT_17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 400, 25));

        jTextField_DEBE_17.setEditable(false);
        jTextField_DEBE_17.setBackground(new java.awt.Color(255, 153, 153));
        jTextField_DEBE_17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField_DEBE_17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_DEBE_17ActionPerformed(evt);
            }
        });
        jPanel4.add(jTextField_DEBE_17, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 520, 90, 25));

        jTextField_PRECIO_17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_PRECIO_17ActionPerformed(evt);
            }
        });
        jTextField_PRECIO_17.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_PRECIO_17KeyTyped(evt);
            }
        });
        jPanel4.add(jTextField_PRECIO_17, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 520, 90, 25));

        jTextField_HABER_17.setBackground(new java.awt.Color(153, 255, 153));
        jTextField_HABER_17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField_HABER_17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_HABER_17ActionPerformed(evt);
            }
        });
        jTextField_HABER_17.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_HABER_17KeyTyped(evt);
            }
        });
        jPanel4.add(jTextField_HABER_17, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 520, 90, 25));

        jTextField_DEBE_TOT.setEditable(false);
        jTextField_DEBE_TOT.setBackground(new java.awt.Color(255, 153, 153));
        jTextField_DEBE_TOT.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField_DEBE_TOT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_DEBE_TOTActionPerformed(evt);
            }
        });
        jPanel4.add(jTextField_DEBE_TOT, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 610, 90, 25));

        jTextField_HABER_TOT.setEditable(false);
        jTextField_HABER_TOT.setBackground(new java.awt.Color(153, 255, 153));
        jTextField_HABER_TOT.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField_HABER_TOT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_HABER_TOTActionPerformed(evt);
            }
        });
        jPanel4.add(jTextField_HABER_TOT, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 610, 90, 25));

        jTextField_TRAT_19.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_TRAT_15KeyTyped(evt);
            }
        });
        jPanel4.add(jTextField_TRAT_19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 580, 400, 25));

        jTextField_PRECIO_19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_PRECIO_19ActionPerformed(evt);
            }
        });
        jTextField_PRECIO_19.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_PRECIO_19KeyTyped(evt);
            }
        });
        jPanel4.add(jTextField_PRECIO_19, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 580, 90, 25));

        jTextField_DEBE_19.setEditable(false);
        jTextField_DEBE_19.setBackground(new java.awt.Color(255, 153, 153));
        jTextField_DEBE_19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField_DEBE_19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_DEBE_19ActionPerformed(evt);
            }
        });
        jPanel4.add(jTextField_DEBE_19, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 580, 90, 25));

        jTextField_HABER_19.setBackground(new java.awt.Color(153, 255, 153));
        jTextField_HABER_19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField_HABER_19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_HABER_19ActionPerformed(evt);
            }
        });
        jTextField_HABER_19.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_HABER_19KeyTyped(evt);
            }
        });
        jPanel4.add(jTextField_HABER_19, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 580, 90, 25));

        jTextField_TRAT_18.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_TRAT_15KeyTyped(evt);
            }
        });
        jPanel4.add(jTextField_TRAT_18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 550, 400, 25));

        jTextField_DEBE_18.setEditable(false);
        jTextField_DEBE_18.setBackground(new java.awt.Color(255, 153, 153));
        jTextField_DEBE_18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField_DEBE_18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_DEBE_18ActionPerformed(evt);
            }
        });
        jPanel4.add(jTextField_DEBE_18, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 550, 90, 25));

        jTextField_PRECIO_18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_PRECIO_18ActionPerformed(evt);
            }
        });
        jTextField_PRECIO_18.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_PRECIO_18KeyTyped(evt);
            }
        });
        jPanel4.add(jTextField_PRECIO_18, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 550, 90, 25));

        jTextField_HABER_18.setBackground(new java.awt.Color(153, 255, 153));
        jTextField_HABER_18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField_HABER_18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_HABER_18ActionPerformed(evt);
            }
        });
        jTextField_HABER_18.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_HABER_18KeyTyped(evt);
            }
        });
        jPanel4.add(jTextField_HABER_18, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 550, 90, 25));

        jTextField_TRAT_5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_TRAT_6KeyTyped(evt);
            }
        });
        jPanel4.add(jTextField_TRAT_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 400, 25));

        jTextField_DEBE_5.setEditable(false);
        jTextField_DEBE_5.setBackground(new java.awt.Color(255, 153, 153));
        jTextField_DEBE_5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField_DEBE_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_DEBE_5ActionPerformed(evt);
            }
        });
        jPanel4.add(jTextField_DEBE_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 160, 90, 25));

        jTextField_PRECIO_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_PRECIO_5ActionPerformed(evt);
            }
        });
        jTextField_PRECIO_5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_PRECIO_5KeyTyped(evt);
            }
        });
        jPanel4.add(jTextField_PRECIO_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, 90, 25));

        jTextField_HABER_5.setBackground(new java.awt.Color(153, 255, 153));
        jTextField_HABER_5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField_HABER_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_HABER_5ActionPerformed(evt);
            }
        });
        jTextField_HABER_5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_HABER_5KeyTyped(evt);
            }
        });
        jPanel4.add(jTextField_HABER_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 160, 90, 25));

        jTextField_TRAT_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_TRAT_4ActionPerformed(evt);
            }
        });
        jTextField_TRAT_4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_TRAT_6KeyTyped(evt);
            }
        });
        jPanel4.add(jTextField_TRAT_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 400, 25));

        jTextField_PRECIO_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_PRECIO_4ActionPerformed(evt);
            }
        });
        jTextField_PRECIO_4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_PRECIO_4KeyTyped(evt);
            }
        });
        jPanel4.add(jTextField_PRECIO_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, 90, 25));

        jTextField_DEBE_4.setEditable(false);
        jTextField_DEBE_4.setBackground(new java.awt.Color(255, 153, 153));
        jTextField_DEBE_4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField_DEBE_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_DEBE_4ActionPerformed(evt);
            }
        });
        jPanel4.add(jTextField_DEBE_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 130, 90, 25));

        jTextField_HABER_4.setBackground(new java.awt.Color(153, 255, 153));
        jTextField_HABER_4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField_HABER_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_HABER_4ActionPerformed(evt);
            }
        });
        jTextField_HABER_4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_HABER_4KeyTyped(evt);
            }
        });
        jPanel4.add(jTextField_HABER_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 130, 90, 25));

        jTextField_TRAT_3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_TRAT_3KeyTyped(evt);
            }
        });
        jPanel4.add(jTextField_TRAT_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 400, 25));

        jTextField_PRECIO_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_PRECIO_3ActionPerformed(evt);
            }
        });
        jTextField_PRECIO_3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_PRECIO_3KeyTyped(evt);
            }
        });
        jPanel4.add(jTextField_PRECIO_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, 90, 25));

        jTextField_DEBE_3.setEditable(false);
        jTextField_DEBE_3.setBackground(new java.awt.Color(255, 153, 153));
        jTextField_DEBE_3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField_DEBE_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_DEBE_3ActionPerformed(evt);
            }
        });
        jPanel4.add(jTextField_DEBE_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 100, 90, 25));

        jTextField_HABER_3.setBackground(new java.awt.Color(153, 255, 153));
        jTextField_HABER_3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField_HABER_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_HABER_3ActionPerformed(evt);
            }
        });
        jTextField_HABER_3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_HABER_3KeyTyped(evt);
            }
        });
        jPanel4.add(jTextField_HABER_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 100, 90, 25));

        jTextField_TRAT_2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_TRAT_2KeyTyped(evt);
            }
        });
        jPanel4.add(jTextField_TRAT_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 400, 25));

        jTextField_PRECIO_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_PRECIO_2ActionPerformed(evt);
            }
        });
        jTextField_PRECIO_2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_PRECIO_2KeyTyped(evt);
            }
        });
        jPanel4.add(jTextField_PRECIO_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, 90, 25));

        jTextField_DEBE_2.setEditable(false);
        jTextField_DEBE_2.setBackground(new java.awt.Color(255, 153, 153));
        jTextField_DEBE_2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField_DEBE_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_DEBE_2ActionPerformed(evt);
            }
        });
        jPanel4.add(jTextField_DEBE_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 70, 90, 25));

        jTextField_HABER_2.setBackground(new java.awt.Color(153, 255, 153));
        jTextField_HABER_2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField_HABER_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_HABER_2ActionPerformed(evt);
            }
        });
        jTextField_HABER_2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_HABER_2KeyTyped(evt);
            }
        });
        jPanel4.add(jTextField_HABER_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 70, 90, 25));

        jTextFieldNOMBRE.setEditable(false);
        jPanel4.add(jTextFieldNOMBRE, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 270, 25));

        jLabel116.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel116.setForeground(new java.awt.Color(255, 255, 255));
        jLabel116.setText("A Pagar :");
        jPanel4.add(jLabel116, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 70, -1, 25));

        jTextFieldA_PAGAR.setEditable(false);
        jPanel4.add(jTextFieldA_PAGAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 100, 90, 25));

        jTextFieldA_FAVOR.setEditable(false);
        jPanel4.add(jTextFieldA_FAVOR, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 40, 90, 25));

        jLabel110.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel110.setForeground(new java.awt.Color(255, 255, 255));
        jLabel110.setText("Totales :");
        jPanel4.add(jLabel110, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 610, -1, 25));

        jLabel111.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel111.setForeground(new java.awt.Color(255, 255, 255));
        jLabel111.setText("Precio :");
        jPanel4.add(jLabel111, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, -1, 25));

        jLabel112.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel112.setForeground(new java.awt.Color(255, 255, 255));
        jLabel112.setText("Debe :");
        jPanel4.add(jLabel112, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, -1, 25));

        jLabel113.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel113.setForeground(new java.awt.Color(255, 255, 255));
        jLabel113.setText("Haber :");
        jPanel4.add(jLabel113, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 10, -1, 25));

        jLabel114.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel114.setForeground(new java.awt.Color(255, 255, 255));
        jLabel114.setText("Tratamientos de :");
        jPanel4.add(jLabel114, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 25));

        jLabel115.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel115.setForeground(new java.awt.Color(255, 255, 255));
        jLabel115.setText("A Favor :");
        jPanel4.add(jLabel115, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 10, -1, 25));

        jButton7.setBackground(new java.awt.Color(0, 153, 153));
        jButton7.setFont(new java.awt.Font("Consolas", 1, 11)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Actualizar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 620, 110, 30));

        jButton6.setBackground(new java.awt.Color(0, 102, 0));
        jButton6.setFont(new java.awt.Font("Consolas", 1, 11)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Atras");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 620, 125, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/orig_83350_1100x688.jpg"))); // NOI18N
        jLabel6.setText("jLabel6");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 1100, -1));

        jTabbedPane1.addTab("Saldo", jPanel4);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 688));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Principal a = new Principal();
        a.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed
TableRowSorter ts;
    private void jfiltobusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jfiltobusquedaKeyTyped
  
        jfiltobusqueda.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent ke){
                
                ts.setRowFilter(RowFilter.regexFilter("(?i)"+jfiltobusqueda.getText(),0));
                
            }
         
        });
        
        ts = new TableRowSorter(model);
        jTable1_Cilentes_Mostrar.setRowSorter(ts);
    }//GEN-LAST:event_jfiltobusquedaKeyTyped

    private void jButtonELIMINARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonELIMINARActionPerformed
        Eliminar();
    }//GEN-LAST:event_jButtonELIMINARActionPerformed

    private void jTable1_Cilentes_MostrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1_Cilentes_MostrarMouseClicked
        String barra = File.separator;
        String ubicacionfoto = System.getProperty("user.dir")+barra+"FotosCliente"+barra;
        int seleccion = jTable1_Cilentes_Mostrar.getSelectedRow();
        jeliminarCli = (String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 0)));
        jTextFieldNOMBRE.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 0)));
        jTextFieldNyA_INTRO.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 0)));
        jTextFieldDOMIC_INTRO.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 1)));
        jTextFieldT_FIJO_INTRO.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 2)));
        jTextFieldCEL_INTRO.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 3)));
        jTextFieldCORREO_INTRO.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 4)));
        jComboBoxPROFESION_SEL.setSelectedItem(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 5)));
        jTextFieldTRAB_LUGAR_INTRO.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 6)));
        String dia = String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 7));
        String mes = String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 7));
        String anio = String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 7));
        dia = dia.substring(0,2);
        mes = mes.substring(3,5);
        anio = anio.substring(6,10);
        jComboBoxDIA_NAC.setSelectedItem(dia);
        jComboBoxMES_NAC.setSelectedItem(mes);
        jComboBoxYEAR_NAC.setSelectedItem(anio);
        jTextFieldDERIV_DOC.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 8)));
        jbtalergia.setSelectedItem(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 9)));
        jbtdiabetes.setSelectedItem(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 10)));
        jTextFieldTRAT_DIET_INTRO.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 11)));
        jComboBoxPARTOS.setSelectedItem(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 12)));
        jTextFieldTENSION_INTRO.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 13)));
        jTextFieldANT_HOR_INTRO.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 14)));
        jTextFieldTEMPERAMENTO_INTRO.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 15)));
        jComboBoxINTQUIRU_INTRO.setSelectedItem(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 16)));
        jbtcigarro.setSelectedItem(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 17)));
        jbtalcohol.setSelectedItem(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 18)));
        jComboBoxBIOT_NORMAL.setSelectedItem(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 19)));
        jComboBoxBIOT_FLUENtE.setSelectedItem(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 20)));
        jComboBoxBIOT_SENSIBLE.setSelectedItem(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 21)));
        jComboBoxBIOT_ALIPICO.setSelectedItem(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 22)));
        jComboBoxBIOT_DESHI.setSelectedItem(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 23)));
        jComboBoxBIOT_XERO.setSelectedItem(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 24)));
        jComboBoxBT_TEXT.setSelectedItem(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 25)));
        jTextFieldBT_COLOR.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 26)));
        jTextFieldBT_PIGMEN.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 27)));
        jTextFieldBT_LOCAL_PIG.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 28)));
        jTextFieldBT_CICAT.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 29)));
        jTextFieldBT_LOCAL_CICA.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 30)));
        jTextFieldBT_LESION.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 31)));
        jTextFieldBT_PLIYARR.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 32)));
        jTextField1.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 33)));
        jComboBoxBT_LOCA_PARP.setSelectedItem(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 34)));
        jComboBoxBT_LOC_PERIBU.setSelectedItem(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 35)));
        jComboBoxBT_LOC_FRENTE.setSelectedItem(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 36)));
        jComboBoxBT_LOCA_NASO.setSelectedItem(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 37)));
        jComboBoxBT_LOCA_PREAURI.setSelectedItem(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 38)));
        jComboBoxBT_CUE_TON.setSelectedItem(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 39)));
        jComboBoxBT_CUE_DASOL.setSelectedItem(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 40)));
        jComboBoxBT_CUE_FLA.setSelectedItem(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 41)));
        jComboBoxBT_CARA.setSelectedItem(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 42)));
        jComboBoxBT_MALAR.setSelectedItem(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 43)));
        jComboBoxBT_BOZO.setSelectedItem(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 44)));
        jComboBoxBT_MENTO.setSelectedItem(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 45)));
        jComboBoxBT_SEDEP.setSelectedItem(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 46)));
        jComboBoxBT_HIRSU.setSelectedItem(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 47)));
        jComboBoxBT_HIPER.setSelectedItem(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 48)));
        jComboBoxCC_SECO.setSelectedItem(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 49)));
        jComboBoxCC_GRAS.setSelectedItem(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 50)));
        jComboBoxCC_ERIT.setSelectedItem(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 51)));
        jComboBoxCC_LESI.setSelectedItem(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 52)));
        jComboBoxCC_ALO.setSelectedItem(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 53)));
        jComboBoxCC_TIPO.setSelectedItem(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 54)));
        jComboBoxCC_ONI.setSelectedItem(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 55)));
        jComboBoxCC_ANTECE.setSelectedItem(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 56)));
        jComboBoxCC_DESCA.setSelectedItem(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 57)));
        jComboBoxCC_UNIA.setSelectedItem(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 58)));
        jComboBoxCC_PITI.setSelectedItem(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 59)));
        jComboBoxCC_PRUR.setSelectedItem(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 60)));
        jComboBoxCC_EXCO.setSelectedItem(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 61)));
        jComboBox1.setSelectedItem(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 62)));
        jTextField2.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 63)));
        jTextField4.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 64)));
        jComboBox2.setSelectedItem(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 65)));
        jTextField3.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 66)));
        jTextField5.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 67)));
        jTextField6.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 68)));
        jTextField7.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 69)));
        jTextField8.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 70)));
        jTextField9.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 71)));
        jTextField10.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 72)));
        jTextField11.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 73)));
        jTextField12.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 74)));
        jTextField13.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 75)));
        jComboBox3.setSelectedItem(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 76)));
        jComboBox4.setSelectedItem(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 77)));
        jComboBox5.setSelectedItem(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 78)));
        jTextField14.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 79)));
        jTextField15.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 80)));
        jTextField16.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 81)));
        jTextField17.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 82)));
        jTextField18.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 83)));
        jTextField19.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 84)));
        jTextField20.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 85)));
        jTextField21.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 86)));
        jTextField22.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 87)));
        jTextField23.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 88)));
        jTextField24.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 89)));
        jTextField_TRAT_1.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 90)));
        jTextField_PRECIO_1.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 91)));
        jTextField_DEBE_1.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 92)));
        jTextField_HABER_1.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 93)));
        jTextField_TRAT_2.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 94)));
        jTextField_PRECIO_2.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 95)));
        jTextField_DEBE_2.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 96)));
        jTextField_HABER_2.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 97)));
        jTextField_TRAT_3.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 98)));
        jTextField_PRECIO_3.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 99)));
        jTextField_DEBE_3.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 100)));
        jTextField_HABER_3.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 101)));
        jTextField_TRAT_4.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 102)));
        jTextField_PRECIO_4.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 103)));
        jTextField_DEBE_4.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 104)));
        jTextField_HABER_4.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 105)));
        jTextField_TRAT_5.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 106)));
        jTextField_PRECIO_5.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 107)));
        jTextField_DEBE_5.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 108)));
        jTextField_HABER_5.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 109)));
        jTextField_TRAT_6.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 110)));
        jTextField_PRECIO_6.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 111)));
        jTextField_DEBE_6.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 112)));
        jTextField_HABER_6.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 113)));
        jTextField_TRAT_7.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 114)));
        jTextField_PRECIO_7.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 115)));
        jTextField_DEBE_7.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 116)));
        jTextField_HABER_7.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 117)));
        jTextField_TRAT_8.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 118)));
        jTextField_PRECIO_8.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 119)));
        jTextField_DEBE_8.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 120)));
        jTextField_HABER_8.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 121)));
        jTextField_TRAT_9.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 122)));
        jTextField_PRECIO_9.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 123)));
        jTextField_DEBE_9.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 124)));
        jTextField_HABER_9.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 125)));
        jTextField_TRAT_10.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 126)));
        jTextField_PRECIO_10.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 127)));
        jTextField_DEBE_10.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 128)));
        jTextField_HABER_10.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 129)));
        jTextField_TRAT_11.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 130)));
        jTextField_PRECIO_11.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 131)));
        jTextField_DEBE_11.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 132)));
        jTextField_HABER_11.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 133)));
        jTextField_TRAT_12.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 134)));
        jTextField_PRECIO_12.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 135)));
        jTextField_DEBE_12.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 136)));
        jTextField_HABER_12.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 137)));
        jTextField_TRAT_13.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 138)));
        jTextField_PRECIO_13.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 139)));
        jTextField_DEBE_13.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 140)));
        jTextField_HABER_13.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 141)));
        jTextField_TRAT_14.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 142)));
        jTextField_PRECIO_14.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 143)));
        jTextField_DEBE_14.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 144)));
        jTextField_HABER_14.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 145)));
        jTextField_TRAT_15.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 146)));
        jTextField_PRECIO_15.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 147)));
        jTextField_DEBE_15.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 148)));
        jTextField_HABER_15.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 149)));
        jTextField_TRAT_16.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 150)));
        jTextField_PRECIO_16.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 151)));
        jTextField_DEBE_16.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 152)));
        jTextField_HABER_16.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 153)));
        jTextField_TRAT_17.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 154)));
        jTextField_PRECIO_17.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 155)));
        jTextField_DEBE_17.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 156)));
        jTextField_HABER_17.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 157)));
        jTextField_TRAT_18.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 158)));
        jTextField_PRECIO_18.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 159)));
        jTextField_DEBE_18.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 160)));
        jTextField_HABER_18.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 161)));
        jTextField_TRAT_19.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 162)));
        jTextField_PRECIO_19.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 163)));
        jTextField_DEBE_19.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 164)));
        jTextField_HABER_19.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 165)));
        jTextField_DEBE_TOT.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 166)));
        jTextField_HABER_TOT.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 167)));
        jTextField25.setText(String.valueOf(jTable1_Cilentes_Mostrar.getValueAt(seleccion, 168)));
        String fotitoloca = jTextField25.getText();
        ImageIcon icon = new ImageIcon(ubicacionfoto+fotitoloca);
        jLabel78.setIcon(icon);
        Icon icono_foto = new ImageIcon(icon.getImage().getScaledInstance(jLabel78.getWidth(), jLabel78.getHeight(), Image.SCALE_DEFAULT));
        jLabel78.setIcon(icono_foto);  
        nombrefoto = jTextField25.getText();
        DEBE_A_FAVOR();
        
    }//GEN-LAST:event_jTable1_Cilentes_MostrarMouseClicked

    private void jTable1_Cilentes_MostrarInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTable1_Cilentes_MostrarInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1_Cilentes_MostrarInputMethodTextChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       Principal a = new Principal();
        a.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextFieldCORREO_INTROActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCORREO_INTROActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCORREO_INTROActionPerformed

    private void jComboBoxYEAR_NACActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxYEAR_NACActionPerformed

    }//GEN-LAST:event_jComboBoxYEAR_NACActionPerformed

    private void jTextFieldCEL_INTROActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCEL_INTROActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCEL_INTROActionPerformed

    private void jTextFieldDOMIC_INTROActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDOMIC_INTROActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDOMIC_INTROActionPerformed

    private void jTextFieldNyA_INTROActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNyA_INTROActionPerformed

    }//GEN-LAST:event_jTextFieldNyA_INTROActionPerformed
    File ficherofoto;
    public String nombrefoto;
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int resultado;
        
        CargarFoto ventana = new CargarFoto();

        FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG y PNG","jpg","png","jpeg");

        CargarFoto.jfchCargarfoto.setFileFilter(filtro);

        resultado= CargarFoto.jfchCargarfoto.showOpenDialog(null);

        if (JFileChooser.APPROVE_OPTION == resultado){

                ficherofoto = CargarFoto.jfchCargarfoto.getSelectedFile();

                try{

                       ImageIcon icon = new ImageIcon(ficherofoto.toString());
                       Icon icono_foto = new ImageIcon(icon.getImage().getScaledInstance(jLabel78.getWidth(), jLabel78.getHeight(), Image.SCALE_DEFAULT));
                       jLabel78.setText(null);
                       jLabel78.setIcon(icono_foto);
                       nombrefoto = ficherofoto.getName();

                }catch(Exception ex){

                    JOptionPane.showMessageDialog(null, "Error abriendo la imagen."+ ex);
                }
         }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextFieldTENSION_INTROActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTENSION_INTROActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTENSION_INTROActionPerformed

    private void jComboBoxPARTOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPARTOSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxPARTOSActionPerformed

    private void jTextFieldDERIV_DOCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDERIV_DOCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDERIV_DOCActionPerformed

    private void jComboBoxBT_LOC_FRENTEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxBT_LOC_FRENTEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxBT_LOC_FRENTEActionPerformed

    private void jComboBoxBT_LOC_PERIBUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxBT_LOC_PERIBUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxBT_LOC_PERIBUActionPerformed

    private void jTextFieldBT_LESIONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBT_LESIONActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldBT_LESIONActionPerformed

    private void jComboBoxBT_TEXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxBT_TEXTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxBT_TEXTActionPerformed

    private void jComboBoxCC_PITIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCC_PITIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxCC_PITIActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        nombrefoto = jLabel78.getName();
        Editar();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Principal a = new Principal();
        a.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        Principal a = new Principal();
        a.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTextField_PRECIO_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_PRECIO_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_PRECIO_1ActionPerformed

    private void jTextField_DEBE_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_DEBE_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_DEBE_1ActionPerformed

    private void jTextField_HABER_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_HABER_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_HABER_1ActionPerformed

    private void jTextField_PRECIO_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_PRECIO_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_PRECIO_2ActionPerformed

    private void jTextField_DEBE_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_DEBE_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_DEBE_2ActionPerformed

    private void jTextField_HABER_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_HABER_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_HABER_2ActionPerformed

    private void jTextField_PRECIO_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_PRECIO_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_PRECIO_3ActionPerformed

    private void jTextField_DEBE_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_DEBE_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_DEBE_3ActionPerformed

    private void jTextField_HABER_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_HABER_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_HABER_3ActionPerformed

    private void jTextField_PRECIO_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_PRECIO_4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_PRECIO_4ActionPerformed

    private void jTextField_DEBE_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_DEBE_4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_DEBE_4ActionPerformed

    private void jTextField_HABER_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_HABER_4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_HABER_4ActionPerformed

    private void jTextField_DEBE_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_DEBE_5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_DEBE_5ActionPerformed

    private void jTextField_PRECIO_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_PRECIO_5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_PRECIO_5ActionPerformed

    private void jTextField_HABER_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_HABER_5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_HABER_5ActionPerformed

    private void jTextField_DEBE_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_DEBE_6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_DEBE_6ActionPerformed

    private void jTextField_PRECIO_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_PRECIO_6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_PRECIO_6ActionPerformed

    private void jTextField_HABER_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_HABER_6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_HABER_6ActionPerformed

    private void jTextField_DEBE_7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_DEBE_7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_DEBE_7ActionPerformed

    private void jTextField_PRECIO_7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_PRECIO_7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_PRECIO_7ActionPerformed

    private void jTextField_HABER_7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_HABER_7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_HABER_7ActionPerformed

    private void jTextField_DEBE_8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_DEBE_8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_DEBE_8ActionPerformed

    private void jTextField_PRECIO_8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_PRECIO_8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_PRECIO_8ActionPerformed

    private void jTextField_HABER_8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_HABER_8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_HABER_8ActionPerformed

    private void jTextField_DEBE_9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_DEBE_9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_DEBE_9ActionPerformed

    private void jTextField_PRECIO_9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_PRECIO_9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_PRECIO_9ActionPerformed

    private void jTextField_HABER_9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_HABER_9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_HABER_9ActionPerformed

    private void jTextField_DEBE_10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_DEBE_10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_DEBE_10ActionPerformed

    private void jTextField_PRECIO_10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_PRECIO_10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_PRECIO_10ActionPerformed

    private void jTextField_HABER_10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_HABER_10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_HABER_10ActionPerformed

    private void jTextField_DEBE_11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_DEBE_11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_DEBE_11ActionPerformed

    private void jTextField_PRECIO_11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_PRECIO_11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_PRECIO_11ActionPerformed

    private void jTextField_HABER_11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_HABER_11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_HABER_11ActionPerformed

    private void jTextField_DEBE_12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_DEBE_12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_DEBE_12ActionPerformed

    private void jTextField_PRECIO_12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_PRECIO_12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_PRECIO_12ActionPerformed

    private void jTextField_HABER_12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_HABER_12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_HABER_12ActionPerformed

    private void jTextField_DEBE_13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_DEBE_13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_DEBE_13ActionPerformed

    private void jTextField_PRECIO_13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_PRECIO_13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_PRECIO_13ActionPerformed

    private void jTextField_HABER_13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_HABER_13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_HABER_13ActionPerformed

    private void jTextField_DEBE_14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_DEBE_14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_DEBE_14ActionPerformed

    private void jTextField_PRECIO_14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_PRECIO_14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_PRECIO_14ActionPerformed

    private void jTextField_HABER_14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_HABER_14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_HABER_14ActionPerformed

    private void jTextField_DEBE_15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_DEBE_15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_DEBE_15ActionPerformed

    private void jTextField_PRECIO_15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_PRECIO_15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_PRECIO_15ActionPerformed

    private void jTextField_HABER_15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_HABER_15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_HABER_15ActionPerformed

    private void jTextField_DEBE_16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_DEBE_16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_DEBE_16ActionPerformed

    private void jTextField_PRECIO_16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_PRECIO_16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_PRECIO_16ActionPerformed

    private void jTextField_HABER_16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_HABER_16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_HABER_16ActionPerformed

    private void jTextField_DEBE_17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_DEBE_17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_DEBE_17ActionPerformed

    private void jTextField_PRECIO_17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_PRECIO_17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_PRECIO_17ActionPerformed

    private void jTextField_HABER_17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_HABER_17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_HABER_17ActionPerformed

    private void jTextField_DEBE_18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_DEBE_18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_DEBE_18ActionPerformed

    private void jTextField_PRECIO_18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_PRECIO_18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_PRECIO_18ActionPerformed

    private void jTextField_HABER_18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_HABER_18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_HABER_18ActionPerformed

    private void jTextField_PRECIO_19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_PRECIO_19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_PRECIO_19ActionPerformed

    private void jTextField_DEBE_19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_DEBE_19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_DEBE_19ActionPerformed

    private void jTextField_HABER_19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_HABER_19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_HABER_19ActionPerformed

    private void jTextField_DEBE_TOTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_DEBE_TOTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_DEBE_TOTActionPerformed

    private void jTextField_HABER_TOTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_HABER_TOTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_HABER_TOTActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if (jTextFieldNyA_INTRO.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Seleccione un Cliente antes de Actualizar!");
        }else
        { 
            Editar();
            this.setVisible(false);
            Principal asd = new Principal();
            asd.setVisible(true);
            asd.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTextField_PRECIO_1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_PRECIO_1KeyTyped
        Error_Garrafal(evt);
    }//GEN-LAST:event_jTextField_PRECIO_1KeyTyped

    private void jTextField_PRECIO_2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_PRECIO_2KeyTyped
        Error_Garrafal(evt);
    }//GEN-LAST:event_jTextField_PRECIO_2KeyTyped

    private void jTextField_PRECIO_3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_PRECIO_3KeyTyped
        Error_Garrafal(evt);
    }//GEN-LAST:event_jTextField_PRECIO_3KeyTyped

    private void jTextField_PRECIO_4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_PRECIO_4KeyTyped
        Error_Garrafal(evt);
    }//GEN-LAST:event_jTextField_PRECIO_4KeyTyped

    private void jTextField_PRECIO_5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_PRECIO_5KeyTyped
        Error_Garrafal(evt);
    }//GEN-LAST:event_jTextField_PRECIO_5KeyTyped

    private void jTextField_PRECIO_6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_PRECIO_6KeyTyped
        Error_Garrafal(evt);
    }//GEN-LAST:event_jTextField_PRECIO_6KeyTyped

    private void jTextField_PRECIO_7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_PRECIO_7KeyTyped
        Error_Garrafal(evt);
    }//GEN-LAST:event_jTextField_PRECIO_7KeyTyped

    private void jTextField_PRECIO_8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_PRECIO_8KeyTyped
        Error_Garrafal(evt);
    }//GEN-LAST:event_jTextField_PRECIO_8KeyTyped

    private void jTextField_PRECIO_9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_PRECIO_9KeyTyped
        Error_Garrafal(evt);       
    }//GEN-LAST:event_jTextField_PRECIO_9KeyTyped

    private void jTextField_PRECIO_10KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_PRECIO_10KeyTyped
        Error_Garrafal(evt);      
    }//GEN-LAST:event_jTextField_PRECIO_10KeyTyped

    private void jTextField_PRECIO_11KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_PRECIO_11KeyTyped
        Error_Garrafal(evt);        
    }//GEN-LAST:event_jTextField_PRECIO_11KeyTyped

    private void jTextField_PRECIO_12KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_PRECIO_12KeyTyped
        Error_Garrafal(evt);      
    }//GEN-LAST:event_jTextField_PRECIO_12KeyTyped

    private void jTextField_PRECIO_13KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_PRECIO_13KeyTyped
        Error_Garrafal(evt);       
    }//GEN-LAST:event_jTextField_PRECIO_13KeyTyped

    private void jTextField_PRECIO_14KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_PRECIO_14KeyTyped
        Error_Garrafal(evt);       
    }//GEN-LAST:event_jTextField_PRECIO_14KeyTyped

    private void jTextField_PRECIO_15KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_PRECIO_15KeyTyped
        Error_Garrafal(evt);        
    }//GEN-LAST:event_jTextField_PRECIO_15KeyTyped

    private void jTextField_PRECIO_16KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_PRECIO_16KeyTyped
        Error_Garrafal(evt);        
    }//GEN-LAST:event_jTextField_PRECIO_16KeyTyped

    private void jTextField_PRECIO_17KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_PRECIO_17KeyTyped
        Error_Garrafal(evt);       
    }//GEN-LAST:event_jTextField_PRECIO_17KeyTyped

    private void jTextField_PRECIO_18KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_PRECIO_18KeyTyped
        Error_Garrafal(evt);      
    }//GEN-LAST:event_jTextField_PRECIO_18KeyTyped

    private void jTextField_PRECIO_19KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_PRECIO_19KeyTyped
        Error_Garrafal(evt);       
    }//GEN-LAST:event_jTextField_PRECIO_19KeyTyped

    private void jTextField_HABER_1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_HABER_1KeyTyped
        Error_Garrafal(evt);       
    }//GEN-LAST:event_jTextField_HABER_1KeyTyped

    private void jTextField_HABER_2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_HABER_2KeyTyped
        Error_Garrafal(evt);       
    }//GEN-LAST:event_jTextField_HABER_2KeyTyped

    private void jTextField_HABER_3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_HABER_3KeyTyped
        Error_Garrafal(evt);    
    }//GEN-LAST:event_jTextField_HABER_3KeyTyped

    private void jTextField_HABER_4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_HABER_4KeyTyped
        Error_Garrafal(evt);   
    }//GEN-LAST:event_jTextField_HABER_4KeyTyped

    private void jTextField_HABER_5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_HABER_5KeyTyped
        Error_Garrafal(evt);      
    }//GEN-LAST:event_jTextField_HABER_5KeyTyped

    private void jTextField_HABER_6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_HABER_6KeyTyped
        Error_Garrafal(evt);      
    }//GEN-LAST:event_jTextField_HABER_6KeyTyped

    private void jTextField_HABER_7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_HABER_7KeyTyped
        Error_Garrafal(evt);     
    }//GEN-LAST:event_jTextField_HABER_7KeyTyped

    private void jTextField_HABER_8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_HABER_8KeyTyped
        Error_Garrafal(evt);       
    }//GEN-LAST:event_jTextField_HABER_8KeyTyped

    private void jTextField_HABER_9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_HABER_9KeyTyped
        Error_Garrafal(evt);       
    }//GEN-LAST:event_jTextField_HABER_9KeyTyped

    private void jTextField_HABER_10KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_HABER_10KeyTyped
        Error_Garrafal(evt);       
    }//GEN-LAST:event_jTextField_HABER_10KeyTyped

    private void jTextField_HABER_11KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_HABER_11KeyTyped
        Error_Garrafal(evt);       
    }//GEN-LAST:event_jTextField_HABER_11KeyTyped

    private void jTextField_HABER_12KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_HABER_12KeyTyped
        Error_Garrafal(evt);      
    }//GEN-LAST:event_jTextField_HABER_12KeyTyped

    private void jTextField_HABER_13KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_HABER_13KeyTyped
        Error_Garrafal(evt);        
    }//GEN-LAST:event_jTextField_HABER_13KeyTyped

    private void jTextField_HABER_14KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_HABER_14KeyTyped
        Error_Garrafal(evt);      
    }//GEN-LAST:event_jTextField_HABER_14KeyTyped

    private void jTextField_HABER_15KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_HABER_15KeyTyped
        Error_Garrafal(evt);   
    }//GEN-LAST:event_jTextField_HABER_15KeyTyped

    private void jTextField_HABER_16KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_HABER_16KeyTyped
        Error_Garrafal(evt);       
    }//GEN-LAST:event_jTextField_HABER_16KeyTyped

    private void jTextField_HABER_17KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_HABER_17KeyTyped
        Error_Garrafal(evt);      
    }//GEN-LAST:event_jTextField_HABER_17KeyTyped

    private void jTextField_HABER_18KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_HABER_18KeyTyped
        Error_Garrafal(evt);      
    }//GEN-LAST:event_jTextField_HABER_18KeyTyped

    private void jTextField_HABER_19KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_HABER_19KeyTyped
        Error_Garrafal(evt);        
    }//GEN-LAST:event_jTextField_HABER_19KeyTyped

    private void jTextField_TRAT_1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_TRAT_1KeyTyped
        Error_Garrafal_2(evt); 
    }//GEN-LAST:event_jTextField_TRAT_1KeyTyped

    private void jTextField_TRAT_2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_TRAT_2KeyTyped
       Error_Garrafal_2(evt); 
    }//GEN-LAST:event_jTextField_TRAT_2KeyTyped

    private void jTextField_TRAT_3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_TRAT_3KeyTyped
        Error_Garrafal_2(evt); 
    }//GEN-LAST:event_jTextField_TRAT_3KeyTyped

    private void jTextField_TRAT_6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_TRAT_6KeyTyped
        Error_Garrafal_2(evt); 
    }//GEN-LAST:event_jTextField_TRAT_6KeyTyped

    private void jTextField_TRAT_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_TRAT_4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_TRAT_4ActionPerformed

    private void jTextField_TRAT_15KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_TRAT_15KeyTyped
        Error_Garrafal_2(evt); 
    }//GEN-LAST:event_jTextField_TRAT_15KeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Cli().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane fotocliente;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButtonELIMINAR;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBoxBIOT_ALIPICO;
    private javax.swing.JComboBox<String> jComboBoxBIOT_DESHI;
    private javax.swing.JComboBox<String> jComboBoxBIOT_FLUENtE;
    private javax.swing.JComboBox<String> jComboBoxBIOT_NORMAL;
    private javax.swing.JComboBox<String> jComboBoxBIOT_SENSIBLE;
    private javax.swing.JComboBox<String> jComboBoxBIOT_XERO;
    private javax.swing.JComboBox<String> jComboBoxBT_BOZO;
    private javax.swing.JComboBox<String> jComboBoxBT_CARA;
    private javax.swing.JComboBox<String> jComboBoxBT_CUE_DASOL;
    private javax.swing.JComboBox<String> jComboBoxBT_CUE_FLA;
    private javax.swing.JComboBox<String> jComboBoxBT_CUE_TON;
    private javax.swing.JComboBox<String> jComboBoxBT_HIPER;
    private javax.swing.JComboBox<String> jComboBoxBT_HIRSU;
    private javax.swing.JComboBox<String> jComboBoxBT_LOCA_NASO;
    private javax.swing.JComboBox<String> jComboBoxBT_LOCA_PARP;
    private javax.swing.JComboBox<String> jComboBoxBT_LOCA_PREAURI;
    private javax.swing.JComboBox<String> jComboBoxBT_LOC_FRENTE;
    private javax.swing.JComboBox<String> jComboBoxBT_LOC_PERIBU;
    private javax.swing.JComboBox<String> jComboBoxBT_MALAR;
    private javax.swing.JComboBox<String> jComboBoxBT_MENTO;
    private javax.swing.JComboBox<String> jComboBoxBT_SEDEP;
    private javax.swing.JComboBox<String> jComboBoxBT_TEXT;
    private javax.swing.JComboBox<String> jComboBoxCC_ALO;
    private javax.swing.JComboBox<String> jComboBoxCC_ANTECE;
    private javax.swing.JComboBox<String> jComboBoxCC_DESCA;
    private javax.swing.JComboBox<String> jComboBoxCC_ERIT;
    private javax.swing.JComboBox<String> jComboBoxCC_EXCO;
    private javax.swing.JComboBox<String> jComboBoxCC_GRAS;
    private javax.swing.JComboBox<String> jComboBoxCC_LESI;
    private javax.swing.JComboBox<String> jComboBoxCC_ONI;
    private javax.swing.JComboBox<String> jComboBoxCC_PITI;
    private javax.swing.JComboBox<String> jComboBoxCC_PRUR;
    private javax.swing.JComboBox<String> jComboBoxCC_SECO;
    private javax.swing.JComboBox<String> jComboBoxCC_TIPO;
    private javax.swing.JComboBox<String> jComboBoxCC_UNIA;
    private javax.swing.JComboBox<String> jComboBoxDIA_NAC;
    private javax.swing.JComboBox<String> jComboBoxINTQUIRU_INTRO;
    private javax.swing.JComboBox<String> jComboBoxMES_NAC;
    private javax.swing.JComboBox<String> jComboBoxPARTOS;
    private javax.swing.JComboBox<String> jComboBoxPROFESION_SEL;
    private javax.swing.JComboBox<String> jComboBoxYEAR_NAC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JLabel jLabelFONDOINFPERS;
    private javax.swing.JLabel jLabelFONDOMEDIDAS;
    private javax.swing.JLabel jLabelFONDOSEMMAS;
    private javax.swing.JLabel jLabelNyA_INFPERS;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelANTECEDE;
    private javax.swing.JPanel jPanelINFOPERS;
    private javax.swing.JPanel jPanelMEDIDAS;
    private javax.swing.JPanel jPanelSEMIOCUT;
    private javax.swing.JPanel jPanelSEMIOCUT_MAS;
    private javax.swing.JScrollPane jScrollPane1CLIENTES_MOSTRAR;
    private javax.swing.JScrollPane jScrollPaneCUMPLES;
    private javax.swing.JScrollPane jScrollPaneDIADE;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPaneOPCIONESCLIENTE;
    private javax.swing.JTable jTable1_Cilentes_Mostrar;
    private javax.swing.JTable jTableCUMPLES;
    private javax.swing.JTable jTableDIADE;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField jTextFieldANT_HOR_INTRO;
    private javax.swing.JTextField jTextFieldA_FAVOR;
    private javax.swing.JTextField jTextFieldA_PAGAR;
    private javax.swing.JTextField jTextFieldBT_CICAT;
    private javax.swing.JTextField jTextFieldBT_COLOR;
    private javax.swing.JTextField jTextFieldBT_LESION;
    private javax.swing.JTextField jTextFieldBT_LOCAL_CICA;
    private javax.swing.JTextField jTextFieldBT_LOCAL_PIG;
    private javax.swing.JTextField jTextFieldBT_PIGMEN;
    private javax.swing.JTextField jTextFieldBT_PLIYARR;
    private javax.swing.JTextField jTextFieldCEL_INTRO;
    private javax.swing.JTextField jTextFieldCORREO_INTRO;
    private javax.swing.JTextField jTextFieldDERIV_DOC;
    private javax.swing.JTextField jTextFieldDOMIC_INTRO;
    private javax.swing.JTextField jTextFieldNOMBRE;
    private javax.swing.JTextField jTextFieldNyA_INTRO;
    private javax.swing.JTextField jTextFieldTEMPERAMENTO_INTRO;
    private javax.swing.JTextField jTextFieldTENSION_INTRO;
    private javax.swing.JTextField jTextFieldTRAB_LUGAR_INTRO;
    private javax.swing.JTextField jTextFieldTRAT_DIET_INTRO;
    private javax.swing.JTextField jTextFieldT_FIJO_INTRO;
    private javax.swing.JTextField jTextField_DEBE_1;
    private javax.swing.JTextField jTextField_DEBE_10;
    private javax.swing.JTextField jTextField_DEBE_11;
    private javax.swing.JTextField jTextField_DEBE_12;
    private javax.swing.JTextField jTextField_DEBE_13;
    private javax.swing.JTextField jTextField_DEBE_14;
    private javax.swing.JTextField jTextField_DEBE_15;
    private javax.swing.JTextField jTextField_DEBE_16;
    private javax.swing.JTextField jTextField_DEBE_17;
    private javax.swing.JTextField jTextField_DEBE_18;
    private javax.swing.JTextField jTextField_DEBE_19;
    private javax.swing.JTextField jTextField_DEBE_2;
    private javax.swing.JTextField jTextField_DEBE_3;
    private javax.swing.JTextField jTextField_DEBE_4;
    private javax.swing.JTextField jTextField_DEBE_5;
    private javax.swing.JTextField jTextField_DEBE_6;
    private javax.swing.JTextField jTextField_DEBE_7;
    private javax.swing.JTextField jTextField_DEBE_8;
    private javax.swing.JTextField jTextField_DEBE_9;
    private javax.swing.JTextField jTextField_DEBE_TOT;
    private javax.swing.JTextField jTextField_HABER_1;
    private javax.swing.JTextField jTextField_HABER_10;
    private javax.swing.JTextField jTextField_HABER_11;
    private javax.swing.JTextField jTextField_HABER_12;
    private javax.swing.JTextField jTextField_HABER_13;
    private javax.swing.JTextField jTextField_HABER_14;
    private javax.swing.JTextField jTextField_HABER_15;
    private javax.swing.JTextField jTextField_HABER_16;
    private javax.swing.JTextField jTextField_HABER_17;
    private javax.swing.JTextField jTextField_HABER_18;
    private javax.swing.JTextField jTextField_HABER_19;
    private javax.swing.JTextField jTextField_HABER_2;
    private javax.swing.JTextField jTextField_HABER_3;
    private javax.swing.JTextField jTextField_HABER_4;
    private javax.swing.JTextField jTextField_HABER_5;
    private javax.swing.JTextField jTextField_HABER_6;
    private javax.swing.JTextField jTextField_HABER_7;
    private javax.swing.JTextField jTextField_HABER_8;
    private javax.swing.JTextField jTextField_HABER_9;
    private javax.swing.JTextField jTextField_HABER_TOT;
    private javax.swing.JTextField jTextField_PRECIO_1;
    private javax.swing.JTextField jTextField_PRECIO_10;
    private javax.swing.JTextField jTextField_PRECIO_11;
    private javax.swing.JTextField jTextField_PRECIO_12;
    private javax.swing.JTextField jTextField_PRECIO_13;
    private javax.swing.JTextField jTextField_PRECIO_14;
    private javax.swing.JTextField jTextField_PRECIO_15;
    private javax.swing.JTextField jTextField_PRECIO_16;
    private javax.swing.JTextField jTextField_PRECIO_17;
    private javax.swing.JTextField jTextField_PRECIO_18;
    private javax.swing.JTextField jTextField_PRECIO_19;
    private javax.swing.JTextField jTextField_PRECIO_2;
    private javax.swing.JTextField jTextField_PRECIO_3;
    private javax.swing.JTextField jTextField_PRECIO_4;
    private javax.swing.JTextField jTextField_PRECIO_5;
    private javax.swing.JTextField jTextField_PRECIO_6;
    private javax.swing.JTextField jTextField_PRECIO_7;
    private javax.swing.JTextField jTextField_PRECIO_8;
    private javax.swing.JTextField jTextField_PRECIO_9;
    private javax.swing.JTextField jTextField_TRAT_1;
    private javax.swing.JTextField jTextField_TRAT_10;
    private javax.swing.JTextField jTextField_TRAT_11;
    private javax.swing.JTextField jTextField_TRAT_12;
    private javax.swing.JTextField jTextField_TRAT_13;
    private javax.swing.JTextField jTextField_TRAT_14;
    private javax.swing.JTextField jTextField_TRAT_15;
    private javax.swing.JTextField jTextField_TRAT_16;
    private javax.swing.JTextField jTextField_TRAT_17;
    private javax.swing.JTextField jTextField_TRAT_18;
    private javax.swing.JTextField jTextField_TRAT_19;
    private javax.swing.JTextField jTextField_TRAT_2;
    private javax.swing.JTextField jTextField_TRAT_3;
    private javax.swing.JTextField jTextField_TRAT_4;
    private javax.swing.JTextField jTextField_TRAT_5;
    private javax.swing.JTextField jTextField_TRAT_6;
    private javax.swing.JTextField jTextField_TRAT_7;
    private javax.swing.JTextField jTextField_TRAT_8;
    private javax.swing.JTextField jTextField_TRAT_9;
    private javax.swing.JComboBox<String> jbtalcohol;
    private javax.swing.JComboBox<String> jbtalergia;
    private javax.swing.JComboBox<String> jbtcigarro;
    private javax.swing.JComboBox<String> jbtdiabetes;
    private javax.swing.JTextField jfiltobusqueda;
    // End of variables declaration//GEN-END:variables
}
