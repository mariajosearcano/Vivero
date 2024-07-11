package logica;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import bean.Abono;
import bean.Matera;

public class LAbono {

	private ArrayList<Abono> arrayAbonos;
	private Abono abono;
        
	public ArrayList<Abono> getArrayAbonos() {
		return arrayAbonos;
	}
        
	public void setArrayAbonos(ArrayList<Abono> arrayAbonos) {
		this.arrayAbonos = arrayAbonos;
	}
        
	public Abono getAbono() {
		return abono;
	}
        
	public void setAbono(Abono abono) {
		this.abono = abono;
	}
        
	public LAbono(ArrayList<Abono> arrayAbonos) {
		super();
		this.arrayAbonos = arrayAbonos;
	}
	
	public LAbono(boolean x) {
		
	}
	
	public LAbono() 
	{
            arrayAbonos = new ArrayList<Abono>();
            
            File archivo = new File("./src/registros/RegistrosAbonos.txt");
            Scanner s = null;
            
            try {
                s = new Scanner(archivo);
                while(s.hasNextLine()) {
                    String linea = s.nextLine();
                    String[] Vlinea = linea.split("::");
                    abono = new Abono(Integer.parseInt(Vlinea[0])/*codigo*/,Integer.parseInt(Vlinea[4])/*precio*/,Vlinea[1]/*nombre*/,Vlinea[2]/*descripcion*/, Vlinea[3]/*utilidad*/);
                    arrayAbonos.add(abono);

                }

            } catch (Exception e) {

                // TODO: handle exception
                e.printStackTrace();
            } 
            finally
            {
                try {
                    if (s != null)
                        s.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }	
		
	}
	
	public String listarAbonos()
	{
			String s="";
            Iterator<Abono> iterAb= arrayAbonos.iterator();
            s+="\nListado Abonos:\n";
            while(iterAb.hasNext())
            {
                    abono = iterAb.next();


                    s+="\nCodigo: "+abono.getCodigo()+" Nombre: "+ abono.getNombre()+" Descripcion: "+ abono.getDescripcion()+ " Utilidad: "+ abono.getUtilidad() + " Precio: $"+ abono.getPrecio();
            }
            return  s+"\n";
	}
	
	public void ingreso()
	{
		JTextField codigo = new JTextField(),nombre= new JTextField(),descripcion= new JTextField(),utilidad= new JTextField(), precio= new JTextField();
		
		Object[] message = {
		    "Codigo:", codigo,
		    "Nombre:", nombre,
		    "Descripcion: ", descripcion,
		    "Utilidad: ", utilidad,
		    "precio: ", precio
		    
		};
		
		int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);
		if (option == JOptionPane.OK_OPTION) {
			
		    abono= new Abono(Integer.parseInt(codigo.getText())/*codigo*/,Integer.parseInt(precio.getText())/*precio*/,nombre.getText()/*nombre*/,descripcion.getText()/*descripcion*/, utilidad.getText()/*utilidad*/);
			
		} else {
		    System.out.println("Ingreso cancelado.");
		}
		
	}
}
