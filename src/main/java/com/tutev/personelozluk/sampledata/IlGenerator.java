package com.tutev.personelozluk.sampledata;

import org.fluttercode.datafactory.AddressDataValues;
import org.fluttercode.datafactory.impl.DefaultAddressDataValues;

public class IlGenerator implements AddressDataValues {

	String[] ilAdlari = { "Afyon", "Ankara", "Antalya", "�stanbul", "�zmir",
			"Giresun", "Sivas", "Erzincan", "Yozgat", "K�tahya" };
	
	String[] ilPlakalari = { "03", "06", "07", "34", "35",
			"28", "58", "24", "66", "43" };
	
	String[] ilTanimlari = { "Afyon", "Ankara", "Antalya", "�stanbul", "�zmir",
			"Giresun", "Sivas", "Erzincan", "Yozgat", "K�tahya" };

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
