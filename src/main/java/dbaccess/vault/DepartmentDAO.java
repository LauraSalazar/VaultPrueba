package dbaccess.vault;

import java.util.List;

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

	@Transactional
	public Double calcularPromedio(Integer locationId) {

		Double promedio = null;
		
		String query = "select avg(a.salary) from EMPLOYEES a where a.department.location.id = :locationId ";
		List<Double> d = (List<Double>) this.getEntityManager().createQuery(query).setParameter("locationId", locationId).getResultList(); 
		System.out.println("el promedio es:" + promedio);
		if (d.size() != 0) {
			promedio =  d.get(0).doubleValue();
		}
		System.out.println("el promedio es:" + promedio);
		return promedio;
	}

}
