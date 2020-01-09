package com.fiften.news.dao;

import com.fiften.news.model.NewsDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.fiften.news.util.Result;

import java.util.HashMap;
import java.util.List;

import java.util.HashMap;
import java.util.List;

import java.util.HashMap;
import java.util.List;

@Mapper
@Repository
public interface NewsDetailMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news_detail
     *
     * @mbggenerated Wed Jan 08 16:32:46 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news_detail
     *
     * @mbggenerated Wed Jan 08 16:32:46 CST 2020
     */
    int insert(NewsDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news_detail
     *
     * @mbggenerated Wed Jan 08 16:32:46 CST 2020
     */
    int insertSelective(NewsDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news_detail
     *
     * @mbggenerated Wed Jan 08 16:32:46 CST 2020
     */
    NewsDetail selectByPrimaryKey(@Param("id") Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news_detail
     *
     * @mbggenerated Wed Jan 08 16:32:46 CST 2020
     */
    int updateByPrimaryKeySelective(NewsDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news_detail
     *
     * @mbggenerated Wed Jan 08 16:32:46 CST 2020
     */
    int updateByPrimaryKey(NewsDetail record);


    NewsDetail UploadNews(NewsDetail newsDetail);

    List<HashMap> getAllMyNews(@Param("id") Integer id);

    HashMap getOneNewsByID(Integer ID);

    boolean updateSubmitDateByID(Integer ID);

    NewsDetail searchNewsByTitle(@Param("title") String title);

    List<HashMap> showNewsById(@Param("id") int id);

    List<HashMap> showNewsByIdWithoutCollect(@Param("id") int id);

    List<HashMap> showNewsListById();
}