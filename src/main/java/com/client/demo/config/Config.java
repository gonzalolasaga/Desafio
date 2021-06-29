package com.client.demo.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Clase que guarda configuraciones necesarias para la aplicacion.
@Configuration
public class Config {

    @Bean
    //mapper utilizado para poder acotar a una linea el mapero de inforamcion entre DTO y Model
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
