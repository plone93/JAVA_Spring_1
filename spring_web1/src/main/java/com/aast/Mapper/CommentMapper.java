package com.aast.Mapper;

import java.util.HashMap;
import java.util.List;

import com.aast.Domain.CommentVO;

public interface CommentMapper {
	/*댓글*/
	public int insertComment(HashMap<String, Object> map);
	public CommentVO viewComment(int commentNumber);
	public void updateComment(HashMap<String, Object> map);
	public int deleteComment(int commentNumber);
	public void updateCommentCount(HashMap<String, Object> map);
	public List<CommentVO> selectComment(int boardNumber);
	public int getCommentCount(int boardNumber);
}
