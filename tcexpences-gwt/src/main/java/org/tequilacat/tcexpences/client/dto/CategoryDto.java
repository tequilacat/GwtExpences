package org.tequilacat.tcexpences.client.dto;

public class CategoryDto extends EntityDto {
  private String label;
  private String pattern;
  private boolean isUsed;

  public CategoryDto() {}
  
  public CategoryDto(String label, String pattern, boolean isUsed) {
    this.label = label;
    this.pattern = pattern;
    this.isUsed = isUsed;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public String getPattern() {
    return pattern;
  }

  public void setPattern(String pattern) {
    this.pattern = pattern;
  }

  public boolean isUsed() {
    return isUsed;
  }

  public void setUsed(boolean isUsed) {
    this.isUsed = isUsed;
  }

}
