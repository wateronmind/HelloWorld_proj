package kr.spring.common.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.spring.common.domain.NationCityCommand;
import kr.spring.common.service.CommonService;

@Controller
public class CommonAjaxController {
 
	private Logger log = Logger.getLogger(this.getClass());

	@Resource
	private CommonService commonService;

	@RequestMapping("/common/ncList.do")
	@ResponseBody
	public Map<String, Object> ncList() {

		if(log.isDebugEnabled()) log.debug("<<nc list>>");
		
		List<NationCityCommand> ncList = commonService.selectNCList();
		Map<String, Object> mapJson = new HashMap<String, Object>();

		mapJson.put("ncList", ncList);

		return mapJson;
	}
}
