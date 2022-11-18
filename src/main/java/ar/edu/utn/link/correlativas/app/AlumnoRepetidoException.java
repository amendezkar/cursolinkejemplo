package ar.edu.utn.link.correlativas.app;

import lombok.Getter;

@Getter
public class AlumnoRepetidoException extends Exception {

    private String nombreAlumno;
    public AlumnoRepetidoException(String message) {
        super();
        nombreAlumno=message;
    }
}
