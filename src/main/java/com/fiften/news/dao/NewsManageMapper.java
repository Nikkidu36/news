package com.fiften.news.dao;

import com.fiften.news.model.NewsManage;

public interface NewsManageMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news_manage
     *
     * @mbggenerated Tue Jan 07 19:18:18 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news_manage
     *
     * @mbggenerated Tue Jan 07 19:18:18 CST 2020
     */
    int insert(NewsManage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news_manage
     *
     * @mbggenerated Tue Jan 07 19:18:18 CST 2020
     */
    int insertSelective(NewsManage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news_manage
     *
     * @mbggenerated Tue Jan 07 19:18:18 CST 2020
     */
    NewsManage selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news_manage
     *
     * @mbggenerated Tue Jan 07 19:18:18 CST 2020
     */
    int updateByPrimaryKeySelective(NewsManage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news_manage
     *
     * @mbggenerated Tue Jan 07 19:18:18 CST 2020
     */
    int updateByPrimaryKey(NewsManage record);
}