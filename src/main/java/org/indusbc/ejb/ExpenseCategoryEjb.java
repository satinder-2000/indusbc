package org.indusbc.ejb;

import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.indusbc.model.ExpenseCategory;

/**
 *
 * @author singh
 */
@Stateless
public class ExpenseCategoryEjb implements ExpenseCategoryEjbLocal {
    
    private static final Logger LOGGER=Logger.getLogger(ExpenseCategoryEjb.class.getName());

    @PersistenceContext(name = "indusbcPU")
    private EntityManager em;
    
    @Override
    public List<ExpenseCategory> getAllForYear(int year) {
        TypedQuery<ExpenseCategory> tQ = em.createQuery("select ec from ExpenseCategory ec where ec.year=?1", ExpenseCategory.class);
        tQ.setParameter(1, year);
        List<ExpenseCategory> toReturn = tQ.getResultList();
        LOGGER.info(String.format("Total ExpenseCategory(s) for year %d are %d", year, toReturn.size()));
        return toReturn;
    }

    @Override
    public ExpenseCategory findByExpenseCategoryAndYear(String expenseCategory, int year) {
        TypedQuery<ExpenseCategory> tQ = em.createQuery("select ec from ExpenseCategory ec where ec.expenseCategory=?1 ec.year=?2", ExpenseCategory.class);
        tQ.setParameter(1, expenseCategory);
        tQ.setParameter(2, year);
        ExpenseCategory toReturn = tQ.getSingleResult();
        LOGGER.info(String.format("ExpenseCategory fetched with ID: %d", toReturn.getId()));
        return toReturn;
    }

    
}
