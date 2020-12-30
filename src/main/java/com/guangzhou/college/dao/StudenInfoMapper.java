package com.guangzhou.college.dao;



import com.guangzhou.college.entity.StudenInfo;

import java.util.List;

public interface StudenInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StudenInfo record);

    int insertSelective(StudenInfo record);

    StudenInfo selectByPrimaryKey(Integer id);

    List<StudenInfo> selectListByPrimaryKey(StudenInfo studenInfo);

    int updateByPrimaryKeySelective(StudenInfo record);

    int updateByPrimaryKey(StudenInfo record);
}