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
		Employee emp = null;
		String query = "from EMPLOYEES a where a.id = :id ";
		if (!this.getEntityManager().createQuery(query).setParameter("id", id).getResultList().isEmpty()){
		emp = (Employee)this.getEntityManager().createQuery(query).setParameter("id", id).getSingleResult();
		}
		if (emp != null){
			 return emp;
					}
		return null;
	}
	
	public void update(Employee emp){	
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().persist(emp);
		this.getEntityManager().getTransaction().commit();
	}
	
	public void delete(Employee emp){	
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().remove(emp);
		this.getEntityManager().getTransaction().commit();
	}
	
	
}
