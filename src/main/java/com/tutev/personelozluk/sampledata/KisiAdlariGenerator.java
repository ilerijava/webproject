package com.tutev.personelozluk.sampledata;

import org.fluttercode.datafactory.NameDataValues;

public class KisiAdlariGenerator implements NameDataValues {

	String[] adlar = { "Ali", "Veli", "Kamil", "Hasan", "H�seyin", "Cengiz",
			"Hakk�", "Ahmet", "Mehmet", "Rasim" };

	String[] soyadlar = { "�elik", "Y�lmaz", "Demir", "Akar", "Serin", "Eser",
			"Yeter", "Bulut", "Ya�mur", "G�ler" };

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
