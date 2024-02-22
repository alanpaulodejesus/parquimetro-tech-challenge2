package br.com.fiap.techchallenge2.exception;

public enum KeyMessages {
    PLACA_NOT_FOUND("Placa não encontrada.");

    String value;

    KeyMessages(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
