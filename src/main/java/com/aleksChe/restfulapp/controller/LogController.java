package com.aleksChe.restfulapp.controller;

import com.aleksChe.restfulapp.entity.Log;
import com.aleksChe.restfulapp.service.LogService;
import lombok.AllArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("log")
@AllArgsConstructor
public class LogController {
    private final LogService logService;
    private static Logger logger = Logger.getLogger(LogController.class);

    @PostMapping(consumes = "application/json")
    public void createLog(@RequestBody Log log) {
        logService.createLog(log);
        logger.info("Message: " + log.getMessage() +". Type: " + log.getType() + ". Level: " + log.getLevel() + ". Time: " + log.getTime().toString());
    }

    @GetMapping("/{id:\\d+}")
    public Log getLog(@PathVariable Long id) {
        return logService.getLog(id);
    }

    @ExceptionHandler(Exception.class)
    private void handleException(Exception exception){
        logger.info("Exception: " + exception.getMessage());
    }
}
