package kr.spring.package_info.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.package_info.dao.Package_infoMapper;

@Service("package_infoService")
public class Package_infoServiceImpl implements Package_infoService{

	@Resource
	private Package_infoMapper package_infoMapper;
	
}
