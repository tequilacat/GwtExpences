package org.tequilacat.tcexpences.shared;

import java.util.Collection;

import org.tequilacat.tcexpences.client.dto.ExpenceEntryDto;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface MessageService extends RemoteService {
  String sendMessage(String message) throws IllegalArgumentException;

  Collection<ExpenceEntryDto> getAllEntries();
}
