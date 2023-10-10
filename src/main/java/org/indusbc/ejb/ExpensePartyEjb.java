package org.indusbc.ejb;

import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.indusbc.model.ExpenseAccount;
import org.indusbc.model.ExpenseCategory;
import org.indusbc.model.ExpenseParty;
import org.indusbc.util.FinancialYear;
import org.indusbc.util.HashGenerator;

/**
 *
 * @author singh
 */
@Stateless
public class ExpensePartyEjb implements ExpensePartyEjbLocal {
    
    private static final Logger LOGGER = Logger.getLogger(ExpensePartyEjb.class.getName());
    
    @PersistenceContext(name ="indusbcPU" )
    private EntityManager em;
    
    @Inject
    private ExpenseCategoryEjbLocal expenseCategoryEjbLocal;
    @Inject
    private ExpenseAccountEjbLocal expenseAccountEjbLocal;

    @Override
    public ExpenseParty createExpenseParty(ExpenseParty expenseParty, List<String> expensePartyAccountsList) {
        em.persist(expenseParty);
        em.flush();
        LOGGER.info(String.format("ExpenseParty created with ID: %d", expenseParty.getId()));
        //Create ExpenseAccounts now.
        for (String expenseCategoryStr : expensePartyAccountsList){
            ExpenseCategory expenseCategory= expenseCategoryEjbLocal.findByExpenseCategoryAndYear(expenseCategoryStr, FinancialYear.financialYear());
            ExpenseAccount ea =new ExpenseAccount();
            ea.setName(expenseCategoryStr);
            ea.setExpensePartyId(expenseParty.getId());
            ea.setExpenseCategoryId(expenseCategory.getId());
            ea.setCreatedOn(LocalDateTime.now());
            ea.setExpenseAccountHash(HashGenerator.generateHash(expenseParty.getEmail()+expenseCategoryStr));
            ea=expenseAccountEjbLocal.createExpenseAccount(ea);
        }
        return expenseParty; 
    }

    
}
