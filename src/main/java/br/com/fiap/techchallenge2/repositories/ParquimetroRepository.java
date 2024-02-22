package br.com.fiap.techchallenge2.repositories;

import br.com.fiap.techchallenge2.entities.Parquimetro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ParquimetroRepository extends JpaRepository<Parquimetro, UUID> {
    Optional<Parquimetro> findByPlaca (String placa);
}
