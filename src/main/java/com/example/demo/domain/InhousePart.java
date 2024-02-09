package com.example.demo.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class InhousePart extends Part{
    int partId;

    public InhousePart() {
    }

    public InhousePart(String name, double price, int inv, int minInv, int maxInv, long id) {
        super(name, price, inv);
        this.minimumInventory = minInv;
        this.maximumInventory = maxInv;
        this.id = id;
    }

    public int getPartId() {
        return partId;
    }

    public void setPartId(int partId) {
        this.partId = partId;
    }
}