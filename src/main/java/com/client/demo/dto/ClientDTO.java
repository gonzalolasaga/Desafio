package com.client.demo.dto;

import com.client.demo.models.ClientModel;
import java.time.LocalDate;

/*
* DTO que se usa como vehiculo de respuesta del servicio
* del informacion completa mas fecha probable de muerte de todos los clientes
 */
public class ClientDTO {

    public static ClientDTO from(ClientModel clientModel, LocalDate probableDeathDate ){
        return new ClientDTO(
                clientModel.getId(),
                clientModel.getFirstName(),
                clientModel.getLastName(),
                clientModel.getAge(),
                clientModel.getBirthDate(),
                probableDeathDate);
    }

    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private LocalDate birthDate;
    private LocalDate probableDeathDate;

    public ClientDTO(Long id, String firstName, String lastName, Integer age, LocalDate birthDate, LocalDate probableDeathDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.birthDate = birthDate;
        this.probableDeathDate = probableDeathDate;
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

    public LocalDate getProbableDeathDate() {
        return probableDeathDate;
    }

    public void setProbableDeathDate(LocalDate probableDeathDate) {
        this.probableDeathDate = probableDeathDate;
    }
}
