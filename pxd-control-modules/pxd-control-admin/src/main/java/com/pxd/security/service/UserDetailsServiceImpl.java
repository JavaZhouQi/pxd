
package com.pxd.security.service;

import com.pxd.security.security.vo.JwtUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import java.util.Optional;

/**
 * @author hupeng
 * @date 2018-11-22
 */
@Service("userDetailsService")
//@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) {
//        UserDto user = userService.findByName(username);
//        if (user == null) {
//            throw new BadRequestException("账号不存在");
//        } else {
//            if (!user.getEnabled()) {
//                throw new BadRequestException("账号未激活");
//            }
//            return createJwtUser(user);
//        }
        return null;
    }

//    private UserDetails createJwtUser(UserDto user) {
//        return new JwtUser(
//                user.getId(),
//                user.getUsername(),
//                user.getNickName(),
//                user.getSex(),
//                user.getPassword(),
//                user.getAvatar(),
//                user.getEmail(),
//                user.getPhone(),
//                Optional.ofNullable(user.getDept()).map(DeptSmallDto::getName).orElse(null),
//                Optional.ofNullable(user.getJob()).map(JobSmallDto::getName).orElse(null),
//                roleService.mapToGrantedAuthorities(user),
//                user.getEnabled(),
//                user.getCreateTime(),
//                user.getLastPasswordResetTime()
//        );
//    }
}
