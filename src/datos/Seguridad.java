package datos;

import javax.swing.JOptionPane;

/**
 *
 * @author malaf
 */
public class Seguridad {

    private final String[] contraseniasDeEncargados = {"1234567", "8135175", "5153975"};
    private final String[] numeroControlEstudiantes = {"22270512", "22270501", "22270532", "22270504", "22270506", "22270371"};
    private String contrasenia;
    private String numeroControl;

    public Seguridad(String contrasenia) {
        if (contrasenia == null) {
            throw new NullPointerException("No pude ser una cadenda null");
        }
        this.contrasenia = contrasenia;
    }

    public Seguridad(String contrasenia, String numeroControl) {

        this.numeroControl = numeroControl;
    }
    

    public Encargado encotrarEncargado() {
        Encargado encontrado = null;
        boolean error;

        switch (contrasenia) {
            case "1234567":
                encontrado = new Encargado("13DGG3KSJB", contrasenia, "Matutino", "Pedro", "Vazquez Vazquez", 96715344);
                break;
            case "8135175":
                encontrado = new Encargado("43MKG3KFGB", contrasenia, "Despertino", "Frida", "Serrano Guzman", 96735754);
                break;
            case "5153975":
                encontrado = new Encargado("5KJKG3GNGP", contrasenia, "Despertino", "Critian", "Velazquez Gomez", 96735754);
                break;

        }

        return encontrado;
    }

    private boolean comprobarNumeroControl() {
        boolean encontrado = false;
        for (int i = 0; i < numeroControlEstudiantes.length; i++) {
            if (numeroControl.equals(numeroControlEstudiantes[i])) {
                encontrado = true;
                break;
            }
        }
        return encontrado;
    }

    
    public Usuario encotrarUsuario() {
        Usuario encontrado = null;

        if (comprobarNumeroControl()) {
            switch (numeroControl) {
                case "22270512":
                    Usuario usuario1=new Usuario(numeroControl, "Cristian Ivan", "Vazquez Vazquez", 967145957);
                    encontrado = usuario1;
                    break;
                case "22270501":
                    encontrado = new Usuario(numeroControl, "Frida Monserrath", "Vazquez de la Cruz", 967147853);
                    break;
                case "22270532":
                    encontrado = new Usuario(numeroControl, "Alejandro", "Serrano Guzman", 961767574);
                    break;
                case "22270504":
                    encontrado = new Usuario(numeroControl, "Fernando Gael", "Estrada Velasco", 961875674);
                    break;
                case "22270506":
                    encontrado = new Usuario(numeroControl, "Raul", "Chavira Narvaez", 961875674);
                    break;
                case "22270371":
                    encontrado = new Usuario(numeroControl, "Gabriela", "Silva Gaspar", 961535222);
                    break;
            }
        }

        return encontrado;
    }
}
