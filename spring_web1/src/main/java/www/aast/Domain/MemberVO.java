package www.aast.Domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class MemberVO {
	private int memberNumber; 
	private String memberId;
	private String memberPass;
	private String memberName;
	private String memberNickName;
	private String memberEmail;
	private String phoneNumber;
	private String addressA;
	private String addressB;
	private Timestamp signDate;
}
