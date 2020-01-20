package org.tequilacat.tcexpences.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RestController;
import org.tequilacat.tcexpences.server.services.TestService;

@RestController
public class TestController {
  //@SuppressWarnings("unused")
  //private static final Logger log = Logger.getLogger(TestController.class);
  
  private @Autowired TestService _testService;
  
  @RequestMapping(value = "/api/mirror", method = RequestMethod.GET)
  public ResponseEntity<?> listMembers(@RequestParam("tp") String testParam) {
    return ResponseEntity.ok(_testService.mirrorName("pseudo"));
  }
}
