package clone.carrot.doamin.dto;

import clone.carrot.doamin.Item;
import clone.carrot.doamin.Member;

public record ItemFindDto(
        String title,
        int price,
        String description,
        String city,

        String status,

        MemberFindDto member

){
    public static ItemFindDto of(
           Item item
    ) {
        MemberFindDto memberFindDto = MemberFindDto.of(item.getMember());
        return new ItemFindDto(item.getTitle(), item.getPrice(), item.getDescription(), item.getCity().toString(), item.getStatus().toString(), memberFindDto);
    }
}