package org.indusbc.collections;

import org.bson.types.ObjectId;

/**
 *
 * @author singh
 */
public class ExpenseCategory {
    
    private ObjectId _id;
    private int year;
    private String expenseCategory;

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getExpenseCategory() {
        return expenseCategory;
    }

    public void setExpenseCategory(String expenseCategory) {
        this.expenseCategory = expenseCategory;
    }
    
    
    
}
