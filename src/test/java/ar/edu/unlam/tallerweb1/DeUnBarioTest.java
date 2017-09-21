package ar.edu.unlam.tallerweb1;

import static org.junit.Assert.*;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.assertThat;
import ar.edu.unlam.tallerweb1.modelo.*;

public class DeUnBarioTest extends SpringTest{

	@Test
	@Transactional	
	public void BuscarFarmaciasDeUnBarrio(){

		Session session;
		session=getSession();
		
		Direccion direccion1= new Direccion("Cristiania",2464);
		Direccion direccion2= new Direccion("Florencio Varela",1903);
		Direccion direccion3= new Direccion("Juan Manuel de Rosas",6434);
		Direccion direccion4= new Direccion("Juncal",100);
		
		Barrio barrio1=new Barrio("Norte");
		Barrio barrio2=new Barrio("San Justo");
		Barrio barrio3=new Barrio("Casanova");
				
		direccion1.setBarrio(barrio1);
		direccion2.setBarrio(barrio2);	
		direccion3.setBarrio(barrio2);
		direccion4.setBarrio(barrio1);
		
		Farmacia farmacia1=new Farmacia(direccion1);
		Farmacia farmacia2=new Farmacia(direccion2);
		Farmacia farmacia3=new Farmacia(direccion3);	
				
		session.save(barrio1);
		session.save(barrio2);
		session.save(barrio3);
		session.save(direccion1);
		session.save(direccion2);
		session.save(direccion3);
		session.save(farmacia1);
		session.save(farmacia2);
		session.save(farmacia3);
				
		List<Farmacia>farmaciasDeUnBarrio;
		farmaciasDeUnBarrio=session.createCriteria(Farmacia.class)
					.createAlias("direccion", "direccion")
					.createAlias("direccion.barrio", "barrio")
					.add(Restrictions.eq("barrio.nombre", "San Justo"))
						.list();
				
				assertThat(farmaciasDeUnBarrio).hasSize(2);
				
				for (Farmacia lista: farmaciasDeUnBarrio) {
					
					assertEquals("San Justo",lista.getDireccion().getBarrio().getNombre());
					
				}
			}
	}