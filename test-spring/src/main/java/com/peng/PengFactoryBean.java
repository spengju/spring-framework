package com.peng;

import com.peng.entity.User;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2025/3/30 14:13
 * @Desc:
 */
@Component
public class PengFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        User user = new User();
        user.setUsername("spengju");
        return user;
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
