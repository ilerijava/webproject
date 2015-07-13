package com.tutev.personelozluk.sampledata;

import java.util.ArrayList;

import org.fluttercode.datafactory.impl.DataFactory;

import com.tutev.personelozluk.entity.Adres;
import com.tutev.personelozluk.entity.Il;
import com.tutev.personelozluk.entity.Ilce;
import com.tutev.personelozluk.entity.Kisi;
import com.tutev.personelozluk.service.AdresServis;
import com.tutev.personelozluk.service.IlServis;
import com.tutev.personelozluk.service.IlceServis;
import com.tutev.personelozluk.service.KisiServis;

public class SampleDataGenerator {

	static KisiServis kisiServis = new KisiServis();
	static AdresServis adresServis = new AdresServis();
	static IlServis ilServis = new IlServis();
	static IlceServis ilceServis = new IlceServis();

	static ArrayList<Adres> adresList = new ArrayList<Adres>();
	static ArrayList<Kisi> kisiList = new ArrayList<Kisi>();
	static ArrayList<Il> ilList = new ArrayList<Il>();
	static ArrayList<Ilce> ilceList = new ArrayList<Ilce>();

	public static void main(String[] args) {
//		generatorIller();
		
		ilList.addAll(ilServis.getAll());
//		generatorIlceler();
		
//		generatorAdresler();
		
		adresList.addAll(adresServis.getAll());
//		generatorKisiler();
	}

	public static void generatorKisiler() {
		DataFactory df = new DataFactory();
		df.setNameDataValues(new KisiAdlariGenerator());
		for (int i = 0; i < 10; i++) {
			Kisi kisi = new Kisi();
			kisi.setAd(df.getFirstName());
			kisi.setAdres(adresList.get(i));
			kisi.setSoyad(df.getLastName());
			kisi.setTcKimlikNo(df.getNumberText(11));
			kisiList.add(kisiServis.save(kisi));
		}
	}

	public static void generatorAdresler() {
		DataFactory df = new DataFactory();
		for (int i = 0; i < 10; i++) {
			Adres adres = new Adres();
			adres.setAdresTanim(df.getAddress());
			Il il = ilList.get(i);
			adres.setIl(il);
			adres.setIlce(ilceServis.getAllById(il.getId().toString()).get(0));
			adresList.add(adresServis.save(adres));
		}
	}

	public static void generatorIller() {
		DataFactory df = new DataFactory();
		df.setAddressDataValues(new IlGenerator());

		for (int i = 0; i < 10; i++) {
			String kod = df.getStreetSuffix();
			Il il = new Il();
			il.setKod(kod);
			il.setPlaka(kod);
			il.setTanim(df.getCity());
			ilList.add(ilServis.save(il));
		}
	}

	public static void generatorIlceler() {
		DataFactory df = new DataFactory();
		df.setAddressDataValues(new IlceGenerator());

		for (int i = 0; i < ilList.size(); i++) {
			String tanim = df.getCity();
			Ilce ilce = new Ilce();
			ilce.setKod(tanim);
			ilce.setTanim(tanim);
			ilce.setIl(ilList.get(i));
			ilceList.add(ilceServis.save(ilce));
		}
	}

}
