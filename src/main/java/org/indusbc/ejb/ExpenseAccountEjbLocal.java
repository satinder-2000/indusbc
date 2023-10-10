package org.indusbc.ejb;

import java.util.List;
import javax.ejb.Local;
import org.indusbc.model.ExpenseAccount;

/**
 *
 * @author singh
 */
@Local
public interface ExpenseAccountEjbLocal {
    
    public ExpenseAccount createExpenseAccount(ExpenseAccount expenseAccount);
    public List<ExpenseAccount> getAllOfExpenseParty(int expensePartyId);
    
}
