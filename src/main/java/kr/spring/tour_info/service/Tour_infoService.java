package kr.spring.tour_info.service;

import java.util.List;
import java.util.Map;

import kr.spring.board.domain.BoardReplyCommand;
import kr.spring.tour_info.domain.Tour_infoCommand;
import kr.spring.tour_info.domain.Tour_infoReplyCommand;

public interface Tour_infoService {
	//부모 글
	public List<Tour_infoCommand> selectList(Map<String,Object> map);
	public int selectRowCount(Map<String,Object> map);
	public void insert(Tour_infoCommand tour_info);
	public Tour_infoCommand selectTour_info(Integer ti_id);
	public void update(Tour_infoCommand tour_info);
	public void delete(Integer ti_id);
    
	//댓글
	public List<Tour_infoReplyCommand> selectListReply(Map<String,Object> map);
    public int selectRowCountReply(Map<String, Object> map);
    public void insertReply(Tour_infoReplyCommand tour_infoReply);
    public void updateReply(Tour_infoReplyCommand tour_infoReply);
	public void deleteReply(Integer tr_idx);
	// 부모글 삭제시 댓글이 존재하면 부모글 삭제전 댓글 삭제
	public void deleteReplyByNum(Integer ti_id);




}
