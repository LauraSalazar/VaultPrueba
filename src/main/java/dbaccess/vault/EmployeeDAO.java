package dbaccess.vault;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Employee;

@Repository
public class EmployeeDAO extends GenericDAO {

	@Transactional
	public Integer create(Employee emp) {
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().persist(emp);
		this.getEntityManager().getTransaction().commit();
		return emp.getId();

	}
}
