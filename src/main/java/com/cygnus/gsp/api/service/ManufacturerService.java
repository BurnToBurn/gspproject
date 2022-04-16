package com.cygnus.gsp.api.service;

import com.cygnus.gsp.api.domain.model.Manufacturer;
import com.cygnus.gsp.api.exception.NotFoundException;
import com.cygnus.gsp.api.persistance.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class ManufacturerService {
    private final ManufacturerRepository manufacturerRepository;

    @Autowired
    public ManufacturerService(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    public List<Manufacturer> getAllManufacturers(){
        return manufacturerRepository.findAll();
    }

    public Manufacturer getManufacturerById(@NotNull Long manufacturerId){
        return manufacturerRepository.findById(manufacturerId)
                .orElseThrow(() -> new NotFoundException("No matching manufacturer was found"));
    }

    public Manufacturer createManufacturer(@NotNull Manufacturer manufacturer){
        if(manufacturer.getManufacturerGroup() == null || manufacturer.getManufacturerGroup().isEmpty()){
            manufacturer.setManufacturerGroup(manufacturer.getManufacturerId());
        }
        return manufacturerRepository.save(manufacturer);
    }

    public Manufacturer updateManufacturer(@NotNull Long manufacturerId,@NotNull Manufacturer manufacturer){

        return manufacturerRepository.findById(manufacturerId)
                .map(newManufacturer -> {
                    newManufacturer.setManufacturerId(manufacturer.getManufacturerId());
                    newManufacturer.setManufacturerGroup(manufacturer.getManufacturerGroup());
                    newManufacturer.setShortName(manufacturer.getShortName());
                    newManufacturer.setCountry(manufacturer.getCountry());
                    newManufacturer.setFullName(manufacturer.getFullName());
                    return manufacturerRepository.save(newManufacturer);
                }).orElseThrow(() -> new NotFoundException("No matching manufacturer was found"));

    }

    public void deleteManufacturerById(Long manufacturerId){
        manufacturerRepository.findById(manufacturerId).orElseThrow(() -> new NotFoundException("No matching manufacturer was found"));
        manufacturerRepository.deleteById(manufacturerId);
    }
}
