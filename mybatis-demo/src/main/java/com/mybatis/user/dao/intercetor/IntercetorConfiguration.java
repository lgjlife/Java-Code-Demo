package com.mybatis.user.dao.intercetor;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Iterator;
import java.util.List;

@Slf4j
@Configuration
public class IntercetorConfiguration {
  @Autowired
    private List<SqlSessionFactory> sqlSessionFactoryList;


   /* @Bean
    public MyIntercetor myIntercetor(){
        return new MyIntercetor();
    }*/

    @PostConstruct
    public void addPageInterceptor() {
        MyIntercetor interceptor = new MyIntercetor();

        Iterator var3 = this.sqlSessionFactoryList.iterator();

        while(var3.hasNext()) {
            SqlSessionFactory sqlSessionFactory = (SqlSessionFactory)var3.next();
            sqlSessionFactory.getConfiguration().addInterceptor(interceptor);
        }

    }
}
