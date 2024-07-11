package logica;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import bean.Planta;

public class LPlanta {

	private ArrayList<Planta> arrayPlantas;
	private Planta planta;

	public Planta getPlanta() {
		return planta;
	}

	public void setPlanta(Planta planta) {
		this.planta = planta;
	}

	public ArrayList<Planta> getArrayPlantas() {
		return arrayPlantas;
	}

	public void setArrayPlantas(ArrayList<Planta> arrayPlantas) {
		this.arrayPlantas = arrayPlantas;
	}

	public LPlanta(ArrayList<Planta> arrayPlantas) {
		super();
		this.arrayPlantas = arrayPlantas;
	}
	
	public LPlanta(boolean x)
	{
		
	}

	public LPlanta()
	{
            arrayPlantas= new ArrayList<Planta>();

            File archivo= new File("./src/registros/RegistrosPlantas.txt");
            Scanner s= null;
            boolean tip=false;
            
            try {
                s = new Scanner(archivo);
                while(s.hasNextLine()) {
                    String linea = s.nextLine();
                    String[] Vlinea = linea.split("::");
                    if("solar".equals(Vlinea[3]))
                    {
                        tip=true;
                    }else{
                        tip=false;
                    }
                    planta= new Planta(Integer.parseInt(Vlinea[0])/*codigo*/,Integer.parseInt(Vlinea[4])/*precio*/,Vlinea[1]/*nombre*/,Vlinea[2]/*cuidados*/, tip/*tipo*/);
                    arrayPlantas.add(planta);

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
	
	public String listarPlantas()
	{
			String s="";
            Iterator<Planta> iterPlant= arrayPlantas.iterator();
            s+="\nListado Plantas:\n";
            String tip="";
            while(iterPlant.hasNext())
            {
                planta=iterPlant.next();
                if(planta.isTipo())
                {
                    tip="solar";
                }else
                {
                    tip="sombra";
                }
                s+="\nCodigo: "+planta.getCodigo()+" Nombre: "+ planta.getNombre()+" Cuidados: "+ planta.getCuidados()+ " Tipo: "+ tip+ " Precio: $"+ planta.getPrecio();
            }
            return s+"\n";
	}
	
	public void ingreso()
	{
		JTextField codigo = new JTextField(),nombre= new JTextField(),cuidados= new JTextField(),tipo= new JTextField(), precio= new JTextField();
		
		Object[] message = {
		    "Codigo:", codigo,
		    "Nombre:", nombre,
		    "Cuidados: ", cuidados,
		    "Tipo (en minusculas): ",tipo,
		    "precio: ", precio
		    
		};
		boolean tip=false;
		int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);
		if (option == JOptionPane.OK_OPTION) {
			if("solar".equals(tipo.getText()))
            {
                tip=true;
            }else{
                tip=false;
            }
		    planta= new Planta(Integer.parseInt(codigo.getText())/*codigo*/,Integer.parseInt(precio.getText())/*precio*/,nombre.getText()/*nombre*/,cuidados.getText()/*cuidados*/, tip/*tipo*/);
			
		} else {
		    System.out.println("Ingreso cancelado.");
		}
		
	}
}
