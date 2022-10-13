package com.ArkadiaPlocienniczak.BilbiotekaWirtualna.service;

import com.ArkadiaPlocienniczak.BilbiotekaWirtualna.repository.BookRepository;
import com.ArkadiaPlocienniczak.BilbiotekaWirtualna.repository.RentsRepository;
import org.springframework.stereotype.Service;

@Service
public class RentsService {

    private RentsRepository rentsRepository;

    public RentsService(RentsRepository rentsRepository){
        this.rentsRepository = rentsRepository;
    }
}
