package bean;

public class Planta extends Producto{
	
	private String cuidados;
	private boolean tipo;//true si es solar, false si es sombra.
	
	public Planta(int codigo, int precio, String nombre, String cuidados, boolean tipo) {
		super();
		this.codigo = codigo;
		this.precio = precio;
		this.nombre = nombre;
		this.cuidados = cuidados;
		this.tipo = tipo;
	}
	
	public Planta() {
		super();
		this.codigo = -1;
		this.precio = 0;
		this.nombre = "";
		this.cuidados = "";
		this.tipo = false;
	}

	public String getCuidados() {
            return cuidados;
	}

	public void setCuidados(String cuidados) {
            this.cuidados = cuidados;
	}

	public boolean isTipo() {
            return tipo;
	}

	public void setTipo(boolean tipo) {
            this.tipo = tipo;
	}
	
	
	
	
}
