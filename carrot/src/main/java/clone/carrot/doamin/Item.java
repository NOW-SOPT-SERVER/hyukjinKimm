package clone.carrot.doamin;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter
@Setter
public  class Item {
    @Id
    @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;
    private String TITLE;
    private int price;
    private String description;
    private String place;

    @Enumerated(EnumType.STRING)
    private ItemStatus status; //주문상태 [YET, FIN]

}

