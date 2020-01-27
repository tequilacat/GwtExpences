package org.tequilacat.tcexpences.client.ui.templates;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;

public class ViewTemplate extends Composite implements PresenterTemplate.Display {
  Button cancelButton;
  
  public ViewTemplate() {
    cancelButton = new Button("Cancel");
    
  }

  @Override
  public HasClickHandlers getCancelButton() {
    return cancelButton;
  }
  
}
