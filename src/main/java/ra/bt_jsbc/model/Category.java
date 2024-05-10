package ra.bt_jsbc.model;

import java.util.Date;

public class Category {
    private int id;
    private String name;
    private String descripttion;
    private Date createdDate;

    public Category() {
    }

    public Category(String name, String descripttion, Date createdDate) {
        this.name = name;
        this.descripttion = descripttion;
        this.createdDate = createdDate;
    }

    public Category(int id, String name, String descripttion, Date createdDate) {
        this.id = id;
        this.name = name;
        this.descripttion = descripttion;
        this.createdDate = createdDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescripttion() {
        return descripttion;
    }

    public void setDescripttion(String descripttion) {
        this.descripttion = descripttion;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
