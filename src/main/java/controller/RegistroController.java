package controller;

import data.GestorDatos;
import model.Cuenta;
import java.util.ArrayList;
import java.util.List;

public class RegistroController {
	private List<Cuenta> cuentas;

	public RegistroController() {
		this.cuentas = new ArrayList<>();
	}

	public List<Cuenta> getCuentas() {
		return cuentas;
	}
	public void cargarCuentas() {
		cuentas = GestorDatos.leerArchivoCuentas("cuentas.txt");
	}

	public void registrarUsuario(String nombre, String rut, String contraseña) {
		Cuenta cuenta = new Cuenta(nombre,rut,contraseña);
		if (buscarUsuarioRut(rut)==null){
			GestorDatos.registroCuenta(cuenta,"cuentas.txt");
			cuentas.add(cuenta);
		}
	}
	public Cuenta buscarUsuario(String nombre, String contraseña) {
		for(Cuenta cuenta : this.cuentas){
			if(cuenta.getNombre().equals(nombre) && cuenta.getContraseña().equals(contraseña)){
				return cuenta;
			}
		}
		return null;
	}
	public Cuenta buscarUsuarioRut(String rut){
		for(Cuenta cuenta : this.cuentas){
			if(cuenta.getRut().equals(rut)){
				return cuenta;
			}
		}
		return null;
	}
}