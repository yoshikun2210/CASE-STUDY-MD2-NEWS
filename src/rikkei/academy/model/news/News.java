package rikkei.academy.model.news;

import java.io.Serializable;

public class News implements Serializable {
    int id;
    private String nameNews;
    private String content;

    public News(String newName,String newContent) {
        this.nameNews = newName;
        this.content = newContent;

    }

    public News(int id, String name, String content) {
        this.id = id;
        this.nameNews = name;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameNews() {
        return nameNews;
    }

    public void setNameNews(String nameNews) {
        this.nameNews = nameNews;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", name='" + nameNews + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
