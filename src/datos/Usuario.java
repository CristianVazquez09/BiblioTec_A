package datos;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author malaf
 */
public class Usuario extends Persona {

    private String numeroControl;
    private static boolean prestado;
   
    
    private static ArrayList<Documento> documentosRentados=new ArrayList<>();
    private Documento doc = new Documento();

    public Usuario(String numeroControl, String nombre, String apellido, long numero_tel) {
        super(nombre, apellido, numero_tel);
        this.numeroControl = numeroControl;
        
        
        
    }

    public boolean isPrestado() {
        return prestado;
    }

    public String getNumeroControl() {
        return numeroControl;
    }
    

    
    

    //Metodos de la clase 
    public void prestarDocumento(long codigo) {
        boolean existe = false;
        int i = 0;
        if (estaVacio()) {
            mostrarMensajeDeEstaVacio();
        } else {

            while (i < getListaDocumentos().size() && getListaDocumentos().get(i).getCodigo() != codigo) {
                i++;
            }
            if (i < getListaDocumentos().size()) {
                this.documentosRentados.add(getListaDocumentos().get(i));
                getListaDocumentos().get(i).mensajeRentar();
                getListaDocumentos().remove(i);
                Usuario.prestado=true;
                

            } else {
                JOptionPane.showMessageDialog(null, "Documento no encontrado");
            }
        }
    }

    public void devolverDocumento(long codigo) {
        //Metodo por hacer 
        boolean existe = false;
        int i=0;

        if (estaVacio()) {
            mostrarMensajeDeEstaVacio();
        } else {

            while (i < this.documentosRentados.size()&& this.documentosRentados.get(i).getCodigo() != codigo) {
                i++;
            }
            if (i < documentosRentados.size()) {
                getListaDocumentos().add(this.documentosRentados.get(i));
                this.documentosRentados.remove(this.documentosRentados.get(i));
                JOptionPane.showMessageDialog(null, "Documento devuelto correctamente");
                Usuario.prestado=false;

            } else {
                JOptionPane.showMessageDialog(null, "Documento no encontrado");
            }
        }
    }

    public void buscarDocumento(String titulo, String autor) {
        Documento docEncontrado = null;

        if (estaVacio()) {
            mostrarMensajeDeEstaVacio();
        } else {
            for (Documento docs : getListaDocumentos()) {
                if (docs.getTitulo().equalsIgnoreCase(titulo) && docs.getAutor().equalsIgnoreCase(autor)) {
                    docEncontrado = docs;
                    break;
                }
            }
            JOptionPane.showMessageDialog(null, docEncontrado);
        }
        
    }

    @Override
    public String mostrarDatos() {
        return super.mostrarDatos() + "\nNumero de control: " + numeroControl;
    }

    @Override
    public String toString() {
        return super.toString() + "numeroControl=" + numeroControl + ", prestado=" + prestado + ", documentosRentados=" + documentosRentados + '}';
    }

}
