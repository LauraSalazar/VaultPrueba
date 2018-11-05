package dbaccess.vault;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import model.Location;

@Repository
public class LocationDAO extends GenericDAO{
	@Transactional
	public Integer create(Location loc) {
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().persist(loc);
		this.getEntityManager().getTransaction().commit();
		return loc.getId();

	}
	
	@Transactional
	public Location findById(Integer id){	
		Location loc = null;
		String query = "from LOCATIONS a where a.id = :id ";
		if (!this.getEntityManager().createQuery(query).setParameter("id", id).getResultList().isEmpty()){
		loc = (Location)this.getEntityManager().createQuery(query).setParameter("id", id).getSingleResult();
		}
		if (loc != null){
			 return loc;
					}
		return null;
	}
}
