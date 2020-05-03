package com.application.aled.service;

import com.application.aled.entity.Services;

import java.util.List;

public interface ServicesService {

    Services getService(String name);

    List<Services> getAllServices();
}
