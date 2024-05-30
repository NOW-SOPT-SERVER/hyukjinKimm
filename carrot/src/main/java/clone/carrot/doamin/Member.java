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

    private int age;

    public Member(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static Member create(
            String name,
            int age
    ) {
        return new Member(name, age);
    }



}
