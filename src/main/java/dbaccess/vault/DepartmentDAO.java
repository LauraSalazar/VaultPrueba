package dbaccess.vault;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import model.Department;

@Repository
public class DepartmentDAO extends GenericDAO {

	@Transactional
	public Integer create(Department dep) {
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().persist(dep);
		this.getEntityManager().getTransaction().commit();
		return dep.getId();

	}

}
