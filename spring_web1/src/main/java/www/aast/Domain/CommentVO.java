package www.aast.Domain;

import java.sql.Timestamp;

import lombok.Data;

@Data	
public class CommentVO {
	private int commentNumber;
	private String boardNumber;
	private String boardId;
	private String memberId;
	private String memberName;
	private String content;
	private Timestamp writeDate;
}
