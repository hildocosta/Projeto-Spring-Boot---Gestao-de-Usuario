package br.com.historico.historico.service.mapper;

import br.com.historico.historico.model.request.WeaponRequest;
import br.com.historico.historico.model.response.WeaponResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface WeaponService {

    WeaponResponse create(WeaponRequest weaponRequest);

    Page<WeaponResponse> getAll(Pageable pageable);

    Optional<WeaponResponse> update(Long id, WeaponRequest weaponRequest);

    Optional<WeaponResponse> get(Long id);

    Optional<WeaponResponse> getByPatrimonio(String patrimonio);

    boolean delete(Long id);
}
