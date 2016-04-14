package ru.mitenev.domain;

import org.joda.time.DateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private DateTime birthDate;
    private DateTime registrationTime;
    private Set<Knowledge> knowledgeSet = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "PHONE_NUMBER")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "BIRTH_DATE")
    public DateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(DateTime birthDate) {
        this.birthDate = birthDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "REGISTRATION_TIME")
    public DateTime getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(DateTime registrationTime) {
        this.registrationTime = registrationTime;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    public void setKnowledgeSet(Set<Knowledge> knowledgeSet) {
        this.knowledgeSet = knowledgeSet;
    }

    public Set<Knowledge> getKnowledgeSet() {
        return knowledgeSet;
    }

    public void addKnowledge(Knowledge knowledge) {
        knowledge.setUser(this);
        getKnowledgeSet().add(knowledge);
    }

    public void remove(Knowledge knowledge) {
        getKnowledgeSet().remove(knowledge);
    }
}
