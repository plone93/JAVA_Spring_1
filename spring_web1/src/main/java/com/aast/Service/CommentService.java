package com.aast.Service;

import java.util.List;

import com.aast.Domain.CommentVO;

public interface CommentService {
	/*댓글*/
	public int writeComment(CommentVO commentVO);
	public CommentVO viewComment(int commentNumber);
	public void updateComment(CommentVO commentVO, int commentNumber);
	public void updateCommentCount(int commentCount, int boardNumber);
	public int deleteComment(int commentNumber);
	public List<CommentVO> selectComment(int boardNumber);
	public int getCommentCount(int boardNumber);

}
