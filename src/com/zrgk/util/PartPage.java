package com.zrgk.util;

import java.io.IOException;
import java.text.MessageFormat;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

public class PartPage extends TagSupport {

	private int nowPage = 1;
	public static int pageSize =3;
	private int count = 0;
	private int totalPage = 0;

	private String url;// 访问路径

	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 当遇到 某一个 标签开始的时候
	 */
	public int doStartTag() throws JspException {
		// 超链接 模板<span class='current'>{2}</span>
		String link = "<a href=''{0}&nowPage={1}''>{2}</a>";
		//String link2="<a href=''{0}?page={1}''><span class='current'>{2}</span></a>";
		if (nowPage <= 1) {
			nowPage = 1;
		}
		if (nowPage >= totalPage) {
			nowPage = totalPage;
		}
		// 拼写超链接
		String first ="首页";
		if (nowPage > 1) {
		     first = MessageFormat.format(link, url, "1", "首页");
		}
		String up = "上一页";
		if (nowPage > 1) {
			up = MessageFormat.format(link, url, (nowPage - 1) + "", "上一页");
		}
		String next = "下一页";
		if (nowPage < totalPage) {
			next = MessageFormat.format(link, url, (nowPage + 1) + "", "下一页");
		}
		String last="尾页";
		if(nowPage != totalPage){
		last = MessageFormat.format(link, url, totalPage + "", "尾页");
		}
		String inpt="跳到:<input type='text' class='scinput5' id='goPage'>页";
		String btn="&nbsp;&nbsp;<input type='button' id='sure' class='scbtn5' value='确定'/>&nbsp;&nbsp;&nbsp;&nbsp;";
		String inpt2="<script type='text/javascript'>$(document).ready(function(e) {"
					+ "$('#sure').click(function(){"
					+"var regex=/[0-9]+$/;"
					+"var page=$('#goPage').val();"
					+" if(!regex.test(page)){"
					+ "	alert('提示:请填写正确的页数!');"
					+ "$('#goPage').val('');"
					+ "}else{"
					+"window.location.href=$('#purl').val()+'&nowPage='+page;"	
					+"}"	 
					+"});});</script>";
		// 拼写超链接
		String str = null;
		str = "共 {0}条记录&nbsp; 当前:{1}页 &nbsp;&nbsp;{2} {3} {4} {5} {6} {7} {8}";
		str = MessageFormat.format(str,count+"",nowPage + "/" + totalPage + "",
				first, up, next, last,inpt,btn,inpt2);
		// 把生成好的 超链接 输出到页面上
		PageContext pc = this.pageContext;
		JspWriter out = pc.getOut();
		try {
			out.println(str);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return this.EVAL_PAGE;
	}

}
