package org.indusbc.ejb;

import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.indusbc.model.ExpenseAccount;

/**
 *
 * @author singh
 */
@Stateless
public class ExpenseAccountEjb implements ExpenseAccountEjbLocal {
    
    private static final Logger LOGGER = Logger.getLogger(ExpenseAccountEjb.class.getName());
    
    @PersistenceContext(name = "indusbcPU")
    private EntityManager em;

    @Override
    public ExpenseAccount createExpenseAccount(ExpenseAccount expenseAccount) {
        em.persist(expenseAccount);
        em.flush();
        LOGGER.info(String.format("ExpenseAccount created with %d", expenseAccount.getId()));
        return expenseAccount;
    }

    @Override
    public List<ExpenseAccount> getAllOfExpenseParty(int expensePartyId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
