package com.client.demo.services;

import com.client.demo.dto.AgeStatisticsDTO;
import com.client.demo.dto.ClientDTO;
import com.client.demo.dto.NewClientDTO;
import com.client.demo.models.ClientModel;
import com.client.demo.repositories.IClientRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.List;

import static java.util.stream.Collectors.toList;

/*
*Service que expone metodos para consulta de informacion sobre los clientes de la base
 */
@Service
public class ClientService {
    //constante usada a fines practico para representar la espectativa de vida en años de las personas
    private static final int LIFE_EXPECTANCY = 75;

    @Autowired
    IClientRepository clientRepository;

    @Autowired
    private ModelMapper modelMapper;

    //Metodo que devuelve el promedio de edad y el desvio estandar de la edad de todos los clientes de la base
    public AgeStatisticsDTO getAgeStatistics(){
        List<ClientModel> allClients = clientRepository.findAll();
        Double average = calculateAverage(allClients);
        Double standardDeviation = calculateStandardDeviation(average,allClients);
        return new AgeStatisticsDTO(average, standardDeviation);
    }
    //metodo privado encargado de hacer el calculo de promedio de los clientes de la base
    private Double calculateAverage(List<ClientModel> allClients) {
        Double average = allClients.stream()
                .map(clientModel -> clientModel.getAge())
                .mapToDouble(Integer::intValue).average().getAsDouble();
        return average;
    }
    //metodo privado que hace el calculo del desvio estandar de las edades de los clientes de la base
    private Double calculateStandardDeviation(Double average, List<ClientModel> allClients) {
       Double variance =  (allClients.stream()
               .mapToDouble(client -> Math.pow( Double.valueOf(client.getAge()) - average ,2))
               .sum()) / allClients.size();
       return Math.sqrt(variance);
    }
    //metodo utilizado para guardar un nuevo cliente en la base
    public NewClientDTO saveClient(NewClientDTO newClient){
        ClientModel clientModel = modelMapper.map(newClient, ClientModel.class);
        return modelMapper.map(clientRepository.save(clientModel), NewClientDTO.class);
    }
    //metodos utilizado para consultar toda la informacion de todos los clientes
    //de la base junto con el caluclo de la fecha probable de muerte de cada uno de ellos
    public List<ClientDTO> getAllClients(){
        return  clientRepository.findAll()
                .stream()
                .map(clientModel -> ClientDTO.from(clientModel,calculateProbableDeathDate(clientModel)))
                .collect(toList());
    }
    //metodos privado que dado un cliente calcula su fecha probable de muerte usando la constante de que guarda
    // la esperanza de vida en el pais
    private LocalDate calculateProbableDeathDate(ClientModel clientRepository) {
        return clientRepository.getBirthDate().plusYears(LIFE_EXPECTANCY);
    }

}
