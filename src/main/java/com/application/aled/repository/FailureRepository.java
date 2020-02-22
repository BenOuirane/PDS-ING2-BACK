package com.application.aled.repository;

import com.application.aled.entity.Failure;
import com.application.aled.entity.Message;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FailureRepository extends CrudRepository<Failure, Long> {
    Failure findByMacAddress(String mac_address);
    @Query("select f from Failure f where year(f.begin_date) = ?1")
    List<Failure> findFailuresByYear(int year);

    @Query("select f from Failure f where year(f.begin_date) = ?1 and month(f.begin_date)= ?2")
    List<Failure> findFailuresByYearAndMonth(int year, int month);

    @Query("select f from Failure f where year(f.begin_date) = ?1 and month(f.begin_date)= ?2 and day(f.begin_date)= ?3")
    List<Failure> findFailuresByDay(int year, int month, int date);
}
