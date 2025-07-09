package vo;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
public class Favorite {
	private int favId;
	private int userNo; // foreign key
	private int playlistId; // foreign key
}
