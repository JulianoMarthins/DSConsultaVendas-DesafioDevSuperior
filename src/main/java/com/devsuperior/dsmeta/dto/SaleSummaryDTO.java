package com.devsuperior.dsmeta.dto;


import com.devsuperior.dsmeta.projections.SaleSummaryProjectuion;

public class SaleSummaryDTO {

    // Atributos de Classe
    private String sellerName;
    private Double total;


    // Construtores
    public SaleSummaryDTO(String sellerName, Double total){
        this.sellerName = sellerName;
        this.total = total;
    }

    public SaleSummaryDTO(SaleSummaryProjectuion projection){
        sellerName = projection.getSellerName();
        Double total = projection.getTotal();
    }

    // Getters

    public String getSellerName() {
        return sellerName;
    }

    public Double getTotal() {
        return total;
    }
}
