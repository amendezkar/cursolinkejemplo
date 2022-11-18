package ar.edu.utn.link.correlativas.app;

import lombok.Getter;

@Getter
public class MateriaRepetidaException extends Exception {

    private String nombreMateria;
    public MateriaRepetidaException(String message) {
        super();
        nombreMateria=message;
    }
}
