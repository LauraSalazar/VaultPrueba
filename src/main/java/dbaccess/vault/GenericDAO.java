package dbaccess.vault;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.springframework.stereotype.Repository;

@Repository
public class GenericDAO {
	
	private EntityManagerFactory emFactory;
	private EntityManager entityManager;
	
	public GenericDAO(){
		super();
		emFactory = Persistence.createEntityManagerFactory("vault");
		entityManager = emFactory.createEntityManager();
	}
	
	public EntityManagerFactory getEmFactory() {
		return emFactory;
	}

	public void setEmFactory(EntityManagerFactory emFactory) {
		this.emFactory = emFactory;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
