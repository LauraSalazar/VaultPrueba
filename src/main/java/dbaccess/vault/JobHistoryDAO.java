package dbaccess.vault;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import model.JobHistory;

@Repository
public class JobHistoryDAO extends GenericDAO{

	@Transactional
	public String create(JobHistory jobhist) {
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().persist(jobhist);
		this.getEntityManager().getTransaction().commit();
		return jobhist.getStartDate().toString();

	}
}
