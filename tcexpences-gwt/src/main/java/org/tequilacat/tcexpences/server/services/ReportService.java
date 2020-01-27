package org.tequilacat.tcexpences.server.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.tequilacat.tcexpences.client.dto.ReportDto;

@Service
public class ReportService {

  private Date parse(String s) {
    try {
      return new SimpleDateFormat("yyyy-MM-dd").parse(s);
    } catch (ParseException e) {
      return new Date();
    }
  }
  
  public List<ReportDto> getAllReports() {
    return Arrays.asList(
        new ReportDto(1, "report1", parse("2019-1-1"), parse("2019-1-30"), "report1 descr"),
        new ReportDto(2, "report2", parse("2019-2-1"), parse("2019-2-28"), "report2 descr"),
        new ReportDto(3, "report3", parse("2019-3-1"), parse("2019-3-30"), "report3 descr")
        );
  }
}
