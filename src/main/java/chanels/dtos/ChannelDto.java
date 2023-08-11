package chanels.dtos;

import lombok.Data;

@Data
public class ChannelDto {
    private String name;
    private String imageUrl;

    public ChannelDto(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }
}
