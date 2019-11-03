package com.mum.batchprocess.controller;

import com.mum.batchprocess.domain.Person;
import com.mum.batchprocess.service.DataLoadService;
import com.mum.batchprocess.service.UserService;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/upload")
public class FileUploadController {

    @Autowired
    UserService userService;

    @Autowired
    DataLoadService dataLoadService;

    @RequestMapping("/display")
    public @ResponseBody
    List<Person> displayData() throws Exception {
        dataLoadService.loadData();
        return userService.getAllPersons();
    }


    @RequestMapping("/")
    public String upload(){
        return "uploadForm";
    }
}
