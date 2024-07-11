package bean;

public class Abono extends Producto {

	private String descripcion, utilidad;
	
	public Abono(int codigo, int precio, String nombre, String descripcion, String utilidad) {
		super();
		this.codigo = codigo;
		this.precio = precio;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.utilidad = utilidad;
	}
	
	public Abono() {
		super();
		this.codigo = -1;
		this.precio = 0;
		this.nombre = "";
		this.descripcion = "";
		this.utilidad = "";
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUtilidad() {
		return utilidad;
	}

	public void setUtilidad(String utilidad) {
		this.utilidad = utilidad;
	}
	
	public String mostrar()
	{
		String s="";
			s="\nCodigo: "+this.getCodigo()+" Nombre: "+ this.getNombre()+" Descripcion: "+ this.getDescripcion()+ " Utilidad: "+ this.getUtilidad() + " Precio: $"+ this.getPrecio();
		return s;
	}
	
	

}
