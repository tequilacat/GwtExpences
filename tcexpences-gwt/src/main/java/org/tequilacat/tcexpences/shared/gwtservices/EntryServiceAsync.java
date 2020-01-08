package org.tequilacat.tcexpences.shared.gwtservices;

import java.util.Collection;

import org.tequilacat.tcexpences.client.dto.ExpenceEntryDto;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface EntryServiceAsync {
  void getAllEntries(AsyncCallback<Collection<ExpenceEntryDto>> callback);

  void getFilteredEntries(long viewId, AsyncCallback<Collection<ExpenceEntryDto>> callback);
}
