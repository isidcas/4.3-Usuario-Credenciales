package ejercicioCredenciales;

public class Credencial {

	private String username;
	private String password;
	private static int secuencia;
	
	public Credencial(String nombre, String apellidos, String password) {
	
		this.username = nombre.substring(0, 3) + apellidos.substring(0, 3) + Integer.valueOf(secuencia + 100);
		this.password = password;
		
	}
	
	public boolean comprobarPassword(String password) {
		return this.password.equals(password);
	}

	public String getUsername() {
		return username;
	}
	
	public boolean esPasswordSegura() {
		
		boolean esMin=false, esDigito=false;
		
		for(int i=0; i<this.password.length(); i++ ) {
		if(Character.isDigit(this.password.charAt(i))) {
			esDigito=true;
		}else {
			if(Character.isLowerCase(this.password.charAt(i))) {
				esMin=true;
			}
		}
		}
		
		return esDigito && esMin && this.password.length()>=8;
	}
	
	public void setPassword(String newpass) {
		this.password = newpass;
	}

	@Override
	public String toString() {
		return "Credencial [username=" + this.username + ", password=" + "*".repeat(this.password.length()) + "]";
	}
	
	

}
