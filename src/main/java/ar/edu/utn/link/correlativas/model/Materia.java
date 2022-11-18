package ar.edu.utn.link.correlativas.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Collection;

@Getter
@Setter
@Entity
public class Materia {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String nombre;

	@Min(1)
	private int anio;

	@ManyToMany
	private Collection<Materia> correlativas;

	private boolean activo;

	public Materia(){
		this.correlativas = new ArrayList<Materia>();
	}
	
	public Materia(String nombre, int anio) {
		this();
		this.nombre = nombre;
		this.anio = anio;
		this.activo=true;
	}
	
	public String getNombre() {

		return nombre;
	}

	public void setNombre(String nombre) {

		this.nombre = nombre;
	}

	public Collection<Materia> getCorrelativas() {

		return new ArrayList<Materia>(this.correlativas);
	}

	protected void setCorrelativas(Collection<Materia> correlativas) {

		this.correlativas = correlativas;
	}

	public void agregarCorrelativa(Materia correlativa) throws CorrelativasException{

		if(this.equals(correlativa)){
			throw new CorrelativasException("Una materia no puede ser correlativa de si misma", this, correlativa);
		}

		if(this.getCorrelativas().contains(correlativa)){
			throw new CorrelativasException("Ya es correlativa", this, correlativa);
		}

		if(!this.isActivo() || !correlativa.isActivo()){
			throw new CorrelativasException("La materia no es valida", this, correlativa);
		}

		this.correlativas.add(correlativa);
	}

	@Override
	public String toString() {

		return "Materia{" + "nombre='" + nombre + '\'' + ", correlativas=" + correlativas + '}';
	}
}
