package chanels.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "channels")
public class Channel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @JsonProperty("channel_name")
    private String name;

    @Column
    private String imageUrl;

    @Temporal(TemporalType.DATE)
    @Column
    private Date createdDate;

    @Temporal(TemporalType.DATE)
    @Column
    private Date endDate;

    @OneToMany(mappedBy = "channel", cascade = CascadeType.ALL)
    private List<Price> prices = new ArrayList<>();

    @OneToMany(mappedBy = "channel", cascade = CascadeType.ALL)
    private List<Discount> discounts = new ArrayList<>();
}
