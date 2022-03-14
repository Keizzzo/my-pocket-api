package br.com.ozzziek.stoncksproject.simulations;

import br.com.ozzziek.stoncksproject.entities.InstallmentPurchase;
import br.com.ozzziek.stoncksproject.entities.MonthlyPayment;
import br.com.ozzziek.stoncksproject.entities.Parcel;
import br.com.ozzziek.stoncksproject.entities.enums.TipoPrazoEnum;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CompraPrazoSimulacao {
    public static void main(String[] args) {
        List<InstallmentPurchase> dues = new ArrayList<>();

        Parcel parcelado = new Parcel();
        parcelado.setDescription("Notebook da Xuxa");
        parcelado.setTotalValue(new BigDecimal(21.33));
        parcelado.setDueDay(15);
        parcelado.setNumberOfParcels(5);
        parcelado.setCurrentParcel(2);

        MonthlyPayment mensalidade = new MonthlyPayment();
        mensalidade.setDescription("Academia Muita Maromba");
        mensalidade.setValue(89.90);
        mensalidade.setDueDay(20);
        mensalidade.setActive(true);

        dues.add(parcelado);
//        dues.add(mensalidade);

        dues.forEach(p -> System.out.println(p.getDescription() + " --- $" + p.getTotalValue() + " --- Vencimento: " + p.getDueDay()));
        System.out.println(dues.get(0) instanceof Parcel);
//        System.out.println(dues.get(1) instanceof Mensalidade);

        //CASTING
        Parcel recebendo = (Parcel) dues.get(0);
        System.out.println(recebendo.getCurrentParcel() + " de " + recebendo.getNumberOfParcels());


    }
}
