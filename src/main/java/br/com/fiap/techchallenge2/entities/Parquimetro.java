package br.com.fiap.techchallenge2.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
public class Parquimetro {

    @Id
    private UUID uuid;
    private LocalDateTime dataEntrada;
    private LocalDateTime dataSaida;
    private String placa;
    private Double valor;

    public Parquimetro(){
    }

    public Parquimetro(LocalDateTime dataEntrada, LocalDateTime dataSaida, String placa, Double valor) {
        this.uuid = UUID.randomUUID();
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.placa = placa;
        this.valor = valor;
    }

    public UUID getUuid() {
        return uuid;
    }

    public LocalDateTime getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDateTime dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDateTime getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDateTime dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }

}
