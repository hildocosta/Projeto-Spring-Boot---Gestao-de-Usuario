package br.com.historico.historico.persistence.repository;

import br.com.historico.historico.persistence.entity.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WeaponRepository extends JpaRepository<Weapon, Long> {

    Optional<Weapon> findByPatrimonio(String patrimonio);
}
