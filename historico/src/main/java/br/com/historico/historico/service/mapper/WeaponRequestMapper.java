package br.com.historico.historico.service.mapper;

import br.com.historico.historico.model.request.WeaponRequest;
import br.com.historico.historico.persistence.entity.Weapon;

public class WeaponRequestMapper implements Mapper<WeaponRequest, Weapon> {


    @Override
    public Weapon map(WeaponRequest input) {
        if(input == null){
            return null;
        }

        Weapon weapon = new Weapon();

        weapon.setSituacao(input.getSituacao());
        weapon.setPatrimonio(input.getPatrimonio());
        weapon.setTipo(input.getTipo());
        weapon.setDistribuicao(input.getDistribuicao());
        weapon.setPropriedade(input.getPropriedade());
        weapon.setObservacao(input.getObservacao());
        weapon.setNumeroSerie(input.getNumeroSerie());
        weapon.setMarca(input.getMarca());
        weapon.setModelo(input.getModelo());
        weapon.setCalibre(input.getCalibre());
        weapon.setCano(input.getCano());
        weapon.setRaias(input.getRaias());
        weapon.setAcabamento(input.getAcabamento());

        return weapon;







    }
}
