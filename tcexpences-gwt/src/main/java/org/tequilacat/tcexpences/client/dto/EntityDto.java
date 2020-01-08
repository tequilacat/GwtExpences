package org.tequilacat.tcexpences.client.dto;

import com.google.gwt.user.client.rpc.IsSerializable;

public class EntityDto implements IsSerializable {
  private long id;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }
}
