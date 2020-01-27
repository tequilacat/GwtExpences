package org.tequilacat.tcexpences.client.util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLTable;

public class UiCallback {
  
  public static int getClickedRow(FlexTable table, ClickEvent event) {
    int selectedRow = -1;
    HTMLTable.Cell cell = table.getCellForEvent(event);
    
    if (cell != null) {
      // Suppress clicks if the user is actually selecting the 
      //  check box
      //
      if (cell.getCellIndex() > 0) {
        selectedRow = cell.getRowIndex();
      }
    }
    
    return selectedRow;
  }
  
  public static List<Integer> getSelectedRows(FlexTable table) {
    List<Integer> selectedRows = new ArrayList<Integer>();
    
    for (int i = 0; i < table.getRowCount(); ++i) {
      CheckBox checkBox = (CheckBox)table.getWidget(i, 0);
      if (checkBox.getValue()) {
        selectedRows.add(i);
      }
    }
    
    return selectedRows;
  }
  
  public static void add(HasClickHandlers source, Consumer<ClickEvent> handler) {
    source.addClickHandler(new ClickHandler() {      
      @Override
      public void onClick(ClickEvent event) {
        handler.accept(event);
      }
    });
  }
  
  public static void setHeader(FlexTable table, String... labels) {
    for (String label : labels) {
      table.setText(0, (table.getRowCount() == 0 ? 0 : table.getCellCount(0)), label);
    }
  }
  
  private static void report(Throwable caught, HTML errorLabel) {
    if(caught == null) {
      if (errorLabel != null) {
        errorLabel.removeStyleName("serverResponseLabelError");
        errorLabel.setHTML("Success");
      }
    } else {
      if (errorLabel != null) {
        errorLabel.addStyleName("serverResponseLabelError");
        errorLabel.setHTML("Error: " + caught);
      }

      Window.alert("Error executing request: " + caught);
    }
  }
  
  public static <RV> AsyncCallback<RV> gwtCb(Consumer<RV> handler, HTML errorLabel) {
    return new AsyncCallback<RV>() {

      @Override
      public void onFailure(Throwable caught) {
        report(caught, errorLabel);
      }

      @Override
      public void onSuccess(RV result) {
        report(null, errorLabel);
        handler.accept(result);
      }
    };
  }
  
  public static <RV> MethodCallback<RV> restyCb(Consumer<RV> handler) {
    return restyCb(handler, null);
  }
  
  public static <RV> MethodCallback<RV> restyCb(Consumer<RV> handler, HTML errorLabel) {
    return new MethodCallback<RV>() {

      @Override
      public void onFailure(Method method, Throwable caught) {
        report(caught, errorLabel);
      }

      @Override
      public void onSuccess(Method method, RV result) {
        report(null, errorLabel);
        handler.accept(result);
      }
    };
  }  
}