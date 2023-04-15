package ru.lenivtsev.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
@NamedQueries({
        @NamedQuery(name = "findAllUsers", query = "SELECT u FROM User u"),
        @NamedQuery(name = "deleteUserById", query = "DELETE FROM User u WHERE u.id = :id"),
        @NamedQuery(name = "findUserByName", query = "SELECT u FROM User u WHERE u.name = :name")
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
