package com.tutev.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tutev.entity.Kullanici;
import com.tutev.entity.KullaniciYetkiRol;

@Service("userDetailsService")
@Transactional
public class UserServiceImpl implements UserDetailsService {

	@Autowired
	private transient RolServis rolServis;
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		Kullanici kullanici = rolServis.getUserByName(username);
		if (kullanici != null) {

			Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			List<KullaniciYetkiRol> list = rolServis
					.getKullaniciRolByKullaniciId(kullanici.getId());

			for (KullaniciYetkiRol kYetkiRol : list) {
				authorities.add(new SimpleGrantedAuthority(kYetkiRol.getRol()
						.getKod()));
			}

			return new User(kullanici.getUsername(), kullanici.getPassword(),
					true, true, true, true, authorities);
		} else {
			throw new BadCredentialsException("Yanlış kullanıcı adı veya şifre");
		}
	}

}
