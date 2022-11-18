package ar.edu.utn.link.correlativas.app;

import ar.edu.utn.link.correlativas.model.Alumno;
import ar.edu.utn.link.correlativas.model.Materia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.transaction.Transactional;
import java.util.Optional;

@RepositoryRestController
public class AlumnosControllerComplement {

    @Autowired
    RepoAlumnoJPA repoAlumno;

    @Autowired
    RepoMateriaJPA repoMateria;

    @Transactional
    @PostMapping("/alumnos/{alumnoId}/aprobadas")
    public @ResponseBody ResponseEntity<Object> agregarCorrelativa(
            @PathVariable("alumnoId") Long alumnoId,
            @RequestBody Long materiaId
    ) throws Exception{

        // --------------- Validar input y obtener objetos --------------------

        Optional<Alumno> alumnoOptional = repoAlumno.findById(alumnoId);
        Optional<Materia> materiaOptional = repoMateria.findById(materiaId);

        if(!alumnoOptional.isPresent() || !materiaOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }

        Alumno alumno = alumnoOptional.get();
        Materia materia = materiaOptional.get();

        // ------------ Dominio ---------------

        alumno.agregarMateriaAprobada(materia);

        // ---------- Respuesta al Usuario ---------

        return ResponseEntity.ok(alumno);
    }
}
