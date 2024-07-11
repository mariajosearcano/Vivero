
package bean;

public class Producto {
    
    //protected: permite que un atributo o método de una clase sea visible desde las clases que heredan de la misma
    protected int codigo, precio;
    protected String nombre;
    
    public Producto() {
        codigo = 0;
        precio = 0;
        nombre = "";
    }
    
    public Producto(int codigo, String nombre, int precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    public String mostrar()
	{
		String s="";
			s="Codigo: "+this.getCodigo()+" Nombre: "+ this.getNombre()+ " Precio: $"+ this.getPrecio();
		return s+"\n";
	}
	
    
}
