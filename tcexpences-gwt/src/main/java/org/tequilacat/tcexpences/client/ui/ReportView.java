package org.tequilacat.tcexpences.client.ui;

import java.util.List;
import java.util.stream.Stream;

import org.tequilacat.tcexpences.client.dto.ExpenceEntryDto;
import org.tequilacat.tcexpences.client.dto.ReportDto;
import org.tequilacat.tcexpences.client.util.UiCallback;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

public class ReportView implements ReportPresenter.Display {
  private final Button cancelButton;
  private final FlowPanel rootWidget;
  private final FlexTable entriesTable;
  
  public ReportView() {
    cancelButton = new Button("Cancel");
    entriesTable = new FlexTable();
    
    rootWidget = new FlowPanel();
    rootWidget.add(entriesTable);
    rootWidget.add(cancelButton);
  }

  @Override
  public HasClickHandlers getCancelButton() {
    return cancelButton;
  }

  @Override
  public Widget asWidget() {
    return rootWidget;
  }

  @Override
  public void setData(List<ExpenceEntryDto> entries) {
    entriesTable.removeAllRows();
    UiCallback.setHeader(entriesTable, "Date", "Description", "Price");
    
    int row = 1;
    
    for(ExpenceEntryDto entry : entries) {      
      entriesTable.setText(row, 0, entry.getDateString());
      entriesTable.setText(row, 1, entry.getDescription());
      entriesTable.setText(row, 2, Integer.toString(entry.getTotalCents()));
      row++;
    }
  }
  
}
