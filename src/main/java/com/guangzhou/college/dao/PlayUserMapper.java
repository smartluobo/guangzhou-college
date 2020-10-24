package com.guangzhou.college.dao;

import com.guangzhou.college.entity.TbApiUser;
import com.guangzhou.college.entity.PlayUser;

import java.util.List;

public interface PlayUserMapper {

    void insert(TbApiUser user);

    List<PlayUser> queryPlayUserList(PlayUser PlayUser);

    int addPlayUser(PlayUser PlayUser);

    int eidtPlayUser(PlayUser PlayUser);

    int delPlayUser(Integer id);
}
