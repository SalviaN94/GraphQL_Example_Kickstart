package com.nick.example.graphql_example_kickstart.security.jwt;

import com.nick.example.graphql_example_kickstart.entity.User;
import com.nick.example.graphql_example_kickstart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JwtUserDetailsService implements UserDetailsService {

  @Autowired
  private UserRepository usuarioRepository;

  @Override
  @Transactional(readOnly = true)
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    User user = usuarioRepository.findByUsername(username);
    if(user == null)
      throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));

    return new JwtUserDetails(user.getId(), user.getUsername(), user.getPassword(), user.getRole());
  }
}


