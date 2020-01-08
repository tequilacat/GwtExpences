package org.tequilacat.tcexpences.client.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExpenceEntryDto extends EntityDto {
  /** sum in euro * 100 */
  private int totalCents;

  private String dateString;
  
  /** e.g. Uberweisung */
  private String type;

  private List<String> tags = new ArrayList<>();

  private String description;

  public ExpenceEntryDto() {
  }

  public ExpenceEntryDto(String dateStr, int totalCents, String type, String description, String... tags) {
    this.dateString = dateStr;
    this.totalCents = totalCents;
    this.type = type;
    this.description = description;

    this.tags.addAll(Arrays.asList(tags));
  }

  public int getTotalCents() {
    return totalCents;
  }

  public void setTotalCents(int totalCents) {
    this.totalCents = totalCents;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public List<String> getTags() {
    return tags;
  }

  public void setTags(List<String> tags) {
    this.tags = tags;
  }

  public String getDateString() {
    return dateString;
  }

  public void setDateString(String dateString) {
    this.dateString = dateString;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
