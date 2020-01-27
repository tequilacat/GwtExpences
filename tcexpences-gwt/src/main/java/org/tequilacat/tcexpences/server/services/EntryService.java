package org.tequilacat.tcexpences.server.services;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.tequilacat.tcexpences.client.dto.ExpenceEntryDto;
import org.tequilacat.tcexpences.client.dto.ReportDto;

@Service
public class EntryService {

  public List<ExpenceEntryDto> getAllEntries() {
    return Arrays.asList(new ExpenceEntryDto("10/10/2019", 100000, "uw", "S.miete"), 
        new ExpenceEntryDto("11/10/2019", 5045, "t", "S.aldi"), 
        new ExpenceEntryDto("12/10/2019", 4000, "t", "S.aldi"), 
        new ExpenceEntryDto("13/10/2019", 2500, "t", "S.kaufl"),
        new ExpenceEntryDto("15/10/2019", 4000, "t", "S.merc"));
  }
}
