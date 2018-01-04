package com.tgb.model;

import java.util.List;

/**
 * 工具类
 * @author administartor
 *
 */
public class Tool {
	private int id;//工具id
	private String tool_name;//工具名字
	List<Material> materialList;//材料类型
	public Tool(int id, String tool_name) {
		super();
		this.id = id;
		this.tool_name = tool_name;
	}
	public Tool() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTool_name() {
		return tool_name;
	}
	public void setTool_name(String tool_name) {
		this.tool_name = tool_name;
	}
	public List<Material> getMaterialList() {
		return materialList;
	}
	public void setMaterialList(List<Material> materialList) {
		this.materialList = materialList;
	}
	
	
}
