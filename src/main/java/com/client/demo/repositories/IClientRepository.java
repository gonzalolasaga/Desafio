package com.client.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.client.demo.models.ClientModel;

@Repository
public interface IClientRepository extends JpaRepository<ClientModel,Long> {
}
