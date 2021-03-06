package com.ch12.dao.mapper;

import com.ch12.dao.model.Scheduler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SchedulerMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table scheduler
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer schedulerId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table scheduler
     *
     * @mbggenerated
     */
    int insert(Scheduler record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table scheduler
     *
     * @mbggenerated
     */
    Scheduler selectByPrimaryKey(Integer schedulerId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table scheduler
     *
     * @mbggenerated
     */
    List<Scheduler> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table scheduler
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Scheduler record);
}