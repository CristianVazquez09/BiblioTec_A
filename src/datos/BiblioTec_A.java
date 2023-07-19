package datos;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author malaf
 */
public class BiblioTec_A {

    static String autor = null, titulo = null, editorial = null;
    static int anioPublicacion;
    static int codigo;

    public static void main(String[] args) {

        int cargo = 0;
        int opcSalida = 1;
        boolean bandera = false;
        boolean error;

        do {
            JOptionPane.showMessageDialog(null, "..:Bienvenido a BIblioTecA:..\n\n");
            do {
                error = false;
                try {
                    cargo = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el cargo que tienes\n1)Encargado de la Biblioteca\n2)Usuario Del tecnologico \n3)Salir"));
                } catch (NumberFormatException e) {
                    error = true;
                    getMenssageError(1);
                }

            } while (error);

            switch (cargo) {
                case 1:
                    EncargadoDatos();
                    break;
                case 2:
                    datosUsuario();

                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "BiblioTec_A les desea un exelente dia y pronto regreso :)");
                    opcSalida = 0;
                    break;

            }
        } while (opcSalida == 1);

    }

    //Metodo para checar que encargado es y hacer la operaciones indicadas 
    public static void EncargadoDatos() {
        int bandera = 0, banderaErrorMenu = 0;
        int opc = 0;
        Seguridad seg;
        boolean error;
        String contrasenia;
        do {

            contrasenia = JOptionPane.showInputDialog("Digite su contraseña: ");

            seg = new Seguridad(contrasenia);

            if (seg.encotrarEncargado() == null) {//Corroborando su contraseña 
                int respuestaContrasenia = 0;
                do {
                    error = false;
                    try {
                        respuestaContrasenia = Integer.parseInt(JOptionPane.showInputDialog("Contraseña incorrecta\n1)Volver a intentar\n2)Volver al principio"));
                    } catch (NumberFormatException e) {
                        error = true;
                        getMenssageError(1);
                    }

                } while (error);

                if (respuestaContrasenia == 2) {
                    bandera = 1;
                }
            } else {
                bandera = 1;
                Encargado encargado = seg.encotrarEncargado();//Igualando la variable encargado al empleado que la funcion retorna 

                JOptionPane.showMessageDialog(null, "Bienvenido: \n" + encargado.mostrarDatos() + "\n");
                JOptionPane.showMessageDialog(null, "Que desea realizar el dia de hoy\n\nPrecio enter para mostrarle el menu ");

                do {
                    do {
                        do {
                            error = false;
                            try {
                                opc = Integer.parseInt(JOptionPane.showInputDialog("\t\t.::MENU::.\t\t"
                                        + "                                         \n1.-Mostrar documentos"
                                        + "                                         \n2.-Registrar Documentos"
                                        + "                                         \n3.-Eliminar Documentos"
                                        + "                                         \n4.-Modificar Documentos"
                                        + "                                         \n5.-Salir"));
                            } catch (NumberFormatException e) {
                                error = true;
                                getMenssageError(1);
                            }
                        } while (error);

                        if (opc > 0 && opc <= 5) {
                            bandera = 1;

                        } else {
                            JOptionPane.showMessageDialog(null, "Eso no se encuentra en nuestro menu, vuelva a intentar");
                        }
                    } while (bandera == 0);

                    switch (opc) {
                        case 1:
                            Persona.mostrarDocs();
                            break;
                        case 2:
                            int badera;
                            int opcDocumentoElegido = 0;

                            do {
                                bandera = 1;
                                do {
                                    error = false;
                                    try {
                                        opcDocumentoElegido = Integer.parseInt(JOptionPane.showInputDialog("Que documentos desea registrar "
                                                + "                                                                 \n1.-Libro"
                                                + "                                                                 \n2.-Revista"
                                                + "                                                                 \n3.-Tesis"));
                                    } catch (NumberFormatException e) {
                                        error = true;
                                        getMenssageError(1);
                                    }
                                } while (error);

                                if (opcDocumentoElegido < 1 || opcDocumentoElegido > 3) {
                                    bandera = 0;
                                    JOptionPane.showMessageDialog(null, "Eso no se encuntra disponible en las opciones mostradas");
                                }
                            } while (bandera == 0);

                            encargado.registrarDocumento(RegistrarDocs(opcDocumentoElegido));
                            break;
                        case 3:
                            int cod;
                            if (encargado.estaVacio()) {
                                encargado.mostrarMensajeDeEstaVacio();
                            } else {
                                if (printCodes()) {
                                    encargado.mostrarCodTit();
                                }
                                cod = getCode();

                                encargado.eliminarDocumento(cod);

                            }

                            break;
                        case 4:
                            long codModi = 0;
                            if (encargado.estaVacio()) {
                                encargado.mostrarMensajeDeEstaVacio();
                            } else {
                                if (printCodes()) {
                                    encargado.mostrarCodTit();
                                }
                                do {
                                    error = false;
                                    try {
                                        codModi = Long.parseLong(JOptionPane.showInputDialog("Dijite el codigo del documento que desea modificar: "));
                                    } catch (NumberFormatException e) {
                                        error = true;
                                        getMenssageError(1);
                                    }
                                } while (error);

                                if (encargado.existeCod(codModi)) {
                                    encargado.modificarDocumento(codModi, setDocument());
                                } else {
                                    JOptionPane.showMessageDialog(null, "Documento no encontrado");
                                }

                            }

                            break;
                        case 5:
                            JOptionPane.showMessageDialog(null, "Gracias por usar BiblioTec_A :)");
                            break;
                    }

                } while (opc != 5);
            }
        } while (bandera == 0);

    }

    //Metodo para registrar documentos 
    public static Documento RegistrarDocs(int opc) {
        Documento lib = null, revi = null, tesis = null;
        int bandera = 0;
        boolean error;
        switch (opc) {
            case 1:
                int cantiPag = 0;
                getDataDocuments();
                CodeGeneration();
                do {
                    error = false;
                    try {
                        cantiPag = Integer.parseInt(JOptionPane.showInputDialog("Digite la cantidad de paginas: "));
                    } catch (NumberFormatException e) {
                        error = true;
                        getMenssageError(1);
                    }
                } while (error);

                lib = new Libro(cantiPag, titulo, autor, editorial, anioPublicacion, codigo);
                bandera = 1;
                break;

            case 2:
                int numero = 0,
                 volumen = 0;
                String mesPublicacion = null;
                getDataDocuments();
                CodeGeneration();

                do {
                    error = false;
                    try {
                        volumen = Integer.parseInt(JOptionPane.showInputDialog("Digite el volumen: "));

                        numero = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero: "));
                    } catch (NumberFormatException e) {
                        error = true;
                        getMenssageError(1);
                    }
                } while (error);

                do {
                    error = false;
                    mesPublicacion = JOptionPane.showInputDialog("Digite el mes de publicacion: ");

                    if (!mesPublicacion.matches("^[a-zA-Z ]+$")) { //"^[a-zA-Z0-9\\s]+$"   ^[a-zA-Z ]+$
                        error = true;
                        getMenssageError(3);
                        //JOptionPane.showMessageDialog(null, "No se permiten caracteres especiales, ni numeros");
                    }
                } while (error);

                revi = new Revista(volumen, numero, mesPublicacion, titulo, autor, editorial, anioPublicacion, codigo);
                bandera = 2;
                break;
            case 3:
                int edicion = 0;
                getDataDocuments();
                CodeGeneration();

                do {
                    error = false;
                    try {
                        edicion = Integer.parseInt(JOptionPane.showInputDialog("Digite la edicion: "));
                    } catch (NumberFormatException e) {
                        error = true;
                        getMenssageError(1);
                    }
                } while (error);

                tesis = new Tesis(edicion, titulo, autor, editorial, anioPublicacion, codigo);
                break;
        }

        if (bandera == 1) {
            return lib;
        } else if (bandera == 2) {
            return revi;
        }

        return tesis;
    }

    //Metodo que devuelve un documento para que este modifique a otro 
    public static Documento setDocument() {
        Documento doc;
        JOptionPane.showMessageDialog(null, "Dijite los nuevos valores del documento a modificar: ");
        getDataDocuments();

        doc = new Documento(titulo, autor, editorial, anioPublicacion, codigo);

        return doc;

    }

    //Metodo del usuario. Contiene el menu 
    public static void datosUsuario() {
        int bandera = 0, banderaMenu = 0, opc = 0;
        Usuario usuario;
        boolean error;
        Seguridad seg;

        do {
            String numControl = "";

            do {
                error = false;
                numControl = JOptionPane.showInputDialog("Digite su numero de control: ");
                if (!numControl.matches("[0-9]+")) {
                    error = true;
                    getMenssageError(4);
                }
            } while (error);

            seg = new Seguridad("00000", numControl);//Corroborando su contraseña 
            if (seg.encotrarUsuario() == null) {

                int contraIncorrecta = Integer.parseInt(JOptionPane.showInputDialog("Numero de control no encontrado\nDigite: \n1)Para volver a intentar \n2)Para regresar al inicio"));
                if (contraIncorrecta == 2) {
                    bandera = 1;
                }

            } else {
                bandera = 1;
                usuario = seg.encotrarUsuario();

                JOptionPane.showMessageDialog(null, "Bienvenido \n" + usuario.mostrarDatos() + "\nPresione enter para acceder al menu");

                do {
                    do {

                        do {
                            error = false;
                            try {
                                opc = Integer.parseInt(JOptionPane.showInputDialog("\t\t.::MENU::.\t\t"
                                        + "                                         \n1.-Mostrar documentos"
                                        + "                                         \n2.-Prestar Documentos"
                                        + "                                         \n3.-Devolver Documentos"
                                        + "                                         \n4.-Buscar Documentos"
                                        + "                                         \n5.-Salir"));
                            } catch (NumberFormatException e) {
                                error = true;

                                getMenssageError(1);
                            }
                        } while (error);

                        if (opc > 0 && opc <= 5) {
                            banderaMenu = 1;

                        } else {
                            JOptionPane.showMessageDialog(null, "Eso no se encuentra en nuestro menu, vuelva a intentar");
                        }
                    } while (banderaMenu == 0);

                    switch (opc) {
                        case 1:
                            Persona.mostrarDocs();
                            break;
                        case 2:
                            if (usuario.estaVacio()) {
                                usuario.mostrarMensajeDeEstaVacio();
                            } else if (printCodes()) {
                                usuario.mostrarCodTit();
                            }
                            if (usuario.isPrestado()) {
                                JOptionPane.showMessageDialog(null, "No puedes prestar un libro porque actualmente ya tienes un libro prstado en tu poseción");
                            } else {
                                long codPrestar = getCode();
                                usuario.prestarDocumento(codPrestar);
                            }

                            break;
                        case 3:
                            long codDevolver = getCode();
                            usuario.devolverDocumento(codDevolver);

                            break;
                        case 4:
                            if (usuario.estaVacio()) {
                                usuario.mostrarMensajeDeEstaVacio();
                            } else {
                                getDataSearch();
                                usuario.buscarDocumento(titulo, autor);

                            }

                            break;
                        case 5:
                            JOptionPane.showMessageDialog(null, "Gracias por usar BiblioTec_A :)");
                            break;
                    }

                } while (opc != 5);
            }
        } while (bandera == 0);

    }

    //Metodo para registar datos de los documentos en general 
    public static void getDataDocuments() {

        boolean error;
        do {
            error = false;
            titulo = JOptionPane.showInputDialog("Digite el titulo: ");
            if (!titulo.matches("^[a-zA-Z0-9\\s]+$")) {
                error = true;
                getMenssageError(5);
            }
        } while (error);

        do {
            error = false;
            autor = JOptionPane.showInputDialog("Digite el autor: ");
            if (!autor.matches("[a-zA-Z ]+")) {
                error = true;
                getMenssageError(3);
            }
        } while (error);

        do {
            error = false;
            editorial = JOptionPane.showInputDialog("Digite la editorial: ");
            if (!editorial.matches("^[a-zA-Z0-9\\s]+$")) {
                error = true;
                getMenssageError(5);
            }
        } while (error);

        do {
            error = false;
            try {
                anioPublicacion = Integer.parseInt(JOptionPane.showInputDialog("Digite el año de publicacion: "));
            } catch (NumberFormatException e) {
                error = true;
                getMenssageError(1);
            }
        } while (error);

    }

    //Metodo que pide el titulo y autor de un documento a buscar 
    public static void getDataSearch() {

        boolean error;

        do {
            error = false;
            titulo = JOptionPane.showInputDialog("Digite el titulo del documento a buscar:");
            if (!titulo.matches("^[a-zA-Z0-9\\s]+$")) {
                error = true;
                getMenssageError(5);
            }
        } while (error);

        do {
            error = false;
            autor = JOptionPane.showInputDialog("Digite el autor del documento a buscar:");
            if (!autor.matches("^[a-zA-Z ]+$")) {
                error = true;
                getMenssageError(3);
            }
        } while (error);

    }

    //Metodo que genera el codigo de los libros 
    public static void CodeGeneration() {
        int salir = 1;
        Random random = new Random();
        int max = 99999;
        int min = 10000;
        int codRandom = 0;

        while (salir == 1) {
            codRandom = random.nextInt(max - min + 1) + min;
            if (Persona.ExisteCodigo(codRandom)) {
                salir = 0;
            }
        }

        codigo = codRandom;

        JOptionPane.showMessageDialog(null, "Codigo: " + codigo);
    }

    //Metodo que pide el codgo de un documento 
    public static int getCode() {

        boolean error;
        int cod = 1;

        do {
            error = false;
            try {
                cod = Integer.parseInt(JOptionPane.showInputDialog("Digite el codigo del documento: "));
            } catch (NumberFormatException e) {
                error = true;
                getMenssageError(1);
            }
        } while (error);

        return cod;
    }

    //Metodo que retorna si quieren ver los codigos de los documentos 
    public static boolean printCodes() {
        long cod = 0;
        String opcCod = "";
        boolean error;

        do {
            error = false;
            opcCod = JOptionPane.showInputDialog("Desea ver los codigos de los documento: ");
            if (opcCod.equalsIgnoreCase("si") || opcCod.equalsIgnoreCase("no")) {
                error = true;

            } else {
                JOptionPane.showMessageDialog(null, "Ingrese (si) o (no), como corresponda");
            }
        } while (!error);

        return opcCod.equalsIgnoreCase("SI");
        //

    }

    public static void getMenssageError(int x) {

        switch (x) {
            case 1:
                JOptionPane.showMessageDialog(null, "Error\nIngrese un valor numerico");
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Error\nNo puedes dejar sin llenar este espacio");
                break;
            case 3:
                JOptionPane.showMessageDialog(null, "No se permiten caracteres especiales, ni numeros");
                break;
            case 4:
                JOptionPane.showMessageDialog(null, "Solo ingresa numero");
                break;
            case 5:
                JOptionPane.showMessageDialog(null, "No se permiten caracteres especiales");
                break;

        }

    }

}
