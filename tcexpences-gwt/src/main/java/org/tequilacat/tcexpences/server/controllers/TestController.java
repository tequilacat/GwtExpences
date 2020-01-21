package org.tequilacat.tcexpences.server.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RestController;
import org.tequilacat.tcexpences.client.dto.ExpenceEntryDto;
import org.tequilacat.tcexpences.server.services.TestService;

@RestController
public class TestController {
  // @SuppressWarnings("unused")
  // private static final Logger log = Logger.getLogger(TestController.class);

  private @Autowired TestService _testService;

  public static class TestEntry {
    private String name;
    private int age;

    public TestEntry() {

    }

    public TestEntry(String name, int age) {
      super();
      this.name = name;
      this.age = age;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public int getAge() {
      return age;
    }

    public void setAge(int age) {
      this.age = age;
    }

  }

  @RequestMapping(value = "/api/mirror", method = RequestMethod.GET)
  public ResponseEntity<?> listMembers() {
    List<ExpenceEntryDto> result = Arrays.asList(new ExpenceEntryDto("10/10/2019", 100000, "uw", "miete"), 
        new ExpenceEntryDto("11/10/2019", 5045, "t", "aldi"), 
        new ExpenceEntryDto("12/10/2019", 4000, "t", "aldi"), 
        new ExpenceEntryDto("13/10/2019", 2500, "t", "kaufl"));
    
    return ResponseEntity.ok(result);
  }
}
