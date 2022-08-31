package rikkei.academy.model.category;

import java.io.Serializable;

public class Category implements Serializable {
    int id;
    String nameCategory;

    public Category(String newNameCategory) {
        this.nameCategory = newNameCategory;
    }

    public Category(int id, String nameCategory) {
        this.id = id;
        this.nameCategory = nameCategory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + nameCategory + '\'' +
                '}';
    }
}
