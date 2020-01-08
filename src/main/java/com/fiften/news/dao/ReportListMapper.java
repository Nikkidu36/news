package com.fiften.news.dao;

import com.fiften.news.model.ReportList;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Mapper
@Repository
public interface ReportListMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table report_list
     *
     * @mbggenerated Tue Jan 07 19:18:18 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table report_list
     *
     * @mbggenerated Tue Jan 07 19:18:18 CST 2020
     */
    int insert(ReportList record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table report_list
     *
     * @mbggenerated Tue Jan 07 19:18:18 CST 2020
     */
    int insertSelective(ReportList record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table report_list
     *
     * @mbggenerated Tue Jan 07 19:18:18 CST 2020
     */
    ReportList selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table report_list
     *
     * @mbggenerated Tue Jan 07 19:18:18 CST 2020
     */
    int updateByPrimaryKeySelective(ReportList record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table report_list
     *
     * @mbggenerated Tue Jan 07 19:18:18 CST 2020
     */
    int updateByPrimaryKey(ReportList record);

    ReportList ReportNews(int media_id,int news_id,String reason);

    List<HashMap> getNewsReports(Integer ID);

}