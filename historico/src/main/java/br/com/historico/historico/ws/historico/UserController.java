package br.com.historico.historico.ws.historico;


import br.com.historico.historico.model.request.UserRequest;
import br.com.historico.historico.model.response.UserResponse;
import br.com.historico.historico.service.UserService;
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
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;


    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody UserRequest userRequest){
        LOGGER.info("Requisicao recebida");
        return ResponseEntity.ok(userService.create(userRequest));
    }

    @GetMapping
    public ResponseEntity<Page<UserResponse>> getAll(Pageable pageable){
        LOGGER.info("Buscando os usuarios");
        Page<UserResponse> userResponses = userService.getAll(pageable);
        return ResponseEntity.ok(userResponses);

    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updtade(@PathVariable("id") Long id, @RequestBody UserRequest userRequest){
        LOGGER.info("Iniciando a atualizacao");
        Optional<UserResponse> update = userService.update(id, userRequest);
        if(!update.isPresent()){
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(update.get());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> get(@PathVariable("id") Long id){
        LOGGER.info("Iniciando a busca pelo usuario");
        Optional<UserResponse> userResponse = userService.get(id);
        if(!userResponse.isPresent()){
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userResponse.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        LOGGER.info("Iniciando a remocao do  usuario");
        if(userService.delete(id)){
            return  ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();

    }



}
