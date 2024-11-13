package com.example.new_project_challenge_15.service;

import com.example.new_project_challenge_15.models.log;
import com.example.new_project_challenge_15.repository.LogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogsService {
    @Autowired
    LogRepo logRepo;

    public log SaveLog(log log){
       return   logRepo.save(log);
    }
}
