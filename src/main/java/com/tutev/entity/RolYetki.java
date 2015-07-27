package com.tutev.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "ROLYETKI")
public class RolYetki implements Serializable  {


	private static final long serialVersionUID = 6193826421298692259L;
	Long id;
	Rol rol;
	Yetki yetki;
	
	public RolYetki() {
	}

	public RolYetki(Long id, Rol rol, Yetki yetki) {
		this.id = id;
		this.rol = rol;
		this.yetki = yetki;
	}

	@Id
	@Column(name = "id")
	@SequenceGenerator(allocationSize = 1, name = "seq_rol_yetki_id", initialValue = 1, sequenceName = "seq_rol_yetki_id")
	@GeneratedValue(generator = "seq_rol_yetki_id", strategy = GenerationType.SEQUENCE)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JoinColumn(name="rol")
	@ManyToOne(fetch=FetchType.LAZY)
	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	@JoinColumn(name="yetki")
	@ManyToOne(fetch=FetchType.LAZY)
	public Yetki getYetki() {
		return yetki;
	}

	public void setYetki(Yetki yetki) {
		this.yetki = yetki;
	}

}
