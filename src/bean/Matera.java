package bean;

public class Matera extends Producto{
	
	private String material, tamaño;
	
	public Matera(int codigo, int precio, String nombre, String material, String tamaño) {
		super();
		this.codigo = codigo;
		this.precio = precio;
		this.nombre = nombre;
		this.material = material;
		this.tamaño = tamaño;
	}
	
	public Matera() {
		super();
		this.codigo = -1;
		this.precio = 0;
		this.nombre = "";
		this.material = "";
		this.tamaño = "";
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getTamaño() {
		return tamaño;
	}

	public void setTamaño(String tamaño) {
		this.tamaño = tamaño;
	}
	
	

}
