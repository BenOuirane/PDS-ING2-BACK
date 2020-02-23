package com.application.aled.service;

import com.application.aled.entity.Failure;
import com.application.aled.entity.Objects;
import com.application.aled.repository.FailureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.logging.Logger;

import java.util.ArrayList;
import java.util.List;

@Service
public class FailureServiceImpl implements FailureService {

    /*
    We get a Message Repository attribute so we get all basic
    sql methods (findAll(), save()...)
    They will be our base for the rest of the service
     */
    @Autowired
    FailureRepository repository;
    Logger logger = Logger.getLogger("com.application.aled.service.FailureServiceImpl");

    /*
    Here we use the 'findAll()' to create a custom getFailures()
    for our application, our controllers
     */
    @Override
    public List<Failure> getFailures() {
      
        logger.info("Get all Failure...");
        List<Failure> failures = new ArrayList<>();
        repository.findAll().forEach(failures::add);

        return failures;
    }
    public List<Failure> getFailureByObject(Objects objects) throws NullPointerException {
        logger.info("Search failure of a connected object");
        List<Failure> failures = repository.findByObjects(objects);

        return failures;
    }

    @Override
    public Failure addFailure(Failure failure) {
        Failure failureRecord = repository.save(failure);
        return failureRecord;
    }
    @Override
    public List<Failure> getFailuresByYear(int year) throws NullPointerException{

        List<Failure> failuresbyyear = new ArrayList<>();
      
        repository.findFailuresByYear(year).forEach(failuresbyyear::add);
        logger.info(" get the failures for the year " + year);
        
        return failuresbyyear; }
        
    @Override
    public List<Failure> getFailuresByYearAndMonth(int year, int month) throws NullPointerException{
        
        List<Failure> failuresbyyear_month = new ArrayList<>();
        repository.findFailuresByYearAndMonth(year, month).forEach(failuresbyyear_month::add);
         logger.info("get the failures for the year " + year+" especially the month "+month);
        return failuresbyyear_month; }

    @Override
    public List<Failure> getFailuresByDay(int year, int month, int day) throws NullPointerException{

        List<Failure> failuresbyday = new ArrayList<>();
        repository.findFailuresByDay(year, month, day).forEach(failuresbyday::add);
        logger.info("get the failures for the day "+ day+" of the month "+month+ " and the year "+year);
        return failuresbyday; }

	


}



