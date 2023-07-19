package datos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 *
 * @author malaf
 */
public class Documento {

    //Atributos de la clase Documento 
    private String titulo;
    private String autor;
    private String editorial;
    private int anioPublicacion;
    private int codigo;

    //Constructor con parametros de la clase Documento 
    public Documento(String titulo, String autor, String editorial, int anioPublicacion, int codigo) {
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.anioPublicacion = anioPublicacion;
        this.codigo = codigo;
    }

    public Documento() {
    }
    

    //Metodos getters para buscar los metos de busqueda 
    public long getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    //Metodos setters para la modificacion de documentos 
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public String mostrarCodsTit() {
        return codigo + " / " + titulo;
    }

    public void mensajeRentar() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate returnDate = currentDate.plusDays(10);

        
        JOptionPane.showMessageDialog(null, "Documento prestado el dia "+currentDate.format(formatter)+"\n Fecha de devolucion "+returnDate.format(formatter));
    }

    @Override
    public String toString() {
        return ".:Documento:." + "\nTitulo: " + titulo + "\nAutor: " + autor + "\nEditorial: " + editorial + "\nAño de Publicacion: " + anioPublicacion + "\nCodigo:" + codigo;
    }

}
