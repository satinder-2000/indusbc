package org.indusbc.ejb;

import java.util.List;
import javax.ejb.Local;
import org.indusbc.model.ExpenseCategory;

/**
 *
 * @author singh
 */
@Local
public interface ExpenseCategoryEjbLocal {
    
    public List<ExpenseCategory> getAllForYear(int year);
    public ExpenseCategory findByExpenseCategoryAndYear(String expenseCategory, int year);
    
}
