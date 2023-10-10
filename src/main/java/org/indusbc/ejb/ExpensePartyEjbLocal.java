package org.indusbc.ejb;

import java.util.List;
import javax.ejb.Local;
import org.indusbc.model.ExpenseParty;

/**
 *
 * @author singh
 */
@Local
public interface ExpensePartyEjbLocal {
    
    public ExpenseParty createExpenseParty(ExpenseParty expenseParty, List<String> expensePartyAccountsList);
    
}
