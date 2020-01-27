package org.tequilacat.tcexpences.client.ui;

import java.util.Collection;
import java.util.List;

import org.tequilacat.tcexpences.client.dto.CategoryDto;
import org.tequilacat.tcexpences.client.services.ClientEntryService;
import org.tequilacat.tcexpences.client.util.UiCallback;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Widget;

public class CategoryPresenter {
  private ClientEntryService service = ClientEntryService.instance();
  
  private Collection<CategoryDto> categories;
  
  private Display display;
  
  public interface Display extends HasValue<Collection<CategoryDto>> {
//    HasClickHandlers getAddButton();
//    HasClickHandlers getDeleteButton();
    HasClickHandlers getList();
    void setData(Collection<CategoryDto> data);
    int getClickedRow(ClickEvent event);
    List<Integer> getSelectedRows();
    Widget asWidget();
  }
  
  private void fetch() {
    service.getAllCategories(UiCallback.restyCb(cats -> {
      categories = cats;
      display.setData(categories);
    }));
  }
  
}
