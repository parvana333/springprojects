package com.example.demospringjpa.entity;

import javax.persistence.*;

@Entity
public class Adress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String info;
    @OneToOne(mappedBy = "adress")
    private Person person;

    public Adress() {
    }

    public Long getId() {
        return id;
    }

    public String getInfo() {
        return info;
    }
    public Person getPerson() {
        return person;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setInfo(String info) {
        this.info = info;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    @Override
    public String toString() {
        return "Adress{" +
                "id=" + id +
                ", info='" + info + '\'' +
                ", person=" + person +
                '}';
    }
}
