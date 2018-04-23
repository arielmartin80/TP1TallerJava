package ar.edu.unlam.tallerweb1;

import static org.junit.Assert.*;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.hibernate.Session;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.assertThat;

public class UsuarioTest extends SpringTest{

	@Test
	@Transactional
	@Rollback
	public void guardarUsuarioEnBD(){
//		creamos la session
		Session session=getSession();

//		Preparar: creamos un usuario
		Usuario ariel = new Usuario();
		ariel.setEmail("ariel_martin80@hotmail.com");
		ariel.setPassword("1234");
		ariel.setRol("admin");

//		Actuar: Guardamos el Usuario en BD
		session.save(ariel);

//		Verificar: realisamos el assert
		Usuario buscado = session.get(Usuario.class,ariel.getId());
		assertThat(buscado).isNotNull();
	}

}
