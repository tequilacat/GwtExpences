package org.tequilacat.tcexpences.shared.gwtservices;

import java.util.Collection;

import org.tequilacat.tcexpences.client.dto.ExpenceEntryDto;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("entry")
public interface EntryService extends RemoteService {

  Collection<ExpenceEntryDto> getAllEntries();

  Collection<ExpenceEntryDto> getFilteredEntries(long viewId);
}
