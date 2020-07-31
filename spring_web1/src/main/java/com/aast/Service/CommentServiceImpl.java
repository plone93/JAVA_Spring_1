package com.aast.Service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.aast.Domain.CommentVO;
import com.aast.Mapper.CommentMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService{
	
	CommentMapper comment;
	HashMap<String, Object> map;
	
	@Override
	public int writeComment(CommentVO commentVO) {
		map = new HashMap<String, Object>();
		map.put("commentVO", commentVO);
		
		return comment.insertComment(map);
	}

	@Override
	public CommentVO viewComment(int commentNumber) {
		return comment.viewComment(commentNumber);
	}

	@Override
	public void updateComment(CommentVO commentVO, int commentNumber) {
		map = new HashMap<String, Object>();
		map.put("commentVO", commentVO);
		map.put("commentNumber", commentNumber);
		
		comment.updateComment(map);
	}

	@Override
	public void updateCommentCount(int commentCount, int boardNumber) {
		map = new HashMap<String, Object>();
		map.put("commentCount", commentCount);
		map.put("boardNumber", boardNumber);
		
		comment.updateCommentCount(map);
	}

	@Override
	public int deleteComment(int commentNumber) {
		return comment.deleteComment(commentNumber);
	}

	@Override
	public List<CommentVO> selectComment(int boardNumber) {
		return comment.selectComment(boardNumber);
	}

	@Override
	public int getCommentCount(int boardNumber) {
		return comment.getCommentCount(boardNumber);
	}

}
