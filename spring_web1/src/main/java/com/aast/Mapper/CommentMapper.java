package com.aast.Mapper;

import java.util.List;

import com.aast.Domain.BoardVO;
import com.aast.Domain.CommentVO;

public interface CommentMapper {
	/*댓글*/
	public int insertComment(CommentVO commentVO);
	public CommentVO viewComment(CommentVO commentVO);
	public void updateComment(CommentVO commentVO);
	public int deleteComment(CommentVO commentVO);
	public void updateCommentCount(BoardVO boardVO);
	public List<CommentVO> selectComment(BoardVO boardVO);
	public int getCommentCount(BoardVO boardVO);
}
