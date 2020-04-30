package edu.uncc.domoapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "accounts")
@NamedQuery(name = "Account.getAll", query = "select acc from Account as acc order by acc.dateCreated")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="account_id")
    private Integer id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "acc_no", nullable = false)
    private String accNum;

    @Column(name = "acc_type", nullable = false)
    private String accType;

    @Column(name = "active", nullable = false)
    private boolean isActive;

    @Column(name = "bank_name", nullable = false)
    private String bankName;

    @Column(name = "routing_no", nullable = false)
    private Integer routingNo;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
    private LocalDate dateCreated;

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Account(int id, String firstName, String lastName, String accNum, String accType, boolean isActive, String bankName, int routingNo, LocalDate dateCreated) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accNum = accNum;
        this.accType = accType;
        this.isActive = isActive;
        this.bankName = bankName;
        this.routingNo = routingNo;
        this.dateCreated = dateCreated;
    }

    public Account() {
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAccNum() {
        return accNum;
    }

    public void setAccNum(String accNo) {
        this.accNum = accNo;
    }

    public String getAccType() {
        return accType;
    }

    public void setAccType(String accType) {
        this.accType = accType;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Integer getRoutingNo() {
        return routingNo;
    }

    public void setRoutingNo(Integer routingNo) {
        this.routingNo = routingNo;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", accNo='" + accNum + '\'' +
                ", accType='" + accType + '\'' +
                ", isActive=" + isActive +
                ", bankName='" + bankName + '\'' +
                ", routingNo=" + routingNo +
                '}';
    }
}
