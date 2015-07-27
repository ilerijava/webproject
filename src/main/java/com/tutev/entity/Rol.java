package com.tutev.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "ROL")
public class Rol {

	private static final long serialVersionUID = 34232132L;
	Long id;
	String tanim;
	String kod;

	public Rol() {

	}

	public Rol(Long id, String tanim, String kod) {
		this.id = id;
		this.tanim = tanim;
		this.kod = kod;
	}

	@Id
	@Column(name = "id")
	@SequenceGenerator(allocationSize = 1, name = "seq_rol_id", initialValue = 1, sequenceName = "seq_rol_id")
	@GeneratedValue(generator = "seq_rol_id", strategy = GenerationType.SEQUENCE)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(unique = true,name = "tanim",length = 100)
	public String getTanim() {
		return tanim;
	}

	public void setTanim(String tanim) {
		this.tanim = tanim;
	}

	@Column(unique = true,name = "kod",length = 100)
	public String getKod() {
		return kod;
	}

	public void setKod(String kod) {
		this.kod = kod;
	}

}
