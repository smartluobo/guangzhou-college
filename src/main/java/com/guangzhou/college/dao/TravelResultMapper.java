package com.guangzhou.college.dao;



import com.guangzhou.college.entity.TravelResult;

import java.util.List;

public interface TravelResultMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TravelResult record);

    int insertSelective(TravelResult record);

    TravelResult selectByPrimaryKey(Integer id);

    List<TravelResult> selectListByPrimaryKey(TravelResult id);

    int updateByPrimaryKeySelective(TravelResult record);

    int updateByPrimaryKey(TravelResult record);
}