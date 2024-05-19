package br.com.historico.historico.service.mapper;

import br.com.historico.historico.model.request.WeaponRequest;
import br.com.historico.historico.model.response.WeaponResponse;
import br.com.historico.historico.persistence.entity.Weapon;
import br.com.historico.historico.persistence.repository.WeaponRepository;
import br.com.historico.historico.service.WeaponService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.springframework.util.Assert.notNull;

@Service
public class WeaponServiceImpl implements WeaponService {

    private  static final Logger LOGGER = LoggerFactory.getLogger(WeaponService.class);

    @Autowired
    private WeaponRepository weaponRepository;

    @Autowired
    private  Mapper<WeaponRequest, Weapon> requestWeaponMapper;

    @Autowired
    private  Mapper<Weapon, WeaponResponse> responseWeaponMapper;


    @Override
    public WeaponResponse create(WeaponRequest weaponRequest) {
       LOGGER.info("Criando o registro da arma");
       notNull(weaponRequest, "Request Invalida");
       Weapon weapon = this.requestWeaponMapper.map(weaponRequest);
       return  weaponRepository.saveAndFlush(weapon).map((Weapon input) -> this.responseWeaponMapper.map(weapon));

    }

    @Override
    public Page<WeaponResponse> getAll(Pageable pageable) {
        LOGGER.info("Buscando todos os registros de armas");
        notNull(pageable, "Request Invalida");
        return  weaponRepository.findAll(pageable).map(weapon -> this.responseWeaponMapper.map(weapon));
    }

    @Override
    public Optional<WeaponResponse> update(Long id, WeaponRequest weaponRequest) {
        LOGGER.info("Atualizando a arma");
        notNull(id, "ID Invalido");

        Weapon weaponUpdate = this.requestWeaponMapper.map((weaponRequest));

        return weaponRepository.findById(id)
                .map(weapon -> {

                    weapon.setSituacao((weaponUpdate.getSituacao()));

                    return  responseWeaponMapper.map(weaponRepository.saveAndFlush(weapon));


                });
    }

    @Override
    public Optional<WeaponResponse> get(Long id) {
       LOGGER.info("Buscando arma");
       notNull(id, "ID Invalido");

       return weaponRepository.findById(id).map(this.responseWeaponMapper::map);
    }

    @Override
    public boolean delete(Long id) {
        LOGGER.info("Removendo arma");
        notNull(id,"ID Invalido");

        try{

            weaponRepository.deleteById(id);
            return true;

        } catch (Exception e) {
            LOGGER.warn("Erro ao remover a arma {}", id);
            return false;
        }
    }
}
