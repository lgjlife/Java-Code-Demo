package com.ch12.serviceImpl;

import com.ch12.dao.mapper.SchedulerMapper;
import com.ch12.dao.model.Scheduler;
import com.ch12.service.SchedulerService;
import com.serviceImpl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: swagger
 * @description: r任务调度Scheduler   Service接口实现层
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-07-05 14:44
 **/


@Service
public class SchedulerServiceImpl implements SchedulerService {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    SchedulerMapper schedulerMapper;

    /**
     * @description:  新建一个任务
     * @param:
     * @return:
     * @author: Mr.lgj
     * @date: 7/5/18
     */
    @Override
    public void newScheduler() {
       Scheduler scheduler = new Scheduler();
       scheduler.setJobName("scheduler1");
       Integer insertCount =  schedulerMapper.insert(scheduler);
       if(insertCount == 0){
           log.error("插入任务-{}-失败",scheduler.getJobName());
       }
       else{
           log.info("插入任务-{}-成功",scheduler.getJobName());
       }


    }

    /**
     * @description:  删除一个任务
     * @param:
     * @return:
     * @author: Mr.lgj
     * @date: 7/5/18
     */
    @Override
    public void deleteScheduler() {

    }

    /**
     * @description:  修改一个任务
     * @param:
     * @return:
     * @author: Mr.lgj
     * @date: 7/5/18
     */
    @Override
    public void modifyScheduler() {

    }

    /**
     * @description:  获取任务
     * @param:
     * @return:
     * @author: Mr.lgj
     * @date: 7/5/18
     */
    @Override
    public void getScheduler(){
        List<Scheduler> scheduler =  schedulerMapper.selectAll();
        if(scheduler == null){
            log.error("无任务存在");
        }
        else{
            log.info("获取的任务为：");
            for(Scheduler s: scheduler){
                log.info(s.toString());
            }

        }
    }

}
