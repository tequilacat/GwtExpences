package org.tequilacat.tcexpences.client.ui;

import org.tequilacat.tcexpences.client.util.UiCallback;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class UploadResultsPresenter implements Presenter {
  private final Display view;
  
  public static final String VIEW_ID = "uploadresults";

  public interface Display {
    HasClickHandlers getCancelButton();
    HasClickHandlers getSaveReportButton();
    Widget asWidget();
  }
  
  public UploadResultsPresenter(Display view) {
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
