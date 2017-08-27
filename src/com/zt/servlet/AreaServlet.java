package com.zt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.zt.entity.Area;
import com.zt.service.AreaService;

public class AreaServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//设置编码
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		//获取参数传递给service调用DAO
		//这里需要获取两个参数layer 和code
		int layer = Integer.parseInt(req.getParameter("layer")) ;
		String code = req.getParameter("code");
		Area area = new Area(code, null, layer);
		//调用后台方法获取数据
		AreaService as =  new AreaService();
		List<Area> areas = as.getAreaInfo(area);
		
		//返回数据
		//封装为JSON格式
		String areaInfo = new Gson().toJson(areas);
		//设置返回数据的格式
		resp.setContentType("text/json");
		//输出到页面
		PrintWriter out = resp.getWriter();
		out.print(areaInfo);
	}
}
