package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Message;

@Stateless
public class MessageService {

	@PersistenceContext
	private EntityManager entityManager;

	public void create(Message msg) {
		entityManager.persist(msg);
	}

	public List<Message> list() {
		return entityManager.createQuery("select m from Message m order by m.id desc", Message.class).getResultList();

	}

}
