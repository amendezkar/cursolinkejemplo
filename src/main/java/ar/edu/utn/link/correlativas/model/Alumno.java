package ar.edu.utn.link.correlativas.model;

import lombok.Getter;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.*;

@Setter
@Getter
@Entity
public class Alumno {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;
	private String apellido;

	@Transient
	@JsonIgnore
	private List<Curso> cursos;

	@ManyToMany
	private Collection<Materia> materiasAprobadas;

	public Alumno(){
		this.materiasAprobadas = new ArrayList<Materia>();
	}

	public Alumno(String nombre) {
		this();
		this.nombre = nombre;
	}

	public Alumno(String nombre, String apellido) {
		this();
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public void inscribir(Curso curso) {
		// TODO Auto-generated method stub
		
	}

	public Collection<Materia> getMateriasAprobadas() {
		return new ArrayList<Materia>(this.materiasAprobadas);
	}

	protected void setMateriasAprobadas(Collection<Materia> materiasAprobadas) {
		this.materiasAprobadas = materiasAprobadas;
	}

	public void agregarMateriaAprobada(Materia materia) {

		//Las validaciones y chequeos irian aca...

		this.materiasAprobadas.add(materia);
	}
}
