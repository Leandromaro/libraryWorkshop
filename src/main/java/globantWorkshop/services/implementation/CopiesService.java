package globantWorkshop.services.implementation;

import globantWorkshop.models.dao.CopiesDao;
import globantWorkshop.models.entities.Copies;
import globantWorkshop.services.interfaces.CopiesServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by leandromaro on 30/10/16.
 */
@Service
public class CopiesService implements CopiesServiceInterface {

    @Autowired
    CopiesDao copiesDao;


    public String save(Copies copies) {
        try {
            copiesDao.create(copies);
        }catch (IllegalArgumentException ex) {
            return "Error creating the copie: " + ex.toString();
        }
        return "Copie succesfully created!";
    }

}
