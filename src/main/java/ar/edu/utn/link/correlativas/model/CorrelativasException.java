package ar.edu.utn.link.correlativas.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CorrelativasException extends Exception{

    private Materia materia;
    private Materia corr;

    public CorrelativasException(String s) {
    }

    public CorrelativasException(String message, Throwable cause) {
        super(message, cause);
    }

    public CorrelativasException(String message, Materia mat, Materia corr){

        super(message);
        this.materia=mat;
        this.corr=corr;
    }

    public CorrelativasException(Throwable cause) {
        super(cause);
    }

    public CorrelativasException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public CorrelativasException() {
    }
}
