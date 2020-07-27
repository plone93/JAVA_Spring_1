package com.aast.Service;

import java.util.HashMap;
import java.util.List;

import com.aast.Mapper.CommentMapper;

import www.aast.Domain.CommentVO;

public class CommentServiceImpl implements CommentService{
	
	CommentMapper comment;
	HashMap<String, Object> map;
	
	@Override
	public int insertComment(CommentVO commentVO) {
		map = new HashMap<String, Object>();
		map.put("commentVO", commentVO);
		
		return comment.insertComment(map);
	}

	@Override
	public CommentVO viewComment(String commentNumber) {
		return comment.viewComment(commentNumber);
	}

	@Override
	public void updateComment(CommentVO commentVO, String commentNumber) {
		map = new HashMap<String, Object>();
		map.put("commentVO", commentVO);
		map.put("commentNumber", commentNumber);
		
		comment.updateComment(map);
	}

	@Override
	public void updateCommentCount(int commentCount, String boardNumber) {
		map = new HashMap<String, Object>();
		map.put("commentCount", commentCount);
		map.put("boardNumber", boardNumber);
		
		comment.updateCommentCount(map);
	}

	@Override
	public int deleteComment(String commentNumber) {
		return comment.deleteComment(commentNumber);
	}

	@Override
	public List<CommentVO> selectComment(String boardNumber) {
		return comment.selectComment(boardNumber);
	}

	@Override
	public int getCommentCount(String boardNumber) {
		return comment.getCommentCount(boardNumber);
	}

}
