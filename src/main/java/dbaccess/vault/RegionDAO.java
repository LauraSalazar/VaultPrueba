package dbaccess.vault;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import model.Region;

@Repository
public class RegionDAO extends GenericDAO{
	@Transactional
	public Integer create(Region reg) {
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().persist(reg);
		this.getEntityManager().getTransaction().commit();
		return reg.getId();

	}
}
