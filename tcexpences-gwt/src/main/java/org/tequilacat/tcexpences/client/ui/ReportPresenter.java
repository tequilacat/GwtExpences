package org.tequilacat.tcexpences.client.ui;

import java.util.List;

import org.tequilacat.tcexpences.client.dto.ExpenceEntryDto;
import org.tequilacat.tcexpences.client.services.ClientEntryService;
import org.tequilacat.tcexpences.client.ui.AppEvents;
import org.tequilacat.tcexpences.client.ui.Presenter;
import org.tequilacat.tcexpences.client.util.UiCallback;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class ReportPresenter implements Presenter {
  private final Display view;
  private List<ExpenceEntryDto> entries;
  
  public static final String VIEW_ID = "report";

  public interface Display {
    HasClickHandlers getCancelButton();
    Widget asWidget();
    void setData(List<ExpenceEntryDto> entries);
  }
  
  public ReportPresenter(Display view) {
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
    ClientEntryService.instance().getAllEntries(UiCallback.restyCb(r -> {
      entries = r;
      view.setData(entries);
    }));
  }

  private void bind() {
    UiCallback.add(view.getCancelButton(), e -> AppEvents.getBus().fireEvent(new AppEvents.JumpHomeEvent()));    
  }

}
