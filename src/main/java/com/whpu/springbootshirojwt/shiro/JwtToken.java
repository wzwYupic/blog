package com.whpu.springbootshirojwt.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * shiro默认的时UserNameToken，我们需要把jwt的信息保存在token，所以需要自己定义一个token
 * 在UserNameToken里面，有username、password、rememberme、host
 * getPrincipal()和getCredentials()方法分别返回username和password
 * 但我们只有token，所以全都返回token
 */
public class JwtToken implements AuthenticationToken {

    private String token;

    public JwtToken(String jwt) {
        this.token = jwt;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
