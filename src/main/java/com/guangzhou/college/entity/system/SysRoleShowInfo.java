package com.guangzhou.college.entity.system;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * 系统菜单展示信息
 */
@Data
public class SysRoleShowInfo {
    /**
     * 菜单树
     */
    private SysMenuTree sysMenuTree;
    /**
     * 角色类型
     */
    private Map<Integer, String> roleType;
    /**
     * 数据权限
     */
    private Map<Integer, List<SysRole>> dataAuthor;
}
