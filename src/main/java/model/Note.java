package model;

import org.bson.types.ObjectId;

import java.time.LocalDateTime;

public class Note {
    private ObjectId id;
    private String title;
    private String content;
    private LocalDateTime createdAt;

}
