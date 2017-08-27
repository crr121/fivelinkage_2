package com.zt.test;

import java.util.List;

import org.junit.Test;

import com.zt.dao.AreaDAO;
import com.zt.entity.Area;

public class AreaTest {

	@Test
	public void areaTest(){
		AreaDAO ad = new AreaDAO();
		Area area = new Area("50", null, 3);
		List<Area> areas = ad.getAreaInfo(area);
		for (Area area2 : areas) {
			System.out.println(area2);
		}
	}
}
