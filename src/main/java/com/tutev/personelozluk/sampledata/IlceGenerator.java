package com.tutev.personelozluk.sampledata;

import org.fluttercode.datafactory.AddressDataValues;

public class IlceGenerator implements AddressDataValues {

	String[] ilceAdlari = { "Sandýklý", "Kozan", "Beypazarý", "Üsküdar",
			"Merkezefendi", "Almus", "Kemah", "Zara", "Sarýkaya", "Meram" };

	String[] ilceKodlari = { "Sandýklý", "Kozan", "Beypazarý", "Üsküdar",
			"Merkezefendi", "Almus", "Kemah", "Zara", "Sarýkaya", "Meram" };

	public String[] getAddressSuffixes() {
		return ilceKodlari;
	}

	public String[] getCities() {
		return ilceAdlari;
	}

	public String[] getStreetNames() {
		return ilceKodlari;
	}

}
