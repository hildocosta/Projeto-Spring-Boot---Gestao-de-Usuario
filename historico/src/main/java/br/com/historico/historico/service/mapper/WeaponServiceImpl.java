package br.com.historico.historico.service.mapper;

import br.com.historico.historico.model.request.WeaponRequest;
import br.com.historico.historico.model.response.WeaponResponse;
import br.com.historico.historico.persistence.entity.User;
import br.com.historico.historico.persistence.entity.Weapon;
import br.com.historico.historico.persistence.repository.WeaponRepository;
import br.com.historico.historico.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

import static org.springframework.util.Assert.notNull;

public class WeaponServiceImpl implements WeaponService{


    private  static final Logger LOGGER = LoggerFactory.getLogger(WeaponService.class);
    
    @Autowired
    private WeaponRepository weaponRepository;
    
    @Autowired
    private Mapper<WeaponRequest, Weapon> requestWeaponMapper;
    
    @Autowired
    private Mapper<Weapon, WeaponResponse> responseWeaponMapper;

        

    @Override
    public WeaponResponse create(WeaponRequest weaponRequest) {
        LOGGER.info("Criando o registro da arma");
        notNull(weaponRequest, "Request Invalida");
        Weapon weapon = this.requestWeaponMapper.map(weaponRequest);
        return weaponRepository.saveAndFlush(weapon).map((Weapon input) -> this.responseWeaponMapper.map(input));
    }

    @Override
    public Page<WeaponResponse> getAll(Pageable pageable) {
        LOGGER.info("Buscando todas as armas");
        notNull(pageable, "Pagina Invalida");
        return weaponRepository.findAll(pageable).map(weapon -> this.responseWeaponMapper.map(weapon));
    }

    @Override
    public Optional<WeaponResponse> update(Long id, WeaponRequest weaponRequest) {
        LOGGER.info("Atualizando a arma");
        notNull(id, "ID Invalido");

        Weapon weaponUptade = this.requestWeaponMapper.map((weaponRequest));

        return weaponRepository.findById(id)
                .map(weapon -> {

                    weapon.setSituacao((weaponUptade.getSituacao()));
                    weapon.setPatrimonio((weaponUptade.getPatrimonio()));
                    weapon.setTipo((weaponUptade.getTipo()));
                    weapon.setDistribuicao((weaponUptade.getDistribuicao()));
                    weapon.setPropriedade((weaponUptade.getPropriedade()));
                    weapon.setObservacao((weaponUptade.getObservacao()));
                    weapon.setNumeroSerie((weaponUptade.getNumeroSerie()));
                    weapon.setMarca((weaponUptade.getMarca()));
                    weapon.setModelo((weaponUptade.getModelo()));
                    weapon.setCalibre((weaponUptade.getCalibre()));
                    weapon.setCano((weaponUptade.getCano()));
                    weapon.setRaias((weaponUptade.getRaias()));
                    weapon.setAcabamento((weaponUptade.getAcabamento()));


                    return responseWeaponMapper.map(weaponRepository.saveAndFlush(weapon));


                });
    }


    @Override
    public Optional<WeaponResponse> get(Long id) {
        LOGGER.info("Buscando  arma");
        notNull(id, "ID Invalido");

        return weaponRepository.findById(id).map(this.responseWeaponMapper::map);
    }

    @Override
    public Optional<WeaponResponse> getByPatrimonio(String patrimonio) {
        LOGGER.info("Buscando arma pelo patrimônio");
        notNull(patrimonio, "Patrimônio Inválido");
        return weaponRepository.findByPatrimonio(patrimonio).map(this.responseWeaponMapper::map);
    }

    @Override
    public boolean delete(Long id) {
        LOGGER.info("Removendo  arma");
        notNull(id, "ID Invalido");

        try {

            weaponRepository.deleteById(id);
            return true;


        } catch (Exception e) {
            LOGGER.warn("Erro ao remover a arma {}", id);
            return false;
        }

    }
}
