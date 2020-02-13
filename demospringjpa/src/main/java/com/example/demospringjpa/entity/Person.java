package com.example.demospringjpa.entity;
import org.omg.CORBA.portable.IDLEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
@Entity
public class Person{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="person_id")
    private long id;
    @Column(name="first_name")
    private String name;
    @Column(name="last_name")
    private String surname;

    @OneToOne()
    @JoinColumn(name="addres_id",referencedColumnName = "id")
    private Adress adress;

    public Person() {
    }
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Adress getAdress() {
        return adress;
    }
    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(getId(), person.getId()) &&
                Objects.equals(getName(), person.getName()) &&
                Objects.equals(getSurname(), person.getSurname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSurname());
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", adress=" + adress +
                '}';
    }
}
