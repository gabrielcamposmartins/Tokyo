package tokyo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tokyo.entity.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {
}
