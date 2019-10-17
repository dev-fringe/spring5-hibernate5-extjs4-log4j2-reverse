package hibernate.service;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import hibernate.model.HttpRestLog;
import hibernate.support.SupportService;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class HttpService extends SupportService{

	public void insert(HttpRestLog http) {
		log.info(http);
		session().save(http);
	}

	public List<HttpRestLog> select(HttpRestLog http) {
		CriteriaBuilder cb = session().getCriteriaBuilder();
		CriteriaQuery<HttpRestLog> cq = cb.createQuery(HttpRestLog.class);
		Root<HttpRestLog> root = cq.from(HttpRestLog.class);
		if(StringUtils.isEmpty(http.getId()) == false) {
			Predicate predicate = cb.equal(root.get("id"), http.getId());
			cq.select(root).where(predicate);
		}
		Query<HttpRestLog> query = session().createQuery(cq);
		query.setFirstResult(http.getFormRecord());
		query.setMaxResults(http.getSize());
		return query.list();
	}

	public Long selectCount() {
		CriteriaBuilder cb = session().getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		cq.select(cb.count(cq.from(HttpRestLog.class)));
		return session().createQuery(cq).getSingleResult();
	}

}
