package ar.edu.utn.link.correlativas.app;

import ar.edu.utn.link.correlativas.model.Alumno;
import ar.edu.utn.link.correlativas.model.dtos.DTOAlumno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "alumnos", excerptProjection = DTOAlumno.class)
public interface RepoAlumnoJPA extends JpaRepository<Alumno, Long> {

    DTOAlumno findAlumnoByNombreAndApellido(String nombre, String apellido);
    Page<Alumno> findAlumnoByNombre(String nombre, Pageable page);
}
