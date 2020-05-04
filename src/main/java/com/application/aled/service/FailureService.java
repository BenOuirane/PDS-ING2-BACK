package com.application.aled.service;

import com.application.aled.entity.Failure;
import com.application.aled.entity.Objects;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FailureService {
    public List<Failure> getFailures();

    public List<Failure> getFailureByObject(Objects objects); //TODO implement this method

    public Failure addFailure(Failure failure);
    
    public List<Failure> getFailuresByYear(int year);

    public List<Failure> getFailuresByYearAndMonth(int year, int month);

    public List<Failure> getFailuresByDay(int year, int month, int day);

    public List<Failure> launchSimulation();
}
