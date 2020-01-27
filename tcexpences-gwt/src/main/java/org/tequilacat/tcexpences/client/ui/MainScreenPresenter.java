package org.tequilacat.tcexpences.client.ui;

import java.util.Collection;
import java.util.List;

import org.tequilacat.tcexpences.client.dto.ReportDto;
import org.tequilacat.tcexpences.client.services.ClientEntryService;
import org.tequilacat.tcexpences.client.util.UiCallback;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class MainScreenPresenter implements Presenter {
  
  public interface Display {
    HasClickHandlers getUploadButton();
    HasClickHandlers getAddReportButton();
    
    HasClickHandlers getReportList();
    void setData(List<ReportDto> data);
    int getClickedReportRow(ClickEvent event);
    List<Integer> getSelectedReportRows();
    Widget asWidget();
  }

  public static final String VIEW_ID = "main";
  
  private final Display view;
  private List<ReportDto> reports;
  
  public MainScreenPresenter(Display view) {
    this.view = view;
  }

  @Override
  public void go(HasWidgets container) {
    bind();
    container.clear();
    container.add(view.asWidget());
    fetch();
  }

  private void bind() {
    UiCallback.add(view.getAddReportButton(), e -> AppEvents.getBus().fireEvent(new AppEvents.NewReportEvent()));
    UiCallback.add(view.getUploadButton(), e -> AppEvents.getBus().fireEvent(new AppEvents.UploadEntriesEvent()));
  }

  private void fetch() {
    ClientEntryService.instance().getAllReports(UiCallback.restyCb(r -> {
      reports = r;
      view.setData(reports);
    }));
  }
}
