package ru.vasiliy.mtstest.model;


import javax.persistence.*;
import java.io.Serializable;
/**
 * @author Vasiliy Bogatyrev on 12/01/2018.
 */

@Entity
@Table(name = "INVOICE")
@Access(AccessType.FIELD)
public class Invoice extends AbstractInvoice implements Serializable{

    @Column(name = "NAME")
    private String name;

    @Column(name = "TIN")
    private String tin;

    @Column(name = "СPP")
    private String cpp;

    @Column(name = "PRODUCT")
    private String product;

    @Column(name = "QUANTITY")
    private String quantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    public String getCpp() {
        return cpp;
    }

    public void setCpp(String cpp) {
        this.cpp = cpp;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
