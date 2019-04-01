package kr.spring.tour_info.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;

import kr.spring.tour_info.domain.Tour_infoCommand;

public interface Tour_infoMapper {
     public List<Tour_infoCommand> selectList(Map<String,Object> map);
     public int selectRowCount(Map<String,Object> map);
     @Insert("INSERT INTO tour_info (num,ti_nm,ti_img,nc_cd,ti_start_day,ti_end_day,ti_min_pp,ti_max_pp,ti_pickup_place,ti_pickup_time,ti_content,ti_pc) "
     		+ "VALUES (tour_info_seq.nextval,#{ti_nm},#{ti_img},#{nc_cd},#{ti_start_day},#{ti_end_day},#{ti_min_pp},#{ti_max_pp},#{ti_pickup_place},#{ti_pickup_time},#{ti_content},#{ti_pc}")
     public void insert(Tour_infoCommand tour_info);
}
