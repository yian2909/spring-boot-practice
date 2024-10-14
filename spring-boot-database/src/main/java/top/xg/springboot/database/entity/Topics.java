package top.xg.springboot.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Topics {
    private Long id;
    private Integer viewCount;
    private Integer followersCount;
    private Boolean isFollowing;
    private String title;
    private String introduction;
    private String banner;
    private Integer updated;
    private List<Tags> tags;
}
