package com.netracker.mapstruct;

import com.netracker.dto.VpnDto;
import com.netracker.model.Vpn;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VpnStruct {
    VpnStruct INSTANCE = Mappers.getMapper(VpnStruct.class);
    VpnDto toDto(Vpn vpn);

    Vpn fromDto(VpnDto vpnDto);

    List<VpnDto> toDto(List<Vpn> vpn);

    List<Vpn> fromDto(List<VpnDto> vpnDto);

}
