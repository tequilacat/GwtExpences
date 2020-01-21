package org.tequilacat.tcexpences.server.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.apache.log4j.Logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.web.bind.annotation.RestController;
import org.tequilacat.tcexpences.client.dto.CategoryDto;
import org.tequilacat.tcexpences.server.services.CategoryService;
import org.tequilacat.tcexpences.server.services.EntryService;

@RestController
public class EntryController {
  @SuppressWarnings("unused")
  private static final Logger log = LogManager.getLogger(EntryController.class);

  private @Autowired EntryService testService;
  private @Autowired CategoryService categoryService;
  
  @RequestMapping(value = "/tcexpences/api/entries", method = RequestMethod.GET)
  public ResponseEntity<?> getAllEntries() {
    log.debug("get all entries");
    return ResponseEntity.ok(testService.getAllEntries());
  }
  
  @RequestMapping(value = "/tcexpences/api/categories", method = RequestMethod.GET)
  public ResponseEntity<?> getAllCategories() {
    log.debug("get all categories");
    return ResponseEntity.ok(categoryService.listAll());
  }
}
