package com.tutev.entity;

import java.util.ArrayList;
import java.util.List;

public class Result {

  Exception exception;
  List<String> messages;
  Boolean islemSonuc;
  Object object;

  public Result() {
    this.messages = new ArrayList();
  }

  public Exception getException() {
    return exception;
  }

  public void setException(Exception exception) {
    this.exception = exception;
  }

  public List<String> getMessages() {
    return messages;
  }

  public void setMessages(List<String> messages) {
    this.messages = messages;
  }

  public Boolean getIslemSonuc() {
    return islemSonuc;
  }

  public void setIslemSonuc(Boolean islemSonuc) {
    this.islemSonuc = islemSonuc;
  }

  public Object getObject() {
    return object;
  }

  public void setObject(Object object) {
    this.object = object;
  }

}
