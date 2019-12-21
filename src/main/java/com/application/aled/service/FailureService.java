package com.application.aled.service;

import com.application.aled.entity.Failure;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FailureService {
    public List<Failure> getFailures();

    public Failure mac_address(String mac_address); //TODO implement this method
}
