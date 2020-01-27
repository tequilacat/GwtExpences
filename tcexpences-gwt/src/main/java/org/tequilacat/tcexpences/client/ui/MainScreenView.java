package org.tequilacat.tcexpences.client.ui;

import java.util.List;

import org.tequilacat.tcexpences.client.dto.ReportDto;
import org.tequilacat.tcexpences.client.util.UiCallback;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;

public class MainScreenView implements MainScreenPresenter.Display {
  private final Button uploadButton;
  private final Button newReportButton;
  private final FlexTable reportsTable;
  private final Widget rootWidget;
  
  public MainScreenView() {
    uploadButton = new Button("Upload");
    newReportButton = new Button("Add new");
    reportsTable = new FlexTable();
    
    FlowPanel buttonPanel = new FlowPanel();
    buttonPanel.add(uploadButton);
    buttonPanel.add(newReportButton);
    
    /*
    DockLayoutPanel p = new DockLayoutPanel(Unit.EM);
    p.addNorth(new HTML("north"), 2);
    p.addSouth(new HTML("south"), 2);
    p.addEast(new HTML("east"), 2);
    p.addWest(new HTML("west"), 2);
    p.add(new HTML("center"));
    rootWidget = p;
    */
    
    rootWidget = buttonPanel;
    /*
    rootWidget = new DockLayoutPanel(Unit.EM);
    rootWidget.addNorth(new HTML("header"), 2);
    rootWidget.addSouth(buttonPanel, 4);
    rootWidget.addSouth(new HTML("footer"), 2);
    rootWidget.addWest(new HTML("navigation"), 10);
    
    //rootWidget.add(reportsTable);
    rootWidget.add(new HTML("The table"));
    */
  }
  
  @Override
  public HasClickHandlers getUploadButton() {
    return uploadButton;
  }

  @Override
  public HasClickHandlers getAddReportButton() {
    return newReportButton;
  }

  @Override
  public HasClickHandlers getReportList() {
    return reportsTable;
  }

  @Override
  public void setData(List<ReportDto> reports) {
    reportsTable.removeAllRows();
    UiCallback.setHeader(reportsTable, "Label", "From", "To", "Descr");
    
    int row = 1;
    
    for(ReportDto report: reports) {      
      reportsTable.setText(row, 0, report.getLabel());
      reportsTable.setText(row, 1, report.getFrom().toString());
      reportsTable.setText(row, 2, report.getTo().toString());
      reportsTable.setText(row, 3, report.getEntriesSummary());
      row++;
    }
  }

  @Override
  public int getClickedReportRow(ClickEvent event) {
    return UiCallback.getClickedRow(reportsTable, event);
  }

  @Override
  public List<Integer> getSelectedReportRows() {
    return UiCallback.getSelectedRows(reportsTable);
  }

  @Override
  public Widget asWidget() {
    return rootWidget;
  }
}
