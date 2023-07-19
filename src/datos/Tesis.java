
package datos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 *
 * @author malaf
 */
public class Tesis extends Documento {//Clase tesis que hereda de Documento 
    //Atributo de la clase 
    private int edicion;

    //Constructor con parametros de la clase 
    public Tesis(int edicion, String titulo, String autor, String editorial, int anioPublicacion, int codigo) {
        super(titulo, autor, editorial, anioPublicacion, codigo);
        this.edicion = edicion;
    }

    
    @Override
    public void mensajeRentar() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate returnDate = currentDate.plusDays(80);

        
        JOptionPane.showMessageDialog(null, "Documento prestado el dia "+currentDate.format(formatter)+"\n Fecha de devolucion "+returnDate.format(formatter));
    }
    @Override
    public String toString() {
        return super.toString() + "\nEdicion: " + edicion ;
    }
    
    
    
    
    
    
}
