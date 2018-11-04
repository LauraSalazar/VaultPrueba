package dbaccess.vault;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

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
	
	@Transactional
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
	
	@Transactional
	public void update(Employee emp){	
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().persist(emp);
		this.getEntityManager().getTransaction().commit();
	}
	
	@Transactional
	public void delete(Employee emp){	
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().remove(emp);
		this.getEntityManager().getTransaction().commit();
	}
	
	@Transactional
	public List<Employee> getEmpleadosByJobId(Integer id){

		 String query = "select new model.Employee(c.firstName,c.lastName,c.email,c.phoneNumber,c.hireDate,c.job,c.salary,c.commissionPct,c.manager,c.department) from EMPLOYEES ";
		 Query a = this.getEntityManager().createQuery(query);//.setParameter("id", id);
		 List<Employee>  employeeList = (List<Employee>) a.getResultList();
		 System.out.println("Antes de entrar al for: " );		 
		 for(Employee employee : employeeList) {
			 System.out.println("Employee FirstName: " + employee.getFirstName());
			 System.out.println("Employee id" + employee.getId());
		 }
		 return employeeList;
	}
	
	public List<Employee> getEmpleadosByManagerId(Integer id){
		 List<Employee> employeeList = new ArrayList<Employee>();
		 return employeeList;
	}
	
	public List<Employee> getEmpleadosLastName(Integer id){
		 List<Employee> employeeList = new ArrayList<Employee>();
		 return employeeList;
	}
}
