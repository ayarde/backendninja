package com.udemy.backendninja.service.impl;

import com.udemy.backendninja.service.ExerciseService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

@Service("exerciseService")
public class ExerciseServiceImpl implements ExerciseService {

    private static final Log LOGGER = LogFactory.getLog(ExerciseServiceImpl.class);

    @Override
    public void showLogMessage() {
        LOGGER.info("Exercise Service in Backend Ninja!");
    }
}
