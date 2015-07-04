package com.tutev.personelozluk.sampledata;

import org.fluttercode.datafactory.AddressDataValues;

public class IlceGenerator implements AddressDataValues {

	String[] ilceAdlari = { "Sand�kl�", "Kozan", "Beypazar�", "�sk�dar",
			"Merkezefendi", "Almus", "Kemah", "Zara", "Sar�kaya", "Meram" };

	String[] ilceKodlari = { "Sand�kl�", "Kozan", "Beypazar�", "�sk�dar",
			"Merkezefendi", "Almus", "Kemah", "Zara", "Sar�kaya", "Meram" };

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
