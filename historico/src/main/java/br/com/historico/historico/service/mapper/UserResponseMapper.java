package br.com.historico.historico.service.mapper;

import br.com.historico.historico.model.response.UserResponse;
import br.com.historico.historico.persistence.entity.User;
import org.springframework.stereotype.Component;


@Component
public class UserResponseMapper implements  Mapper<User, UserResponse>{


    @Override
    public UserResponse map(User input) {
       if(input == null){
           return  null;
       }

       UserResponse userResponse = new UserResponse();

       userResponse.setId(input.getId());
       userResponse.setName(input.getName());
       userResponse.setDocument(input.getDocument());
       userResponse.setLogin(input.getLogin());
       userResponse.setEmail(input.getEmail());
       userResponse.setPassword(input.getPassword());

       return userResponse;
    }
}
