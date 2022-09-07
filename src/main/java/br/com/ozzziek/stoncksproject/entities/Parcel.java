package br.com.ozzziek.stoncksproject.entities;

import javax.persistence.Entity;

//@Entity
public class Parcel extends TermPurchase {
    private Integer numberOfParcels;
    private Integer currentParcel;

    public Integer getNumberOfParcels() {
        return numberOfParcels;
    }

    public Integer getCurrentParcel() {
        return currentParcel;
    }

    public void setNumberOfParcels(Integer numberOfParcels) {
        this.numberOfParcels = numberOfParcels;
    }

    public void setCurrentParcel(Integer currentParcel) {
        this.currentParcel = currentParcel;
    }

}
