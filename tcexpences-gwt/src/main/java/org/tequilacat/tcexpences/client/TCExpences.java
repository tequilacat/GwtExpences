package org.tequilacat.tcexpences.client;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.stream.Stream;

import org.tequilacat.tcexpences.client.dto.CategoryDto;
import org.tequilacat.tcexpences.client.dto.ExpenceEntryDto;
import org.tequilacat.tcexpences.client.services.ClientEntryService;
import org.tequilacat.tcexpences.client.ui.AppController;
import org.tequilacat.tcexpences.client.util.UiCallback;
import org.tequilacat.tcexpences.shared.MessageService;
import org.tequilacat.tcexpences.shared.MessageServiceAsync;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootLayoutPanel;
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
    
    /*
    VerticalPanel panel = new VerticalPanel();
    panel.setHorizontalAlignment(VerticalPanel.ALIGN_CENTER);
    panel.add(new Button("Load entries", (ClickHandler)(e -> loadEntries())));
    panel.add(allEntriesFt);    
    panel.add(warningLabel);
    
    RootPanel.get("mainui").add(panel);
    */
    new AppController().go(RootPanel.get());
    
    /*
    DockLayoutPanel p = new DockLayoutPanel(Unit.EM);
    p.addNorth(new HTML("north"), 2);
    p.addSouth(new HTML("<div style='background:red'>south</div>"), 2);
    p.addEast(new HTML("east"), 2);
    p.addWest(new HTML("west"), 2);
    p.add(new HTML("<div style='background:red'>center</div>"));

    // Attach the LayoutPanel to the RootLayoutPanel. The latter will listen for
    // resize events on the window to ensure that its children are informed of
    // possible size changes.
    RootLayoutPanel rp = RootLayoutPanel.get();
    rp.add(p);
    */
  }
  
  /**
   * fills table with retrieved entries
   * @param allEntries
   */
  private void fillEntries(Collection<ExpenceEntryDto> allEntries) {
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
  }
  
  private void fillCategories(Collection<CategoryDto> categories) {
    GWT.log("Loaded categories: " + categories.size());
    categories.stream().forEach(c -> GWT.log(c.getLabel()));
  }
  
  private void loadEntries() {
    GWT.log("get all actegories: ");
    ClientEntryService.instance().getAllCategories(UiCallback.restyCb(this::fillCategories, warningLabel));
    ClientEntryService.instance().getAllEntries(UiCallback.restyCb(this::fillEntries, warningLabel));    
    // messageServiceAsync.getAllEntries(UiCallback.gwtCb(this::fillEntries, warningLabel));    
  }
}
