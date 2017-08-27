package com.zt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zt.entity.Area;
import com.zt.util.DBUtil;

public class AreaDAO {
    private ResultSet rs = null;
    private PreparedStatement ps = null;
    private Connection con = null;


    /**
     * 5级联动地址通用方法
     * @param area layer等级 code代码
     * @return 返回对应的数据
     */
    public List<Area> getAreaInfo(Area areaParame){
        List<Area> areas = new ArrayList<Area>();
        Area area = null;
        con = DBUtil.getConnection();
        String sql = "select code,name,layer from area where layer=? and code like ?||'%' ";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, areaParame.getLayer());
            ps.setString(2, areaParame.getCode());
            rs = ps.executeQuery();
            while(rs.next()){
                area = new Area(rs.getString("code"), rs.getString("name"), rs.getInt("layer"));
                areas.add(area);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DBUtil.closeAll(rs, ps, con);
        }
        return areas;
    }

}