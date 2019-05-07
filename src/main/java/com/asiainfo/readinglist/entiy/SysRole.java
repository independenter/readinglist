package com.asiainfo.readinglist.entiy;

import java.util.List;

public class SysRole {
    public List<SysPermission> permissionList;

    public SysRole(String role,String rolename){

    }
    public SysRole(){

    }

    public List<SysPermission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<SysPermission> permissionList) {
        this.permissionList = permissionList;
    }
}
