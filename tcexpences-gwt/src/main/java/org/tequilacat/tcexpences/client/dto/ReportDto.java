package org.tequilacat.tcexpences.client.dto;

import java.util.Date;

public class ReportDto extends EntityDto {

  private String label;
  private Date from;
  private Date to;
  private String entriesSummary;

  public ReportDto() {
    
  }
  
  public ReportDto(long id, String label, Date from, Date to, String entriesSummary) {
    super(id);
    this.label = label;
    this.from = from;
    this.to = to;
    this.entriesSummary = entriesSummary;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public Date getFrom() {
    return from;
  }

  public void setFrom(Date from) {
    this.from = from;
  }

  public Date getTo() {
    return to;
  }

  public void setTo(Date to) {
    this.to = to;
  }

  public String getEntriesSummary() {
    return entriesSummary;
  }

  public void setEntriesSummary(String entriesSummary) {
    this.entriesSummary = entriesSummary;
  }

}
