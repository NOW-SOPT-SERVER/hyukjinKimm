package clone.carrot.doamin;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor
public  class Item {
    @Id
    @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;
    private String title;
    private int price;
    private String description;

    @Enumerated(EnumType.STRING)
    private City city;

    @Enumerated(EnumType.STRING)
    private ItemStatus status; //주문상태 [YET, FIN]

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;


    public Item(String title, int price, String description, City city, ItemStatus status, Member member) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.city = city;
        this.status = status;
        this.member = member;
    }

    public static Item create(
            Member member,
            String title,
            int price,
            String description,
            City city,
            ItemStatus itemStatus

    ) {

        return new Item(title, price, description, city, itemStatus, member);

    }
}

