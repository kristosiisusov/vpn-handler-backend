package com.netracker.repository;

import com.netracker.model.Vpn;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface VpnBaseRepository extends CrudRepository<Vpn, UUID> {

}
