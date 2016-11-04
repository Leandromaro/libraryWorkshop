package globantWorkshop.models.dao;

import globantWorkshop.models.entities.Copies;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * Created by leandromaro on 30/10/16.
 */
@Repository
@Transactional
public class CopiesDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(Copies copies) {
        entityManager.persist(copies);
        return;
    }
}
