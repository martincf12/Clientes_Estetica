package Ventanas;

import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.*;
import java.util.Formatter;
import java.util.LinkedList;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class AgCliente extends javax.swing.JFrame {
    
    JFileChooser seleccionado = new JFileChooser();
    File archivo;
    FileInputStream entrada;
    FileOutputStream salida;

    String barra = File.separator;
    String ubicacion = System.getProperty("user.dir")+barra+"ClientesRegistro"+barra;  
            
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
    public static LinkedList contenedor = new LinkedList();

    public AgCliente()
    {
        initComponents();
        FECHASNAC();     
    }
    
    private void CrearReg()
    {
        String ArchCli = jTextFieldNyA_INTRO.getText()+".txt";
        File crear_ubica = new File(ubicacion);
        File crear_archivo = new File(ubicacion+ArchCli);
        if (jTextFieldNyA_INTRO.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Ingrese un Nombre para Guardar el Cliente!");
        }else
        {   
            try
            {
                if(crear_archivo.exists())
                {
                JOptionPane.showMessageDialog(null,"El Cliente ya existe.");
                }else
                {
                crear_ubica.mkdirs();
                    try (Formatter crea = new Formatter(ubicacion+ArchCli)) {
                        crea.format("%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n"
                                + "%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n",
                                "NyA="+jTextFieldNyA_INTRO.getText(),
                                "Dom="+jTextFieldDOMIC_INTRO.getText(),
                                "Fijo="+jTextFieldT_FIJO_INTRO.getText(),
                                "Cel="+jTextFieldCEL_INTRO.getText(),
                                "mail="+jTextFieldCORREO_INTRO.getText(),
                                "PROF="+jComboBoxPROFESION_SEL.getSelectedItem(),
                                "Prof_Lugar="+jTextFieldTRAB_LUGAR_INTRO.getText(),
                                "dn="+jComboBoxDIA_NAC.getSelectedItem(),
                                "mn="+jComboBoxMES_NAC.getSelectedItem(),
                                "an="+jComboBoxYEAR_NAC.getSelectedItem(),
                                "medico="+jTextFieldDERIV_DOC.getText(),
                                "alergico="+jbtalergia.getSelectedItem(),
                                "diabetes="+jbtdiabetes.getSelectedItem(),
                                "tratam_diete="+jTextFieldTRAT_DIET_INTRO.getText(),
                                "c_partos="+jComboBoxPARTOS.getSelectedItem(),
                                "ten_art="+jTextFieldTENSION_INTRO.getText(),
                                "ant_hormo="+jTextFieldANT_HOR_INTRO.getText(),
                                "tempera="+jTextFieldTEMPERAMENTO_INTRO.getText(),
                                "inter_quir="+jComboBoxINTQUIRU_INTRO.getSelectedItem(),
                                "tabaco="+jbtcigarro.getSelectedItem(),
                                "alcohol="+jbtalcohol.getSelectedItem(),
                                "normal="+jComboBoxBIOT_NORMAL.getSelectedItem(),
                                "fluente="+jComboBoxBIOT_FLUENtE.getSelectedItem(),
                                "sensi="+jComboBoxBIOT_SENSIBLE.getSelectedItem(),
                                "secoalip="+jComboBoxBIOT_ALIPICO.getSelectedItem(),
                                "secodeshi="+jComboBoxBIOT_DESHI.getSelectedItem(),
                                "xero="+jComboBoxBIOT_XERO.getSelectedItem(),
                                "texuta="+jComboBoxBT_TEXT.getSelectedItem(),
                                "color="+jTextFieldBT_COLOR.getText(),
                                "pigme="+jTextFieldBT_PIGMEN.getText(),
                                "local="+jTextFieldBT_LOCAL_PIG.getText(),
                                "cicat="+jTextFieldBT_CICAT.getText(),
                                "locacic="+jTextFieldBT_LOCAL_CICA.getText(),
                                "lesion="+jTextFieldBT_LESION.getText(),
                                "debioti="+jTextFieldBT_PLIYARR.getText(),
                                "indu_sol="+jTextField1.getText(),
                                "parpad="+jComboBoxBT_LOCA_PARP.getSelectedItem(),
                                "peribuca="+jComboBoxBT_LOC_PERIBU.getSelectedItem(),
                                "frente="+jComboBoxBT_LOC_FRENTE.getSelectedItem(),
                                "nasoge="+jComboBoxBT_LOCA_NASO.getSelectedItem(),
                                "periauri="+jComboBoxBT_LOCA_PREAURI.getSelectedItem(),
                                "tonici="+jComboBoxBT_CUE_TON.getSelectedItem(),
                                "daniosol="+jComboBoxBT_CUE_DASOL.getSelectedItem(),
                                "flaci="+jComboBoxBT_CUE_FLA.getSelectedItem(),
                                "cara="+jComboBoxBT_CARA.getSelectedItem(),
                                "malar="+jComboBoxBT_MALAR.getSelectedItem(),
                                "bozo="+jComboBoxBT_BOZO.getSelectedItem(),
                                "mento="+jComboBoxBT_MENTO.getSelectedItem(),
                                "sedepi="+jComboBoxBT_SEDEP.getSelectedItem(),
                                "hirsu="+jComboBoxBT_HIRSU.getSelectedItem(),
                                "hipertri="+jComboBoxBT_HIPER.getSelectedItem(),
                                "seco="+jComboBoxCC_SECO.getSelectedItem(),
                                "graso="+jComboBoxCC_GRAS.getSelectedItem(),
                                "erite="+jComboBoxCC_ERIT.getSelectedItem(),
                                "leseri="+jComboBoxCC_LESI.getSelectedItem(),
                                "alope="+jComboBoxCC_ALO.getSelectedItem(),
                                "tipoalope="+jComboBoxCC_TIPO.getSelectedItem(),
                                "onico="+jComboBoxCC_ONI.getSelectedItem(),
                                "anteonico="+jComboBoxCC_ANTECE.getSelectedItem(),
                                "descama="+jComboBoxCC_DESCA.getSelectedItem(),
                                "unias="+jComboBoxCC_UNIA.getSelectedItem(),
                                "pitiri="+jComboBoxCC_PITI.getSelectedItem(),
                                "pruri="+jComboBoxCC_PRUR.getSelectedItem(),
                                "excor="+jComboBoxCC_EXCO.getSelectedItem(),
                                "celuli="+jComboBox1.getSelectedItem(),
                                "tipocelu="+jTextField2.getText(),
                                "locacelu="+jTextField4.getText(),
                                "estria="+jComboBox2.getSelectedItem(),
                                "locaestri="+jTextField3.getText(),
                                "acnetipoestri="+jTextField5.getText(),
                                "tiempoevol="+jTextField6.getText(),
                                "antehereestri="+jTextField7.getText(),
                                "lesielem="+jTextField8.getText(),
                                "localesielem="+jTextField9.getText(),
                                "rosatipo="+jTextField10.getText(),
                                "tiempoevolrosa="+jTextField11.getText(),
                                "locarosa="+jTextField12.getText(),
                                "antehererosa="+jTextField13.getText(),
                                "pielsen="+jComboBox3.getSelectedItem(),
                                "querato="+jComboBox4.getSelectedItem(),
                                "elasto="+jComboBox5.getSelectedItem(),
                                "otrasalter="+jTextField14.getText(),
                                "involedad="+jTextField15.getText(),
                                "tratderma="+jTextField16.getText(),
                                "tratcosme="+jTextField17.getText(),
                                "arribaomb="+jTextField18.getText(),
                                "abajoomb="+jTextField19.getText(),
                                "bder="+jTextField20.getText(),
                                "bizq="+jTextField21.getText(),
                                "cade="+jTextField22.getText(),
                                "talla="+jTextField23.getText(),
                                "peso="+jTextField24.getText(),
                                "t1="+"",
                                "t2="+"",
                                "t3="+"",
                                "t4="+"",
                                "t5="+"",
                                "t6="+"",
                                "t7="+"",
                                "t8="+"",
                                "t9="+"",
                                "t10="+"",
                                "t11="+"",
                                "t12="+"",
                                "t13="+"",
                                "t14="+"",
                                "t15"+"",
                                "t16="+"",
                                "t17="+"",
                                "t18="+"",
                                "t19="+"",
                                "p1="+0,
                                "p2="+0,
                                "p3="+0,
                                "p4="+0,
                                "p5="+0,
                                "p6="+0,
                                "p7="+0,
                                "p8="+0,
                                "p9="+0,
                                "p10="+0,
                                "p11="+0,
                                "p12="+0,
                                "p13="+0,
                                "p14="+0,
                                "p15="+0,
                                "p16="+0,
                                "p17="+0,
                                "p18="+0,
                                "p19="+0,
                                "d1="+0,
                                "d2="+0,
                                "d3="+0,
                                "d4="+0,
                                "d5="+0,
                                "d6="+0,
                                "d7="+0,
                                "d8="+0,
                                "d9="+0,
                                "d10="+0,
                                "d11="+0,
                                "d12="+0,
                                "d13="+0,
                                "d14="+0,
                                "d15="+0,
                                "d16="+0,
                                "d17="+0,
                                "d18="+0,
                                "d19="+0,
                                "d_TOT="+0,
                                "h1="+0,
                                "h2="+0,
                                "h3="+0,
                                "h4="+0,
                                "h5="+0,
                                "h6="+0,
                                "h7="+0,
                                "h8="+0,
                                "h9="+0,
                                "h10="+0,
                                "h11="+0,
                                "h12="+0,
                                "h13="+0,
                                "h14="+0,
                                "h15="+0,
                                "h16="+0,
                                "h17="+0,
                                "h18="+0,
                                "h19="+0,
                                "h_TOT="+0,
                                "fo_nomb="+nombrefoto);
                                
                                
                    }
                        JOptionPane.showMessageDialog(null,"Cliente guardado con éxito.");
                }
            }
            catch (HeadlessException | FileNotFoundException e)
            {
                JOptionPane.showMessageDialog(null,"No se pudo guardar el Cliente.");
            }
            
        }
    }
    
    @Override
    public Image getIconImage()
    {
       Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/vcICONO.jpg"));
       return retValue; 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPaneOPCIONESCLIENTE = new javax.swing.JTabbedPane();
        jPanelINFOPERS = new javax.swing.JPanel();
        jComboBoxPROFESION_SEL = new javax.swing.JComboBox<>();
        jTextFieldTRAB_LUGAR_INTRO = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldCORREO_INTRO = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxDIA_NAC = new javax.swing.JComboBox<>();
        jComboBoxMES_NAC = new javax.swing.JComboBox<>();
        jComboBoxYEAR_NAC = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldCEL_INTRO = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldT_FIJO_INTRO = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldDOMIC_INTRO = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldNyA_INTRO = new javax.swing.JTextField();
        jLabelNyA_INFPERS = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        fotocliente = new javax.swing.JScrollPane();
        jLabel78 = new javax.swing.JLabel();
        jLabelFONDOINFPERS = new javax.swing.JLabel();
        jPanelANTECEDE = new javax.swing.JPanel();
        jComboBoxINTQUIRU_INTRO = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jTextFieldTEMPERAMENTO_INTRO = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldANT_HOR_INTRO = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldTENSION_INTRO = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldTRAT_DIET_INTRO = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jComboBoxPARTOS = new javax.swing.JComboBox<>();
        jTextFieldDERIV_DOC = new javax.swing.JTextField();
        jbtcigarro = new javax.swing.JComboBox<>();
        jbtalcohol = new javax.swing.JComboBox<>();
        jbtdiabetes = new javax.swing.JComboBox<>();
        jbtalergia = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
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
        jLabel23 = new javax.swing.JLabel();
        jTextFieldBT_LESION = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jTextFieldBT_LOCAL_PIG = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jTextFieldBT_PIGMEN = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jTextFieldBT_COLOR = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jComboBoxBT_TEXT = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
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
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
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
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel58 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel63 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel69 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel72 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel73 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        jLabelFONDOSEMMAS = new javax.swing.JLabel();
        jPanelMEDIDAS = new javax.swing.JPanel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jTextField18 = new javax.swing.JTextField();
        jTextField19 = new javax.swing.JTextField();
        jTextField20 = new javax.swing.JTextField();
        jTextField21 = new javax.swing.JTextField();
        jTextField22 = new javax.swing.JTextField();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jTextField23 = new javax.swing.JTextField();
        jTextField24 = new javax.swing.JTextField();
        jLabel87 = new javax.swing.JLabel();
        jLabelFONDOMEDIDAS = new javax.swing.JLabel();
        jButtonATRASMENCLI = new javax.swing.JButton();
        jButton1GUARDAR = new javax.swing.JButton();
        jLabelFONDOMenCli = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPaneOPCIONESCLIENTE.setBackground(new java.awt.Color(255, 255, 255));

        jPanelINFOPERS.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBoxPROFESION_SEL.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ND", "Actor/Actriz", "Fonoaudiologa/o", "Periodista", "Bioquimica/o", "Ingeniera/o", "Locutor/a", "Abogada/o", "Secretaria/o", "Maestra/o", "Profesor/a", "Fotografa/o", "Cosmetologa/o", "Odontologa/o", "Farmaceutioca/o", "Psicologa/o", "Contador/a" }));
        jPanelINFOPERS.add(jComboBoxPROFESION_SEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, 150, 30));
        jPanelINFOPERS.add(jTextFieldTRAB_LUGAR_INTRO, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 320, 150, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Lugar :");
        jPanelINFOPERS.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 320, 125, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Profesión :");
        jPanelINFOPERS.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 125, 30));

        jTextFieldCORREO_INTRO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCORREO_INTROActionPerformed(evt);
            }
        });
        jPanelINFOPERS.add(jTextFieldCORREO_INTRO, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 300, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Correo Electrónico : ");
        jPanelINFOPERS.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 125, 30));

        jPanelINFOPERS.add(jComboBoxDIA_NAC, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 50, 25));

        jPanelINFOPERS.add(jComboBoxMES_NAC, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, 50, 25));

        jComboBoxYEAR_NAC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxYEAR_NACActionPerformed(evt);
            }
        });
        jPanelINFOPERS.add(jComboBoxYEAR_NAC, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, 70, 25));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Fecha de Nacimiento :");
        jPanelINFOPERS.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 125, 25));

        jTextFieldCEL_INTRO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCEL_INTROActionPerformed(evt);
            }
        });
        jPanelINFOPERS.add(jTextFieldCEL_INTRO, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 300, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Celular :");
        jPanelINFOPERS.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 120, 30));
        jPanelINFOPERS.add(jTextFieldT_FIJO_INTRO, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 300, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Teléfono Fijo :");
        jPanelINFOPERS.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 120, 30));

        jTextFieldDOMIC_INTRO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDOMIC_INTROActionPerformed(evt);
            }
        });
        jPanelINFOPERS.add(jTextFieldDOMIC_INTRO, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 300, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Domicilio :");
        jPanelINFOPERS.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 120, 30));

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

        jButton2.setBackground(new java.awt.Color(0, 102, 0));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Agregar Foto");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanelINFOPERS.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 340, -1, 25));

        fotocliente.setMaximumSize(new java.awt.Dimension(300, 300));
        fotocliente.setMinimumSize(new java.awt.Dimension(300, 300));
        fotocliente.setPreferredSize(new java.awt.Dimension(300, 300));
        fotocliente.setViewportView(jLabel78);

        jPanelINFOPERS.add(fotocliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 30, 300, 300));

        jLabelFONDOINFPERS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/orig_1050x650.jpg"))); // NOI18N
        jPanelINFOPERS.add(jLabelFONDOINFPERS, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jTabbedPaneOPCIONESCLIENTE.addTab("Información Personal", jPanelINFOPERS);

        jPanelANTECEDE.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBoxINTQUIRU_INTRO.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        jPanelANTECEDE.add(jComboBoxINTQUIRU_INTRO, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 350, -1, 25));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Intervenciones Quirúrgicas :");
        jPanelANTECEDE.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 160, 25));
        jPanelANTECEDE.add(jTextFieldTEMPERAMENTO_INTRO, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, 300, 25));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Temperamento :");
        jPanelANTECEDE.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 125, 25));
        jPanelANTECEDE.add(jTextFieldANT_HOR_INTRO, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 300, 25));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Antecedentes Hormonales : ");
        jPanelANTECEDE.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 160, 25));

        jTextFieldTENSION_INTRO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTENSION_INTROActionPerformed(evt);
            }
        });
        jPanelANTECEDE.add(jTextFieldTENSION_INTRO, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 300, 25));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Tensión Arterial : ");
        jPanelANTECEDE.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 125, 25));
        jPanelANTECEDE.add(jTextFieldTRAT_DIET_INTRO, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 300, 25));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Tratamientos Dietéticos :");
        jPanelANTECEDE.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 150, 25));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Cantidad de Partos :");
        jPanelANTECEDE.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 125, 25));

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

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Derivado/a por el Dr :");
        jPanelANTECEDE.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 125, 25));

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

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/orig_1050x650.jpg"))); // NOI18N
        jPanelANTECEDE.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 590));

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

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Cicatrices :");
        jPanelSEMIOCUT.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, -1, 25));

        jTextFieldBT_LESION.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldBT_LESIONActionPerformed(evt);
            }
        });
        jPanelSEMIOCUT.add(jTextFieldBT_LESION, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 470, 180, 25));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Lesiones :");
        jPanelSEMIOCUT.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, -1, 25));
        jPanelSEMIOCUT.add(jTextFieldBT_LOCAL_PIG, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, 180, 25));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Localizaciòn :");
        jPanelSEMIOCUT.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, 25));
        jPanelSEMIOCUT.add(jTextFieldBT_PIGMEN, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 180, 25));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Pigmentos :");
        jPanelSEMIOCUT.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 70, 25));
        jPanelSEMIOCUT.add(jTextFieldBT_COLOR, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 180, 25));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Color :");
        jPanelSEMIOCUT.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 50, 25));

        jComboBoxBT_TEXT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Untuosa", "Aspera", "Turgencia", "Lisa", "Rugosa" }));
        jComboBoxBT_TEXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxBT_TEXTActionPerformed(evt);
            }
        });
        jPanelSEMIOCUT.add(jComboBoxBT_TEXT, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, -1, 25));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Textura :");
        jPanelSEMIOCUT.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 125, 25));

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

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Biotipo cutáneo :");
        jPanelSEMIOCUT.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 125, 25));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/orig_1050x650.jpg"))); // NOI18N
        jPanelSEMIOCUT.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1050, 600));

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

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("Lesiones : ");
        jPanelSEMIOCUT_MAS.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, -1, 25));

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("Tipo :");
        jPanelSEMIOCUT_MAS.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, -1, 25));

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("Graso :");
        jPanelSEMIOCUT_MAS.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, -1, 25));

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("Eritema :");
        jPanelSEMIOCUT_MAS.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, -1, 25));

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("Alopecias :");
        jPanelSEMIOCUT_MAS.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, -1, 25));

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("Seco :");
        jPanelSEMIOCUT_MAS.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, -1, 25));

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Cuero Cabelludo :");
        jPanelSEMIOCUT_MAS.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, 25));

        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setText("Celulitis :");
        jPanelSEMIOCUT_MAS.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, -1, 25));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "SI" }));
        jPanelSEMIOCUT_MAS.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, -1, 25));

        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setText("Tipo :");
        jPanelSEMIOCUT_MAS.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 390, -1, 25));
        jPanelSEMIOCUT_MAS.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 390, 300, 25));

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setText("Localización :");
        jPanelSEMIOCUT_MAS.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 510, -1, 25));
        jPanelSEMIOCUT_MAS.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 510, 200, 25));

        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 255, 255));
        jLabel60.setText("Localización :");
        jPanelSEMIOCUT_MAS.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 430, -1, 25));
        jPanelSEMIOCUT_MAS.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 430, 300, 25));

        jLabel61.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(255, 255, 255));
        jLabel61.setText("ACNÉ :");
        jPanelSEMIOCUT_MAS.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, -1, 25));

        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(255, 255, 255));
        jLabel62.setText("Tipo :");
        jPanelSEMIOCUT_MAS.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 50, -1, 25));
        jPanelSEMIOCUT_MAS.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 50, 300, 25));

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("Estrías :");
        jPanelSEMIOCUT_MAS.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 470, -1, 25));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "SI" }));
        jPanelSEMIOCUT_MAS.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 470, -1, 25));

        jLabel63.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(255, 255, 255));
        jLabel63.setText("Tiempo de Evolución :");
        jPanelSEMIOCUT_MAS.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 90, -1, 25));
        jPanelSEMIOCUT_MAS.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 90, 300, 25));

        jLabel64.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(255, 255, 255));
        jLabel64.setText("Antecedentes Hereditarios :");
        jPanelSEMIOCUT_MAS.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, -1, 25));
        jPanelSEMIOCUT_MAS.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 130, 300, 25));

        jLabel65.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(255, 255, 255));
        jLabel65.setText("Lesiones Elementales :");
        jPanelSEMIOCUT_MAS.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 170, -1, 25));
        jPanelSEMIOCUT_MAS.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 170, 300, 25));

        jLabel66.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(255, 255, 255));
        jLabel66.setText("Localización :");
        jPanelSEMIOCUT_MAS.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 210, -1, 25));
        jPanelSEMIOCUT_MAS.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 210, 300, 25));

        jLabel67.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(255, 255, 255));
        jLabel67.setText("ROSÁCEA tipo :");
        jPanelSEMIOCUT_MAS.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 250, -1, 25));
        jPanelSEMIOCUT_MAS.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 250, 300, 25));

        jLabel68.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(255, 255, 255));
        jLabel68.setText("Tiempo de evolución :");
        jPanelSEMIOCUT_MAS.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 290, -1, 25));
        jPanelSEMIOCUT_MAS.add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 290, 300, 25));

        jLabel69.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(255, 255, 255));
        jLabel69.setText("Localización :");
        jPanelSEMIOCUT_MAS.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 330, -1, 25));
        jPanelSEMIOCUT_MAS.add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 330, 300, 25));

        jLabel70.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(255, 255, 255));
        jLabel70.setText("Antecedentes Hereditarios :");
        jPanelSEMIOCUT_MAS.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 370, -1, 25));
        jPanelSEMIOCUT_MAS.add(jTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 370, 300, 25));

        jLabel71.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(255, 255, 255));
        jLabel71.setText("Piel Senil :");
        jPanelSEMIOCUT_MAS.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 410, -1, 25));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "SI" }));
        jPanelSEMIOCUT_MAS.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 410, -1, 25));

        jLabel72.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(255, 255, 255));
        jLabel72.setText("Queratosis Actinicas :");
        jPanelSEMIOCUT_MAS.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 410, -1, 25));

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "SI" }));
        jPanelSEMIOCUT_MAS.add(jComboBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 410, -1, 25));

        jLabel73.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(255, 255, 255));
        jLabel73.setText("Elastosis Solar :");
        jPanelSEMIOCUT_MAS.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 410, -1, 25));

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "SI" }));
        jPanelSEMIOCUT_MAS.add(jComboBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 410, -1, 25));

        jLabel74.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(255, 255, 255));
        jLabel74.setText("Otras Alteraciónes :");
        jPanelSEMIOCUT_MAS.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 450, -1, 25));

        jLabel75.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(255, 255, 255));
        jLabel75.setText("Involución segun la edad :");
        jPanelSEMIOCUT_MAS.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 480, -1, 25));

        jLabel76.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(255, 255, 255));
        jLabel76.setText("Tratamientos Dermatológicos :");
        jPanelSEMIOCUT_MAS.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 510, -1, 25));

        jLabel77.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(255, 255, 255));
        jLabel77.setText("Tratamientos Cosméticos :");
        jPanelSEMIOCUT_MAS.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 540, -1, 25));
        jPanelSEMIOCUT_MAS.add(jTextField14, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 450, 300, 25));
        jPanelSEMIOCUT_MAS.add(jTextField15, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 480, 300, 25));
        jPanelSEMIOCUT_MAS.add(jTextField16, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 510, 300, 25));
        jPanelSEMIOCUT_MAS.add(jTextField17, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 540, 300, 25));

        jLabelFONDOSEMMAS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/orig_1050x650.jpg"))); // NOI18N
        jPanelSEMIOCUT_MAS.add(jLabelFONDOSEMMAS, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 590));

        jTabbedPaneOPCIONESCLIENTE.addTab("...", jPanelSEMIOCUT_MAS);

        jPanelMEDIDAS.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel79.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(255, 255, 255));
        jLabel79.setText("Arriba Ombligo :");
        jPanelMEDIDAS.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, 25));

        jLabel80.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(255, 255, 255));
        jLabel80.setText("Abajo Ombligo :");
        jPanelMEDIDAS.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, 25));

        jLabel81.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(255, 255, 255));
        jLabel81.setText("Brazo Derecho :");
        jPanelMEDIDAS.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, 25));

        jLabel82.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(255, 255, 255));
        jLabel82.setText("Brazo Izquierdo :");
        jPanelMEDIDAS.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, 25));
        jPanelMEDIDAS.add(jTextField18, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 300, 25));
        jPanelMEDIDAS.add(jTextField19, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 300, 25));
        jPanelMEDIDAS.add(jTextField20, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 300, 25));
        jPanelMEDIDAS.add(jTextField21, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 300, 25));
        jPanelMEDIDAS.add(jTextField22, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 300, 25));

        jLabel84.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(255, 255, 255));
        jLabel84.setText("Caderas :");
        jPanelMEDIDAS.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, 25));

        jLabel85.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(255, 255, 255));
        jLabel85.setText("Talla :");
        jPanelMEDIDAS.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, 25));

        jLabel86.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(255, 255, 255));
        jLabel86.setText("Peso :");
        jPanelMEDIDAS.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, 25));
        jPanelMEDIDAS.add(jTextField23, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 300, 25));
        jPanelMEDIDAS.add(jTextField24, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, 100, 25));

        jLabel87.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(255, 255, 255));
        jLabel87.setText("Kg.");
        jPanelMEDIDAS.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, -1, 25));

        jLabelFONDOMEDIDAS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/orig_1050x650.jpg"))); // NOI18N
        jPanelMEDIDAS.add(jLabelFONDOMEDIDAS, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 590));

        jTabbedPaneOPCIONESCLIENTE.addTab("Medidas", jPanelMEDIDAS);

        getContentPane().add(jTabbedPaneOPCIONESCLIENTE, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 1050, 610));

        jButtonATRASMENCLI.setBackground(new java.awt.Color(0, 102, 0));
        jButtonATRASMENCLI.setFont(new java.awt.Font("Consolas", 1, 11)); // NOI18N
        jButtonATRASMENCLI.setForeground(new java.awt.Color(255, 255, 255));
        jButtonATRASMENCLI.setText("Atras");
        jButtonATRASMENCLI.setPreferredSize(new java.awt.Dimension(107, 23));
        jButtonATRASMENCLI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonATRASMENCLIActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonATRASMENCLI, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 650, 120, 30));

        jButton1GUARDAR.setBackground(new java.awt.Color(0, 102, 0));
        jButton1GUARDAR.setFont(new java.awt.Font("Consolas", 1, 11)); // NOI18N
        jButton1GUARDAR.setForeground(new java.awt.Color(255, 255, 255));
        jButton1GUARDAR.setText("Guardar");
        jButton1GUARDAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1GUARDARActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1GUARDAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 650, 120, 30));

        jLabelFONDOMenCli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1100x688-green-wallpaper-hd.jpg"))); // NOI18N
        getContentPane().add(jLabelFONDOMenCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonATRASMENCLIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonATRASMENCLIActionPerformed
        Principal a = new Principal();
        a.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonATRASMENCLIActionPerformed

    private void jTextFieldNyA_INTROActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNyA_INTROActionPerformed
        
    }//GEN-LAST:event_jTextFieldNyA_INTROActionPerformed

    private void jTextFieldDOMIC_INTROActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDOMIC_INTROActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDOMIC_INTROActionPerformed

    private void jTextFieldCEL_INTROActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCEL_INTROActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCEL_INTROActionPerformed

    private void jTextFieldCORREO_INTROActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCORREO_INTROActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCORREO_INTROActionPerformed

    private void jTextFieldTENSION_INTROActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTENSION_INTROActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTENSION_INTROActionPerformed

    private void jTextFieldBT_LESIONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBT_LESIONActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldBT_LESIONActionPerformed

    private void jButton1GUARDARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1GUARDARActionPerformed
        
        String nombyap = jTextFieldNyA_INTRO.getText();
        String domicilio = jTextFieldDOMIC_INTRO.getText();
        String t_fijo = jTextFieldT_FIJO_INTRO.getText();
        String t_cel = jTextFieldCEL_INTRO.getText();
        String mail = jTextFieldCORREO_INTRO.getText();
        String profes = (String) jComboBoxPROFESION_SEL.getSelectedItem();
        String profes_lugar = jTextFieldTRAB_LUGAR_INTRO.getText();
        String dn = (String)jComboBoxDIA_NAC.getSelectedItem();
        String mn = (String)jComboBoxMES_NAC.getSelectedItem();
        String an = (String)jComboBoxYEAR_NAC.getSelectedItem();
        String medico = jTextFieldDERIV_DOC.getText();
        String alergico = (String)jbtalergia.getSelectedItem();
        String diabetico = (String)jbtdiabetes.getSelectedItem();
        String trat_dietetico = jTextFieldTRAT_DIET_INTRO.getText();
        String c_partos = (String)jComboBoxPARTOS.getSelectedItem();
        String ten_art = jTextFieldTENSION_INTRO.getText();
        String ant_hormo = jTextFieldANT_HOR_INTRO.getText();
        String tempera = jTextFieldTEMPERAMENTO_INTRO.getText();
        String inter_quir = (String)jComboBoxINTQUIRU_INTRO.getSelectedItem();
        String tabaco = (String)jbtcigarro.getSelectedItem();
        String alcohol = (String)jbtalcohol.getSelectedItem();
        String normal = (String)jComboBoxBIOT_NORMAL.getSelectedItem();
        String fluente = (String)jComboBoxBIOT_FLUENtE.getSelectedItem();
        String sensible = (String)jComboBoxBIOT_SENSIBLE.getSelectedItem();
        String seco_alpi = (String)jComboBoxBIOT_ALIPICO.getSelectedItem();
        String seco_deshi = (String)jComboBoxBIOT_DESHI.getSelectedItem();
        String xreo = (String)jComboBoxBIOT_XERO.getSelectedItem();
        String textura = (String)jComboBoxBT_TEXT.getSelectedItem();
        String color = jTextFieldBT_COLOR.getText();
        String pigme = jTextFieldBT_PIGMEN.getText();
        String Local = jTextFieldBT_LOCAL_PIG.getText();
        String cicat = jTextFieldBT_CICAT.getText();
        String Loca_cic = jTextFieldBT_LOCAL_CICA.getText();
        String Lesion = jTextFieldBT_LESION.getText();
        String De_Bioti = jTextFieldBT_PLIYARR.getText();
        String Indu_sol = jTextField1.getText();
        String parpados = (String)jComboBoxBT_LOCA_PARP.getSelectedItem();
        String peribuca = (String)jComboBoxBT_LOC_PERIBU.getSelectedItem();
        String frente = (String)jComboBoxBT_LOC_FRENTE.getSelectedItem();
        String nasoge = (String)jComboBoxBT_LOCA_NASO.getSelectedItem();
        String periauri = (String)jComboBoxBT_LOCA_PREAURI.getSelectedItem();
        String tonici = (String)jComboBoxBT_CUE_TON.getSelectedItem();
        String danio_sol = (String)jComboBoxBT_CUE_DASOL.getSelectedItem();
        String flaci = (String)jComboBoxBT_CUE_FLA.getSelectedItem();
        String cara = (String)jComboBoxBT_CARA.getSelectedItem();
        String malar = (String)jComboBoxBT_MALAR.getSelectedItem();
        String bozo = (String)jComboBoxBT_BOZO.getSelectedItem();
        String mento = (String)jComboBoxBT_MENTO.getSelectedItem();
        String se_depi = (String)jComboBoxBT_SEDEP.getSelectedItem();
        String hirsu = (String)jComboBoxBT_HIRSU.getSelectedItem();
        String hipertri = (String)jComboBoxBT_HIPER.getSelectedItem();
        String seco = (String)jComboBoxCC_SECO.getSelectedItem();
        String graso = (String)jComboBoxCC_GRAS.getSelectedItem();
        String eritema = (String)jComboBoxCC_ERIT.getSelectedItem();
        String les_eri = (String)jComboBoxCC_LESI.getSelectedItem();
        String alope = (String)jComboBoxCC_ALO.getSelectedItem();
        String tipo_alope = (String)jComboBoxCC_TIPO.getSelectedItem();
        String onico = (String)jComboBoxCC_ONI.getSelectedItem();
        String antece_onico = (String)jComboBoxCC_ANTECE.getSelectedItem();
        String descama = (String)jComboBoxCC_DESCA.getSelectedItem();
        String unias = (String)jComboBoxCC_UNIA.getSelectedItem();
        String pitiri = (String)jComboBoxCC_PITI.getSelectedItem();
        String pruri = (String)jComboBoxCC_PRUR.getSelectedItem();
        String excor = (String)jComboBoxCC_EXCO.getSelectedItem();
        String celuli = (String)jComboBox1.getSelectedItem();
        String tipo_celu = jTextField2.getText();
        String loca_celu = jTextField4.getText();
        String estrias = (String)jComboBox2.getSelectedItem();
        String loca_estri = jTextField3.getText();
        String acne_tipo_estri = jTextField5.getText();
        String tiempo_evol = jTextField6.getText();
        String ante_here_estri = jTextField7.getText();
        String lesi_elem = jTextField8.getText();
        String loca_lesi_elem = jTextField9.getText();
        String rosa_tipo = jTextField10.getText();
        String tiempo_evol_rosa = jTextField11.getText();
        String loca_rosa = jTextField12.getText();
        String ante_here_rosa = jTextField13.getText();
        String piel_sen = (String)jComboBox3.getSelectedItem();
        String querato = (String)jComboBox4.getSelectedItem();
        String elasto = (String)jComboBox5.getSelectedItem();
        String otras_alter = jTextField14.getText();
        String invol_edad = jTextField15.getText();
        String trat_dermat = jTextField16.getText();
        String trat_cosmet = jTextField17.getText();
        String arriba_ombli = jTextField18.getText();
        String abajo_ombli = jTextField19.getText();
        String braz_der = jTextField20.getText();
        String braz_izq = jTextField21.getText();
        String cade = jTextField22.getText();
        String talla = jTextField23.getText();
        String peso = jTextField24.getText();
        String t1 = "";
        String t2 = "";
        String t3 = "";
        String t4 = "";
        String t5 = "";
        String t6 = "";
        String t7 = "";
        String t8 = "";
        String t9 = "";
        String t10 = "";
        String t11 = "";
        String t12 = "";
        String t13 = "";
        String t14 = "";
        String t15 = "";
        String t16 = "";
        String t17 = "";
        String t18 = "";
        String t19 = "";
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        int p4 = 0;
        int p5 = 0;
        int p6 = 0;
        int p7 = 0;
        int p8 = 0;
        int p9 = 0;
        int p10 = 0;
        int p11 = 0;
        int p12 = 0;
        int p13 = 0;
        int p14 = 0;
        int p15 = 0;
        int p16 = 0;
        int p17 = 0;
        int p18 = 0;
        int p19 = 0;
        int d1 = 0;
        int d2 = 0;
        int d3 = 0;
        int d4 = 0;
        int d5 = 0;
        int d6 = 0;
        int d7 = 0;
        int d8 = 0;
        int d9 = 0;
        int d10 = 0;
        int d11 = 0;
        int d12 = 0;
        int d13 = 0;
        int d14 = 0;
        int d15 = 0;
        int d16 = 0;
        int d17 = 0;
        int d18 = 0;
        int d19 = 0;
        int d_TOT = 0;
        int h1 = 0;
        int h2 = 0;
        int h3 = 0;
        int h4 = 0;
        int h5 = 0;
        int h6 = 0;
        int h7 = 0;
        int h8 = 0;
        int h9 = 0;
        int h10 = 0;
        int h11 = 0;
        int h12 = 0;
        int h13 = 0;
        int h14 = 0;
        int h15 = 0;
        int h16 = 0;
        int h17 = 0;
        int h18 = 0;
        int h19 = 0;
        int h_TOT = 0;
        String fo_nomb = "null";
        
        
        AgregarCliente clase = new AgregarCliente(nombyap,domicilio,t_fijo,t_cel,mail,profes,profes_lugar, dn,
                mn, an, medico,alergico, diabetico, trat_dietetico, c_partos, ten_art, ant_hormo, tempera, inter_quir, tabaco, alcohol,normal, fluente, sensible,seco_alpi,
                       seco_deshi,  xreo,  textura,  color,  pigme,  Local,  cicat,  Loca_cic, Lesion,  De_Bioti,  Indu_sol,  parpados,  peribuca,  frente,  nasoge,
                       periauri,  tonici,  danio_sol,  flaci,  cara,  malar,  bozo,  mento,
                       se_depi,  hirsu,  hipertri,  seco,  graso,  eritema,  les_eri, alope,  tipo_alope,  onico,  antece_onico, descama, unias, pitiri,
                       pruri,  excor,  celuli,  tipo_celu,  loca_celu,  estrias,  loca_estri,
                       acne_tipo_estri,  tiempo_evol,  ante_here_estri,  lesi_elem,  loca_lesi_elem,
                       rosa_tipo,  tiempo_evol_rosa,  loca_rosa,  ante_here_rosa,  piel_sen,  querato,
                       elasto,  otras_alter,  invol_edad,  trat_dermat,  trat_cosmet,  arriba_ombli,
                       abajo_ombli,  braz_der,  braz_izq,  cade,  talla,  peso,t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16
                       ,t17,t18,t19,p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p17,p18,p19,d1,d2,d3,d4,d5,d6,d7,
                       d8,d9,d10,d11,d12,d13,d14,d15,d16,d17,d18,d19,d_TOT,h1,h2,h3,h4,h5,h6,h7,
                       h8,h9,h10,h11,h12,h13,h14,h15,h16,h17,h18,h19,h_TOT,fo_nomb);
        contenedor.add(clase);
        
        CrearReg();
        Principal a = new Principal();
        this.setVisible(false);
        a.setVisible(true);
       
    }//GEN-LAST:event_jButton1GUARDARActionPerformed

    private void jComboBoxCC_PITIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCC_PITIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxCC_PITIActionPerformed

    private void jComboBoxYEAR_NACActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxYEAR_NACActionPerformed
        
    }//GEN-LAST:event_jComboBoxYEAR_NACActionPerformed
    File ficherofoto;
    public String nombrefoto;
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
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
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBoxPARTOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPARTOSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxPARTOSActionPerformed

    private void jTextFieldDERIV_DOCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDERIV_DOCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDERIV_DOCActionPerformed

    private void jComboBoxBT_LOC_PERIBUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxBT_LOC_PERIBUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxBT_LOC_PERIBUActionPerformed

    private void jComboBoxBT_LOC_FRENTEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxBT_LOC_FRENTEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxBT_LOC_FRENTEActionPerformed

    private void jComboBoxBT_TEXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxBT_TEXTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxBT_TEXTActionPerformed

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
            java.util.logging.Logger.getLogger(AgCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new AgCliente().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane fotocliente;
    private javax.swing.JButton jButton1GUARDAR;
    public javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonATRASMENCLI;
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
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JLabel jLabelFONDOMenCli;
    private javax.swing.JLabel jLabelFONDOSEMMAS;
    private javax.swing.JLabel jLabelNyA_INFPERS;
    private javax.swing.JPanel jPanelANTECEDE;
    private javax.swing.JPanel jPanelINFOPERS;
    private javax.swing.JPanel jPanelMEDIDAS;
    private javax.swing.JPanel jPanelSEMIOCUT;
    private javax.swing.JPanel jPanelSEMIOCUT_MAS;
    private javax.swing.JTabbedPane jTabbedPaneOPCIONESCLIENTE;
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
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField jTextFieldANT_HOR_INTRO;
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
    private javax.swing.JTextField jTextFieldNyA_INTRO;
    private javax.swing.JTextField jTextFieldTEMPERAMENTO_INTRO;
    private javax.swing.JTextField jTextFieldTENSION_INTRO;
    private javax.swing.JTextField jTextFieldTRAB_LUGAR_INTRO;
    private javax.swing.JTextField jTextFieldTRAT_DIET_INTRO;
    private javax.swing.JTextField jTextFieldT_FIJO_INTRO;
    private javax.swing.JComboBox<String> jbtalcohol;
    private javax.swing.JComboBox<String> jbtalergia;
    private javax.swing.JComboBox<String> jbtcigarro;
    private javax.swing.JComboBox<String> jbtdiabetes;
    // End of variables declaration//GEN-END:variables

}
