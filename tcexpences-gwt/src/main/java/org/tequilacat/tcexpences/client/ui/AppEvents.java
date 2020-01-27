package org.tequilacat.tcexpences.client.ui;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.web.bindery.event.shared.binder.GenericEvent;

public class AppEvents {

  private final static EventBus eventBus = new SimpleEventBus();

  public static EventBus getBus() {
    return eventBus;
  }
  
  public static class UploadEntriesEvent extends GenericEvent { }
  
  public static class NewReportEvent extends GenericEvent { }
  
  public static class OpenReportEvent extends GenericEvent { 
    private final String reportId;

    public OpenReportEvent(String reportId) {
      this.reportId = reportId;
    }

    public String getReportId() {
      return reportId;
    }
  }

  public static class JumpToViewEvent extends GenericEvent { 
    private final String viewId;

    public JumpToViewEvent(String viewId) {
      super();
      this.viewId = viewId;
    }

    public String getViewId() {
      return viewId;
    }
  }
  
  public static class JumpHomeEvent extends JumpToViewEvent { 
    public JumpHomeEvent() {
      super(null);
    }
  }  
}
