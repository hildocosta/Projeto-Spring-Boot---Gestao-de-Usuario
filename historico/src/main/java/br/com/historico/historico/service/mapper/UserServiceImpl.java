package br.com.historico.historico.service.mapper;

import br.com.historico.historico.model.request.UserRequest;
import br.com.historico.historico.model.response.UserResponse;
import br.com.historico.historico.persistence.entity.User;
import br.com.historico.historico.persistence.repository.UserRepository;
import br.com.historico.historico.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.springframework.util.Assert.notNull;


@Service
public class UserServiceImpl implements UserService {


    private  static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

@Autowired
private UserRepository userRepository;

@Autowired
private Mapper<UserRequest, User> requestMapper;

@Autowired
private Mapper<User, UserResponse> responseMapper;


    @Override
    public UserResponse create(UserRequest userRequest) {
        LOGGER.info("Criando o registro do usuario");
        notNull(userRequest, "Request Invalida");
        User user = this.requestMapper.map(userRequest);
        return userRepository.saveAndFlush(user).map((User input) -> this.responseMapper.map(input));
    }

    @Override
    public Page<UserResponse> getAll(Pageable pageable) {
        LOGGER.info("Buscando todos os usuarios");
        notNull(pageable, "Pagina Invalida");
        return userRepository.findAll(pageable).map(user -> this.responseMapper.map(user));
    }

    @Override
    public Optional<UserResponse> update(Long id, UserRequest userRequest) {
        LOGGER.info("Atualizando o usuario");
        notNull(id, "ID Invalido");

        User userUptade = this.requestMapper.map((userRequest));

        return userRepository.findById(id)
                .map(user -> {

                    user.setName((userUptade.getName()));

                    return responseMapper.map(userRepository.saveAndFlush(user));


                });
    }



    @Override
    public Optional<UserResponse> get(Long id) {
        LOGGER.info("Buscando  usuario");
        notNull(id, "ID Invalido");

        return userRepository.findById(id).map(this.responseMapper::map);
    }



    @Override
    public boolean delete(Long id) {
        LOGGER.info("Removendo  usuario");
        notNull(id, "ID Invalido");

        try {

            userRepository.deleteById(id);
            return true;


        } catch (Exception e) {
            LOGGER.warn("Erro ao remover o usuario {}", id);
            return false;
        }
    }
}
