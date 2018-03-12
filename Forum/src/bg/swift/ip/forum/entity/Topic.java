package bg.swift.ip.forum.entity;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class Topic extends Entity {

  String name;
  String message;
  LocalDateTime dateCreated;
  LocalDateTime dateModified;
  User owner;
  int forumId;

    public Topic(String name, String message, LocalDateTime dateCreated, LocalDateTime dateModified, User owner, int forumId) {
        this.name = name;
        this.message = message;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
        this.owner = owner;
        this.forumId = forumId;
    }

    public Topic(){

    }

    public int getForumId() {
        return forumId;
    }

    public void setForumId(int forumId) {
        this.forumId = forumId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getDateModified() {
        return dateModified;
    }

    public void setDateModified(LocalDateTime dateModified) {
        this.dateModified = dateModified;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
