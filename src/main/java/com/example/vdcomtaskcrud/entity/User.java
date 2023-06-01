package com.example.vdcomtaskcrud.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    @NotEmpty(message = "Name shouldn't be empty")
    @Size(min = 2, max = 124, message = "Name should be between 2 and 124 symbols")
    private String name;

    @Column(name = "age")
    @Min(value = 0, message = "Age should be greater than 0")
    private int age;

    @Column(name = "vacancy")
    @NotEmpty(message = "Vacancy shouldn't be empty")
    @Size(min = 2, max = 124, message = "Vacancy should be between 2 and 124 symbols")
    private String vacancy;

    @Column(name = "email")
    @NotEmpty(message = "Email shouldn't be empty")
    @Email(message = "Email should be seem like email")
    private String email;

    public User(String name, int age, String vacancy, String email) {
        this.name = name;
        this.age = age;
        this.vacancy = vacancy;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && age == user.age && Objects.equals(name, user.name) && Objects.equals(vacancy, user.vacancy) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, vacancy, email);
    }
}
