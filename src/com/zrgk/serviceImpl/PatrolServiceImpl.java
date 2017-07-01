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

import com.zrgk.mapper.PatrolMapper;
import com.zrgk.pojo.FlawPojo;
import com.zrgk.pojo.FuzzyPartPTaskParams;
import com.zrgk.pojo.InformationStatisticsParams;
import com.zrgk.pojo.LinePojo;
import com.zrgk.pojo.PatrolFlawPojo;
import com.zrgk.pojo.PatrolQueryPojo;
import com.zrgk.pojo.PatrolTaskPojo;
import com.zrgk.pojo.PatrolUserPojo;
import com.zrgk.pojo.PolePojo;
import com.zrgk.pojo.UserPojo;
import com.zrgk.service.PatrolService;
import com.zrgk.util.DownloadUtils;
import com.zrgk.util.PartPage;
/**
 * @author liucan
 * @version 2016年11月23日15:30:23
 * */
@Service
public class PatrolServiceImpl implements PatrolService{
	@Autowired
	private PatrolMapper patrolMapper;
	public void setPatrolMapper(PatrolMapper patrolMapper) {
		this.patrolMapper = patrolMapper;
	}
	public PatrolMapper getPatrolMapper() {
		return patrolMapper;
	}
	
	//根据id查询巡检业务详情
	@Override
	public PatrolTaskPojo getOnePatrolTask(int pid) {
		return patrolMapper.getOnePatrolTask(pid);
	}
	@Override
	public List<UserPojo> getPatrolPeople() {
		return patrolMapper.getPatrolPeople();
	}
	@Override
	public List<LinePojo> getAllLine() {
		return patrolMapper.getAllLine();
	}
	@Override
	public List<PolePojo> getPojoByLine(int lid) {
		// TODO Auto-generated method stub
		return patrolMapper.getPojoByLine(lid);
	}
	@Override
	public String getMaxTaskID() {
		// TODO Auto-generated method stub
		return patrolMapper.getMaxTaskID();
	}
	@Override
	public int addPatrolTask(PatrolTaskPojo ptp) {
		// TODO Auto-generated method stub
		return patrolMapper.addPatrolTask(ptp);
	}
	@Override
	public int getPidByPcode(String p_num) {
		// TODO Auto-generated method stub
		return patrolMapper.getPidByPcode(p_num);
	}
	@Override
	public int addTaskUser(PatrolUserPojo pup) {
		// TODO Auto-generated method stub
		return patrolMapper.addTaskUser(pup);
	}
	@Override
	public int addTaskPole(PatrolFlawPojo pfp) {
		// TODO Auto-generated method stub
		return patrolMapper.addTaskPole(pfp);
	}
	@Override
	public List<PolePojo> getTaskPole(PatrolTaskPojo ptp) {
		// TODO Auto-generated method stub
		return patrolMapper.getTaskPole(ptp);
	}
	@Override
	public int cancleTask(int p_id) {
		// TODO Auto-generated method stub
		return patrolMapper.cancleTask(p_id);
	}
	@Override
	public List<PatrolTaskPojo> getAllPatrolTask(FuzzyPartPTaskParams fptp) {
		// TODO Auto-generated method stub
		return patrolMapper.getAllPatrolTask(fptp);
	}
	@Override
	public int getAllPatrolTaskCount(FuzzyPartPTaskParams fptp) {
		// TODO Auto-generated method stub
		return patrolMapper.getAllPatrolTaskCount(fptp);
	}
	@Override
	public PartPage getPartPage(int count, int page) {
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
	public List<PatrolTaskPojo> getAllPTask(FuzzyPartPTaskParams fptp) {
		// TODO Auto-generated method stub
		return patrolMapper.getAllPTask(fptp);
	}
	@Override
	public int getAllPTaskCount(FuzzyPartPTaskParams fptp) {
		// TODO Auto-generated method stub
		return patrolMapper.getAllPTaskCount(fptp);
	}
	@Override
	public int deletePTaskUser(int p_id) {
		// TODO Auto-generated method stub
		return patrolMapper.deletePTaskUser(p_id);
	}
	@Override
	public List<PatrolUserPojo> getPtaskUser(int p_id) {
		// TODO Auto-generated method stub
		return patrolMapper.getPtaskUser(p_id);
	}
	@Override
	public int updatePaskState(PatrolTaskPojo ptp) {
		// TODO Auto-generated method stub
		return patrolMapper.updatePaskState(ptp);
	}
	@Override
	public int deletePTaskFlaw(int p_id) {
		// TODO Auto-generated method stub
		return patrolMapper.deletePTaskFlaw(p_id);
	}
	@Override
	public int updatePTask(PatrolTaskPojo ptp) {
		// TODO Auto-generated method stub
		return patrolMapper.updatePTask(ptp);
	}
	@Override
	public int updatePStartTime(PatrolTaskPojo ptp) {
		// TODO Auto-generated method stub
		return patrolMapper.updatePStartTime(ptp);
	}
	@Override
	public List<FlawPojo> getPFlaw() {
		// TODO Auto-generated method stub
		return patrolMapper.getPFlaw();
	}
	@Override
	public int updatePoleFlaw(PatrolFlawPojo pfp) {
		// TODO Auto-generated method stub
		return patrolMapper.updatePoleFlaw(pfp);
	}
	@Override
	public PatrolFlawPojo getOnePFP(int pf_id) {
		// TODO Auto-generated method stub
		return patrolMapper.getOnePFP(pf_id);
	}
	@Override
	public int uploadPTask(int p_id) {
		// TODO Auto-generated method stub
		return patrolMapper.uploadPTask(p_id);
	}
	@Override
	public List<PatrolQueryPojo> getAllCompletePatrol(FuzzyPartPTaskParams fptp) {
		// TODO Auto-generated method stub
		return patrolMapper.getAllCompletePatrol(fptp);
	}
	@Override
	public int getCompletePatrolCount(FuzzyPartPTaskParams fptp) {
		// TODO Auto-generated method stub
		return patrolMapper.getCompletePatrolCount(fptp);
	}
	@Override
	public int updatePFinishTime(PatrolTaskPojo ptp) {
		// TODO Auto-generated method stub
		return patrolMapper.updatePFinishTime(ptp);
	}
	@Override
	public PatrolFlawPojo getOnePFP2(int pf_id) {
		// TODO Auto-generated method stub
		return patrolMapper.getOnePFP2(pf_id);
	}
	@Override
	public List<PatrolQueryPojo> exportPatrolExcel() {
		// TODO Auto-generated method stub
		return patrolMapper.exportPatrolExcel();
	}
	public void export(HttpServletRequest request, HttpServletResponse response,List<PatrolQueryPojo>list,List<FlawPojo>fList)
			throws ServletException, IOException {

			//火狐的编码是base64 IE的编码是URL
			String agent = request.getHeader("user-agent");
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
				Label label02 = new Label(1, 0, "线路编号");
				Label label03 = new Label(2, 0, "塔杆编号");
				Label label04 = new Label(3, 0, "缺陷等级");
				Label label05 = new Label(4, 0, "缺陷类型");
				Label label06 = new Label(5, 0, "发现人");
				Label label07 = new Label(6, 0, "发现时间");
				Label label08 = new Label(7, 0, "下发人");
				Label label09 = new Label(8, 0, "下发时间");
				Label label010 = new Label(9, 0, "完好率");
				Label label011 = new Label(10, 0, "缺陷描述");
				// 第3行第2列
				try {
				for (int i = 0; i < list.size(); i++) {
					PatrolQueryPojo p = (PatrolQueryPojo)list.get(i);
					Label label11 = new Label(0, i + 1, p.getP_num());
					Label label12 = new Label(1, i + 1, p.getLi_code());
					Label label13 = new Label(2, i + 1, p.getPole_code());
					Label label14 = new Label(3, i + 1, p.getPf_flaw_grade()==1?"一般":p.getPf_flaw_grade()==2?"严重":"紧急");
					String str="";
					//得到缺陷名字
					for (int j = 0; j < fList.size(); j++) {
						if(fList.get(j).getF_id()==p.getPf_flaw()){
							str=fList.get(j).getF_name();
							break;
						}
					}
					Label label15 = new Label(4,i+1,str);
					Label label16 = new Label(5,i+1,p.getPf_find_people());
					Label label17 = new Label(6,i+1,p.getFind_time());
					Label label18 = new Label(7,i+1,p.getP_issued_name());
					Label label19 = new Label(8,i+1,p.getIssued_time());
					Label label110 = new Label(9,i+1,p.getPf_flaw_rate()+"%");
					Label label111 = new Label(10,i+1,p.getPf_remark());
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
					book.write();
					book.close();
					System.out.println("导出成功");
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
					fileName2=URLEncoder.encode("巡检任务","utf-8");
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
	public int getPatrolInformationCount(InformationStatisticsParams isp) {
		// TODO Auto-generated method stub
		return patrolMapper.getPatrolInformationCount(isp);
	}
	@Override
	public List<PatrolQueryPojo> getPatrolInformation(
			InformationStatisticsParams isp) {
		// TODO Auto-generated method stub
		return patrolMapper.getPatrolInformation(isp);
	}
	public void exportISPExcel(HttpServletRequest request, HttpServletResponse response,List<PatrolQueryPojo>list,List<FlawPojo>fList)
			throws ServletException, IOException {

			//火狐的编码是base64 IE的编码是URL
			String agent = request.getHeader("user-agent");
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
				Label label03 = new Label(2, 0, "线路编号(起始杆号-终止杆号)");
				Label label04 = new Label(3, 0, "塔杆编号");
				Label label05 = new Label(4, 0, "缺陷级别");
				Label label06 = new Label(5, 0, "缺陷类型");
				Label label07 = new Label(6, 0, "发现时间");
				Label label08 = new Label(7, 0, "缺陷描述");
				// 第3行第2列
				try {
				for (int i = 0; i < list.size(); i++) {
					PatrolQueryPojo p = (PatrolQueryPojo)list.get(i);
					Label label11 = new Label(0, i + 1, p.getP_num());
					Label label12 = new Label(1, i + 1, p.getP_name());
					Label label13 = new Label(2, i + 1, p.getLi_code()+"("+p.getP_strcode()+"-"+p.getP_endcode()+")");
					Label label14 = new Label(3, i + 1, p.getPole_code());
					Label label15 = new Label(4, i + 1, p.getPf_sure_grade()==1?"一般":p.getPf_sure_grade()==2?"严重":"紧急");
					String str="";
					//得到缺陷名字
					for (int j = 0; j < fList.size(); j++) {
						if(fList.get(j).getF_id()==p.getPf_flaw()){
							str=fList.get(j).getF_name();
							break;
						}
					}
					Label label16 = new Label(5,i+1,str);
					Label label17 = new Label(6,i+1,p.getFind_time());
					Label label18 = new Label(7,i+1,p.getPf_remark());
					sheet.addCell(label11);
					sheet.addCell(label12);
					sheet.addCell(label13);
					sheet.addCell(label14);
					sheet.addCell(label15);
					sheet.addCell(label16);
					sheet.addCell(label17);
					sheet.addCell(label18);
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
					book.write();
					book.close();
					System.out.println("导出成功");
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
					fileName2=URLEncoder.encode("巡检信息统计","utf-8");
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
