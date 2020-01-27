package org.tequilacat.tcexpences.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.web.bindery.event.shared.binder.EventBinder;
import com.google.web.bindery.event.shared.binder.EventHandler;

public class AppController implements Presenter, ValueChangeHandler<String>  {
  interface MyEventBinder extends EventBinder<AppController> {}
  
  private final MyEventBinder eventBinder = GWT.create(MyEventBinder.class);
  private HasWidgets container;
  
  public AppController() {
    eventBinder.bindEventHandlers(this, AppEvents.getBus());  
    History.addValueChangeHandler(this);
  }

  @EventHandler(handles = {AppEvents.NewReportEvent.class})
  void onNewReport() {
    History.newItem(ReportPresenter.VIEW_ID);
  }
  
  @EventHandler(handles = {AppEvents.UploadEntriesEvent.class})
  void onUploadEntries() {
    History.newItem(ReportPresenter.VIEW_ID);
  }
  
  @EventHandler
  void onOpenReport(AppEvents.OpenReportEvent event) {
    GWT.log("open report "+event.getReportId());
  }
  
  @EventHandler
  void onJumpHome(AppEvents.JumpHomeEvent event) {
    History.newItem(MainScreenPresenter.VIEW_ID);
  }
  
  @EventHandler
  void onJumpToView(AppEvents.JumpToViewEvent event) {
    String token = event.getViewId() == null ? MainScreenPresenter.VIEW_ID : event.getViewId();
    History.newItem(token);
  }
  
  
  @Override
  public void go(HasWidgets container) {
    this.container = container;
    
    if ("".equals(History.getToken())) {
      History.newItem(MainScreenPresenter.VIEW_ID);
    } else {
      History.fireCurrentHistoryState();
    }
  }

  @Override
  public void onValueChange(ValueChangeEvent<String> event) {
    String token = event.getValue();
    
    if (token != null) {
      Presenter presenter = null;

      GWT.log("onValueChanged: token = "+ token);
      
      if (token.equals(MainScreenPresenter.VIEW_ID)) {
        presenter = new MainScreenPresenter(new MainScreenView());
      } else if (token.equals(ReportPresenter.VIEW_ID)) {
        presenter = new ReportPresenter(new ReportView());
//      } else if (token.equals("edit")) {
//        presenter = new EditContactPresenter(rpcService, eventBus, new EditContactView());
      }

      if (presenter != null) {
        presenter.go(container);
      }
    }
    
  }
  
  /*
  
  @Override
  public void onValueChange(ValueChangeEvent<String> event) {
  } */
}
