package org.indusbc.collections;

import java.util.Date;
import org.bson.types.ObjectId;

/**
 *
 * @author singh
 */
public class Access {
    
    private ObjectId _id;
    private String accessType;
    private String email;
    private int failedAttempts;
    private Date lastAccessedOn;
    private ObjectId partyId;
    private String password;

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }

    public String getAccessType() {
        return accessType;
    }

    public void setAccessType(String accessType) {
        this.accessType = accessType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getFailedAttempts() {
        return failedAttempts;
    }

    public void setFailedAttempts(int failedAttempts) {
        this.failedAttempts = failedAttempts;
    }

    public Date getLastAccessedOn() {
        return lastAccessedOn;
    }

    public void setLastAccessedOn(Date lastAccessedOn) {
        this.lastAccessedOn = lastAccessedOn;
    }

    

    public ObjectId getPartyId() {
        return partyId;
    }

    public void setPartyId(ObjectId partyId) {
        this.partyId = partyId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    
    
}
