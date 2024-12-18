package org.indusbc.collections;

import java.util.Date;
import org.bson.types.ObjectId;

/**
 *
 * @author singh
 */
public class ExpenseAccount {
    
    private ObjectId _id;
    private String name;
    private int year;
    private ObjectId expenseCategoryId;
    private String expenseCategory;
    private ObjectId expensePartyId;
    private String expenseAccountHash;
    private Date createdOn;
    private String ytdBalance="0.0";

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public ObjectId getExpenseCategoryId() {
        return expenseCategoryId;
    }

    public void setExpenseCategoryId(ObjectId expenseCategoryId) {
        this.expenseCategoryId = expenseCategoryId;
    }

    public String getExpenseCategory() {
        return expenseCategory;
    }

    public void setExpenseCategory(String expenseCategory) {
        this.expenseCategory = expenseCategory;
    }

    public ObjectId getExpensePartyId() {
        return expensePartyId;
    }

    public void setExpensePartyId(ObjectId expensePartyId) {
        this.expensePartyId = expensePartyId;
    }

    public String getExpenseAccountHash() {
        return expenseAccountHash;
    }

    public void setExpenseAccountHash(String expenseAccountHash) {
        this.expenseAccountHash = expenseAccountHash;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getYtdBalance() {
        return ytdBalance;
    }

    public void setYtdBalance(String ytdBalance) {
        this.ytdBalance = ytdBalance;
    }

    
}
