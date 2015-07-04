package com.tutev.personelozluk.bean;



import javax.faces.bean.ManagedBean;

@ManagedBean(name = "editor")
public class EditorBean {

	private String value = "test";

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}