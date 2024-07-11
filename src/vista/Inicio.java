package vista;


import java.util.ArrayList;

import javax.swing.JOptionPane;
import logica.LAbono;
import logica.LGeneral;
import logica.LMatera;
import logica.LPlanta;

public class Inicio {

	public static void main(String[] args) {
            int opcion = 0;
            
            LPlanta lplanta = new LPlanta();
            LMatera lmatera = new LMatera();
            LAbono labono = new LAbono();
            LGeneral lgeneral = new LGeneral();
            
            do{
                opcion = Integer.parseInt(JOptionPane.showInputDialog("""
                                    Menu Vivero
                               
                                1. Ingresar nuevos datos.
                                2. Cantidad de plantas de sombra.
                                3. Total de dinero en materas.
                                4. Plantas solares.
                                5. Abonos caros.
                                6. Productos mas baratos.
                                7. Listar todo.
                                0. Salir.
                                                                                   """));

                switch(opcion){
                    
                    case 1: 
                    			ingreso(lgeneral);
                        break;
                    case 2: 
                                lgeneral.plantasSombra();
                            
                        break;
                    case 3: 
                                lgeneral.totalMateras();
                            
                        break;
                    case 4: 
                                lgeneral.plantasSolares();
                            
                        break;
                    case 5: 
                                lgeneral.abonosCaros();
                            
                        break;
                    case 6: 
                                lgeneral.masBarato();
                            
                        break;
                    case 7: 
		                    	JOptionPane.showMessageDialog(null, lgeneral.listar());
		                    
                break;
                    case 0: JOptionPane.showMessageDialog(null, "Fue un gusto que usara nuestros servicios");
                        break;
                    default: JOptionPane.showMessageDialog(null, "Opcion equivocada");


                }
            }
            while(opcion != 0);

	}
	
	public static void ingreso(LGeneral lgeneral)
	{ 	int opcion=0;
		String menu= """
                Menu Vivero

            1. Ingresar planta.
            2. Ingresar matera.
            3. Ingresar abono.
            0. Salir.
                                                               """;
		do {
			opcion=Integer.parseInt(JOptionPane.showInputDialog(menu));
			switch (opcion) {
			case 1: LPlanta planta= new LPlanta(false);
					planta.ingreso();
					lgeneral.getArrayGeneral().get(0).add(planta.getPlanta());
					JOptionPane.showMessageDialog(null, "Insertado exitoso.");
				break;
			case 2: LMatera matera= new LMatera(false);
					matera.ingreso();
					lgeneral.getArrayGeneral().get(1).add(matera.getMatera());
					JOptionPane.showMessageDialog(null, "Insertado exitoso.");
				break;
			case 3: LAbono abono=  new LAbono(false);
					abono.ingreso();
					lgeneral.getArrayGeneral().get(2).add(abono.getAbono());
					JOptionPane.showMessageDialog(null, "Insertado exitoso.");
				
				break;
			case 0: JOptionPane.showMessageDialog(null, "Volviendo al menu anterior.");
				break;
			default: JOptionPane.showMessageDialog(null,"Opcion equivocada.");
				
			}
		}while(opcion!=0);
		
	
	}

}
