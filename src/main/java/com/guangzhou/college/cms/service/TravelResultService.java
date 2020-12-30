package com.guangzhou.college.cms.service;

import com.guangzhou.college.dao.TravelResultMapper;
import com.guangzhou.college.entity.TravelResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TravelResultService {


    @Resource
    private TravelResultMapper travelResultMapper;

    public int deleteByPrimaryKey(Integer id) {
        return travelResultMapper.deleteByPrimaryKey(id);
    }

    public int insertSelective(TravelResult record) {
        return travelResultMapper.insertSelective(record);
    }

    public TravelResult selectByPrimaryKey(Integer id) {
        return travelResultMapper.selectByPrimaryKey(id);
    }

    public List<TravelResult> selectListByPrimaryKey(TravelResult record) {
        return travelResultMapper.selectListByPrimaryKey(record);
    }

    public int updateByPrimaryKeySelective(TravelResult record) {
        return travelResultMapper.updateByPrimaryKeySelective(record);
    }


}
