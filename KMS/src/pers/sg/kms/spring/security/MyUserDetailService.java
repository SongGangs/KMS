/**

 * 
 */

package pers.sg.kms.spring.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import pers.sg.kms.model.Userinfo;
import pers.sg.kms.services.IUserInfoService;

/**
 * 
 * @Title:MyUserDetailService
 * @Description:
 * @Personal
 * @author : SGang
 * @date : 2017��6��2������3:26:08
 */
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	private IUserInfoService userService = null;

	// 登陆验证时，通过username获取用户的所有权限信息，
	// 并返回User放到spring的全�?缓存SecurityContextHolder中，以供授权器使�?
	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		Userinfo user = userService.getUserinfoByUserName(arg0);
		System.out.println("User : " + user);
		if (user == null) {
			System.out.println("User not found");
			throw new UsernameNotFoundException("Username not found");
		}
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), true,
				true, true, true, getGrantedAuthorities(user));
	}

	private List<GrantedAuthority> getGrantedAuthorities(Userinfo user) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		System.out.print("authorities :" + authorities);
		return authorities;
	}

}
