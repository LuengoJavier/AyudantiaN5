package View;
import controller.RegistroController;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class VentanaRegistro extends Ventana {
    private JLabel textoEncabezado, textoRut, textoNombre, textoContraseña;
    private JTextField campoRut, campoNombre, campoContraseña;
    private JButton botonRegistrar, botonCancelar;
    private RegistroController registroController;


    public VentanaRegistro(RegistroController registroController){
        super("Registro de cliente", 500, 520);
        this.registroController = registroController;
        generarElementosVentana();
    }
    private void generarElementosVentana() {
        generarEncabezado();
        generarBotonCancelar();
        generarBotonRegistrar();
        generarCampoContraseña();
        generarCampoNombre();
        generarCampoRut();
    }
    private void generarEncabezado() {
        String textoCabecera = "Registro de cliente";
        super.generarJLabelEncabezado(this.textoEncabezado, textoCabecera, 190, 10, 200, 50);

    }
    private void generarBotonRegistrar() {
        String textoBoton= "Registrar Cliente";
        this.botonRegistrar = super.generarBoton(textoBoton, 75, 400, 150, 20);
        this.add(this.botonRegistrar);
        this.botonRegistrar.addActionListener(this);
    }
    private void generarBotonCancelar() {
        String textoBotonCancelar = "Cancelar";
        this.botonCancelar = super.generarBoton(textoBotonCancelar, 275, 400, 150, 20);
        this.add(this.botonCancelar);
        this.botonCancelar.addActionListener(this);
    }
    private void generarCampoNombre(){
        String textoNombre= "Nombre:";
        super.generarJLabel(this.textoNombre,textoNombre,20,50,150,20);
        this.campoNombre= super.generarJTextField(200,50,250,20);
        this.add(this.campoNombre);
    }
    private void generarCampoRut(){
        String textoRut= "Rut:";
        super.generarJLabel(this.textoRut,textoRut,20,100,150,20);
        this.campoRut= super.generarJTextField(200,100,250,20);
        this.add(this.campoRut);
    }
    private void generarCampoContraseña(){
        String textoContraseña= "Contraseña:";
        super.generarJLabel(this.textoContraseña,textoContraseña,20,150,150,20);
        this.campoContraseña= super.generarJTextField(200,150,250,20);
        this.add(this.campoContraseña);
    }

    private boolean registrarCuenta(){
        if(this.campoNombre.getText().length() == 0 || this.campoRut.getText().length()==0 ||
                this.campoContraseña.getText().length() == 0){
            return false;
        }
        else{

            return true;
        }
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.botonRegistrar) {
            if(registrarCuenta()) {
                if(registroController.buscarUsuarioRut(this.campoRut.getText())==null){
                    registroController.registrarUsuario(this.campoNombre.getText(),this.campoRut.getText(),
                            this.campoContraseña.getText());
                    JOptionPane.showMessageDialog(this,"Cuenta registrada correctamente");
                    VentanaIngreso ventanaIngreso = new VentanaIngreso(registroController);
                    this.dispose();
                }else{
                    JOptionPane.showMessageDialog(this,"La cuenta ya existe");
                    VentanaRegistro ventanaRegistro = new VentanaRegistro(registroController);
                    this.dispose();
                }
            }
            else{
                JOptionPane.showMessageDialog(this,"Ingrese un rut válido");
            }

        }
        if (e.getSource() == this.botonCancelar){
            VentanaIngreso ventanaIngreso = new VentanaIngreso(registroController);
            this.dispose();
        }

    }
}