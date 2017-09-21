package ar.edu.unlam.tallerweb1.modelo;

import java.util.*;
import javax.persistence.*;

@Entity
public class Comuna {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	
	@OneToMany (mappedBy = "comuna", cascade = CascadeType.ALL)
	private List<Barrio> barrios = new ArrayList<Barrio> ();
	
	public Barrio addBarrio(Barrio barrio) {
		return barrio;
	}
	
	public List<Barrio> getBarrios() {
		return barrios;
	}

	public void setBarrios(List<Barrio> barrios) {
		this.barrios = barrios;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
