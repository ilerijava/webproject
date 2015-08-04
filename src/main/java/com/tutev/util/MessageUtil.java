package com.tutev.util;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public class MessageUtil {

  private static FacesMessage facesMessage = new FacesMessage();

  public static void addInfoMessage(String detail) {
    facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "İŞLEM!!!",
        detail);
    FacesContext.getCurrentInstance().addMessage(null, facesMessage);
  }

  public static void addInfoMessage(String summary, String detail) {
    facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,
        detail);
    FacesContext.getCurrentInstance().addMessage(null, facesMessage);
  }

  public static void addErrorMessage(String detail) {
    facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "HATA!!!",
        detail);
    FacesContext.getCurrentInstance().addMessage(null, facesMessage);
  }

  public static void addErrorMessage(String summary, String detail) {
    facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, summary,
        detail);
    FacesContext.getCurrentInstance().addMessage(null, facesMessage);
  }

  public static void addMessage(Severity messageType, String summary,
                                String detail) {
    facesMessage = new FacesMessage(messageType, summary, detail);
    FacesContext.getCurrentInstance().addMessage(null, facesMessage);
  }

}
