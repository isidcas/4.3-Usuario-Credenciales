package ejercicioCredenciales;

public class Usuario {

	private String nombre;
	private String apellidos;
	private String email;
	private Credencial credencial;
	private int intentos;
	
	public Usuario(String nombre, String apellidos, String password) {
		super();
		credencial = new Credencial(nombre, apellidos, password);
	}

	public Usuario(String nombre, String apellidos, String email, String password) {
		super();
		credencial = new Credencial(nombre, apellidos, password);
		this.email = email;
	}
	
	public boolean esCuentaBloqueada() {
		return this.intentos>2;
	}

	public void setCredencial(Credencial credencial) {
		this.credencial = credencial;
	}
	
	public boolean modificarPassword(String oldpass, String newpass, String newpassverif) {
		
		boolean esPassModificable = false;
		
		if(esCuentaBloqueada()) {
			System.out.println("CUENTA BLOQUEADA!!");
		}
		
		else if(this.credencial.comprobarPassword(oldpass) && !oldpass.equals(newpass) && !newpass.equals(newpassverif)){
			newpass=newpassverif;
			this.credencial.setPassword(newpassverif);
			esPassModificable=true;
		}
		
		return esPassModificable;
	}
	
	public boolean esPasswordSegura() {
		return this.credencial.esPasswordSegura();
	}
	
	public boolean hacerLogin(String username, String password) {
		
		boolean esLoginCorrecto=false;
		
		if(esCuentaBloqueada()) {
			System.out.println("CUENTA BLOQUEADA!!");
		}
		else {
	
		if(username.equals(this.credencial.getUsername()) && this.credencial.comprobarPassword(password)) {
			esLoginCorrecto=true;
		}
		else {
			esLoginCorrecto=false;
			this.intentos++;
		}
		}
		
		return esLoginCorrecto;
	}

	@Override
	public String toString() {
		
		String cadena = "";
		
		if(esCuentaBloqueada()) {
			cadena = "CUENTA BLOQUEADA";
		}else {
			cadena = "Usuari@: " + this.nombre + this.apellidos + " con email " + this.email + ", " + this.credencial.toString();
		}
		
		return cadena;
				 
	}
	
	
	
}
