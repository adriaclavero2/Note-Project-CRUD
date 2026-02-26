package model;

import org.bson.types.ObjectId;

import java.time.LocalDateTime;

public class Note {
    private ObjectId id;
    private String title;
    private String content;
    private LocalDateTime createdAt;

    public Note(){}

    public Note(String title, String content){
        this.title = title;
        this.content = content;
        this.createdAt = LocalDateTime.now();
    }

    public Note(ObjectId id, String title, String content, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
