package hr.vvg.programiranje.java.banka;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DeviznaTransakcija extends Transakcija implements Devizna {
	
	private static final BigDecimal TECAJ_EUR_KN = new BigDecimal(7.5);
	
	public DeviznaTransakcija(TekuciRacun polazniRacun, DevizniRacun dolazniRacun, BigDecimal iznosZaPrebaciti){
		super(polazniRacun, dolazniRacun, iznosZaPrebaciti);
		}
	
	public BigDecimal mjenjacnica(BigDecimal iznosZaPrebaciti, String valuta){
		
		if ("EURO".equals(valuta) || "euro".equals(valuta)) {
			BigDecimal iznos = iznosZaPrebaciti.divide(TECAJ_EUR_KN, 2, RoundingMode.HALF_UP);
			return iznos;
			}
		else return iznosZaPrebaciti;
	}
	
	public void provediTransakciju(){
		
		polazniRacun.isplatiSRacuna(super.iznosZaPrebaciti);
		BigDecimal konvertiraniIznos = mjenjacnica(super.iznosZaPrebaciti,((DevizniRacun)dolazniRacun).getValuta());
		dolazniRacun.uplatiNaRacun(konvertiraniIznos);
	}
	
}
