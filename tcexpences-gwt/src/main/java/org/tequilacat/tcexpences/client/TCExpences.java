package org.tequilacat.tcexpences.client;

import java.util.function.Consumer;
import java.util.stream.Stream;

import org.tequilacat.tcexpences.client.dto.ExpenceEntryDto;
import org.tequilacat.tcexpences.client.util.UiCallback;
import org.tequilacat.tcexpences.shared.MessageService;
import org.tequilacat.tcexpences.shared.MessageServiceAsync;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class TCExpences implements EntryPoint {
  private final MessageServiceAsync messageServiceAsync = GWT.create(MessageService.class);

  private final FlexTable allEntriesFt = new FlexTable();
  private final HTML warningLabel = new HTML();

  /**
   * create UI
   */
  public void onModuleLoad() {
    VerticalPanel panel = new VerticalPanel();
    panel.setHorizontalAlignment(VerticalPanel.ALIGN_CENTER);
    panel.add(new Button("Load entries", (ClickHandler)(e -> loadEntries())));
    panel.add(allEntriesFt);    
    panel.add(warningLabel);
    
    RootPanel.get("mainui").add(panel);    
  }

  private <T> UiCallback<T> callback(Consumer<T> handler) {
    return new UiCallback<T>(warningLabel, handler);
  }

  private void loadEntries() {
    messageServiceAsync.getAllEntries(callback(allEntries -> {
      allEntriesFt.removeAllRows();
      
      Stream.of("Date", "Description", "Type", "Sum").forEach(s->
        allEntriesFt.setText(0, (allEntriesFt.getRowCount()==0 ? 0 : allEntriesFt.getCellCount(0)), s)
      );
      
      int row = 1;
      
      for(ExpenceEntryDto entry: allEntries) {
        allEntriesFt.setText(row, 0, entry.getDateString());
        allEntriesFt.setText(row, 1, entry.getDescription());
        allEntriesFt.setText(row, 2, entry.getType());
        allEntriesFt.setText(row, 3, "" + (entry.getTotalCents() / 100.0));
        row++;
      }
    }));
  }
}