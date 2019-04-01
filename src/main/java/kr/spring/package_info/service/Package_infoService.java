package kr.spring.package_info.service;

import java.util.Map;

public interface Package_infoService {
	public List<Package_infoCommand> selectList(Map<String,Object>);
	public int selectRowCount(Map<String,Object> map);
	public void insert(Package_infoCommand package_info);
	public Package_infoCommand selectPackage_info(Integer num);
	public void update(Package_infoCommand package_info);
	public void delete(Integer num);

}
