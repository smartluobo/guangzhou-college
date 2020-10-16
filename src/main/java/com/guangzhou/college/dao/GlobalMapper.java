package com.guangzhou.college.dao;

import com.guangzhou.college.entity.TbApiUser;
import com.guangzhou.college.entity.Global;

import java.util.List;

public interface GlobalMapper {


    List<Global> queryGlobalList(Global Global);

    int addGlobal(Global Global);

    int eidtGlobal(Global Global);

    int delGlobal(Integer id);
}
