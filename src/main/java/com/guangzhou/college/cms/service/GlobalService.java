package com.guangzhou.college.cms.service;

import com.guangzhou.college.dao.GlobalMapper;
import com.guangzhou.college.entity.Global;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class GlobalService {


    @Resource
    private GlobalMapper globalMapper;

    public List<Global> queryGlobalList(Global Global){
        return  globalMapper.queryGlobalList(Global);
    }

    public int addGlobal(Global Global){
        return globalMapper.addGlobal(Global);
    }

    public int eidtGlobal(Global Global){
        return  globalMapper.eidtGlobal(Global);
    }

    public int delGlobal(Integer id){
        return globalMapper.delGlobal(id);
    }


}
