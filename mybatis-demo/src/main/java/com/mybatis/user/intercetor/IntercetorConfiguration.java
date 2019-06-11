package com.mybatis.user.intercetor;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.Iterator;
import java.util.List;

@Slf4j
//@Configuration
public class IntercetorConfiguration {
  @Autowired
    private List<SqlSessionFactory> sqlSessionFactoryList;


   /* @Bean
    public MyIntercetor myIntercetor(){
        return new MyIntercetor();
    }*/

    @PostConstruct
    public void addPageInterceptor() {

        Iterator var3 = this.sqlSessionFactoryList.iterator();

        while(var3.hasNext()) {
            SqlSessionFactory sqlSessionFactory = (SqlSessionFactory)var3.next();
            sqlSessionFactory.getConfiguration().addInterceptor(new MyIntercetor());
            //  sqlSessionFactory.getConfiguration().addInterceptor(new PageIntercetor());

            sqlSessionFactory.getConfiguration().addInterceptor(new ParperIntercetor());
        }

    }
}
