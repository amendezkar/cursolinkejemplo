package ar.edu.utn.link.correlativas;

import ar.edu.utn.link.correlativas.app.RepoAlumnoJPA;
import ar.edu.utn.link.correlativas.app.RepoMateriaJPA;
import ar.edu.utn.link.correlativas.model.Alumno;
import ar.edu.utn.link.correlativas.model.Materia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class AppCorrelativas {

    @Autowired
    RepositoryRestConfiguration config;

    @Value("${algo}")
    private int unNumero;

    @Value("${path}")
    private String unPath;

    public static void main(String[] args) {

        SpringApplication.run(AppCorrelativas.class, args);
    }

    @Bean
    public CommandLineRunner init(RepoMateriaJPA repoMateria, RepoAlumnoJPA repoAlumno){

        config.exposeIdsFor(Materia.class);

        return(cosas) -> {
            repoMateria.save(new Materia("SO", 3));
            repoMateria.save(new Materia("DDS", 3));
            Materia algo = new Materia("Algo", 1);
            repoMateria.save(algo);
            repoMateria.save(new Materia("Analisis", 2));
            repoMateria.save(new Materia("Sintaxis", 2));

            //System.out.println(unNumero);
            //System.out.println(unPath);

            Alumno pepe = new Alumno("pepe", "gomez");
            pepe.getMateriasAprobadas().add(algo);
            repoAlumno.save(pepe);
            repoAlumno.save(new Alumno("juan", "benitez"));
            repoAlumno.save(new Alumno("jorge", "sosa"));
        };
    }
}
