package br.com.fiap.techchallenge2.controller;

import br.com.fiap.techchallenge2.dto.ParquimetroEntryResponseDTO;
import br.com.fiap.techchallenge2.dto.ParquimetroRequestDTO;
import br.com.fiap.techchallenge2.dto.ParquimetroResponseDTO;
import br.com.fiap.techchallenge2.service.ParquimetroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parquimetro")
public class ParquimetroController {

    @Autowired
    private ParquimetroService parquimetroService;

    @GetMapping("/{placa}")
    public ResponseEntity<ParquimetroResponseDTO> findByPlaca(@PathVariable String placa) {
        final ParquimetroResponseDTO parquimetroResponseDTO = parquimetroService.findByPlaca(placa);
        return ResponseEntity.ok(parquimetroResponseDTO);
    }

    @PostMapping
    public ResponseEntity<ParquimetroEntryResponseDTO> entrar(@RequestBody ParquimetroRequestDTO parquimetroRequestDTO) {
        final ParquimetroEntryResponseDTO parquimetroEntryResponseDTO = parquimetroService.entrar(parquimetroRequestDTO);
        return ResponseEntity.ok(parquimetroEntryResponseDTO);
    }

    @PostMapping("/{placa}/sair")
    public ResponseEntity<ParquimetroResponseDTO> sair(@PathVariable String placa) {
        final ParquimetroResponseDTO parquimetroResponseDTO = parquimetroService.sair(placa);
        return ResponseEntity.ok(parquimetroResponseDTO);
    }

}
