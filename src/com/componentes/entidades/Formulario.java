package com.componentes.entidades;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.IndexColumn;


@Entity
@NamedQueries(value = {
		@NamedQuery(
				name = "Formulario.findPK", 
				query = "SELECT f FROM Formulario f"
	),
		@NamedQuery(
				name = "Formulario.DeUsuario", 
				query = "SELECT f FROM Formulario f WHERE f.UsuarioPadre = :usuarioParam "
	),
		@NamedQuery(
				name = "Formulario.Encuesta", 
				query = "SELECT f FROM Formulario f WHERE f.encuesta = :usuarioParam "
	)
})

@NamedNativeQueries({
	@NamedNativeQuery(
			name="Formulario.findAll", 
			query="SELECT * FROM formulario", 
			resultClass=Formulario.class), 
	@NamedNativeQuery(
			name="Formulario.findAllSQLWithParam", 
			query="SELECT * FROM formulario ", 
			resultClass=Formulario.class)			
})


public class Formulario implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	private String Nombre;
	private boolean Favorito;
	///Si con el se van aa contruir respuestas
	private boolean IsInterface; 
	@OneToMany(mappedBy="FormularioPadre",cascade= CascadeType.ALL)
	private List<Seccion> Secciones;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="fk_Usuario")
	private Usuario UsuarioPadre; 
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="fk_Encuesta")
	private Encuesta encuesta; 
	private static final long serialVersionUID = 1L;
	
	
	public Formulario() {
		super();
	}   
	
	public String toString() {
		return Nombre; 
	}
	
	public void setEncuesta(Encuesta encuesta) {
		this.encuesta = encuesta; 
	}
	public Encuesta getEncuesta() {
		return this.encuesta; 
	}
	
	public List<Seccion> GetSecciones(){
		return this.Secciones;
	}
	public void SetSecciones(List<Seccion> secciones){
		this.Secciones = secciones; 
	}
	
	public Integer getId() {
		return this.Id;
	}

	public void setId(Integer Id) {
		this.Id = Id;
	}   
	public String getNombre() {
		return this.Nombre;
	}

	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}   
	public boolean getFavorito() {
		return this.Favorito;
	}

	public void setFavorito(boolean Favorito) {
		this.Favorito = Favorito;
	}
	public Usuario getUsuarioPadre() {
		return this.UsuarioPadre; 
	}
	
	public void setUsuarioPadre(Usuario usuarioPadre) {
		this.UsuarioPadre = usuarioPadre; 
	}
	public boolean isIsInterface() {
		return IsInterface;
	}
	public void setIsInterface(boolean isInterface) {
		IsInterface = isInterface;
	}

	
}
