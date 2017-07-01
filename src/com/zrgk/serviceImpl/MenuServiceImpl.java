package com.zrgk.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zrgk.mapper.MenuMapper;
import com.zrgk.pojo.MenuPageParams;
import com.zrgk.pojo.MenuPojo;
import com.zrgk.service.MenuService;
import com.zrgk.util.PartPage;
/**
 * 
 * @author 龙汶宇
 *
 */
@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuMapper menuMapper;
	
	public MenuMapper getMenuMapper() {
		return menuMapper;
	}

	public void setMenuMapper(MenuMapper menuMapper) {
		this.menuMapper = menuMapper;
	}

	@Override
	public List<MenuPojo> getUserMenus(int id) {
		// TODO Auto-generated method stub
		return menuMapper.getUserMenus(id);
	}

	@Override
	public List<MenuPojo> getAllMenus(MenuPageParams mpp) {
		// TODO Auto-generated method stub
		return menuMapper.getAllMenus(mpp);
	}

	@Override
	public MenuPojo getMenuById(int id) {
		// TODO Auto-generated method stub
		return menuMapper.getMenuById(id);
	}

	@Override
	public int getCount(MenuPageParams mpp) {
		// TODO Auto-generated method stub
		return menuMapper.getCount(mpp);
	}
	public PartPage getPartPage(int count,int page) {
		PartPage p=new PartPage();
		int pages=0;
		if(count!=0){
			if (count%PartPage.pageSize!=0) {
				pages=count/PartPage.pageSize+1;
			}else {
				pages=count/PartPage.pageSize;
			}
			if(page<1){
				page=1;
			}else if (page>pages) {
				page=pages;
			}
			p.setCount(count);
			p.setNowPage(page);
			p.setTotalPage(pages);
		}else {
			p.setCount(0);
			p.setNowPage(1);
			p.setTotalPage(1);
		}
		return p;
	}

	@Override
	public List<MenuPojo> findAllMenus() {
		return menuMapper.findAllMenus();
	}
	@Override
	public List<MenuPojo> findAllFatherMenus() {
		// TODO Auto-generated method stub
		List<MenuPojo> list=menuMapper.findAllMenus();
		List<MenuPojo> mlist=new ArrayList<MenuPojo>();
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getM_father() == 0 && list.get(i).getM_state()==0){
				mlist.add(list.get(i));
			}
		}
		return mlist;
	}

	@Override
	public int deleteMenu(int id) {
		// TODO Auto-generated method stub
		return menuMapper.deleteMenu(id);
	}

	//添加菜单
	@Override
	public int addMenu(MenuPojo mp) {
		// TODO Auto-generated method stub
		return menuMapper.addMenu(mp);
	}

	@Override
	public int updateMenu(MenuPojo mp) {
		// TODO Auto-generated method stub
		return menuMapper.updateMenu(mp);
	}

	@Override
	public int deleteMenu2(int id) {
		// TODO Auto-generated method stub
		return menuMapper.deleteMenu2(id);
	}

	@Override
	public int updateMenu2(MenuPojo mp) {
		// TODO Auto-generated method stub
		return menuMapper.updateMenu2(mp);
	}

}
