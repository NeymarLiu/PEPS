package com.zrgk.pojo;

/**
 * 
 * @author wangmingyong
 *@version 2016年11月23日18:24:04
 **/
public class FlawPojo {

		private int f_id;//缺陷ID
		private String f_name;//缺陷名字
		private int f_state;//缺陷状态
		private String f_described;//缺陷描述
		public int getF_id() {
			return f_id;
		}
		public void setF_id(int f_id) {
			this.f_id = f_id;
		}
		public String getF_name() {
			return f_name;
		}
		public void setF_name(String f_name) {
			this.f_name = f_name;
		}
		public int getF_state() {
			return f_state;
		}
		public void setF_state(int f_state) {
			this.f_state = f_state;
		}
		public String getF_described() {
			return f_described;
		}
		public void setF_described(String f_described) {
			this.f_described = f_described;
		}
}
