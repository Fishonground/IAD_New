package pip.course.serviseImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pip.course.entities.UsersEntity;
import pip.course.repository.UsersRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // с помощью нашего сервиса UserService получаем User
        UsersEntity usersEntity = usersRepository.findUsersEntityByLogin("I've done it");

        if(usersEntity == null){
            throw new UsernameNotFoundException("User not found");
        }else {
            Set<GrantedAuthority> roles = new HashSet();
            //roles.add(new SimpleGrantedAuthority(UserRoleEnum.USER.name()));
            roles.add(new SimpleGrantedAuthority(usersEntity.getUsersStatusByStatus().getName()));
            // на основании полученных данных формируем объект UserDetails
            // который позволит проверить введенный пользователем логин и пароль
            // и уже потом аутентифицировать пользователя
            UserDetails userDetails =
                    new org.springframework.security.core.userdetails.User(usersEntity.getLogin(),
                            usersEntity.getPassword(),
                            roles);

            return userDetails;
        }
    }

}