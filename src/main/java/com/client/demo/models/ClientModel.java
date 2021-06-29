package com.client.demo.models;

import javax.persistence.*;
import java.time.LocalDate;

/*
 * Modelo de datos equivalente a la tabla Cleintes usado para obtener y regitrar los datos en al misma.
 */
@Entity
@Table(name ="Cliente")
public class ClientModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    @Column (name="Nombre")
    private String firstName;
    @Column (name="Apellido")
    private String lastName;
    @Column(name="Edad")
    private Integer age;
    @Column(name="FechaNacimiento")
    private LocalDate birthDate;

    public ClientModel(){
    }

    public ClientModel(Long id, String firstName, String lastName, Integer age, LocalDate birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "NewClienteModel{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", birthDate=" + birthDate +
                '}';
    }
}
