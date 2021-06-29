package com.client.demo.dto;
/*
*DTO para mapear la respuesta del servicio de promedio de edad y desvio estandar
*/
public class AgeStatisticsDTO {

    //Promedio de edad de todas las personas registardas
    private Double average;
    //Desvio estandar de la edad de todas las personas registradas
    private Double standardDeviation;

    public AgeStatisticsDTO() {
    }

    public AgeStatisticsDTO(Double average, Double standardDeviation) {
        this.average = average;
        this.standardDeviation = standardDeviation;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    public Double getStandardDeviation() {
        return standardDeviation;
    }

    public void setStandardDeviation(Double standardDeviation) {
        this.standardDeviation = standardDeviation;
    }
}
