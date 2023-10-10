package org.indusbc.ejb;

import java.util.List;
import javax.ejb.Local;
import org.indusbc.model.IdentityType;

/**
 *
 * @author singh
 */
@Local
public interface IdentityTypeEjbLocal {
    
    public List<IdentityType> getAllIdentityTypes(); 
    
}
