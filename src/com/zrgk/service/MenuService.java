package com.zrgk.service;

import java.util.List;

import com.zrgk.pojo.MenuPageParams;
import com.zrgk.pojo.MenuPojo;
import com.zrgk.util.PartPage;
/**
 * 
 * @author 龙汶宇
 *
 */
public interface MenuService {

	//得到用户的菜单相关信息
	public List<MenuPojo> getUserMenus(int id);
	//得到所有的菜单
	public List<MenuPojo> getAllMenus(MenuPageParams mpp);
	//得到所有的菜单
	public List<MenuPojo> findAllMenus();
	//得到所有的父级菜单
	public List<MenuPojo> findAllFatherMenus();
	//通过id 得到菜单的信息
	public MenuPojo getMenuById(int id);
	//得到总记录数
	public int getCount(MenuPageParams mpp);
	//分页
	public PartPage getPartPage(int count,int page);
	//根据id删除菜单
	public int deleteMenu(int id);
	//根据id删除菜单中间表
	public int deleteMenu2(int id);
	//添加菜单信息
	public int addMenu(MenuPojo mp);
	//更具id修改菜单
	public int updateMenu(MenuPojo mp);
	//更具id修改菜单
	public int updateMenu2(MenuPojo mp);
}
