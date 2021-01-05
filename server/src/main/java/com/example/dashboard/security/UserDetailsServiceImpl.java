package com.example.dashboard.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

import com.example.dashboard.model.Users;
import com.example.dashboard.repository.UtilisateursRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private UtilisateursRepository applicationUserRepository;

    public UserDetailsServiceImpl(UtilisateursRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users applicationUser = applicationUserRepository.findByMail(username);
        if (applicationUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(applicationUser.getName(), applicationUser.getPassword(), emptyList());
    }
}