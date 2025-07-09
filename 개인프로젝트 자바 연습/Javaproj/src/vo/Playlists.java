package vo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
public class Playlists {
	private int playlistId;
	private String playlistTitle;
	private String playlistDesc;
	private String thumnail;
	private String playlistCode;
	private String theme;
	private LocalDateTime createDate;
	private LocalDateTime modifyDate;
	private int userNo; // foreign key
}
