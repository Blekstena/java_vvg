package hr.vvg.programiranje.java.glavna;

import hr.vvg.programiranje.java.banka.DeviznaTransakcija;
import hr.vvg.programiranje.java.banka.DevizniRacun;
import hr.vvg.programiranje.java.banka.TekuciRacun;
import hr.vvg.programiranje.java.osoba.Osoba;

import java.math.BigDecimal;
import java.util.Scanner;

public class Glavna {

	public static void main(String[] args) {

		Scanner unos = new Scanner(System.in);

		System.out.print("Unesi ime prvog korisnika racuna: ");
		String ime1 = unos.next();
		System.out.print("Unesi prezime prvog korisnika racuna: ");
		String prezime1 = unos.next();
		System.out.print("Unesi OIB prvog korisnika racuna: ");
		String oib1 = unos.next();
		Osoba vlasnikRacuna1 = new Osoba(ime1, prezime1, oib1);

		System.out.print("Unesi broj prvog racuna: ");
		String brojRacuna1 = unos.next();
		System.out.print("Unesi stanje prvog raèuna: ");
		BigDecimal stanjeRacuna1 = unos.nextBigDecimal();
		TekuciRacun polazniRacun = new TekuciRacun(vlasnikRacuna1, stanjeRacuna1, brojRacuna1);

		System.out.print("Unesi ime drugog korisnika racuna: ");
		String ime2 = unos.next();
		System.out.print("Unesi prezime drugog korisnika racuna: ");
		String prezime2 = unos.next();
		System.out.print("Unesi OIB drugog korisnika racuna: ");
		String oib2 = unos.next();
		Osoba vlasnikRacuna2 = new Osoba(ime2, prezime2, oib2);

		System.out.print("Unesi broj prvog racuna: ");
		String brojRacuna2 = unos.next();
		System.out.print("Unesi stanje drugog racuna: ");
		BigDecimal stanjeRacuna2 = unos.nextBigDecimal();
		System.out.print("Unesi iBan racuna: ");
		String iban = unos.next();
		System.out.print("Unesi valutu drugog racuna: ");
		String valuta = unos.next();
		DevizniRacun dolazniRacun = new DevizniRacun(vlasnikRacuna2, stanjeRacuna2, iban, valuta, brojRacuna2);

		System.out.print("Unesi iznos za prebaciti sa prvog na drugi racun: ");
		BigDecimal iznosZaPrebaciti = unos.nextBigDecimal();
		DeviznaTransakcija transakcija = new DeviznaTransakcija(polazniRacun, dolazniRacun, iznosZaPrebaciti);

		transakcija.provediTransakciju();

		unos.close();


		// samo testiram pull request
		System.out.println("Vlasnik prvog racuna:\nime:  "
				+ polazniRacun.getVlasnikRacuna().getIme() + "\nprezime:  "	+ polazniRacun.getVlasnikRacuna().getPrezime() + "\noib:  "
				+ polazniRacun.getVlasnikRacuna().getOib() + "\nbroj raèuna: " + polazniRacun.getBrojRacuna() + 
				"\nstanje na racunu nakon transakcije: "  + polazniRacun.getStanjeRacuna());
		
		System.out.println("Vlasnik drugog racuna:\nime: "
				+ dolazniRacun.getVlasnikRacuna().getIme() + ";\nprezime:  "
				+ dolazniRacun.getVlasnikRacuna().getPrezime() + ";\noib:  "
				+ dolazniRacun.getVlasnikRacuna().getOib() + ";\nbroj raèuna: " + dolazniRacun.getBrojRacuna() 
				+ ";\nstanje na racunu nakon transakcije: "  + dolazniRacun.getStanjeRacuna() + dolazniRacun.getValuta());
	}

}
