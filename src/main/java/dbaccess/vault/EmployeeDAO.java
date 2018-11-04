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
	
	public Employee findById(Integer id){	
		String query = "from employees a where a.id = :id ";
		Employee emp = (Employee) this.getEntityManager().createQuery(query).setParameter("id", id).getSingleResult();
		return emp;
	}
	
	public void update(Employee emp){	
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().persist(emp);
		this.getEntityManager().getTransaction().commit();
	}
	
	
}
