package kr.spring.category.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import kr.spring.category.domain.ItemCategoryCommand;
import kr.spring.member.domain.MemberCommand;


public interface ItemCategoryMapper {
	@Select("SELECT ict_num,ict_nm,ict_state FROM item_category ORDER BY ict_num")
	public List<ItemCategoryCommand> selectList();
	@Select("SELECT COUNT(*) FROM item_category")
	public int getCategoryCount();
	@Insert("INSERT INTO item_category (ict_num,ict_nm,ict_state) VALUES (item_category_seq.nextval, #{ict_nm}, #{ict_state})")
	public void insert(ItemCategoryCommand ItemCategory);
	public void update(ItemCategoryCommand ItemCategory);
	public void delete(Integer num);
}
