package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

@Entity
public class Punto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String latitud;
	private String longitud;
	
	public Punto(String latitud, String longitud){
		this.latitud=latitud;
		this.longitud=longitud;
	}
	
	public Punto(){
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLatitud() {
		return latitud;
	}
	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}
	public String getLongitud() {
		return longitud;
	}
	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}
	
}
