package model;

public class Cuenta {
	private String nombre;
	private String rut;
	private String contraseña;

	public Cuenta(String nombre, String rut, String contraseña) {
		this.nombre = nombre;
		this.rut = rut;
		this.contraseña = contraseña;
	}

	public String getNombre() {
		return nombre;
	}

	public String getRut() {
		return rut;
	}

	public String getContraseña() {
		return contraseña;
	}

	@Override
	public String toString() {
		return getNombre()+","+getRut()+","+getContraseña();
	}
}