package com.siqueyros.dscommerce.entities;

import jakarta.persistence.*;
import org.apache.catalina.mapper.Mapper;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table (name = "tb_User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(unique = true)

    private String email;
    private String phone;
    private LocalDate birthDate;
    private String password;
    //private String[] roles;

    @OneToMany(mappedBy = "client")
    private List<Order> orders = new ArrayList<>();

    public User() {}

    public User(Long id, String nome, String email, String phone, LocalDate birthDate, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.birthDate = birthDate;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return name;
    }

    public void setNome(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getBirthData() {
        return birthDate;
    }

    public void setBirthData(LocalDate birthData) {
        this.birthDate = birthData;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(email, user.email) && Objects.equals(phone, user.phone) && Objects.equals(birthDate, user.birthDate) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, phone, birthDate, password);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nome='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", birthData=" + birthDate +
                ", password='" + password + '\'' +
                '}';
    }
}
