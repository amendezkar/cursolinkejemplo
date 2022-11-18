package ar.edu.utn.link.correlativas.app;

import ar.edu.utn.link.correlativas.model.CorrelativasException;
import ar.edu.utn.link.correlativas.model.Materia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Optional;

@RepositoryRestController
public class MateriasControllerComplement {

    @Autowired
    RepoMateriaJPA repo;

    @Transactional
    @DeleteMapping("/materias/{materiaId}")
    public @ResponseBody ResponseEntity<Object> delete(@PathVariable("materiaId") Long materiaId){

        Optional<Materia> materiaOptional = repo.findById(materiaId);

        if(materiaOptional.isPresent()){

            Materia materia = materiaOptional.get();

            if(materia.isActivo()){

                materia.setActivo(false);
                return ResponseEntity.ok("Materia borrada ok");
                //Equivale a ResponseEntity.ok().body("Materia borrada ok")
            }
        }

        return new ResponseEntity<Object>("La materia no existe", HttpStatus.NOT_FOUND);
        // ResponseEntity.notFound().build();
        //"La materia no existe";
    }

    @Transactional
    @PostMapping("/materias/{materiaId}/correlativas")
    public @ResponseBody ResponseEntity<Object> agregarCorrelativa(
            @PathVariable("materiaId") Long materiaId,
            @RequestBody Long corrId
            ) throws Exception{

        // --------------- Validar input y obtener objetos --------------------

        Optional<Materia> materiaOptional = repo.findById(materiaId);
        Optional<Materia> materiaCorrOptional = repo.findById(corrId);

        if(!materiaOptional.isPresent() || !materiaCorrOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }

        Materia materia = materiaOptional.get();
        Materia correlativa = materiaCorrOptional.get();

        // ------------ Dominio ---------------
        // try{
        materia.agregarCorrelativa(correlativa);
        //} catch(CorrelativasException ex){
        //    return new ResponseEntity<Object>(ex.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
        //}

        // ---------- Respuesta al Usuario ---------

        return ResponseEntity.ok(materia);
    }
}
