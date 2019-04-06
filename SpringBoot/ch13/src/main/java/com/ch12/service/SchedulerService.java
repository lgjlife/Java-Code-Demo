package com.ch12.service;

/**
 * @program: swagger
 * @description: 任务调度Scheduler   Service接口层
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-07-05 14:43
 **/
public interface SchedulerService {

    /** 
     * @description:  新建一个任务
     * @param:  
     * @return:  
     * @author: Mr.lgj 
     * @date: 7/5/18 
    */ 
    void newScheduler();
    /**
     * @description:  删除一个任务
     * @param:
     * @return:
     * @author: Mr.lgj
     * @date: 7/5/18
     */
    void deleteScheduler();
    /**
     * @description:  修改一个任务
     * @param:
     * @return:
     * @author: Mr.lgj
     * @date: 7/5/18
     */
    void modifyScheduler();

    /**
     * @description:  获取任务
     * @param:
     * @return:
     * @author: Mr.lgj
     * @date: 7/5/18
     */
    void getScheduler();

}
