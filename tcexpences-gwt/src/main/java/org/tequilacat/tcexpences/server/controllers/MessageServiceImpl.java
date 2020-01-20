package org.tequilacat.tcexpences.server.controllers;

import org.tequilacat.tcexpences.client.dto.ExpenceEntryDto;
import org.tequilacat.tcexpences.shared.MessageService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class MessageServiceImpl extends RemoteServiceServlet implements MessageService {

  public String sendMessage(String message) throws IllegalArgumentException {
    if (message == null) {
      throw new IllegalArgumentException("message is null");
    }

    return "Hello, " + message + "!<br><br> Time received: " + LocalDateTime.now();
  }

  @Override
  public Collection<ExpenceEntryDto> getAllEntries() {
    //throw new NullPointerException("like a null");
    return Arrays.asList(new ExpenceEntryDto("10/10/2019", 100000, "uw", "miete"), 
        new ExpenceEntryDto("11/10/2019", 5045, "t", "aldi"), 
        new ExpenceEntryDto("12/10/2019", 4000, "t", "aldi"), 
        new ExpenceEntryDto("13/10/2019", 2500, "t", "kaufl") );    
  }

}
