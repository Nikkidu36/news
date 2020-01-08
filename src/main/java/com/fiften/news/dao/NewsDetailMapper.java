package com.fiften.news.dao;

import com.fiften.news.model.NewsDetail;
import com.fiften.news.model.NewsDetailWithBLOBs;

public interface NewsDetailMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news_detail
     *
     * @mbggenerated Tue Jan 07 19:18:18 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news_detail
     *
     * @mbggenerated Tue Jan 07 19:18:18 CST 2020
     */
    int insert(NewsDetailWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news_detail
     *
     * @mbggenerated Tue Jan 07 19:18:18 CST 2020
     */
    int insertSelective(NewsDetailWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news_detail
     *
     * @mbggenerated Tue Jan 07 19:18:18 CST 2020
     */
    NewsDetailWithBLOBs selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news_detail
     *
     * @mbggenerated Tue Jan 07 19:18:18 CST 2020
     */
    int updateByPrimaryKeySelective(NewsDetailWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news_detail
     *
     * @mbggenerated Tue Jan 07 19:18:18 CST 2020
     */
    int updateByPrimaryKeyWithBLOBs(NewsDetailWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news_detail
     *
     * @mbggenerated Tue Jan 07 19:18:18 CST 2020
     */
    int updateByPrimaryKey(NewsDetail record);

    NewsDetail insertTitleAndKeyAndDetailToNewsDetail(String title,String key,String detail);
}