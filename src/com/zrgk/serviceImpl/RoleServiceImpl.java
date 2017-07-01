package com.zrgk.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zrgk.mapper.RoleMapper;
import com.zrgk.pojo.RolePageParams;
import com.zrgk.pojo.RolePojo;
import com.zrgk.service.RoleService;
import com.zrgk.util.PartPage;
/**
 * 
 * @author 龙汶宇
 *
 */
@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;
	
	public RoleMapper getMenuMapper() {
		return roleMapper;
	}

	public void setMenuMapper(RoleMapper roleMapper) {
		this.roleMapper = roleMapper;
	}

	
	@Override
	public List<RolePojo> getAllRoles(RolePageParams mpp) {
		// TODO Auto-generated method stub
		return roleMapper.getAllRoles(mpp);
	}

	@Override
	public RolePojo getRoleById(int id) {
		// TODO Auto-generated method stub
		return roleMapper.getRoleById(id);
	}

	@Override
	public int getCount(RolePageParams rpp) {
		// TODO Auto-generated method stub
		return roleMapper.getCount(rpp);
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
	public List<RolePojo> findAllRoles() {
		// TODO Auto-generated method stub
		return roleMapper.findAllRoles();
	}

	@Override
	public int deleteRole(int id) {
		// TODO Auto-generated method stub
		return roleMapper.deleteRole(id);
	}

	//添加菜单
	@Override
	public int addRole(RolePojo rp) {
		// TODO Auto-generated method stub
		return roleMapper.addRole(rp);
	}

	@Override
	public int updateRole(RolePojo rp) {
		// TODO Auto-generated method stub
		return roleMapper.updateRole(rp);
	}

	@Override
	public List<RolePojo> findAllRoles2() {
		// TODO Auto-generated method stub
		return roleMapper.findAllRoles2();
	}

	@Override
	public int updateUserRole(RolePojo rp) {
		// TODO Auto-generated method stub
		return roleMapper.updateUserRole(rp);
	}

	@Override
	public List<RolePojo> findAllRoles3() {
		// TODO Auto-generated method stub
		return roleMapper.findAllRoles3();
	}

}
