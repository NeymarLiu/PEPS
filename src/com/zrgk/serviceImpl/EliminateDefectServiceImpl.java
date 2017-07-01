package com.zrgk.serviceImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zrgk.mapper.EliminateDefectMapper;
import com.zrgk.pojo.EdTaskPatrolFlowPojo;
import com.zrgk.pojo.EdTaskPojo;
import com.zrgk.pojo.EliminateDefectPojo;
import com.zrgk.pojo.EliminateDefectUserPojo;
import com.zrgk.pojo.FlawPojo;
import com.zrgk.pojo.MoHuTask;
import com.zrgk.pojo.PatrolQueryPojo;
import com.zrgk.pojo.UserPojo;
import com.zrgk.service.EliminateDefectService;
import com.zrgk.util.DownloadUtils;
import com.zrgk.util.PartPage;
/**bn
 * @author wujin
 *  2016年11月23日20:08:29
 */
@Service
public class EliminateDefectServiceImpl implements EliminateDefectService {
	@Autowired
	private EliminateDefectMapper eliminateDefectMapper;
	public EliminateDefectMapper getEliminateDefectMapper() {
		return eliminateDefectMapper;
	}
	public void setEliminateDefectMapper(EliminateDefectMapper eliminateDefectMapper) {
		this.eliminateDefectMapper = eliminateDefectMapper;
	}
	//所有巡检人物
	@Override
	public List<EliminateDefectPojo> getAllEliminateDefect() {
		// TODO Auto-generated method stub
		return eliminateDefectMapper.getAllEliminateDefect();
	}
	@Override
	public List<EliminateDefectPojo> getSomeEliminateDefect(MoHuTask mht) {
		// TODO Auto-generated method stub
		return eliminateDefectMapper.getSomeEliminateDefect(mht);
	}
	@Override
	public int getAllTaskCount(MoHuTask mht) {
		// TODO Auto-generated method stub
		return eliminateDefectMapper.getAllTaskCount(mht);
	}
	@Override
	public PartPage getPartPage(int count, int page) {
		PartPage p=new PartPage();
		if(count!=0){
		int pages=0;
		if (count%PartPage.pageSize!=0) {
			pages=count/PartPage.pageSize+1;
		}else {
			pages=count/PartPage.pageSize;
		}
		//System.out.println(page);
		if(page<1){
			page=1;
		}else if (page>pages) {
			page=pages;
		}
		//System.out.println(page);
		p.setCount(count);
		p.setNowPage(page);
		p.setTotalPage(pages);
		}else{
			p.setCount(0);
			p.setNowPage(1);
			p.setTotalPage(1);
		}
		return p;
	}
	@Override
	public String getMaxTaskId() {//得到最大id
		return eliminateDefectMapper.getMaxTaskId();
	}
	@Override
	public List<UserPojo> getAllIssued() {
		// TODO Auto-generated method stub
		return eliminateDefectMapper.getAllIssued();
	}
	@Override
	public List<UserPojo> getEliminateDefectPeople() {
		// TODO Auto-generated method stub
		return eliminateDefectMapper.getEliminateDefectPeople();
	}
	@Override
	public List<EdTaskPojo> selectAllFlaw() {
		// TODO Auto-generated method stub
		return eliminateDefectMapper.selectAllFlaw();
	}
	@Override
	public int deleteTask(int e_id) {
		// TODO Auto-generated method stub
		return eliminateDefectMapper.deleteTask(e_id);
	}
	@Override
	public List<EliminateDefectPojo> getAllEliminateDefect2(UserPojo up) {
		// TODO Auto-generated method stub
		return eliminateDefectMapper.getAllEliminateDefect2(up);
	}
	@Override
	public List<EliminateDefectPojo> getSomeEliminateDefectTwo(MoHuTask mht) {
		// TODO Auto-generated method stub
		return eliminateDefectMapper.getSomeEliminateDefectTwo(mht);
	}
	@Override
	public int getAllTaskCount2(MoHuTask mht) {
		// TODO Auto-generated method stub
		return eliminateDefectMapper.getAllTaskCount2(mht);
	}
	@Override
	public List<UserPojo> lookOneTaskUser(int id) {
		// TODO Auto-generated method stub
		return eliminateDefectMapper.lookOneTaskUser(id);
	}
	@Override
	public EliminateDefectPojo getAllValue(int id) {
		// TODO Auto-generated method stub
		return eliminateDefectMapper.getAllValue(id);
	}
	@Override
	public int addEdTask(EliminateDefectPojo edp) {
		// TODO Auto-generated method stub
		return eliminateDefectMapper.addEdTask(edp);
	}
	@Override
	public int getIdByTask(EliminateDefectPojo edp) {
		// TODO Auto-generated method stub
		return eliminateDefectMapper.getIdByTask(edp);
	}
	@Override
	public int addEdUser(EliminateDefectUserPojo edup) {
		// TODO Auto-generated method stub
		return eliminateDefectMapper.addEdUser(edup);
	}
	@Override
	public int addEdTaskPatrol(EdTaskPatrolFlowPojo epfp) {
		// TODO Auto-generated method stub
		return eliminateDefectMapper.addEdTaskPatrol(epfp);
	}
	@Override
	public String getRealnameById(int u_realid) {
		// TODO Auto-generated method stub
		return eliminateDefectMapper.getRealnameById(u_realid);
	}
	@Override
	public int updatePfState(EdTaskPatrolFlowPojo epfp) {
		// TODO Auto-generated method stub
		return eliminateDefectMapper.updatePfState(epfp);
	}
	@Override
	public int updateEdState(int id) {
		// TODO Auto-generated method stub
		return eliminateDefectMapper.updateEdState(id);
	}
	@Override
	public List<EdTaskPojo> selectTaskDetail(int id) {
		// TODO Auto-generated method stub
		return eliminateDefectMapper.selectTaskDetail(id);
	}
	@Override
	public List<UserPojo> getTaskUser(int id) {
		// TODO Auto-generated method stub
		return eliminateDefectMapper.getTaskUser(id);
	}
	@Override
	public int updateEdTask(EliminateDefectPojo edp) {
		// TODO Auto-generated method stub
		return eliminateDefectMapper.updateEdTask(edp);
	}
	@Override
	public int updateEdStateTwo(int id) {
		// TODO Auto-generated method stub
		return eliminateDefectMapper.updateEdStateTwo(id);
	}
	@Override
	public int addUpdateReceipt(EliminateDefectPojo edp) {
		// TODO Auto-generated method stub
		return eliminateDefectMapper.addUpdateReceipt(edp);
	}
	@Override
	public int updateEdStateThree(EliminateDefectPojo edp) {
		// TODO Auto-generated method stub
		return eliminateDefectMapper.updateEdStateThree(edp);
	}
	@Override
	public int getAllTaskCount3(MoHuTask mht) {
		// TODO Auto-generated method stub
		return eliminateDefectMapper.getAllTaskCount3(mht);
	}
	@Override
	public List<FlawPojo> selectAllFlaw2() {
		// TODO Auto-generated method stub
		return eliminateDefectMapper.selectAllFlaw2();
	}
	@Override
	public List<EdTaskPojo> getSomeEliminateDefect3(MoHuTask mht) {
		// TODO Auto-generated method stub
		return eliminateDefectMapper.getSomeEliminateDefect3(mht);
	}
	@Override
	public int freeTask(int e_id) {
		// TODO Auto-generated method stub
		return eliminateDefectMapper.freeTask(e_id);
	}
	@Override
	public void export(HttpServletRequest request,
			HttpServletResponse response,List<EdTaskPojo> list) throws ServletException, IOException {

		//火狐的编码是base64 IE的编码是URL
		String agent = request.getHeader("user-agent");
		System.out.println(agent);
		//
		//导出excel
		if(!list.isEmpty() && list != null){
			String path = request.getServletContext().getRealPath("\\excel");
			//String path = request.getServletContext().getRealPath("\\excel");
			//查询成功
			WritableWorkbook book = Workbook.createWorkbook(new File(path
					+ "/test.xls"));
			// 创建第一页工作簿
			WritableSheet sheet = book.createSheet("第一页", 0);
			// 第一个参数代表列 ，第二个参数代表行
			Label label01 = new Label(0, 0, "任务编号");
			Label label02 = new Label(1, 0, "任务状态");
			Label label03 = new Label(2, 0, "工作单据");
			Label label04 = new Label(3, 0, "线路编号");
			Label label05 = new Label(4, 0, "杆塔编号");
			Label label06 = new Label(5, 0, "缺陷级别");
			Label label07 = new Label(6, 0, "缺陷类型");
			Label label08 = new Label(7, 0, "发现人");
			Label label09 = new Label(8, 0, "发现时间");
			Label label010 = new Label(9, 0, "下发人");
			Label label011 = new Label(10, 0, "下发时间");
			Label label012 = new Label(11, 0, "完好率");
			Label label013 = new Label(12, 0, "缺陷描述");
			// 第3行第2列
			try {
			for (int i = 0; i < list.size(); i++) {
				EdTaskPojo ep = (EdTaskPojo)list.get(i);
				Label label11 = new Label(0, i + 1, ep.getE_task_id());
				Label label12 = new Label(1, i + 1, ep.getE_task_state()==2?"已分配":ep.getE_task_state()==3?"执行中":ep.getE_task_state()==4?"已完成":"无");
				Label label13 = new Label(2, i + 1, ep.getE_security_id()==1?"第一张种单据":ep.getE_security_id()==2?"第二种单据":"无");
				Label label14 = new Label(3, i + 1, ep.getLi_code());
				Label label15 = new Label(4, i + 1,ep.getPole_code());
				Label label16 = new Label(5, i + 1,ep.getPf_sure_grade()==1?"一般":ep.getPf_sure_grade()==2?"严重":ep.getPf_sure_grade()==3?"紧急":"无");
				Label label17 = new Label(6, i + 1,ep.getF_name());
				Label label18 = new Label(7, i + 1,ep.getPf_find_people());
				Label label19 = new Label(8, i + 1,ep.getFind_time());
				Label label110 = new Label(9, i + 1,ep.getE_issued_name());
				Label label111 = new Label(10, i + 1,ep.getIssued_time());
				Label label112 = new Label(11, i + 1,ep.getPf_flaw_rate()+"%");
				Label label113 = new Label(12, i + 1,ep.getPf_remark());
				
	
				
				
				
				
				sheet.addCell(label11);
				sheet.addCell(label12);
				sheet.addCell(label13);
				sheet.addCell(label14);
				sheet.addCell(label15);
				sheet.addCell(label16);
				sheet.addCell(label17);
				sheet.addCell(label18);
				sheet.addCell(label19);
				sheet.addCell(label110);
				sheet.addCell(label111);
				sheet.addCell(label112);
				sheet.addCell(label113);
			}

		
				// 将格子放入工作簿中
			sheet.addCell(label01);
			sheet.addCell(label02);
			sheet.addCell(label03);
			sheet.addCell(label04);
			sheet.addCell(label05);
			sheet.addCell(label06);
			sheet.addCell(label07);
			sheet.addCell(label08);
			sheet.addCell(label09);
			sheet.addCell(label010);
			sheet.addCell(label011);
			sheet.addCell(label012);
			sheet.addCell(label013);
				book.write();
				book.close();
				System.out.println("成功");
			} catch (RowsExceededException e) {
				e.printStackTrace();
			} catch (WriteException e) {
				e.printStackTrace();
			}
			// -------------------
			String fileName2= null;
			if(agent.contains("Firefox")){
				//火狐浏览器  base64的编码处理
				fileName2 = DownloadUtils.base64EncodeFileName("导出信息");
			}else{
				//ie 或者谷歌浏览器URL编码处理
				fileName2=URLEncoder.encode("消缺任务","utf-8");
			}
			FileInputStream input = new FileInputStream(new File(path
					+ "/test.xls"));
			OutputStream out = response.getOutputStream();
			response.setHeader(
					"Content-Disposition",
					"attachment; filename="+fileName2+".xls"
									);
			response.setContentType("application/vnd.ms-excel");
			int flag = 0;
			while ((flag = input.read()) != -1) {
				out.write(flag);
			}
			out.flush();
			out.close();
			input.close();
		}
	}
	
	
	@Override
	public void exportT(HttpServletRequest request,
			HttpServletResponse response,List<EdTaskPojo> list) throws ServletException, IOException {
		

		//火狐的编码是base64 IE的编码是URL
		String agent = request.getHeader("user-agent");
		System.out.println(agent);
		
		//导出excel
		if(!list.isEmpty() && list != null){
			String path = request.getServletContext().getRealPath("\\excel");
			//String path = request.getServletContext().getRealPath("\\excel");
			//查询成功
			WritableWorkbook book = Workbook.createWorkbook(new File(path
					+ "/test.xls"));
			// 创建第一页工作簿
			WritableSheet sheet = book.createSheet("第一页", 0);
			// 第一个参数代表列 ，第二个参数代表行
			Label label01 = new Label(0, 0, "任务编号");
			Label label02 = new Label(1, 0, "任务名称");
			Label label03 = new Label(2, 0, "线路编号");
			Label label04 = new Label(3, 0, "杆塔编号");
			Label label05 = new Label(4, 0, "缺陷级别");
			Label label06 = new Label(5, 0, "缺陷类型");
			Label label07 = new Label(6, 0, "消缺时间");
			Label label08 = new Label(7, 0, "发现时间");
			Label label09 = new Label(8, 0, "缺陷描述");
			// 第3行第2列
			try {
			for (int i = 0; i < list.size(); i++) {
				EdTaskPojo ep = (EdTaskPojo)list.get(i);
				Label label11 = new Label(0, i + 1, ep.getE_task_id());
				Label label12 = new Label(1, i + 1, ep.getE_name());
				Label label13 = new Label(2, i + 1, ep.getLi_code());
				Label label14 = new Label(3, i + 1,ep.getPole_code());
				Label label15 = new Label(4, i + 1,ep.getPf_sure_grade()==1?"一般":ep.getPf_sure_grade()==2?"严重":ep.getPf_sure_grade()==3?"紧急":"无");
				Label label16 = new Label(5, i + 1,ep.getF_name());
				Label label17 = new Label(6, i + 1,ep.getTask_finish_time());
				Label label18 = new Label(7, i + 1,ep.getFind_time());
				Label label19 = new Label(8, i + 1,ep.getPf_remark());
				
	
				
				
				
				
				sheet.addCell(label11);
				sheet.addCell(label12);
				sheet.addCell(label13);
				sheet.addCell(label14);
				sheet.addCell(label15);
				sheet.addCell(label16);
				sheet.addCell(label17);
				sheet.addCell(label18);
				sheet.addCell(label19);
			}

		
				// 将格子放入工作簿中
			sheet.addCell(label01);
			sheet.addCell(label02);
			sheet.addCell(label03);
			sheet.addCell(label04);
			sheet.addCell(label05);
			sheet.addCell(label06);
			sheet.addCell(label07);
			sheet.addCell(label08);
			sheet.addCell(label09);
				book.write();
				book.close();
				System.out.println("成功");
			} catch (RowsExceededException e) {
				e.printStackTrace();
			} catch (WriteException e) {
				e.printStackTrace();
			}
			// -------------------
			String fileName2= null;
			if(agent.contains("Firefox")){
				//火狐浏览器  base64的编码处理
				fileName2 = DownloadUtils.base64EncodeFileName("导出信息");
			}else{
				//ie 或者谷歌浏览器URL编码处理
				fileName2=URLEncoder.encode("消缺任务","utf-8");
			}
			FileInputStream input = new FileInputStream(new File(path
					+ "/test.xls"));
			OutputStream out = response.getOutputStream();
			response.setHeader(
					"Content-Disposition",
					"attachment; filename="+fileName2+".xls"
									);
			response.setContentType("application/vnd.ms-excel");
			int flag = 0;
			while ((flag = input.read()) != -1) {
				out.write(flag);
			}
			out.flush();
			out.close();
			input.close();
		}
	}
}
	


