package pl.project.carDealer.Services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.project.carDealer.Repositories.RoleRepositories;
import pl.project.carDealer.Repositories.UserRepositories;
import pl.project.carDealer.model.User;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImp implements UserDetailsService {
    private static final Logger LOG = LoggerFactory.getLogger(UserDetailsServiceImp.class);

    private final UserRepositories userRepositories;
    private final RoleRepositories roleRepositories;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserDetailsServiceImp(UserRepositories userRepositories, RoleRepositories roleRepositories, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.roleRepositories = roleRepositories;
        this.userRepositories = userRepositories;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;

    }


    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepositories.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("nie ma takiego użytkownika"));

        Set<GrantedAuthority> grantedAuthorities =
                user.getRoles().stream()
                        .map(r -> new SimpleGrantedAuthority("ROLE_" + r.getName()))
                        .collect(Collectors.toSet());

        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(), grantedAuthorities);

    }

    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet(userRepositories.findAll()));
        userRepositories.save(user);
    }
}
