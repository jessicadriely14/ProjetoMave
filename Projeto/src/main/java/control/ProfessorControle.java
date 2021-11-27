package control;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Professor;

public class ProfessorControle {

	private EntityManager em;

	public ProfessorControle() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("projeto");
		em = emf.createEntityManager();

	}

	public void inserir(Professor objeto) {
		try {
			em.getTransaction().begin();
			em.persist(objeto);
			em.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}
	}

	public void alterar(Professor objeto) {
		try {
			em.getTransaction().begin();
			em.merge(objeto);
			em.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();

		}
	}

	public void excluir(Professor objeto) {
		try {
			em.getTransaction().begin();
			em.remove(objeto);
			em.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();

		}
	}

	public void excluirPorId(Integer id) {
		try {
			Professor objeto = buscarPorId(id);
			excluir(objeto);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public Professor buscarPorId(Integer id) {

		return em.find(Professor.class, id);
	}

	public List<Professor> BuscarTodos() {
		String nomeClasse = Professor.class.getName();
		return em.createQuery("FROM " + nomeClasse).getResultList();
	}
}
