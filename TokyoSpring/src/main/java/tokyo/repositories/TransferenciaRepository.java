package tokyo.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tokyo.entity.Transferencia;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {
    List<Transferencia> findAllByEfetuadaFalseAndDataTransferencia(LocalDate dtaTransferencia);
    Page<Transferencia> findAllByOrigemId(Long origemId, Pageable pageable);
}
