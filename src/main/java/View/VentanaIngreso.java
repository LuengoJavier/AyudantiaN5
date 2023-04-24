package View;

import controller.RegistroController;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class VentanaIngreso extends Ventana {
    private JLabel textoEncabezado, textoRut, textoNombre, textoContraseña;
    private JTextField campoNombre;
    private JButton botonRegistrar, botonCancelar, botonIngresar;
    private JPasswordField campoContraseña;
    private RegistroController registroController;


    public VentanaIngreso(RegistroController registroController){
        super("Login", 450, 250);
        this.registroController = registroController;
        generarElementosVentana();
    }
    private void generarElementosVentana() {
        generarEncabezado();
        generarCampoNombre();
        generarCampoContraseña();
        generarBotonCancelar();
        generarBotonRegistrar();
        generarBotonIngresar();


    }
    private void generarEncabezado() {
        String textoCabecera = "¡Bienvenido!\n Ingresa a tu cuenta o registrate";
        super.generarJLabelEncabezado(this.textoEncabezado, textoCabecera, 20, 10, 400, 40);
    }
    private void generarBotonIngresar(){
        String textoBoton = "Ingresar";
        this.botonIngresar = super.generarBoton(textoBoton, 40,150,100,40);
        this.add(this.botonIngresar);
        this.botonIngresar.addActionListener(this);
    }
    private void generarBotonRegistrar() {
        String textoBoton= "Registrarse";
        this.botonRegistrar = super.generarBoton(textoBoton, 300, 150, 100, 40);
        this.add(this.botonRegistrar);
        this.botonRegistrar.addActionListener(this);
    }
    private void generarBotonCancelar() {
        String textoBotonCancelar = "Cancelar";
        this.botonCancelar = super.generarBoton(textoBotonCancelar, 175, 160, 100, 20);
        this.add(this.botonCancelar);
        this.botonCancelar.addActionListener(this);
    }
    private void generarCampoNombre(){
        String textoNombre= "Nombre:";
        super.generarJLabel(this.textoNombre,textoNombre,60,70,80,20);
        this.campoNombre= super.generarJTextField(200,70,150,20);
        this.add(this.campoNombre);
    }
    private void generarCampoContraseña(){
        String textoContraseña = "Contraseña:";
        super.generarJLabel(this.textoContraseña,textoContraseña,60,90,80,20);
        this.campoContraseña = super.generarJPasswordField(200,90,150,20);
        this.add(this.campoContraseña);
    }
    private boolean registrarCuenta(){
        if(this.campoNombre.getText().length()==0 || this.campoContraseña.getText().length()==0){
            return false;
        }
        else{

            return true;
        }
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.botonRegistrar) {
            VentanaRegistro ventanaRegistro = new VentanaRegistro(registroController);
            this.dispose();
        }
        if (e.getSource() == this.botonIngresar) {
            if (registrarCuenta()){
                if(registroController.buscarUsuario(this.campoNombre.getText(),this.campoContraseña.getText())!=null){
                    JOptionPane.showMessageDialog(this,"Bienvenido "+this.campoNombre.getText());
                    this.dispose();
                }else {
                    JOptionPane.showMessageDialog(this,"Contraseña incorrecta o\nUsuario no registrado");
                    VentanaIngreso ventanaIngreso = new VentanaIngreso(registroController);
                    this.dispose();
                }
                this.dispose();
            }
        }
        if(e.getSource() == this.botonCancelar){
            this.dispose();
            System.exit(0);
        }

    }
}

