package vo;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
public class PlaylistMusic {
	private int pmId;
	private LocalDateTime addDate;
	private int playlistId; // foriegn key
	private int musicId; // foriegn key
}
