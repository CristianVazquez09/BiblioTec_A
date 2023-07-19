package datos;

import javax.swing.JOptionPane;

/**
 *
 * @author malaf
 */
public class Encargado extends Persona {//Clase Encargado que hereda de persona 

    //Atributos de la clase 
    private String DNI;
    private String contraseñia;
    private String turno;

    //constructor con parametros de la clase
    public Encargado(String DNI, String contraseñia, String turno, String nombre, String apellido, long numero_tel) {
        super(nombre, apellido, numero_tel);
        this.DNI = DNI;
        this.contraseñia = contraseñia;
        this.turno = turno;

    }

    //Metodos para registrar docs a la lista de docs 
    public void registrarDocumento(Documento doc) {
        getListaDocumentos().add(doc);
        JOptionPane.showMessageDialog(null, "Documento registrado con exito");
    }

    //Metodo para eliminar Documentos de la lista 
    public void eliminarDocumento(long codigo) {

        int i = 0;
        Documento docEncontrado;

        if (estaVacio()) {
            mostrarMensajeDeEstaVacio();
        } else {
            while (i < getListaDocumentos().size() && getListaDocumentos().get(i).getCodigo() != codigo) {
                i++;
            }
            if (i < getListaDocumentos().size()) {
                getListaDocumentos().remove(i);
                JOptionPane.showMessageDialog(null, "Documento eliminado exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "Documento no encontrado");
            }
        }

    }

    //Metodo para modificar documentos 
    public void modificarDocumento(long cod, Documento doc) {
        int i=0;
        if (estaVacio()) {
            mostrarMensajeDeEstaVacio();
        } else {

            while (i < getListaDocumentos().size() && getListaDocumentos().get(i).getCodigo() != cod) {
                i++;
            }
            if (i < getListaDocumentos().size()) {
                getListaDocumentos().get(i).setTitulo(doc.getTitulo());
                getListaDocumentos().get(i).setAutor(doc.getAutor());
                getListaDocumentos().get(i).setEditorial(doc.getEditorial());
                getListaDocumentos().get(i).setAnioPublicacion(doc.getAnioPublicacion());
                JOptionPane.showMessageDialog(null, "Documento modificado correctamente");
            } 

        }

    }

    @Override
    public String mostrarDatos() {
        return super.mostrarDatos() + "\nTurno: " + turno;
    }

    //Metodo para corroborar codigo
    public boolean existeCod(long cod) {
        boolean existe = false;
        for (Documento listaDocumento : getListaDocumentos()) {
            if (listaDocumento.getCodigo() == cod) {
                existe = true;
            }

        }
        return existe;
    }

}
