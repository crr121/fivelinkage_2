package com.zt.service;

import java.util.List;

import com.zt.dao.AreaDAO;
import com.zt.entity.Area;

public class AreaService {
    private AreaDAO ad = new AreaDAO();

    /**
     * 通用
     * @param areaParame
     * @return
     */
    public List<Area> getAreaInfo(Area areaParame){
        return ad.getAreaInfo(areaParame);
    }


}