package com.componentes.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



@Entity
@NamedQueries(value = {
		@NamedQuery(
				name = "Encuesta.findPK", 
				query = "SELECT f FROM Encuesta f"
	)
})


public class Encuesta implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	@OneToMany(mappedBy="encuesta",cascade= CascadeType.ALL)
    private List<Formulario> Respuestas;
	
	///Map to Scaffolding
	//fk_Encuesta
	@ManyToOne(cascade= CascadeType.ALL)
	private Formulario FrmScaffolding; 
	
	
	
	
	public Encuesta() {
		super(); 
	}
	
	
	public Formulario ConstruirRespuestas() {
	
		///Ir y buscar el formulario 
		return FrmScaffolding;   
		
	}
	
	public List<Formulario> getRespuestas() {
		return Respuestas;
	}
	public void setRespuestas(List<Formulario> respuestas) {
		Respuestas = respuestas;
	}
	public Formulario getFrmScaffolding() {
		return FrmScaffolding;
	}


	public void setFrmScaffolding(Formulario frmScaffolding) {
		FrmScaffolding = frmScaffolding;
	}


	
	
	
}



















