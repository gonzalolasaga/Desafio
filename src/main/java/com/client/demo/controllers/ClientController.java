package com.client.demo.controllers;

import com.client.demo.dto.AgeStatisticsDTO;
import com.client.demo.dto.ClientDTO;
import com.client.demo.dto.NewClientDTO;
import com.client.demo.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
/*
*Controller que expone Endpoints de consultas y registro de clientes para ser ultilizados externamente
 */
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("/listclientes")
    public List<ClientDTO> getAllClients(){
        return clientService.getAllClients();
    }

    @PostMapping("creacliente")
    public NewClientDTO saveClient(@RequestBody NewClientDTO newClient){
        return clientService.saveClient(newClient);
    }

    @GetMapping("/kpideclientes")
    public AgeStatisticsDTO getAgeStatistics(){
        return clientService.getAgeStatistics();
    }
}
