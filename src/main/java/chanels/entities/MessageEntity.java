package chanels.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class MessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "channel_id")
    private Channel channel;
}
