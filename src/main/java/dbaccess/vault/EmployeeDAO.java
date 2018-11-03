package dbaccess.vault;

import model.Employee;

public class EmployeeDAO extends GenericDAO{
	public Integer create(Employee emp){
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().persist(emp);
		this.getEntityManager().getTransaction().commit();
		return emp.getId();

	} 
}
