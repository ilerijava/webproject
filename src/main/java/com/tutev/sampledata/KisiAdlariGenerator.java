package com.tutev.sampledata;

import org.fluttercode.datafactory.NameDataValues;

public class KisiAdlariGenerator implements NameDataValues {

	String[] adlar = { "Ali", "Veli", "Kamil", "Hasan", "Hüseyin", "Cengiz",
			"Hakkı", "Ahmet", "Mehmet", "Rasim" };

	String[] soyadlar = { "Çelik", "Yılmaz", "Demir", "Akar", "Serin", "Eser",
			"Yeter", "Bulut", "Yağmur", "Güler" };

	public String[] getFirstNames() {
		return adlar;
	}

	public String[] getLastNames() {
		return soyadlar;
	}

	public String[] getPrefixes() {
		return adlar;
	}

	public String[] getSuffixes() {
		return soyadlar;
	}

}
