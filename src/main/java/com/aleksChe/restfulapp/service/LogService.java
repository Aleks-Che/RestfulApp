package com.aleksChe.restfulapp.service;

import com.aleksChe.restfulapp.entity.Log;
import com.aleksChe.restfulapp.repository.LogRepository;
import lombok.AllArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LogService {
    private final LogRepository logRepository;

    public void createLog(Log log){
        logRepository.save(log);
        }
}
