package com.InvoiceGenerator;

public class InvoiceGenerator {

  public int calculateFare(int distance , int time){
      int cost = distance * 10 + time * 1;
      return cost;
  }

}
