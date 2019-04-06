package com.serviceImpl;

import com.dao.mapper.OsUserMapper;
import com.dao.model.OsUser;
import com.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    OsUserMapper userMapper;

    @Override
    public List<OsUser> getAll() {
        System.out.println("访问UserServiceImpl getAll aa");
        List<OsUser> users = userMapper.selectAll();
        if(users == null){
            log.info("user is null");
        }
        else{
            System.out.println("get user success");

            for(OsUser u: users){
                System.out.println(u.getPhoneNum());
            }
        }
        return  users;

    }
}
