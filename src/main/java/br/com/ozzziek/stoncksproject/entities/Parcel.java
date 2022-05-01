package br.com.ozzziek.stoncksproject.entities;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Entity
public class Parcel extends InstallmentPurchase {
    private Integer numberOfParcels;
    private Integer currentParcel;

//    @OneToMany(targetEntity = LocalDate.class)
//    private Map<Integer, LocalDate> validities = new HashMap<>();

    public Integer getNumberOfParcels() {
        return numberOfParcels;
    }

    public Integer getCurrentParcel() {
        return currentParcel;
    }

//    public Map<Integer, LocalDate> getValidities() {
//        return validities;
//    }

    public void setNumberOfParcels(Integer numberOfParcels) {
        this.numberOfParcels = numberOfParcels;
    }

    public void setCurrentParcel(Integer currentParcel) {
        this.currentParcel = currentParcel;
    }

//    public void generateParcels() {
//
//        int anoBase = 0;
//
//        for (int i = 1; i <= this.numberOfParcels; i++) {
//            var data = LocalDate.now();
//
//            var dataVencimento = LocalDate.of(data.getYear() + anoBase,
//                    data.getMonth().plus(i).getValue(),
//                    this.getDueDay());
//
//            if (data.getMonth().plus(i).getValue() == 12) {
//                anoBase++;
//            }
//
//            this.validities.put(i, dataVencimento);
//        }
//    }

}
