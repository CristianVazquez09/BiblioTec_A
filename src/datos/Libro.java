
package datos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 *
 * @author malaf
 */
public class Libro extends Documento{//Clase que hereda de Documento 
    //Atributo de la Clase Libro 
    private int cantidadDePaginas;

    //Costructor con parametros de la clase Libro 
    public Libro(int cantidadDePaginas, String titulo, String autor, String editorial, int anioPublicacion, int codigo) {
        super(titulo, autor, editorial, anioPublicacion, codigo);
        this.cantidadDePaginas = cantidadDePaginas;
    }

    
    @Override
     public  void mensajeRentar() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate returnDate = currentDate.plusDays(45);

        
        JOptionPane.showMessageDialog(null, "Documento prestado el dia "+currentDate.format(formatter)+"\n Fecha de devolucion "+returnDate.format(formatter));
    }

    @Override
    public String toString() {
        return super.toString() + "\nCantidad De Paginas: " + cantidadDePaginas ;
    }
    
    
    
    
    
    
}
