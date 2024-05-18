package br.com.historico.historico.persistence.repository;

import br.com.historico.historico.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
