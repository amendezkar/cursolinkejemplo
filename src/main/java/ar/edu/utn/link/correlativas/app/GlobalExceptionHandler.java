package ar.edu.utn.link.correlativas.app;

import ar.edu.utn.link.correlativas.model.CorrelativasException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MateriaRepetidaException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    String materiaRepetida(MateriaRepetidaException ex){

        return "La materia " + ex.getNombreMateria() + " ya existe";
    }

    @ExceptionHandler(AlumnoRepetidoException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    String alumnoRepetido(AlumnoRepetidoException ex){

        return "El alumno " + ex.getNombreAlumno() + " ya existe";
    }

    @ExceptionHandler(CorrelativasException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String correlativaMal(CorrelativasException ex){

        return ex.getLocalizedMessage();
    }
}
