package org.tequilacat.tcexpences.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.web.bind.annotation.RestController;
import org.tequilacat.tcexpences.server.services.CategoryService;
import org.tequilacat.tcexpences.server.services.EntryService;
import org.tequilacat.tcexpences.server.services.ReportService;

@RestController
public class EntryController {
  @SuppressWarnings("unused")
  private static final Logger log = LogManager.getLogger(EntryController.class);

  private @Autowired EntryService testService;
  private @Autowired CategoryService categoryService;
  private @Autowired ReportService reportService;
  
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
  
  @RequestMapping(value = "/tcexpences/api/reports", method = RequestMethod.GET)
  public ResponseEntity<?> getAllReports() {
    log.debug("get all reports");
    return ResponseEntity.ok(reportService.getAllReports());
  }
}
