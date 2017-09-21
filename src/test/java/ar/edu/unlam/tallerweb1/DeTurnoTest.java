package ar.edu.unlam.tallerweb1;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Farmacia;

public class DeTurnoTest extends SpringTest{

	@Test
	@Transactional	
	public void BuscarFarmaciasDeTurnoDiaMarte(){
		
		Session session;
		session=getSession();
				
		Farmacia farmacia1 =new Farmacia("lodefarma","viernes");
		Farmacia farmacia2 =new Farmacia("andaafarfear","sabado");
		Farmacia farmacia3 =new Farmacia("farmacity","martes");
		Farmacia farmacia4 =new Farmacia("farmacolor","martes");
		Farmacia farmacia5 =new Farmacia("laFarmaDelColo","martes");
	
		session.save(farmacia1);
		session.save(farmacia2);
		session.save(farmacia3);
		session.save(farmacia4);
		session.save(farmacia5);
		
		List<Farmacia>farmaciasDeTurno;
		farmaciasDeTurno=session.createCriteria(Farmacia.class)
				.add(Restrictions.eq("diaDeTurno", "martes"))
				.list();
		
		assertThat(farmaciasDeTurno).hasSize(3);
		
		for (Farmacia lista: farmaciasDeTurno) {
			
			assertEquals("martes",lista.getDiaDeTurno());
			
		}
	}
}
     

