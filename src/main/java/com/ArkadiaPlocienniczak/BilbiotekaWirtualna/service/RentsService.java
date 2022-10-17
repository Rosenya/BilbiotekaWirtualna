package com.ArkadiaPlocienniczak.BilbiotekaWirtualna.service;

import com.ArkadiaPlocienniczak.BilbiotekaWirtualna.model.Category;
import com.ArkadiaPlocienniczak.BilbiotekaWirtualna.model.Rents;
import com.ArkadiaPlocienniczak.BilbiotekaWirtualna.model.User;
import com.ArkadiaPlocienniczak.BilbiotekaWirtualna.repository.RentsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class RentsService {

    /*    @param injecting beans
    @return service methods

     */

    private RentsRepository rentsRepository;

    public RentsService(RentsRepository rentsRepository){
        this.rentsRepository = rentsRepository;
    }

    public List<Rents> getRents(){
        return rentsRepository.findAll();
    }

    public Rents getRentById(Long id){
        return rentsRepository.findById(id).orElse(null);
    }

    public void addRent(Rents rents){
        rentsRepository.save(rents);
        log.info("Dodano wypożyczenie: " + rents.getId());
    }

    public void deleteRentById(Long id){
        rentsRepository.deleteById(id);
        log.info("Zakończono wypożyczenie o id: " + id);
    }
}
