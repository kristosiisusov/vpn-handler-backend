package com.netracker.rest.controllers;

import com.netracker.dto.VpnDto;
import com.netracker.exceptions.NotExistConstraintViolationException;
import com.netracker.services.IVpnService;
import com.netracker.services.implementation.VpnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.UUID;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "/vpn-services")
public class VpnController {
    private final IVpnService iVpnService;

    @Autowired
    public VpnController(VpnService vpnService) {
        this.iVpnService = vpnService;
    }

    @GetMapping
    List<VpnDto> getList() {
        return iVpnService.getList();
    }

    @GetMapping("/{id}")
    VpnDto getById(@PathVariable("id") UUID id) {
        try {
            return iVpnService.findById(id);
        } catch (ConstraintViolationException e) {
            throw new NotExistConstraintViolationException(e.getMessage(), e.getConstraintViolations());
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    VpnDto create(@RequestBody VpnDto vpnDto) {
        return iVpnService.create(vpnDto);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable("id") UUID id) {
        try {
            iVpnService.deleteById(id);
        } catch (ConstraintViolationException e) {
            throw new NotExistConstraintViolationException(e.getMessage(), e.getConstraintViolations());
        }
    }

    @PutMapping("/{id}")
    VpnDto updateById(@PathVariable("id") UUID id, @RequestBody VpnDto vpnDto) {
        try {
            return iVpnService.updateById(id, vpnDto);
        } catch (ConstraintViolationException e) {
            throw new NotExistConstraintViolationException(e.getMessage(), e.getConstraintViolations());
        }
    }

    @DeleteMapping()
    void deleteAll() {
        iVpnService.deleteAll();

    }
}
