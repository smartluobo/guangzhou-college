package com.guangzhou.college.dao;

import com.guangzhou.college.entity.TbApiUser;
import com.guangzhou.college.entity.Title;

import java.util.List;

public interface TitleMapper {

    void insert(TbApiUser user);

    List<Title> queryTitleList(Title title);

    int addTitle(Title title);

    int eidtTitle(Title title);

    int delTitle(Integer id);


}
