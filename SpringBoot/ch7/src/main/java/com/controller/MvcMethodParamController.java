package com.controller;



import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @description:  
* @param:
* @return:  
* @author: Mr.lgj 
* @date: 6/29/18 
*/


@Api("/mvc/method/param")
@Controller
@RequestMapping("/mvc/method/param")
public class MvcMethodParamController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    //URI路径匹配 PathVariable


    //：描述一个类的一个方法，或者说一个接口
    @ApiOperation(value="/func1/{id}",notes = "URI路径匹配 PathVariable")
    @ResponseBody
    @GetMapping("/func1/{id}")
    public String func1(@PathVariable("id") int id){

        log.info("访问/mvc/func1/{id}");
        log.info("id = " + id);
        return "/mvc/func1/{id} Request Success";

    }

    //绑定 Model
    @GetMapping("/func2")
    public String func2(Model model){

        log.info("访问/mvc/method/param/func2");
        Map<String,Student> map = new HashMap<String,Student>();

        Student stu = new Student(1234L,"liSa");

        map.put("students",stu);
        model.addAttribute("students",stu);
        model.addAttribute("name","url");
        return "studentInfo";

    }
    //绑定 ModelAndView
    @RequestMapping("/func3")
    public ModelAndView func3(Model model){

        log.info("访问/mvc/method/param/func3");
        ModelAndView view = new ModelAndView("studentInfo");

        Student stu = new Student(1234L,"liSa");
        view.addObject("students",stu);
        view.addObject("name","url");
        return view;

    }

    ////url?xxx=xxx
    @ResponseBody
    @RequestMapping("/func4")
    public String func4(@RequestParam(name = "name",required = true) String name){

        log.info("访问/mvc/method/param/func4");
        return name;

    }
    @ResponseBody
    @RequestMapping("/func5")
    public String func5(@RequestBody  Student stu){

        log.info("访问/mvc/method/param/func5");
        System.out.println(stu.toString());
        return "name = " + stu.getName();

    }

    /** 
    * @description: 文件上传测试
    * @param:  
    * @return:  
    * @author: Mr.lgj 
    * @date: 6/30/18 
    */ 
    @ResponseBody
    @RequestMapping("/func6")
    public String func6(List<MultipartFile> files){

        log.info("访问/mvc/method/param/func6");
        log.info("lenth = " + files.size());
        for(MultipartFile file:files){
            log.info("name = " + file.getOriginalFilename());

            try{
                File downloadFilePath = new File("download");
                if(!downloadFilePath.exists()){
                    downloadFilePath.mkdir();
                }
                String name = file.getOriginalFilename();
                File f = new File(downloadFilePath,name);

                file.transferTo(f);
                log.info("文件：" + name + "保存成功！");


            }catch (Exception e){
                e.printStackTrace();
            }


            try{
                log.info("bytes = " + file.getBytes());
            }
            catch(Exception e){
                e.printStackTrace();
            }

        }

        return "file";

    }

    @GetMapping("/func7")
    @ResponseBody
    public String func7(@Value("${aserver.servlet.context-path}") String path){
        return "context-path = " + path;
    }
}

class Student{

    private Long id;
    private String name;

    public Student() {
    }

    public Student(Long id, String name) {
        this.id = id;
        this.name = name;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}