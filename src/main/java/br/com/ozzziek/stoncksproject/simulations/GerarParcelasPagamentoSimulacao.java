package br.com.ozzziek.stoncksproject.simulations;

import br.com.ozzziek.stoncksproject.entities.Parcel;

public class GerarParcelasPagamentoSimulacao {

    public static void main(String[] args) {
        Parcel parcelado = new Parcel();
        parcelado.setNumberOfParcels(24);
        parcelado.setDescription("Empréstimo com Agiota");
        parcelado.setDueDay(20);

//        parcelado.generateParcels();
//
//        parcelado.getValidities().forEach((p,d) -> System.out.println("Parcela: " + p + " Data: " + d));

        //Resultado deve ser: 2021-12-20
//        System.out.println(parcelado.getValidities().get(4));

    }

}
