package br.com.fiap.techchallenge2.mappers;

import br.com.fiap.techchallenge2.dto.ParquimetroEntryResponseDTO;
import br.com.fiap.techchallenge2.dto.ParquimetroRequestDTO;
import br.com.fiap.techchallenge2.dto.ParquimetroResponseDTO;
import br.com.fiap.techchallenge2.entities.Parquimetro;

import java.time.LocalDateTime;

public interface ParquimetroMapper {
    static Parquimetro toParquimetroEntity (ParquimetroRequestDTO requestDTO){
        return new Parquimetro(LocalDateTime.now(), null, requestDTO.placa(), null);
    }
    static ParquimetroEntryResponseDTO entradaNoEstacionamento (Parquimetro parquimetro){
        return new ParquimetroEntryResponseDTO(parquimetro.getUuid(),
                                            parquimetro.getPlaca(),
                                            parquimetro.getDataEntrada());
    }
    static ParquimetroResponseDTO saidaDoEstacionamento (Parquimetro parquimetro){
        return new ParquimetroResponseDTO(
                parquimetro.getUuid(),
                parquimetro.getPlaca(),
                parquimetro.getDataEntrada(),
                parquimetro.getDataSaida(),
                parquimetro.getValor());
    }

}
