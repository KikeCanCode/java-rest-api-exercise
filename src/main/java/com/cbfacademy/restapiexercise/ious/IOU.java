package com.cbfacademy.restapiexercise.ious;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table (name= "ious") // This tells Hibernate to make a table out of this class

public class IOU {
  @Id // schema = class in java
  @GeneratedValue(strategy=GenerationType.UUID) // a class - new object - new instance - these are specific key to identify an instance. object orientated concept


//public IOU(String borrower, String lender, BigDecimal amount, Instant datetime) - 
//constructor that should generate a new UUID, use the documentation to learn how to generate a random value.*/

private UUID id; //- unique identifier for the IOU
private String borrower; // - name of borrower
private String lender; // - name of lender
private BigDecimal amount; // - amount covered by IOU
private Instant dateTime; // - date and time of IOU being issued


public IOU(String borrower, String lender, BigDecimal amount, Instant dateTime){
this.borrower = borrower;
this.lender = lender;
this.amount = amount;
this.dateTime = dateTime; 
}


public IOU() {
    //TODO Auto-generated constructor stub
}


public UUID getId() {
  return id;
}
public void setId(UUID id) {
  this.id = id;
 }
public String getBorrower() {
  return borrower;
}
public void setBorrower(String borrower) {
  this.borrower = borrower;
}
public String getLender() {
  return lender;
}
public void setLender(String lender) {
  this.lender = lender;
}
public BigDecimal getAmount() {
  return amount;
}
public void setAmount(BigDecimal amount) {
  this.amount = amount;
}
public Instant getDateTime() {
  return dateTime;
}
public void setDateTime(Instant dateTime) {
  this.dateTime = dateTime;
}

}