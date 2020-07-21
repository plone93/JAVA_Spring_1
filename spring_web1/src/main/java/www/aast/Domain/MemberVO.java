package www.aast.Domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class MemberVO {
	private String memberNumber; //int
	private String memberId;
	private String memberPass;
	private String memberName;
	private String memberEmail;
	private Timestamp signDate;
	
	private String name;
	private String phoneNumber;
	private String address1;
	private String address2;
}
