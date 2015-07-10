package com.tutev.personelozluk.sampledata;

import org.fluttercode.datafactory.AddressDataValues;
import org.fluttercode.datafactory.impl.DefaultAddressDataValues;

public class IlGenerator implements AddressDataValues {

	String[] ilAdlari = { "Afyon", "Ankara", "Antalya", "İstanbul", "İzmir",
			"Giresun", "Sivas", "Erzincan", "Yozgat", "Kütahya" };
	
	String[] ilPlakalari = { "03", "06", "07", "34", "35",
			"28", "58", "24", "66", "43" };
	
	String[] ilTanimlari = { "Afyon", "Ankara", "Antalya", "İstanbul", "İzmir",
			"Giresun", "Sivas", "Erzincan", "Yozgat", "Kütahya" };

	public String[] getAddressSuffixes() {
		return ilPlakalari;
	}

	public String[] getCities() {
		return ilAdlari;
	}

	public String[] getStreetNames() {
		return ilTanimlari;
	}

}
