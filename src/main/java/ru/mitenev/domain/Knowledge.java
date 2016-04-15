package ru.mitenev.domain;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "KNOWLEDGE")
public class Knowledge {


    private Long id;
    private String description;
//    private KnowledgeType knowledgeType;
    private String location;
    private User user;

    public Knowledge() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }

//    public KnowledgeType getKnowledgeType() {
//        return knowledgeType;
//    }
//
//    public void setKnowledgeType(KnowledgeType knowledgeType) {
//        this.knowledgeType = knowledgeType;
//    }

    @Column(name = "LOCATION")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = User.class)
    @JoinColumn(name = "USER_ID")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return " knowledge=" + description;
    }
}
