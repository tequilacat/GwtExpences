package org.tequilacat.tcexpences.client.services;

import java.util.List;

import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;
import org.tequilacat.tcexpences.client.dto.CategoryDto;
import org.tequilacat.tcexpences.client.dto.ExpenceEntryDto;
import org.tequilacat.tcexpences.client.dto.ReportDto;

import com.google.gwt.core.client.GWT;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

public interface ClientEntryService extends RestService {

  public static ClientEntryService instance() {
    return ServicePool.get(ClientEntryService.class, () -> GWT.create(ClientEntryService.class));
  }
  
  @GET
  @Path("/api/entries")
  public void getAllEntries(MethodCallback<List<ExpenceEntryDto>> cb);
  
  @GET
  @Path("/api/categories")
  public void getAllCategories(MethodCallback<List<CategoryDto>> cb);

  @GET
  @Path("/api/reports")
  public void getAllReports(MethodCallback<List<ReportDto>> cb);
}
