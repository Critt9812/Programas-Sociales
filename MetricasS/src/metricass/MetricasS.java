package metricass;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.io.File;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
import java.time.LocalDate;
import java.time.Period;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class MetricasS implements ActionListener {
    public Connection connection;
    JPanel panelP, panelR, panelPM, panelMod, panelIS, panelRPS;
    JFrame ventana;
    JLabel textoP, tituloIS, usuarioT, contrasenaT, nombreRL, correoRL, contrasenaRL, confirmacionRL,
            nombreRPS, apellidoPRPS, apellidoMRPS, fechaNRPS, paisRPS, estadoRPS, municipioRPS, fraccionamientoRPS, calleRPS, numeroIntRPS, numeroExtRPS, codigoPRPS,
            CURPRPS, claveERPS, OCRRPS, vgenciaIneRPS, ineAnvRPS, ineRevRPS, correoERPS;
    JButton iniciar, iniciarS, registrate, registrar, regresarR, registrarPM, actualizarPM, eliminarPM, visualizarPM, registrarRPS, regresarRPS, ineAnvRPSB, ineRevRPSB,
            actualizarD;
    Font fontTP, fontTIS;
    JTextField usuarioTF, contrasenaTF, nombreRT, correoRT, contrasenaRT, confirmacionRT, nombreRPST, apellidoPRPST, apellidoMRPST, fechaNRPST, paisRPST, estadoRPST,
            municipioRPST, fraccionamientoRPST, calleRPST, numeroIntRPST, numeroExtRPST, codigoPRPST,
            CURPRPST, claveERPST, OCRRPST, vigenciaIneRPST, correoERPST, contrasenaRPST;  
    String anv, rev, curpPe, curpE;
    String input, continua;
    boolean valida=false;
    
    
    public void Interfaz(){
        ventana = new JFrame();
        ventana.setTitle("Programa");
        ventana.setSize(800, 600);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Modulos();
        ventana.setVisible(true);
    }
    
    public void Modulos(){
        Principal();
    }
    
    public void Principal(){
        panelP = new JPanel();
        panelP.setLayout(null);
        panelP.setBackground(Color.WHITE);
        ventana.getContentPane().add(panelP);
        ElementosP();
    }
    
    public void ElementosP(){
        textoP = new JLabel();
        textoP.setText("BENEFICIOS SOCIALES");
        fontTP = new Font("Serif", Font.BOLD, 50);
        textoP.setBounds(100, 200, 600, 100);
        textoP.setFont(fontTP);
        panelP.add(textoP);
        
        iniciar = new JButton();
        iniciar.setText("Iniciar sesión");
        iniciar.setBounds(325, 330, 150, 50);
        iniciar.addActionListener(this);
        panelP.add(iniciar);
    }
    
    public void LogIn(){
        panelIS = new JPanel();
        panelIS.setLayout(null);
        panelIS.setBackground(Color.WHITE);
        ventana.getContentPane().add(panelIS);
        ElementosLogIn();
    }
    
    public void ElementosLogIn(){
        tituloIS = new JLabel();
        tituloIS.setText("Inicia sesión");
        tituloIS.setBounds(300, 160, 200, 30);
        fontTIS = new Font("Serif", Font.BOLD, 30);
        tituloIS.setHorizontalAlignment(SwingConstants.CENTER);
        tituloIS.setFont(fontTIS);
        panelIS.add(tituloIS);
        
        usuarioT = new JLabel();
        usuarioT.setText("Usuario");
        usuarioT.setBounds(310, 200, 200, 30);
        panelIS.add(usuarioT);
        
        contrasenaT = new JLabel();
        contrasenaT.setText("Contraseña");
        contrasenaT.setBounds(310, 260, 200, 30);
        panelIS.add(contrasenaT);
        
        usuarioTF = new JTextField();
        usuarioTF.setBounds(300, 230, 200, 30);
        panelIS.add(usuarioTF);
        
        contrasenaTF = new JTextField();
        contrasenaTF.setBounds(300, 290, 200, 30);
        panelIS.add(contrasenaTF);
        
        iniciarS = new JButton();
        iniciarS.setText("Iniciar");
        iniciarS.setForeground(Color.BLACK);
        iniciarS.setBackground(Color.GREEN);
        iniciarS.setBounds(300, 345, 200, 30);
        iniciarS.addActionListener(this);
        panelIS.add(iniciarS);
        
        registrate = new JButton();
        registrate.setText("Regístrate");
        registrate.setBounds(400, 325, 100, 15);
        registrate.setBackground(Color.WHITE);
        panelIS.add(registrate);
        registrate.addActionListener(this);
        registrate.setBorderPainted(false);
        
        ((AbstractDocument) contrasenaTF.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                // Reemplazar el texto por "*" (caracter de ocultamiento)
                super.replace(fb, offset, length, text.replaceAll(".", "*"), attrs);
            }
        });
        
        ventana.revalidate();
        ventana.repaint();
    }
    
    public void Registrarse(){
        panelR = new JPanel();
        panelR.setLayout(null);
        panelR.setBackground(Color.WHITE);
        ventana.getContentPane().add(panelR); 
        ElementosR();
    }
    
    public void ElementosR(){
        nombreRL = new JLabel();
        nombreRL.setText("Nombre");
        nombreRL.setBounds(200, 110, 400, 30);
        panelR.add(nombreRL);

        nombreRT = new JTextField();
        nombreRT.setBounds(200, 145, 400, 30);
        panelR.add(nombreRT);
        
        correoRL = new JLabel();
        correoRL.setText("Correo");
        correoRL.setBounds(200, 180, 400, 30);
        panelR.add(correoRL);
                
        correoRT = new JTextField();
        correoRT.setBounds(200, 215, 400, 30);
        panelR.add(correoRT);
        
        contrasenaRL = new JLabel();
        contrasenaRL.setText("Contraseña");
        contrasenaRL.setBounds(200, 250, 400, 30);
        panelR.add(contrasenaRL);
        
        contrasenaRT = new JTextField();
        contrasenaRT.setBounds(200, 280, 400, 30);
        panelR.add(contrasenaRT);
        
        confirmacionRL = new JLabel();
        confirmacionRL.setText("Confirmar contraseña");
        confirmacionRL.setBounds(200, 315, 400, 30);
        panelR.add(confirmacionRL);
        
        confirmacionRT = new JTextField();
        confirmacionRT.setBounds(200, 350, 400, 30);
        panelR.add(confirmacionRT);
        
        registrar = new JButton();
        registrar.setText("Registrar");
        registrar.setBounds(430, 390, 100, 30);
        registrar.setForeground(Color.BLACK);
        registrar.setBackground(Color.GREEN);
        registrar.addActionListener(this);
        panelR.add(registrar);
        
        regresarR = new JButton();
        regresarR.setText("Regresar");
        regresarR.setForeground(Color.WHITE);
        regresarR.setBackground(Color.RED);
        regresarR.setBounds(280, 390, 100, 30);
        regresarR.addActionListener(this);
        panelR.add(regresarR);
        
        ((AbstractDocument) nombreRT.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                String newStr = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
                if (newStr.matches("[a-zA-Z\\s]*")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
        
        ((AbstractDocument) contrasenaRT.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                // Reemplazar el texto por "*" (caracter de ocultamiento)
                super.replace(fb, offset, length, text.replaceAll(".", "*"), attrs);
            }
        });
        
        ((AbstractDocument) confirmacionRT.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                // Reemplazar el texto por "*" (caracter de ocultamiento)
                super.replace(fb, offset, length, text.replaceAll(".", "*"), attrs);
            }
        });
        
        ventana.revalidate();
        ventana.repaint();
        
    }
    
    public void principalM(){
        panelPM = new JPanel();
        panelPM.setLayout(null);
        panelPM.setBackground(Color.WHITE);
        ventana.getContentPane().add(panelPM);
        componentesPM();
    }
    
    public void componentesPM(){
        registrarPM = new JButton();
        registrarPM.setText("Registrarse");
        registrarPM.setBounds(300,200,200,30);
        registrarPM.addActionListener(this);
        panelPM.add(registrarPM);
        
        actualizarPM = new JButton();
        actualizarPM.setText("Actualizar registro");
        actualizarPM.setBounds(300,240,200,30);
        actualizarPM.addActionListener(this);
        panelPM.add(actualizarPM);
        
        eliminarPM = new JButton();
        eliminarPM.setText("Eliminar registro");
        eliminarPM.setBounds(300,280,200,30);
        eliminarPM.addActionListener(this);
        panelPM.add(eliminarPM);
        
        visualizarPM = new JButton();
        visualizarPM.setText("Ver registro");
        visualizarPM.setBounds(300,320,200,30);
        visualizarPM.addActionListener(this);
        panelPM.add(visualizarPM);
        
        ventana.revalidate();
        ventana.repaint();
    }
    
    public void registroPS(){
        panelRPS = new JPanel();
        panelRPS.setLayout(null);
        panelRPS.setBackground(Color.WHITE);
        ventana.getContentPane().add(panelRPS);
        componentesRPS();
    }
    
    public void componentesRPS(){
        nombreRPS = new JLabel();
        nombreRPS.setText("Nombre");
        nombreRPS.setBounds(80,20,200,30);
        panelRPS.add(nombreRPS);
        
        nombreRPST = new JTextField();
        nombreRPST.setBounds(80,55,200,30);
        panelRPS.add(nombreRPST);
        
        apellidoPRPS = new JLabel();
        apellidoPRPS.setText("Apellido paterno");
        apellidoPRPS.setBounds(300,20,200,30);
        panelRPS.add(apellidoPRPS);
        
        apellidoPRPST = new JTextField();
        apellidoPRPST.setBounds(300,55,200,30);
        panelRPS.add(apellidoPRPST);
        
        apellidoMRPS = new JLabel();
        apellidoMRPS.setText("Apellido materno");
        apellidoMRPS.setBounds(520,20,200,30);
        panelRPS.add(apellidoMRPS);
        
        apellidoMRPST = new JTextField();
        apellidoMRPST.setBounds(520,55,200,30);
        panelRPS.add(apellidoMRPST);
        
        fechaNRPS = new JLabel();
        fechaNRPS.setText("Fecha de nacimiento");
        fechaNRPS.setBounds(80,90,200,30);
        panelRPS.add(fechaNRPS);
        
        fechaNRPST = new JTextField();
        fechaNRPST.setBounds(80,125,200,30);
        panelRPS.add(fechaNRPST);
        
        paisRPS = new JLabel();
        paisRPS.setText("Pais");
        paisRPS.setBounds(80,160,200,30);
        panelRPS.add(paisRPS);
        
        paisRPST = new JTextField();
        paisRPST.setBounds(80,195,200,30);
        panelRPS.add(paisRPST);
        
        estadoRPS = new JLabel();
        estadoRPS.setText("Estado");
        estadoRPS.setBounds(300,160,200,30);
        panelRPS.add(estadoRPS);
        
        estadoRPST = new JTextField();
        estadoRPST.setBounds(300,195,200,30);
        panelRPS.add(estadoRPST);
        
        municipioRPS = new JLabel();
        municipioRPS.setText("Municipio");
        municipioRPS.setBounds(520,160,200,30);
        panelRPS.add(municipioRPS);
        
        municipioRPST = new JTextField();
        municipioRPST.setBounds(520,195,200,30);
        panelRPS.add(municipioRPST);
        
        fraccionamientoRPS = new JLabel();
        fraccionamientoRPS.setText("Fraccionamiento");
        fraccionamientoRPS.setBounds(80,230,200,30);
        panelRPS.add(fraccionamientoRPS);
        
        fraccionamientoRPST = new JTextField();
        fraccionamientoRPST.setBounds(80,265,200,30);
        panelRPS.add(fraccionamientoRPST);
        
        calleRPS = new JLabel();
        calleRPS.setText("Calle");
        calleRPS.setBounds(300,230,200,30);
        panelRPS.add(calleRPS);
        
        calleRPST = new JTextField();
        calleRPST.setBounds(300,265,200,30);
        panelRPS.add(calleRPST);
        
        numeroIntRPS = new JLabel();
        numeroIntRPS.setText("Numero interior");
        numeroIntRPS.setBounds(520,230,200,30);
        panelRPS.add(numeroIntRPS);
        
        numeroIntRPST = new JTextField();
        numeroIntRPST.setBounds(520,265,200,30);
        panelRPS.add(numeroIntRPST);
        
        codigoPRPS = new JLabel();
        codigoPRPS.setText("Codigo postal");
        codigoPRPS.setBounds(80,300,200,30);
        panelRPS.add(codigoPRPS);
        
        codigoPRPST = new JTextField();
        codigoPRPST.setBounds(80,335,200,30);
        panelRPS.add(codigoPRPST);
        
        correoERPS = new JLabel();
        correoERPS.setText("Correo electronico");
        correoERPS.setBounds(300,300,200,30);
        panelRPS.add(correoERPS);
        
        correoERPST = new JTextField();
        correoERPST.setBounds(300,335,200,30);
        panelRPS.add(correoERPST);
                
        CURPRPS = new JLabel();
        CURPRPS.setText("CURP");
        CURPRPS.setBounds(80,370,200,30);
        panelRPS.add(CURPRPS);
        
        CURPRPST = new JTextField();
        CURPRPST.setBounds(80,405,200,30);
        panelRPS.add(CURPRPST);
        
        claveERPS = new JLabel();
        claveERPS.setText("Clave del elector");
        claveERPS.setBounds(300,370,200,30);
        panelRPS.add(claveERPS);
        
        claveERPST = new JTextField();
        claveERPST.setBounds(300,405,200,30);
        panelRPS.add(claveERPST);
        
        OCRRPS = new JLabel();
        OCRRPS.setText("OCR");
        OCRRPS.setBounds(520,370,200,30);
        panelRPS.add(OCRRPS);
        
        OCRRPST = new JTextField();
        OCRRPST.setBounds(520,405,200,30);
        panelRPS.add(OCRRPST);
        
        ineAnvRPS = new JLabel();
        ineAnvRPS.setText("INE anverso");
        ineAnvRPS.setBounds(80,440,200,30);
        panelRPS.add(ineAnvRPS);
        
        ineAnvRPSB = new JButton();
        ineAnvRPSB.setText("AGREGAR");
        ineAnvRPSB.setBounds(80,475,100,30);
        ineAnvRPSB.addActionListener(this);
        panelRPS.add(ineAnvRPSB);
        
        ineRevRPS = new JLabel();
        ineRevRPS.setText("INE reverso");
        ineRevRPS.setBounds(300,440,200,30);
        panelRPS.add(ineRevRPS);
        
        ineRevRPSB = new JButton();
        ineRevRPSB.setText("AGREGAR");
        ineRevRPSB.setBounds(300,475,100,30);
        ineRevRPSB.addActionListener(this);
        panelRPS.add(ineRevRPSB);
        
        regresarRPS = new JButton();
        regresarRPS.setText("Regresar");
        regresarRPS.setBounds(480,475,100,30);
        regresarRPS.setForeground(Color.WHITE);
        regresarRPS.setBackground(Color.RED);
        regresarRPS.addActionListener(this);
        panelRPS.add(regresarRPS);
        
        Timer timer = new Timer(100, null); // Nuevo temporizador con un retraso de 100 ms

        fechaNRPST.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                startTimer();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                startTimer();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                startTimer();
            }

            private void startTimer() {
                // Reiniciar el temporizador para evitar la acumulación de eventos
                timer.restart();
            }
        });

        // ActionListener para el temporizador
        timer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el texto actual
                String text = fechaNRPST.getText();
                // Eliminar cualquier carácter que no sea dígito
                text = text.replaceAll("[^\\d]", "");
                // Verificar si la longitud es mayor o igual a 4 y 7 antes de agregar guiones
                if (text.length() >= 4 && text.charAt(3) != '-') {
                    text = text.substring(0, 4) + "-" + text.substring(4);
                }
                if (text.length() >= 7 && text.charAt(6) != '-') {
                    text = text.substring(0, 7) + "-" + text.substring(7);
                }
                // Actualizar el texto en el JTextField
                fechaNRPST.setText(text);
            }
        });
        
        ((AbstractDocument) nombreRPST.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                String newStr = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
                if (newStr.matches("[a-zA-Z\\s]*")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
        
        ((AbstractDocument) apellidoPRPST.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                String newStr = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
                if (newStr.matches("[a-zA-Z\\s]*")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
        
        ((AbstractDocument) apellidoMRPST.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                String newStr = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
                if (newStr.matches("[a-zA-Z\\s]*")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
        
        
        
        ((AbstractDocument) codigoPRPST.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                String newStr = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
                if (newStr.matches("\\d*") && newStr.length() <= 5) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
        
        ((AbstractDocument) CURPRPST.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                String newStr = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
                if (newStr.length() <= 18) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
        
        ((AbstractDocument) claveERPST.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                String newStr = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
                if (newStr.length() <= 18) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
        
        ((AbstractDocument) OCRRPST.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                String newStr = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
                if (newStr.matches("\\d*") && newStr.length() <= 13) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });

        ventana.revalidate();
        ventana.repaint();
    }
    
    
   public void validarNombre(){
        input = nombreRPST.getText();
        if (input.matches("[a-zA-ZñÑáéíóúÁÉÍÓÚ\\s]+")) {
            validarApellidoP();
        } else {
            JOptionPane.showMessageDialog(null, "El nombre no puede contener números ni símbolos. Intente de nuevo.");
        }
   }
   
   public void validarApellidoP(){
        input = apellidoPRPST.getText();
        if (input.matches("[a-zA-ZñÑáéíóúÁÉÍÓÚ\\s]+")) {
            validarApellidoM();
        } else {
            JOptionPane.showMessageDialog(null, "El apellido paterno no puede contener números ni símbolos. Intente de nuevo.");
        }
   }
   
   public void validarApellidoM(){
       input = apellidoMRPST.getText();
       if (input.matches("[a-zA-ZñÑáéíóúÁÉÍÓÚ\\s]+")) {
        //conexion();
        //agregarBeneficiario();
        //principalM();
        validarFechaN();
        } else {
            JOptionPane.showMessageDialog(null, "El apellido materno no puede contener números ni símbolos. Intente de nuevo.");
        }
   }
   
    public void validarFechaN(){
        String fechaTexto = fechaNRPST.getText();
        LocalDate fechaIngresada = LocalDate.parse(fechaTexto);

        LocalDate fechaActual = LocalDate.now();
        Period edad = Period.between(fechaIngresada, fechaActual);

        if (edad.getYears() >= 18) {
            validarPais();
        } else {
            JOptionPane.showMessageDialog(null, "La fecha ingresada no es válida. El usuario debe tener al menos 18 años.");
        }
    }
    
    public void validarPais(){
        input = paisRPST.getText();
        if (input.matches("[a-zA-ZñÑáéíóúÁÉÍÓÚ\\s]+")) {
            validarEstado();
        } else {
            JOptionPane.showMessageDialog(null, "El pais no puede contener números ni símbolos. Intente de nuevo.");
        }
    }
    
    public void validarEstado(){
       input = estadoRPST.getText();
       if (input.matches("[a-zA-ZñÑáéíóúÁÉÍÓÚ\\s]+")) {
           validarMunicipio();
       } else {
            JOptionPane.showMessageDialog(null, "El Estado no puede contener números ni símbolos. Intente de nuevo.");
        }
    }
    
    public void validarMunicipio(){
        input = municipioRPST.getText();
        if (input.matches("[a-zA-ZñÑáéíóúÁÉÍÓÚ\\s]+")) {
            validarCodigoP();
        } else {
            JOptionPane.showMessageDialog(null, "El municipio no puede contener números ni símbolos. Intente de nuevo.");
        }
    }
    
    public void validarCodigoP(){
       String codigoPostal = codigoPRPST.getText();        
        // Verificar si el código postal tiene exactamente cinco dígitos
        if (codigoPostal.matches("\\d{5}")) {
            validarCurp();
        } else {
            JOptionPane.showMessageDialog(null, "El código postal debe tener exactamente cinco dígitos.");
       }
    }
    
    public void validarCurp(){
        String curp = CURPRPST.getText();        
        // Verificar si el CURP tiene exactamente 18 caracteres
        if (curp.length() == 18) {
            validarClaveE();
        } else {
            JOptionPane.showMessageDialog(null, "El CURP debe tener exactamente 18 caracteres.");
        }
    }
    
    
    public void validarClaveE(){
        String elec = claveERPST.getText();        
        // Verificar si el CURP tiene exactamente 18 caracteres
        if (elec.length() == 18) {
            validarOCR();
        } else {
            JOptionPane.showMessageDialog(null, "La clave de elctor debe tener exactamente 18 caracteres.");
        }
    }
    
    public void validarOCR(){
        String ocr = OCRRPST.getText();        
        // Verificar si el CURP tiene exactamente 18 caracteres
        if (ocr.length() == 12 || ocr.length() == 13) {
            validarCorreoE();
        } else {
            JOptionPane.showMessageDialog(null, "El OCR debe tener exactamente 18 caracteres.");
        }
    }
    
    public boolean validarUsuario() {
        boolean valido = false;
        try {
        String sql = "SELECT correo, contrasena FROM Registro WHERE correo = ? AND contrasena = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, usuarioTF.getText());
        statement.setString(2, contrasenaTF.getText());
        try (ResultSet resultSet = statement.executeQuery()) {
            valido = resultSet.next(); // Si hay un resultado, el usuario es válido
        }
        
        } catch (SQLException e) {
            System.err.println("Error al registrarse: " + e.getMessage());
        }
        return valido;
    }
    
    public void regi(){
        try {
        String sql = "INSERT INTO Registro (nombreR, correo, contrasena) VALUES ( ?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, nombreRT.getText());
        statement.setString(2, correoRT.getText());
        statement.setString(3, contrasenaRT.getText());
        
        
        statement.executeUpdate();
        System.out.println("Registro guardado");
        JOptionPane.showMessageDialog(ventana, "Registro guardado.");
        ventana.getContentPane().removeAll();
            ventana.revalidate();
            ventana.repaint();
            LogIn();
            ventana.revalidate();
            ventana.repaint();
    } catch (SQLException e) {
        System.err.println("Error al registrarse: " + e.getMessage());
    }
    }
    
    public void validacionR(){
        if(confirmacionRT.getText().equals(contrasenaRT.getText())){
            conexion();
            regi(); 
        }else{
            JOptionPane.showMessageDialog(ventana, "Las contraseñas no coinsiden.");
        }
    }
    
    public void validarCorreoRT(){
        String correo = correoRT.getText();
        // Verificar si el correo electrónico coincide con el formato básico y el dominio válido
        if (correo.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$") && correo.contains("@gmail.com") || correo.contains("@hotmail.com") || correo.contains("@yahoo.com") || correo.contains("@outlook.com")) {
            validacionR();
        } else {
            JOptionPane.showMessageDialog(ventana, "El correo electrónico no es válido. Por favor, ingrese un correo válido.");
        }
    }
    
    public void validarCorreoE(){
        String correo = correoERPST.getText();
        // Verificar si el correo electrónico coincide con el formato básico y el dominio válido
        if (correo.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$") && correo.contains("@gmail.com") || correo.contains("@hotmail.com") || correo.contains("@yahoo.com") || correo.contains("@outlook.com")) {
            conexion();
            agregarBeneficiario();
            JOptionPane.showMessageDialog(ventana, "Registro guardado");
            ventana.getContentPane().removeAll();
            ventana.revalidate();
            ventana.repaint();
            principalM();
            ventana.revalidate();
            ventana.repaint();
        } else {
            JOptionPane.showMessageDialog(ventana, "El correo electrónico no es válido. Por favor, ingrese un correo válido.");
        }
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==iniciar){
        ventana.getContentPane().removeAll();
        ventana.revalidate();
        ventana.repaint();
        LogIn();
      }
      else if(e.getSource()==registrate){
        ventana.getContentPane().removeAll();
        ventana.revalidate();
        ventana.repaint();
        Registrarse();
      }
      else if(e.getSource()==regresarR){
        ventana.getContentPane().removeAll();
        ventana.revalidate();
        ventana.repaint();
        LogIn();
      }
      else if(e.getSource()==registrar){
        validarCorreoRT();
      }
      else if(e.getSource()==iniciarS){
        conexion();
        valida = validarUsuario();
        if(valida){
            continua = usuarioTF.getText();
            ventana.getContentPane().removeAll();
            ventana.revalidate();
            ventana.repaint();
            principalM();
            
        }else{
            JOptionPane.showMessageDialog(ventana, "Usuario o contraseña no validos");
        }
        
      }
      else if(e.getSource()==registrarPM){
        ventana.getContentPane().removeAll();
        ventana.revalidate();
        ventana.repaint();
        
        registroPS();
        registrarRPS = new JButton();
        registrarRPS.setText("Registrar");
        registrarRPS.setBounds(620,475,100,30);
        registrarRPS.setForeground(Color.BLACK);
        registrarRPS.setBackground(Color.GREEN);
        registrarRPS.addActionListener(this);
        panelRPS.add(registrarRPS);
        ventana.revalidate();
        ventana.repaint();
      }
      else if(e.getSource()==regresarRPS){
        ventana.getContentPane().removeAll();
        ventana.revalidate();
        ventana.repaint();
        principalM();
      }
      else if(e.getSource()==registrarRPS){
        validarNombre();
        
      }
      else if (e.getSource()==ineAnvRPSB){
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(null);
            
            if (result == JFileChooser.APPROVE_OPTION) {
                    anv = fileChooser.getSelectedFile().getAbsolutePath();
                    File selectedFile = fileChooser.getSelectedFile();
                    String fileName = selectedFile.getName();
                    String extension = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
                    
                    // Comprobar si la extensión es una imagen o un PDF
                    if (extension.equals("jpg") || extension.equals("jpeg") || extension.equals("png") ||
                        extension.equals("gif") || extension.equals("bmp") || extension.equals("pdf")) {
                        JOptionPane.showMessageDialog(ventana, "Archivo válido: " + selectedFile.getAbsolutePath());
                    } else {
                        JOptionPane.showMessageDialog(ventana, "\"Archivo no válido. Selecciona una imagen (jpg, jpeg, png, gif, bmp) o un PDF.");
                    }
                }
        }
        else if (e.getSource()==ineRevRPSB){
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                    rev = fileChooser.getSelectedFile().getAbsolutePath();
                    File selectedFile = fileChooser.getSelectedFile();
                    String fileName = selectedFile.getName();
                    String extension = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
                    
                    // Comprobar si la extensión es una imagen o un PDF
                    if (extension.equals("jpg") || extension.equals("jpeg") || extension.equals("png") ||
                        extension.equals("gif") || extension.equals("bmp") || extension.equals("pdf")) {
                        JOptionPane.showMessageDialog(ventana, "Archivo válido: " + selectedFile.getAbsolutePath());
                    } else {
                        JOptionPane.showMessageDialog(ventana, "\"Archivo no válido. Selecciona una imagen (jpg, jpeg, png, gif, bmp) o un PDF.");
                    }
                }
        }
        else if(e.getSource()==actualizarPM){
            curpPe = JOptionPane.showInputDialog(null, "Por favor, ingresa tu CURP:");
            conexion();
            ventana.getContentPane().removeAll();
            ventana.revalidate();
            ventana.repaint();
            
            registroPS();
            actualizarD = new JButton();
            actualizarD.setText("Actualizar");
            actualizarD.setBounds(620,475,100,30);
            actualizarD.setForeground(Color.BLACK);
            actualizarD.setBackground(Color.GREEN);
            actualizarD.addActionListener(this);
            panelRPS.add(actualizarD);
            leer();
            
            ventana.revalidate();
            ventana.repaint();
        }
        else if(e.getSource()==actualizarD){
            conexion();
            actualizar();
        }
        else if(e.getSource()==eliminarPM){
            conexion();
            curpE = JOptionPane.showInputDialog(null, "Por favor, ingresa tu CURP:");
            eliminar();
        }
        else if(e.getSource()==visualizarPM){
            curpPe = JOptionPane.showInputDialog(null, "Por favor, ingresa tu CURP:");
            conexion();
            ventana.getContentPane().removeAll();
            ventana.revalidate();
            ventana.repaint();
            registroPS();
            leer();
            ventana.revalidate();
            ventana.repaint();
            
        }
    }
    
    public void agregarBeneficiario() {  
        // Método para agregar un beneficiario a la base de datos
        try {
        String sql = "INSERT INTO Beneficiarios (nombre, apellidoP, apellidoM, fecha_nacimiento, pais, estado, municipio, fraccionamiento,calle, numeroInt, codigo_postal, curp, clave_elector, ocr, ineAnv, ineRev, correoE,correo1) VALUES ( ?,?,?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, nombreRPST.getText());
        statement.setString(2, apellidoPRPST.getText());
        statement.setString(3, apellidoMRPST.getText());
        statement.setString(4,(fechaNRPST.getText()));
        statement.setString(5, paisRPST.getText());
        statement.setString(6, estadoRPST.getText());
        statement.setString(7, municipioRPST.getText());
        statement.setString(8, fraccionamientoRPST.getText());
        statement.setString(9, calleRPST.getText());
        statement.setString(10, numeroIntRPST.getText());
        statement.setString(11, codigoPRPST.getText());
        statement.setString(12, CURPRPST.getText());
        statement.setString(13, claveERPST.getText());
        statement.setString(14, OCRRPST.getText());
        statement.setString(15, anv);
        statement.setString(16, rev);
        statement.setString(17, correoERPST.getText());
        statement.setString(18, continua);
        
        statement.executeUpdate();
        System.out.println("Beneficiario agregado correctamente.");
    } catch (SQLException e) {
        System.err.println("Error al agregar beneficiario: " + e.getMessage());
    }
    }
    
    public void conexion(){
        // Método para establecer la conexión a la base de datos
        try{
            connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/ProgramaS", "root", "");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void leer(){
        // Método para leer datos de la base de datos
        try {
        // Consulta SQL para seleccionar datos de un beneficiario por CURP
        String sql = "SELECT * FROM Beneficiarios WHERE curp = ?";
        
        // Crear una declaración preparada
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, curpPe);
        
        ResultSet resultSet = statement.executeQuery();
        
        
        if (resultSet.next()) {
            nombreRPST.setText(resultSet.getString("nombre"));
            apellidoPRPST.setText(resultSet.getString("apellidoP"));
            apellidoMRPST.setText(resultSet.getString("apellidoM"));
            fechaNRPST.setText(resultSet.getString("fecha_nacimiento"));
            paisRPST.setText(resultSet.getString("pais"));
            estadoRPST.setText(resultSet.getString("estado"));
            municipioRPST.setText(resultSet.getString("municipio"));
            fraccionamientoRPST.setText(resultSet.getString("fraccionamiento"));
            calleRPST.setText(resultSet.getString("calle"));
            numeroIntRPST.setText(resultSet.getString("numeroInt"));
            codigoPRPST.setText(resultSet.getString("codigo_postal"));
            CURPRPST.setText(resultSet.getString("curp"));
            claveERPST.setText(resultSet.getString("clave_elector"));
            OCRRPST.setText(resultSet.getString("ocr"));
            correoERPST.setText(resultSet.getString("correoE"));
            
            } else {
              System.out.println("No se encontró ningún beneficiario con el CURP proporcionado.");
        }
        
        // Cerrar los recursos (ResultSet, PreparedStatement)
        resultSet.close();
        statement.close();
    } catch (SQLException e) {
        // Manejar cualquier excepción de SQL
        e.printStackTrace();
    }
    }
    
    public void actualizar(){
        // Método para actualizar datos en la base de datos
        try {
        // Consulta SQL para actualizar datos de un beneficiario por CURP
        String sql = "UPDATE Beneficiarios SET nombre = ?, apellidoP = ?, apellidoM = ?, fecha_nacimiento = ?, pais = ?, estado = ?, municipio = ?, fraccionamiento = ?, calle = ?, numeroInt = ?, codigo_postal = ?, curp = ?, clave_elector = ?, ocr = ?, ineAnv = ?, ineRev = ?, correoE = ? WHERE curp = ?";

        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setString(1, nombreRPST.getText());
        statement.setString(2, apellidoPRPST.getText());
        statement.setString(3, apellidoMRPST.getText());
        statement.setString(4,(fechaNRPST.getText()));
        statement.setString(5, paisRPST.getText());
        statement.setString(6, estadoRPST.getText());
        statement.setString(7, municipioRPST.getText());
        statement.setString(8, fraccionamientoRPST.getText());
        statement.setString(9, calleRPST.getText());
        statement.setString(10, numeroIntRPST.getText());
        statement.setString(11, codigoPRPST.getText());
        statement.setString(12, CURPRPST.getText());
        statement.setString(13, claveERPST.getText());
        statement.setString(14, OCRRPST.getText());
        statement.setString(15, anv);
        statement.setString(16, rev);
        statement.setString(17, correoERPST.getText());
        statement.setString(18, curpPe);
        
        int filasActualizadas = statement.executeUpdate();
        
        // Verificar si se actualizó correctamente al menos una fila
        if (filasActualizadas > 0) {
            System.out.println("Registro actualizado correctamente.");
             JOptionPane.showMessageDialog(null, "Actualizacion exitosa");
            // Puedes agregar más lógica aquí si necesitas realizar más acciones después de la actualización
        } else {
             JOptionPane.showMessageDialog(null, "Error al actualizar los datos.");
            // Puedes mostrar un mensaje o realizar alguna acción adicional si la actualización no afectó ninguna fila
        }
        
        // Cerrar el recurso (PreparedStatement)
        statement.close();
    } catch (SQLException e) {
        // Manejar cualquier excepción de SQL
        e.printStackTrace();
    }
    }
    
    
    // Método para validar correo electrónico usando expresiones regulares
    public boolean validarCorreo(String correo) {
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(correo);
        return matcher.matches();
    }

    // Método para validar que el nombre no contenga números
    public boolean validarNombre(String nombre) {
        return !nombre.matches(".*\\d.*");
    }

    // Método para validar el tamaño de una cadena
    public boolean validarTamaño(String cadena, int tamaño) {
        return cadena.length() == tamaño;
    }
    
    public void eliminar(){
        // Método para eliminar datos de la base de datos
        try {
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM Beneficiarios WHERE curp = ?");
            stmt.setString(1, curpE);
            int filasEliminadas = stmt.executeUpdate();
    
            if (filasEliminadas > 0) {
                JOptionPane.showMessageDialog(null, "Se eliminó el registro con CURP: " + curpE);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningún registro con el CURP: " + curpE);
            
            }
        } catch (SQLException e) {
            System.err.println("Error al intentar eliminar el registro: " + e.getMessage());
        e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        MetricasS m = new MetricasS();
        m.Interfaz();
    }
}
