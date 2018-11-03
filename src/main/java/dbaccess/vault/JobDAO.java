package dbaccess.vault;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import model.Job;

@Repository
public class JobDAO extends GenericDAO {

	@Transactional
	public Integer create(Job job) {
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().persist(job);
		this.getEntityManager().getTransaction().commit();
		return job.getId();

	}

}
