package com.zrgk.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.zrgk.pojo.MenuPageParams;
import com.zrgk.pojo.MenuPojo;
/**
 * 
 * @author 龙汶宇
 *
 */
@Component
public interface MenuMapper {

	//通过角色id得到相应的菜单
	public List<MenuPojo> getUserMenus(int id);
	//得到所有的菜单并且分页
	public List<MenuPojo> getAllMenus(MenuPageParams mpp);
	//得到所有的菜单
	public List<MenuPojo> findAllMenus();
	//通过id 得到菜单的信息
	public MenuPojo getMenuById(int id);
	//得到总记录数
	public int getCount(MenuPageParams mpp);
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
