package dbaccess.vault;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import model.Country;

@Repository
public class CountryDAO extends GenericDAO {

	@Transactional
	public Integer create(Country coun) {
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().persist(coun);
		this.getEntityManager().getTransaction().commit();
		return coun.getId();

	}
}
