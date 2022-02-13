package com.example.officialsapplication.services;

import com.example.officialsapplication.model.users.korisnik.Korisnik;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserAuthService implements UserDetailsService {

    private final KorisnikService korisnikService;

    public UserAuthService(KorisnikService korisnikService) {
        this.korisnikService = korisnikService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Korisnik korisnik;
        korisnik = korisnikService.getXmlAsObject(username);

        List<GrantedAuthority> authorities = new ArrayList<>();
        GrantedAuthority authority = korisnik::getRola;
        authorities.add(authority);

        return new User(username, korisnik.getSifra(), authorities);
    }}
