package com.aast.Service;

import java.util.List;

import www.aast.Domain.CommentVO;

public interface CommentService {
	/*댓글*/
	public int writeComment(CommentVO commentVO);
	public CommentVO viewComment(String commentNumber);
	public void updateComment(CommentVO commentVO, String commentNumber);
	public void updateCommentCount(int commentCount, String boardNumber);
	public int deleteComment(String commentNumber);
	public List<CommentVO> selectComment(String boardNumber);
	public int getCommentCount(String boardNumber);

}
