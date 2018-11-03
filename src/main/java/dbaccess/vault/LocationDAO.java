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
}
