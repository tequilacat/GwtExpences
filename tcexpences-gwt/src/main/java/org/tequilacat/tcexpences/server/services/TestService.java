package org.tequilacat.tcexpences.server.services;

import org.springframework.stereotype.Service;

@Service
public class TestService {

  public String mirrorName(String input) {
    return "mirror of '" + input +"'";
  }
}
