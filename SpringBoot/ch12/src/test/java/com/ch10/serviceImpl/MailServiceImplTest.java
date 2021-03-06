package com.ch10.serviceImpl;

import com.ch10.pojo.MailSenderMsg;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
public class MailServiceImplTest {

    @Autowired
    MailServiceImpl mailService;

    /** 
     * @description:  普通邮件测试
     * @param:  
     * @return:  
     * @author: Mr.lgj 
     * @date: 7/4/18 
    */ 
   // @Test
    public  void sendSimpleMailTest(){

        MailSenderMsg msg = new MailSenderMsg("563739007@qq.com","Spring Boot 邮件测试","邮件内容");
        mailService.sendSimpleMail(msg);
    }


    /** 
     * @description: 发送Html 
     * @param:  
     * @return:  
     * @author: Mr.lgj 
     * @date: 7/4/18 
    */ 
   // @Test
    public  void sendHtmlMailTest(){
        String content="<html>\n" +
                "<body>\n" +
                "    <h1>hello world ! 这是一封Html邮件!</h1>\n" +
                "    <h3>hello world ! 这是一封Html邮件!</h3>\n" +
                "</body>\n" +
                "</html>";
        MailSenderMsg msg = new MailSenderMsg("563739007@qq.com",
                "Spring Boot Html邮件测试",
                content);
        mailService.sendHtmlMail(msg);
    }

    /** 
     * @description: 带附件 
     * @param:  
     * @return:  
     * @author: Mr.lgj 
     * @date: 7/4/18 
    */ 
    //@Test
    public  void sendAttachmentTest(){
        String content="<html>\n" +
                "<body>\n" +
                "    <h1>hello world ! 这是一封Html邮件!</h1>\n" +
                "    <h3>hello world ! 这是一封Html邮件!</h3>\n" +
                "</body>\n" +
                "</html>";
        MailSenderMsg msg = new MailSenderMsg("563739007@qq.com",
                "Spring Boot 附件邮件测试",content,
                "upload/123.jpeg");
        mailService.sendAttachmentMail(msg);
    }
    /** 
     * @description: 带附件和文本插入图片
     * @param:  
     * @return:  
     * @author: Mr.lgj 
     * @date: 7/4/18 
    */ 

    @Test
    public  void sendInlineResourceMailTest(){

        String rscId = "pic";
        String content="<html>\n" +
                "<body>\n" +
                "    <h1>hello world ! 这是一封Html邮件!</h1>\n" +
                "这是有图片的邮件：<img src=\'cid:" + rscId + "\' >" +
                "    <h3>hello world ! 这是一封Html邮件!</h3>\n" +
                "</body>\n" +
                "</html>";
        MailSenderMsg msg = new MailSenderMsg("563739007@qq.com",
                "Spring Boot 附件，嵌入图片邮件测试",
                content,"upload/123.jpeg",
                rscId,"upload/123.jpeg");
        mailService.sendInlineResourceMail(msg);
    }

}