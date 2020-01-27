package org.tequilacat.tcexpences.client.ui.templates;

import org.tequilacat.tcexpences.client.ui.AppEvents;
import org.tequilacat.tcexpences.client.ui.Presenter;
import org.tequilacat.tcexpences.client.util.UiCallback;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class PresenterTemplate implements Presenter {
  private final Display view;
  
  public interface Display {
    HasClickHandlers getCancelButton();
    Widget asWidget();
  }
  
  public PresenterTemplate(Display view) {
    this.view = view;
  }
  
  @Override
  public void go(HasWidgets container) {
    bind();
    container.clear();
    container.add(view.asWidget());
    fetch();
  }

  private void fetch() {
    // TODO Auto-generated method stub
    
  }

  private void bind() {
    // TODO Auto-generated method stub
    UiCallback.add(view.getCancelButton(), e -> AppEvents.getBus().fireEvent(new AppEvents.JumpHomeEvent()));
  }

}
