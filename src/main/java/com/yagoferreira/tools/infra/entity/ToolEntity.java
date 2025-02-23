package com.yagoferreira.tools.infra.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "tool")
public class ToolEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String link;

    private String description;

    @ElementCollection
    @CollectionTable(name = "tags", joinColumns = @JoinColumn(name = "tools_id"))
    @Column(name = "tag")
    private List<String> tags;

    public ToolEntity() {
    }

    public ToolEntity(Long id, String title, String link, String description, List<String> tags) {
        this.id = id;
        this.title = title;
        this.link = link;
        this.description = description;
        this.tags = tags;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
