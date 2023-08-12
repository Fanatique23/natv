package chanels.dtos;

import lombok.Data;

import java.util.List;

@Data
public class ChannelDto {
    private Long channel_id;
    private String channel_name;
    private String img_url;
    private List<DiscountDto> discounts;
}
