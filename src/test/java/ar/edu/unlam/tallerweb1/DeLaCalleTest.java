package ar.edu.unlam.tallerweb1;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.*;

public class DeLaCalleTest extends SpringTest{

	@Test
	@Transactional
	public void BuscarFarmaciasDeUnaCalle(){
		
		Session session;
		session=getSession();
		
		Direccion direccion1 = new Direccion("Cristiania",2464);
		Direccion direccion2 = new Direccion("Florencio Varela",1903);
		Direccion direccion3 = new Direccion("Cristiania",3900);
		
		Farmacia farmacia1 = new Farmacia(direccion1);
		Farmacia farmacia2 = new Farmacia(direccion2);
		Farmacia farmacia3 = new Farmacia(direccion3);	
				
		session.save(farmacia1);
		session.save(farmacia2);
		session.save(farmacia3);
		session.save(direccion1);
		session.save(direccion2);
		session.save(direccion3);
		
		List<Farmacia>farmaciasdeUnaCalle;
		farmaciasdeUnaCalle=session.createCriteria(Farmacia.class)
				.createAlias("direccion", "direccion")
				.add(Restrictions.eq("direccion.calle", "Florencio Varela"))
				.list();
		
		assertThat(farmaciasdeUnaCalle).hasSize(1);
		
		
		for (Farmacia lista: farmaciasdeUnaCalle) {
			
			assertEquals("Florencio Varela",lista.getDireccion().getCalle());
			
		}
	
	}
}
