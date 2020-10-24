package com.guangzhou.college.dao;

import com.guangzhou.college.entity.PlayResult;
import com.guangzhou.college.entity.TbApiUser;

import java.util.List;

public interface PlayResultMapper {

    void insert(TbApiUser user);

    List<PlayResult> queryPlayResultList(PlayResult PlayResult);

    int addPlayResult(PlayResult PlayResult);

    int eidtPlayResult(PlayResult PlayResult);

    int delPlayResult(Integer id);
}
