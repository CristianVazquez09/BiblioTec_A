package datos;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author malaf
 */
public class Persona {//Clase persona 

    //Atributos de la clase 
    private String nombre;
    private String apellido;
    private long numero_tel;
    private static ArrayList<Documento> listaDocumentos = new ArrayList<>();//Lista donde de guardan todos los documentos  registrados 

    //Constructor con parametros de la Clase 
    public Persona(String nombre, String apellido, long numero_tel) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numero_tel = numero_tel;

    }

    

    //Metodo getter para que la lista se pueda ver en la demas clases 
    public ArrayList<Documento> getListaDocumentos() {
        return listaDocumentos;
    }

    //Metodo para corroborar si la lista esta vacia 
    public boolean estaVacio() {
        return getListaDocumentos().isEmpty();
    }

    //Metodo para mostrar los documentos de la lista 
    public static void mostrarDocs() {
        int banderaLibros = 0, banderaRevista = 0, banderaTesis = 0;//Variables para checar si hay esos tipos de documentos

        if (listaDocumentos.isEmpty()) {//Checando si la lista es vacia 

            JOptionPane.showMessageDialog(null, "No se puede mostrar datos porque no hay documentos registrados");

        } else {

            JOptionPane.showMessageDialog(null, "Libros");
            for (Documento docs : listaDocumentos) {
                if (docs instanceof Libro) {//Checando si en la lista de docs son de tipo libros 

                    JOptionPane.showMessageDialog(null, docs.toString());//Mostrando los libros 
                    banderaLibros = 1;

                }

            }
            if (banderaLibros == 0) {//Comprobar si no hay libros 
                JOptionPane.showMessageDialog(null, "Aun no hay libros registrados");
            }

            JOptionPane.showMessageDialog(null, "Revistas");
            for (Documento docs : listaDocumentos) {
                if (docs instanceof Revista) {//Checando si en la lista de docs son de tipo revista

                    JOptionPane.showMessageDialog(null, docs.toString());//Mostrando revistas
                    banderaRevista = 1;
                }
            }
            if (banderaRevista == 0) {//Comprobando si no hay revistas
                JOptionPane.showMessageDialog(null, "Aun no hay revistas registradas");

            }

            JOptionPane.showMessageDialog(null, "Tesis");
            for (Documento docs : listaDocumentos) {//Checando si en la lista de docs son de tipo tesis
                if (docs instanceof Tesis) {

                    JOptionPane.showMessageDialog(null, docs.toString());//Mostrando tesis
                    banderaTesis = 1;
                }
            }
            if (banderaTesis == 0) {//Comprobando si no hay teisi
                JOptionPane.showMessageDialog(null, "Aun no hay Tesis registradas");
            }
        }

    }
    
    //Metodo que solo imprime un mensaje de esta vacio 
    public void mostrarMensajeDeEstaVacio(){
        JOptionPane.showMessageDialog(null, "No se puede mostrar datos porque no hay documentos registrados. \nIngrese un documento entes de usar esta opcion ");
    }
    
    //Metodo que muestra el codigo del documento con el respectivo titulo 
    public void mostrarCodTit(){
        
        for (Documento listaDocumento : listaDocumentos) {
            JOptionPane.showMessageDialog(null, listaDocumento.mostrarCodsTit());
            
        }
        
    }
    //Metodo que muestra el nombre y apellido de las personas 
     public String mostrarDatos (){
        return nombre+" "+apellido;
    }
     
     
 
     public static boolean ExisteCodigo(int cod){
         boolean existe=true;
         if(listaDocumentos.isEmpty()){
             return existe;
         }
         
         for (Documento listaDocumento : listaDocumentos) {
             if(listaDocumento.getCodigo()==cod){
                 existe=false;
             } 
         }
         
         return existe;
     }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellido=" + apellido + ", numero_tel=" + numero_tel + '}';
    }
    

}
