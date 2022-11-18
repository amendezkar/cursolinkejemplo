package ar.edu.utn.link.correlativas.app;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import ar.edu.utn.link.correlativas.model.Materia;

import java.util.List;

@Repository
public interface RepoMateria {

    public void save(Materia m) throws MateriaRepetidaException;

    public List<Materia> all();

    public Page<Materia> page(Pageable pageable);

    public Materia porNombre(String nombre);

    boolean existeMateriaDeNombre(String nombre);

    List<Materia> porAnio(int anio);
}
