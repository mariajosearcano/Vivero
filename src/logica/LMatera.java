package logica;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import bean.Matera;
import bean.Planta;



public class LMatera {
	
	private ArrayList<Matera> arrayMateras;
	private Matera matera;
        
	public ArrayList<Matera> getArrayMateras() {
		return arrayMateras;
	}
        
	public void setArrayMateras(ArrayList<Matera> arrayMateras) {
		this.arrayMateras = arrayMateras;
	}
        
	public Matera getMatera() {
		return matera;
	}
        
	public void setMatera(Matera matera) {
		this.matera = matera;
	}
        
	public LMatera(ArrayList<Matera> arrayMateras) {
		super();
		this.arrayMateras = arrayMateras;
	}
	
	public LMatera(boolean x) {
		
	}
	
	public LMatera()
	{
            arrayMateras= new ArrayList<Matera>();
            
            File archivo= new File("./src/registros/RegistrosMateras.txt");
            Scanner s= null;
            
            try {
                s = new Scanner(archivo);
                while(s.hasNextLine()) {
                        String linea = s.nextLine();
                        String[] Vlinea=linea.split("::");
                        matera= new Matera(Integer.parseInt(Vlinea[0])/*codigo*/,Integer.parseInt(Vlinea[4])/*precio*/,Vlinea[1]/*nombre*/,Vlinea[2]/*material*/, Vlinea[3]/*tamaño*/);
                        arrayMateras.add(matera);

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
	
	public String listarMateras()
	{		String s="";
            Iterator<Matera> iterMat= arrayMateras.iterator();
            s+="\nListado Materas:\n";
            while(iterMat.hasNext())
            {
                matera=iterMat.next();


               s+="\nCodigo: "+matera.getCodigo()+" Nombre: "+ matera.getNombre()+" Material: "+ matera.getMaterial()+ " Tamaño: "+ matera.getTamaño() + " Precio: $"+ matera.getPrecio();
            }
            return s+"\n";
	}
	
	public void ingreso()
	{
		JTextField codigo = new JTextField(),nombre= new JTextField(),material= new JTextField(),tamaño= new JTextField(), precio= new JTextField();
		
		Object[] message = {
		    "Codigo:", codigo,
		    "Nombre:", nombre,
		    "Material: ", material,
		    "Tamaño: ",tamaño,
		    "precio: ", precio
		    
		};
		
		int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);
		if (option == JOptionPane.OK_OPTION) {
			
		    matera= new Matera(Integer.parseInt(codigo.getText())/*codigo*/,Integer.parseInt(precio.getText())/*precio*/,nombre.getText()/*nombre*/,material.getText()/*material*/, tamaño.getText()/*tamaño*/);
			
		} else {
		    System.out.println("Ingreso cancelado.");
		}
		
	}
	

}