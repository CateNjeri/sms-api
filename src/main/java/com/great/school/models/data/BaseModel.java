package com.great.school.models.data;

import javax.annotation.PreDestroy;
import javax.persistence.*;
import java.util.Date;

/**
 * Created by Kibet on 25-Nov-17.
 */

public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    private Date createdAt;
    private Date updatedAt;
    private Date deletedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = new Date(System.currentTimeMillis());
    }
    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Date(System.currentTimeMillis());
    }
    @PreDestroy
    protected void onDelete() {
        deletedAt = new Date(System.currentTimeMillis());
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
