package org.tequilacat.tcexpences.shared;

import java.util.Collection;

import org.tequilacat.tcexpences.client.dto.ExpenceEntryDto;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>MessageService</code>.
 */
public interface MessageServiceAsync {
  void sendMessage(String input, AsyncCallback<String> callback) throws IllegalArgumentException;

  void getAllEntries(AsyncCallback<Collection<ExpenceEntryDto>> callback);
}
