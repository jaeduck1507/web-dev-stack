package vo;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
public class Musics {
	private int musicId;
	private String musicTitle;
	private String musicDesc;
	private String musicCode;
	private String thumnail;
}
