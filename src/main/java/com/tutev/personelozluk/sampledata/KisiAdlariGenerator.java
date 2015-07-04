package com.tutev.personelozluk.sampledata;

import org.fluttercode.datafactory.NameDataValues;

public class KisiAdlariGenerator implements NameDataValues {

	String[] adlar = { "Ali", "Veli", "Kamil", "Hasan", "Hüseyin", "Cengiz",
			"Hakký", "Ahmet", "Mehmet", "Rasim" };

	String[] soyadlar = { "Çelik", "Yýlmaz", "Demir", "Akar", "Serin", "Eser",
			"Yeter", "Bulut", "Yaðmur", "Güler" };

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
