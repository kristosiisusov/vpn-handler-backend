package com.netracker.services;


import com.netracker.dto.VpnDto;
import com.netracker.validation.annotations.VpnExists;


import javax.validation.Valid;
import java.util.List;
import java.util.UUID;


public interface IVpnService {
    VpnDto findById(@VpnExists UUID id);

    void deleteById(@VpnExists UUID id);

    VpnDto create(@Valid VpnDto vpnDto);

    List<VpnDto> getList();

    VpnDto updateById(@VpnExists UUID id, @Valid  VpnDto vpnDto);

    void deleteAll();

    boolean existsById(UUID id);
}
