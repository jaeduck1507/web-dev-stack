package vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data
public class JobPosition {
	private int jobNo;
	private String jobTitle;
	private int jobLevel;
	private String description;
}
