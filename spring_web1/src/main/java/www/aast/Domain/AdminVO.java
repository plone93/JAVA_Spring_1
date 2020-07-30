package www.aast.Domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class AdminVO {
	private int adminNumber;
	private String adminId;
	private String adminPass;
	private String adminName;
	private String adminEmail;
	private Timestamp signDate;
}
