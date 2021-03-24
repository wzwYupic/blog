package com.whpu.springbootshirojwt.shiro;


import com.whpu.springbootshirojwt.entity.User;
import com.whpu.springbootshirojwt.service.UserService;
import com.whpu.springbootshirojwt.utils.JwtUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class AccountRealm extends AuthorizingRealm {

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    UserService userService;


    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    /**
     * 拿到用户后获取权限信息
     * 把权限信息封装成 info 然后返回给 shiro
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    /**
     * 身份验证，获取token，进行密码的校验等逻辑
     * 校验成功后返回基本信息
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        //获取到token，需要解析，注入JwtUtils
        JwtToken jwtToken = (JwtToken) token;

        String userId = jwtUtils.getClaimByToken((String) jwtToken.getPrincipal()).getSubject();

        User user = userService.getById(Long.valueOf(userId));

        if (user == null){
            throw new UnknownAccountException("账户不存在");
        }
        if (user.getStatus() == -1){
            throw new LockedAccountException("账户已被锁定");
        }

        AccountProfile profile = new AccountProfile();

        BeanUtils.copyProperties(user,profile);
        //profile通常封装一些非私密性的数据，用户id，身份，邮件等等
        return new SimpleAuthenticationInfo(profile,jwtToken.getCredentials(),getName());

    }
}
