package com.aast.Mapper;

import java.util.HashMap;
import java.util.List;

import www.aast.Domain.CommentVO;

public interface CommentMapper {
	/*댓글*/
	public int insertComment(HashMap<String, Object> map);
	public CommentVO viewComment(String commentNumber);
	public void updateComment(HashMap<String, Object> map);
	public int deleteComment(String commentNumber);
	public void updateCommentCount(HashMap<String, Object> map);
	public List<CommentVO> selectComment(String boardNumber);
	public int getCommentCount(String boardNumber);
}
