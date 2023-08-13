package chanels.models.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ChannelDto {
    private Long channel_id;
    private String channel_name;
    private String img_url;
    private List<DiscountDto> discounts;
}
