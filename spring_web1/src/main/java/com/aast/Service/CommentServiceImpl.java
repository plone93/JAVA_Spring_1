package com.aast.Service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.aast.Domain.BoardVO;
import com.aast.Domain.CommentVO;
import com.aast.Mapper.CommentMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService{
	
	CommentMapper comment;
	
	@Override
	public int writeComment(CommentVO commentVO) {
		return comment.insertComment(commentVO);
	}

	@Override
	public CommentVO viewComment(CommentVO commentVO) {
		return comment.viewComment(commentVO);
	}

	@Override
	public void updateComment(CommentVO commentVO) {
		comment.updateComment(commentVO);
	}

	@Override
	public void updateCommentCount(BoardVO boardVO) {
		comment.updateCommentCount(boardVO);
	}

	@Override
	public int deleteComment(CommentVO commentVO) {
		return comment.deleteComment(commentVO);
	}

	@Override
	public List<CommentVO> selectComment(BoardVO boardVO) {
		return comment.selectComment(boardVO);
	}

	@Override
	public int getCommentCount(BoardVO boardVO) {
		return comment.getCommentCount(boardVO);
	}

}
