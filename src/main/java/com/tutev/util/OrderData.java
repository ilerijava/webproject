package com.tutev.util;

public class OrderData {
  private String property;
  private OrderType type;

  public OrderData() {
  }

  public OrderData(String property) {
    this.property = property;
    this.type = OrderType.ASC;
  }

  public OrderData(String property, OrderType type) {
    this.property = property;
    this.type = type;
  }

  public String getProperty() {
    return property;
  }

  public boolean isAsc() {
    return type.equals(OrderType.ASC);
  }

  public void setType(OrderType type) {
    this.type = type;
  }

  public void setProperty(String property) {
    this.property = property;
  }

}
