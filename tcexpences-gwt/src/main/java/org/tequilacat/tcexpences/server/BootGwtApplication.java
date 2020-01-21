package org.tequilacat.tcexpences.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class BootGwtApplication extends SpringBootServletInitializer {

  public static void main(String[] args) {
    SpringApplication.run(BootGwtApplication.class, args);
    // .getEnvironment().getSystemProperties().put("test", "test");
  }
}
