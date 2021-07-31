package com.josue.sample.Service;

import com.josue.sample.Repository.BitacoraRepository;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@CommonsLog
@Service
public class Test {
    @Autowired
    private BitacoraRepository bitacoraRepository;

    public Test(BitacoraRepository bitacoraRepository){
        this.bitacoraRepository =  bitacoraRepository;
    }

    public void Test(){

        log.info(bitacoraRepository.findAll().toString());
    }

}
