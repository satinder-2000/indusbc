package org.indusbc.ejb;

import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.indusbc.model.IdentityType;

/**
 *
 * @author singh
 */
@Stateless
public class IdentityTypeEjb implements IdentityTypeEjbLocal {
    
    private static final Logger LOGGER = Logger.getLogger(IdentityTypeEjb.class.getName());
    
    @PersistenceContext(name = "indusbcPU")
    private EntityManager em;

    @Override
    public List<IdentityType> getAllIdentityTypes() {
        TypedQuery<IdentityType> tQ=em.createQuery("select it from IdentityType it", IdentityType.class);
        List<IdentityType> toReturn = tQ.getResultList();
        LOGGER.info(String.format("Count of IdentityType(s) is %d", toReturn.size()));
        return toReturn;
    }

    
}
