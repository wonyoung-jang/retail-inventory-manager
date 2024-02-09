package com.example.demo.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("2")
public class OutsourcedPart extends Part{
String companyName;

    public OutsourcedPart() {
    }

    public OutsourcedPart(String name, double price, int inv, String companyName, int minInv, int maxInv, long id) {
        super(name, price, inv);
        this.companyName = companyName;
        this.minimumInventory = minInv;
        this.maximumInventory = maxInv;
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
