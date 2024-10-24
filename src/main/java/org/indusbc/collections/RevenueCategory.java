package org.indusbc.collections;

import org.bson.types.ObjectId;

/**
 *
 * @author singh
 */
public class RevenueCategory {
    
    private ObjectId _id;
    private int year;
    private String revenueCategory;

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

    public String getRevenueCategory() {
        return revenueCategory;
    }

    public void setRevenueCategory(String revenueCategory) {
        this.revenueCategory = revenueCategory;
    }
    
    
    
}
