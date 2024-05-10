package ra.bt_jsbc.model;

import java.time.LocalDate;

public class Product {
    private int id;
    private String name;
    private String images;
    private String descripttion;
    private LocalDate createdDate;
    private int price;
    private int categoryId;
    private boolean status;

    public Product() {
    }

    public Product(int id, String name, String images, String descripttion, LocalDate createdDate, int price, int categoryId, boolean status) {
        this.id = id;
        this.name = name;
        this.images = images;
        this.descripttion = descripttion;
        this.createdDate = createdDate;
        this.price = price;
        this.categoryId = categoryId;
        this.status = status;
    }

    public Product(String name, String images, String descripttion, LocalDate createdDate, int price, int categoryId, boolean status) {
        this.name = name;
        this.images = images;
        this.descripttion = descripttion;
        this.createdDate = createdDate;
        this.price = price;
        this.categoryId = categoryId;
        this.status = status;
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

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getDescripttion() {
        return descripttion;
    }

    public void setDescripttion(String descripttion) {
        this.descripttion = descripttion;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
