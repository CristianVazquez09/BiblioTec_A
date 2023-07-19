
package datos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 *
 * @author malaf
 */
public class Revista extends Documento {//Clase revista que hereda de Documento 
    //Atributos de la clase 
    private int volumen;
    private int numero;
    private String mesDePublicacion;

    //Costructor con parametros de la clase Revista 
    public Revista(int volumen, int numero, String mesDePublicacion, String titulo, String autor, String editorial, int anioPublicacion, int codigo) {
        super(titulo, autor, editorial, anioPublicacion, codigo);
        this.volumen = volumen;
        this.numero = numero;
        this.mesDePublicacion = mesDePublicacion;
    }
    

    @Override
    public String toString() {
        return super.toString() + "\nVolumen: " + volumen + "\nNumero: " + numero + "\nMes De Publicacion: " + mesDePublicacion ;
    }
    @Override
     public void mensajeRentar() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate returnDate = currentDate.plusDays(28);

        
        JOptionPane.showMessageDialog(null, "Documento prestado el dia "+currentDate.format(formatter)+"\n Fecha de devolucion "+returnDate.format(formatter));
    }
    
    
           
    
}
