package br.com.historico.historico.service.mapper;

import br.com.historico.historico.model.request.UserRequest;
import br.com.historico.historico.persistence.entity.User;

import org.springframework.stereotype.Component;


@Component
public class UserRequestMapper implements Mapper<UserRequest, User> {


    @Override
    public User map(UserRequest input) {
        if(input == null){
            return null;
        }

        User user = new User();
        user.setName(input.getName());
        user.setDocument(input.getDocument());
        user.setLogin(input.getLogin());
        user.setEmail(input.getEmail());
        user.setPassword(input.getPassword());

        return  user;
    }
}
