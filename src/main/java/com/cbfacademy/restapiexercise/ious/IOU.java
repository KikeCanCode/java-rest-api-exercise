package com.cbfacademy.restapiexercise.ious;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class IOU {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)

  /*final UUID id - unique identifier for the IOU
String borrower - name of borrower
String lender - name of lender
BigDecimal amount - amount covered by IOU
Instant dateTime - date and time of IOU being issued
public IOU(String borrower, String lender, BigDecimal amount, Instant datetime) - 
constructor that should generate a new UUID, use the documentation to learn how to generate a random value.*/