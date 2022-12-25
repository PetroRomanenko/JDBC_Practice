package com.ferros.model;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Post {
    private Integer id;
    private String content;
    private Long created;
    private Long updated;
    private PostStatus status;
    private List<Label> labels;

    public PostStatus getStatus() {
        return status;
    }

    public void setStatus(PostStatus status) {
        this.status = status;
    }

    public Post(Integer id, String content, Long created, Long updated, PostStatus status, List<Label> labels) {
        this.id = id;
        this.content = content;
        this.created = created;
        this.updated = updated;
        this.status = status;
        this.labels = labels;
    }

    public Post(Integer id, String content, Long created, PostStatus status, List<Label> labels) {
        this.id = id;
        this.content = content;
        this.created = created;
        this.status = status;
        this.labels = labels;
    }

    public Post(Integer id, String content, PostStatus status) {
        this.id = id;
        this.content = content;
        this.status = status;
    }

    public Post(Integer id, String content, Long created, Long updated, PostStatus status) {
        this.id = id;
        this.content = content;
        this.created = created;
        this.updated = updated;
        this.status = status;
    }

    public Post(String content, PostStatus status) {
        this.content = content;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Post post = (Post) o;
        return id.equals(post.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public Long getUpdated() {
        return updated;
    }

    public void setUpdated(Long updated) {
        this.updated = updated;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                ", status=" + status +
                ", labels=" + labels +
                '}';
    }
}
