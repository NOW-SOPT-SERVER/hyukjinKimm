package clone.carrot.doamin;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Member {


    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    private String name;

    @Enumerated(EnumType.STRING)
    private City city;

    private int age;

    public Member(String name) {
        this.name = name;
    }

    public static Member create(
            String name
    ) {
        return new Member(name);
    }



}
