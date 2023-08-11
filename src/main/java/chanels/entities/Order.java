package chanels.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "client_name")
    private String clientName;

    @Column
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column
    private String text;

    @Column(name = "pay_status")
    private String payStatus;

    @Column(name = "total_price")
    private double totalPrice;

    @Column(name = "price_with_discount")
    private double priceWithDiscount;
}

