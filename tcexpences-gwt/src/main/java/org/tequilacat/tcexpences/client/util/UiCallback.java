package org.tequilacat.tcexpences.client.util;

import java.util.function.Consumer;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;

public class UiCallback<T> implements AsyncCallback<T> {
  private final HTML errorLabel;
  private final Consumer<T> successHandler;
  // private final Consumer<Throwable> errorHandler;

  public UiCallback(HTML errorLabel, Consumer<T> successHandler) {
    this.errorLabel = errorLabel;
    this.successHandler = successHandler;
  }

  @Override
  public void onFailure(Throwable caught) {
    if (errorLabel != null) {
      errorLabel.addStyleName("serverResponseLabelError");
      errorLabel.setHTML("Error: " + caught);
    }
    
    Window.alert("Error executing request: " + caught);
  }

  @Override
  public void onSuccess(T result) {
    if (errorLabel != null) {
      errorLabel.removeStyleName("serverResponseLabelError");
      errorLabel.setHTML("Success");
    }
    successHandler.accept(result);
  }
}