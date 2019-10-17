package hibernate.service;

import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import hibernate.model.Event;
import hibernate.support.SupportService;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class EventService extends SupportService{

	public void insert() {
		session().save(new Event("Our very first event!", new Date()));
		session().save(new Event("A follow up event", new Date()));
	}

	public List<Event> select() {
		return session().createQuery("from Event", Event.class).list();
	}
	
	public Long selectCount() {
		CriteriaBuilder cb = session().getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		cq.select(cb.count(cq.from(Event.class)));
		return session().createQuery(cq).getSingleResult();
	}

	public void delete() {
		List<Event> list = session().createQuery("from Event", Event.class).list();
		for (Event event : list) {
			session().remove(event);
		}
	}

	public void create(Event event) {
		log.info("create = " + event);
		session().save(event);
	}

	public void update(Event event) {
		session().update(event);	
	}

	public List<Event> select(Event event) {
		CriteriaBuilder cb = session().getCriteriaBuilder();
		CriteriaQuery<Event> cq = cb.createQuery(Event.class);
		Root<Event> root = cq.from(Event.class);
		if(StringUtils.isEmpty(event.getId()) == false) {
			Predicate predicate = cb.equal(root.get("id"), event.getId());
			cq.select(root).where(predicate);
		}
		Query<Event> query = session().createQuery(cq);
		query.setFirstResult(event.getFormRecord());
		query.setMaxResults(event.getSize());
		return query.list();
	}

	public void delete(Event event) {
		session().remove(event);
	}

}
