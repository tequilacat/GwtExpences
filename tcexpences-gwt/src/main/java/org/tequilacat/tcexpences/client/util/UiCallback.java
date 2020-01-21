package org.tequilacat.tcexpences.client.util;

import java.util.function.Consumer;

import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;

public class UiCallback {

  private static void report(Throwable caught, HTML errorLabel) {
    if(caught == null) {
      if (errorLabel != null) {
        errorLabel.removeStyleName("serverResponseLabelError");
        errorLabel.setHTML("Success");
      }
    } else {
      if (errorLabel != null) {
        errorLabel.addStyleName("serverResponseLabelError");
        errorLabel.setHTML("Error: " + caught);
      }

      Window.alert("Error executing request: " + caught);
    }
  }
  
  public static <RV> AsyncCallback<RV> gwtCb(Consumer<RV> handler, HTML errorLabel) {
    return new AsyncCallback<RV>() {

      @Override
      public void onFailure(Throwable caught) {
        report(caught, errorLabel);
      }

      @Override
      public void onSuccess(RV result) {
        report(null, errorLabel);
        handler.accept(result);
      }
    };
  }
  
  public static <RV> MethodCallback<RV> restyCb(Consumer<RV> handler, HTML errorLabel) {
    return new MethodCallback<RV>() {

      @Override
      public void onFailure(Method method, Throwable caught) {
        report(caught, errorLabel);
      }

      @Override
      public void onSuccess(Method method, RV result) {
        report(null, errorLabel);
        handler.accept(result);
      }
    };
  }  
}