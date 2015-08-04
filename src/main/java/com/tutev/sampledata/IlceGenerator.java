package com.tutev.sampledata;

import org.fluttercode.datafactory.AddressDataValues;

public class IlceGenerator implements AddressDataValues {

  String[] ilceAdlari = {"Sandıklı", "Kozan", "Beypazarı", "Üsküdar",
      "Merkezefendi", "Almus", "Kemah", "Zara", "Sarıkaya", "Meram"};

  String[] ilceKodlari = {"Sandıklı", "Kozan", "Beypazarı", "Üsküdar",
      "Merkezefendi", "Almus", "Kemah", "Zara", "Sarıkaya", "Meram"};

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
