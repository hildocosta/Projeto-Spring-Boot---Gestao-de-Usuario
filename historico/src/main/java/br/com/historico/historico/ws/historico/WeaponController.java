package br.com.historico.historico.ws.historico;

import br.com.historico.historico.model.request.WeaponRequest;
import br.com.historico.historico.model.response.WeaponResponse;
import br.com.historico.historico.service.WeaponService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/historico")
public class WeaponController {


    private  static final Logger LOGGER = LoggerFactory.getLogger(WeaponService.class);

    @Autowired
    private WeaponService weaponService;

    @PostMapping
    public ResponseEntity<WeaponResponse> create(@RequestBody WeaponRequest weaponRequest){
        LOGGER.info("Requisicao recebida");
        return ResponseEntity.ok(weaponService.create(weaponRequest));
    }

    @GetMapping
    public ResponseEntity<Page<WeaponResponse>> getAll(Pageable pageable){
        LOGGER.info("Buscando as armas");
        Page<WeaponResponse> weaponResponses = weaponService.getAll(pageable);
        return ResponseEntity.ok(weaponResponses);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WeaponResponse> update(@PathVariable("id") Long id, @RequestBody WeaponRequest weaponRequest){
        LOGGER.info("Iniciando a atualizacao");
        Optional<WeaponResponse> update = weaponService.update(id, weaponRequest);
        if(!update.isPresent()){
            return ResponseEntity.notFound().build();

        }
        return ResponseEntity.ok(update.get());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WeaponResponse> get(@PathVariable("id") Long id){
        LOGGER.info("Iniciando a busca pela arma");
        Optional<WeaponResponse> weaponResponse = weaponService.get(id);
        if(!weaponResponse.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(weaponResponse.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        LOGGER.info("Iniciando a remocao da arma");
        if(weaponService.delete(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }










}
