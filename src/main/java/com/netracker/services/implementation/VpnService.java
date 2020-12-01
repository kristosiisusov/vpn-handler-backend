package com.netracker.services.implementation;

import com.google.common.collect.Lists;
import com.netracker.dto.VpnDto;
import com.netracker.mapstruct.VpnStruct;
import com.netracker.model.Vpn;
import com.netracker.repository.VpnBaseRepository;
import com.netracker.services.IVpnService;
import com.netracker.validation.annotations.VpnExists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;


import javax.validation.Valid;
import java.util.List;
import java.util.UUID;


@Slf4j
@Service
@Validated
public class VpnService implements IVpnService {
    //TODO добавить нормальное логирование http запросов

    private final VpnBaseRepository vpnBaseRepository;
    private final VpnStruct vpnStruct = VpnStruct.INSTANCE;

    @Autowired
    public VpnService(VpnBaseRepository vpnBaseRepository) {
        this.vpnBaseRepository = vpnBaseRepository;
    }

    @Override
    public VpnDto findById(@VpnExists UUID id){
        log.info("Start to getting of vpn by id = {}", id);
        return vpnStruct.toDto(vpnBaseRepository.findById(id).get());
    }
    @Override
    public void deleteById(@VpnExists UUID id){
        log.info("Start to deleting of vpn by id = {}", id);
        vpnBaseRepository.deleteById(id);
    }

    @Override
    public VpnDto create(@Valid VpnDto vpnDto){
        log.info("Start to creating new vpn = {}", vpnDto.toString());
        return vpnStruct.toDto(vpnBaseRepository.save(vpnStruct.fromDto(vpnDto)));
    }
    @Override
    public List<VpnDto> getList(){
        List<VpnDto> vpnDto = vpnStruct.toDto(Lists.newArrayList(
                vpnBaseRepository.findAll()));
        log.info("Start to getting list vpn = {}", vpnDto.toString());
        return vpnDto;
    }

    @Override
    public VpnDto updateById(@VpnExists UUID id, @Valid VpnDto vpnDto) {
        log.info("Start to updating vpn = {}", vpnDto.toString());
        Vpn newVpn = new Vpn();
        newVpn.setExpirationDate(vpnDto.getExpirationDate());
        newVpn.setTitle(vpnDto.getTitle());
        newVpn.setPassword(vpnDto.getPassword());
        return vpnStruct.toDto(vpnBaseRepository.save(newVpn));
    }

    @Override
    public void deleteAll() {
        vpnBaseRepository.deleteAll();
    }

    @Override
    public boolean existsById(UUID id) {
        return vpnBaseRepository.existsById(id);
    }
}
