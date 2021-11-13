package view;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Professor;

public class Programa {
	public static void main(String[] args) {
		
		Professor prof1 = new Professor(null, "Lee Ji Ah", "1" , "1978-08-06" , "1267569076" , "leejiah12@hotmail.com" , "F");
		Professor prof2 = new Professor(null, "Park Eun Seok", "1" , "1984-02-10" , "1347469571" , "parkeunseok@hotmail.com" , "M");
		Professor prof3 = new Professor(null, "Lee Joon Gi", "1" , "1972-04-17" , "1367465048" , "leejoongi@hotmail.com" , "M");
		Professor prof4 = new Professor(null, "Moon Chae Won", "1" , "1986-11-13" , "1767868094" , "moonchaewon@hotmail.com" , "F");
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("projeto");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(prof1); //chamo o gerenciador de tabelas(em) para fazer o comando insert relacionado ao professor.
		em.persist(prof2);
		em.persist(prof3);
		em.persist(prof4);
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
}