package org.tequilacat.tcexpences.server.services;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.stereotype.Service;
import org.tequilacat.tcexpences.client.dto.CategoryDto;

@Service
public class CategoryService {

  public Collection<CategoryDto> listAll() {
    return Arrays.asList(
        new CategoryDto("l1", "/1/", false),
        new CategoryDto("l2", "/2/", true),
        new CategoryDto("l3", "/3/", false));
  }
}
