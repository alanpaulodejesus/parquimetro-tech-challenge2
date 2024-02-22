package br.com.fiap.techchallenge2.service;

import br.com.fiap.techchallenge2.dto.ParquimetroEntryResponseDTO;
import br.com.fiap.techchallenge2.dto.ParquimetroRequestDTO;
import br.com.fiap.techchallenge2.dto.ParquimetroResponseDTO;
import br.com.fiap.techchallenge2.entities.Parquimetro;
import br.com.fiap.techchallenge2.exception.KeyMessages;
import br.com.fiap.techchallenge2.exception.NotFoundException;
import br.com.fiap.techchallenge2.mappers.ParquimetroMapper;
import br.com.fiap.techchallenge2.repositories.ParquimetroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ParquimetroService {

    @Autowired
    private ParquimetroRepository repository;
    private final double TAXA_POR_HORA = 10.0;
    private final double TAXA_POR_15_MIN = 3.0;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");



    public ParquimetroResponseDTO findByPlaca(String placa) {
        return ParquimetroMapper.saidaDoEstacionamento(findInDB(placa));
    }

    public ParquimetroEntryResponseDTO entrar(ParquimetroRequestDTO parquimetroRequestDTO) {
        Parquimetro parquimetro = ParquimetroMapper.toParquimetroEntity(parquimetroRequestDTO);
        Parquimetro parquimetroSalvo = repository.saveAndFlush(parquimetro);
            return ParquimetroMapper.entradaNoEstacionamento(parquimetro);
    }

    public ParquimetroResponseDTO sair(String placa) {
        Parquimetro parquimetro = findInDB(placa);
        parquimetro.setDataSaida(LocalDateTime.now());
        calculaValorDevido(parquimetro);
        return ParquimetroMapper.saidaDoEstacionamento(parquimetro);

    }

    private void calculaValorDevido(Parquimetro parquimetro) {
        Duration duration = Duration.between(parquimetro.getDataEntrada(),parquimetro.getDataSaida());
        parquimetro.setValor((duration.toHours() * TAXA_POR_HORA) + (Math.ceil(duration.toMinutesPart() / 15.0) * TAXA_POR_15_MIN));
    }

    private Parquimetro findInDB(String placa) {
        final Parquimetro parquimetro = repository.findByPlaca(placa).orElseThrow(()
                -> new NotFoundException(KeyMessages.PLACA_NOT_FOUND.getValue()));
        return parquimetro;
    }

}
