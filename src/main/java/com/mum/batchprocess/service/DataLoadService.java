package com.mum.batchprocess.service;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class DataLoadService {
    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job importJob;

    public JobParameters jobParameters;

    public void loadData() throws Exception {
        jobParameters = new JobParametersBuilder()
                .addLong("time", System.currentTimeMillis())
                .toJobParameters();
        jobLauncher.run(importJob,jobParameters);
    }

}
