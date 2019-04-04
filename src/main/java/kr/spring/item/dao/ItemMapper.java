package kr.spring.item.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.spring.board.domain.BoardCommand;
import kr.spring.item.domain.ItemCommand;

public interface ItemMapper {
	public List<ItemCommand> selectList(Map<String,Object> map);
	@Select("SELECT * FROM item_info WHERE i_num=#{i_num}")
	public ItemCommand selectItem(Integer i_num);
	public int selectRowCount(Map<String,Object> map);
	@Insert("INSERT INTO item_info (i_num,i_nm,i_pc,i_dispc,i_quan,i_img,i_content,i_rent_day,i_return_day,i_state,ict_num) VALUES (item_info_seq.nextval, #{i_nm}, #{i_pc}, #{i_dispc}, #{i_quan}, #{i_img}, #{i_content}, #{i_rent_day}, #{i_return_day}, #{i_state}, #{ict_num})")
	public void insert(ItemCommand Item);
	@Update("UPDATE item_info SET i_nm=#{i_nm},i_pc=#{i_pc},i_dispc=#{i_dispc},i_quan=#{i_quan},i_img=#{i_img},i_content=#{i_content},i_rent_day=#{i_rent_day},i_return_day=#{i_return_day},i_state=#{i_state},ict_num=#{ict_num}")
	public void update(ItemCommand Item);
	public void delete(Integer i_num);
}
