package com.bilgeadam.security;

import com.bilgeadam.repository.entity.Personal;
import com.bilgeadam.service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JwtUserDetails implements UserDetailsService {
    @Autowired
    PersonalService personalService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    public UserDetails getUserByAuthId(Long personalid){
        Optional<Personal> personal = personalService.findById(personalid);

        if (personal.isEmpty()) return null;
        List<GrantedAuthority> authorities = new ArrayList<>();
        /**
         * Burada belirtilen isimlendirmeler tamamen size aittir. özel bir kullanım değildir.
         * Yetki Adı: yönetici, asistan,
         */

/*        roleService.findByAuthid(personalid).forEach(x->{
            authorities.add(new SimpleGrantedAuthority(x.getRole()));
        });*/
        return User.builder()
                .username(personalid.toString())
                .password("")
                .accountLocked(false)
                .accountExpired(false)
                .authorities(authorities)
                .build();
    }
}

