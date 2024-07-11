package logica;
import bean.Abono;
import bean.Matera;
import bean.Planta;
import bean.Producto;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

public class LGeneral {
	
	private ArrayList<ArrayList> arrayGeneral;

	public ArrayList<ArrayList> getArrayGeneral() {
            return arrayGeneral;
	}

	public void setArrayGeneral(ArrayList<ArrayList> arrayGeneral) {
            this.arrayGeneral = arrayGeneral;
	}

	public LGeneral(ArrayList<ArrayList> arrayGeneral) {
            super();
            this.arrayGeneral = arrayGeneral;
	}

	public LGeneral()
	{
            arrayGeneral = new ArrayList<ArrayList>();
            
            LPlanta plantas= new LPlanta();
            LMatera matera= new LMatera();
            LAbono abono= new LAbono();
            
            arrayGeneral.add(plantas.getArrayPlantas());
            arrayGeneral.add(matera.getArrayMateras());
            arrayGeneral.add(abono.getArrayAbonos());
		
	}
	
	public String listar()
	{		String s="";
            LPlanta plantas= new LPlanta(arrayGeneral.get(0));
            LMatera matera= new LMatera(arrayGeneral.get(1));
            LAbono abono= new LAbono(arrayGeneral.get(2));
            s+=plantas.listarPlantas();
            s+=matera.listarMateras();
            s+=abono.listarAbonos();
            return s;
	}
        
        public void plantasSombra(){
            
            
            Iterator<Planta> itr = arrayGeneral.get(0).iterator();
            Planta planta = new Planta();
            int c = 0;
            
            while(itr.hasNext()){
                planta = itr.next();
                
                if(!planta.isTipo())
                    c++;
            }
            
            JOptionPane.showMessageDialog(null, "Las plantas en sombra son: " + c);

        }
        
        public void totalMateras(){
            
            Iterator<Matera> itr = arrayGeneral.get(1).iterator();
            Matera matera = new Matera();
            int c = 0;
            
            while(itr.hasNext()){
                matera = itr.next();
                
                c += matera.getPrecio();
            }
            
            JOptionPane.showMessageDialog(null, "El total de materas es: " + c);

        }
        
        public void plantasSolares(){
            
            Iterator<Planta> itr = arrayGeneral.get(0).iterator();
            Planta planta = new Planta();
            String s = "";
            
            while(itr.hasNext()){
                planta = itr.next();
                
                if(planta.isTipo())
                    s += "Nombre: " + planta.getNombre() + " Cuidados: " + planta.getCuidados() + "\n";
            }
            
            JOptionPane.showMessageDialog(null, """
                                                Listado de plantas solares
                                                """ + s);

        }
        
        public void abonosCaros(){
           
            Iterator<Abono> itr = arrayGeneral.get(2).iterator();
            Abono abono = new Abono();
            String s = "";
            
            while(itr.hasNext()){
                abono = itr.next();
                
                if(abono.getPrecio() > 6500)
                    s += "Nombre: " + abono.getNombre() + " Utilidad: " + abono.getUtilidad()+"\n";
            }
            
            JOptionPane.showMessageDialog(null, """
                                    Listado de abonos que cuestan mas de $6500
                                                """ + s);
        }
        
        public void masBarato(){
            Iterator<ArrayList> itr = arrayGeneral.iterator();
            ArrayList[] arrayBaratos = new ArrayList[3];
            int c = 0;
            Producto producto = new Producto();
            
            while(itr.hasNext()){
                ArrayList array = itr.next();
                Iterator itrMini = array.iterator();
                ArrayList<Producto> array2 = new ArrayList();
                producto = new Producto();
                
                if(!array.isEmpty()){
                    array2.add((Producto)itrMini.next());
                }
                int d=0;
                while(itrMini.hasNext()){
                    producto = (Producto) itrMini.next();
                    
                    if(array2.get(d).getPrecio() > producto.getPrecio())
                    	{array2.clear();
                    	d=0;
                    	array2.add(producto);
                        }
                    
                    else
                        if(array2.get(d).getPrecio() == producto.getPrecio()){
                            array2.add(producto);
                            d++;
                        }
                }
                
                arrayBaratos[c] = array2;
                c++;
                
                
                
            }
         
            
            int p=0;
            String lis="";
            for(ArrayList<Producto> arrayAux : arrayBaratos){
              Iterator<Producto> itrAux = arrayAux.iterator();
                switch (p) {
				case 0:lis+="\nListado de plantas mas baratas\n";
					
					break;
				case 1:lis+="\nListado de materas mas baratas\n";
				
				break;
				case 2:lis+="\nListado de abonos mas baratos\n";
				
				break;
				default:
					break;
				}
      
                while(itrAux.hasNext()){
                	producto=itrAux.next();
                	lis+=producto.mostrar();
                }
                
                p++;
            }
            
            JOptionPane.showMessageDialog(null, lis);
            
        }
        
        
}
