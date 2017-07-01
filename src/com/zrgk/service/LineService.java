package com.zrgk.service;

import java.util.List;

 









import com.zrgk.pojo.FuzzyPartPTaskParams;
import com.zrgk.pojo.LinePojo;
import com.zrgk.pojo.Linecanshu;
import com.zrgk.pojo.MenuPojo;
import com.zrgk.pojo.PatrolTaskPojo;
import com.zrgk.pojo.PolePojo;
import com.zrgk.util.PartPage;
 


public interface LineService {
	//得到所有线路
	public List<LinePojo> getAllLine (Linecanshu lc) ;
	//得到所有线路记录数
	public int getAlllineCount(Linecanshu lc);
	//得到所有的线路信息
    public List<LinePojo> findAllLine();
	//通过id 得到线路的信息
    public LinePojo getLineById(int id);
	//根据线路名称查询线路详情
	public List<LinePojo> getLIByname(String liname);
	//分页
    public PartPage getPartPage(int count,int page);
  //得到所有的父级线路
  	public List<LinePojo> findAllFatherLine();
    //添加线路
    public int addLine(LinePojo li);
    //根据id删除线路信息
    public int deleteLine(int id);
    //在数据库中查询最大的liid
    public int  getmaxLi_id();
    //更具id修改线路
	public int updateLine(LinePojo lp);
	 //根据id修改线路状态值
	public int lineState(LinePojo lp);
	//在数据库中查询线路编号
	public int  selectlicode(LinePojo lp);
	public int selectlicode2(LinePojo lp);

 
	
}
