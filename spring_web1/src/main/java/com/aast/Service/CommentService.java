package com.aast.Service;

import java.util.List;

import com.aast.Domain.BoardVO;
import com.aast.Domain.CommentVO;

public interface CommentService {
	/*댓글*/
	public int writeComment(CommentVO commentVO);
	public CommentVO viewComment(CommentVO commentVO);
	public void updateComment(CommentVO commentVO);
	public void updateCommentCount(BoardVO boardVO);
	public int deleteComment(CommentVO commentVO);
	public List<CommentVO> selectComment(BoardVO boardVO);
	public int getCommentCount(BoardVO boardVO);

}
