package com.asiainfo.readinglist.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.*;

import java.util.List;

@Slf4j
@Component
@ConfigurationProperties
public class MyBean {

    @Value("${name}")
    private String name;

    @Autowired
    public MyBean(ApplicationArguments args) {
        boolean debug = args.containsOption("debug");
        List<String> files = args.getNonOptionArgs();
        // if run with "--debug logfile.txt" debug=true, files=["logfile.txt"]
    }
}

//import org.springframework.boot.*;
//        import org.springframework.stereotype.*;
//@Component
//public class MyBean implements CommandLineRunner {
//    public void run(String... args) {
//// Do something...
//    }
//}