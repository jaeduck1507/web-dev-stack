package vo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
public class UserInfo {
	private int userNo;
	private String UserId;
	private String userNickname;
	private String phone;
	private String email;
	private LocalDate joinDate;
	private LocalDate userBirth;
}
