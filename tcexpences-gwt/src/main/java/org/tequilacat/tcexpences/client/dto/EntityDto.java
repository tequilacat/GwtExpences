package org.tequilacat.tcexpences.client.dto;

import com.google.gwt.user.client.rpc.IsSerializable;

public class EntityDto implements IsSerializable {
  private long id;
  
  public EntityDto() {
    
  }
  
  public EntityDto(long id) {
    this.id = id;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }
  
  public String getStringId() {
    return Long.toString(getId());
  }
}
