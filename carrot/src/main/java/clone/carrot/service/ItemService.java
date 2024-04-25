package clone.carrot.service;

import clone.carrot.doamin.City;
import clone.carrot.doamin.Item;
import clone.carrot.doamin.ItemStatus;
import clone.carrot.doamin.Member;
import clone.carrot.doamin.dto.ItemCreateRequestDto;
import clone.carrot.repository.ItemRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final MemberService memberService;
    private final ItemRepository itemRepository;

    @Transactional
    public String create(Long memberId, ItemCreateRequestDto itemCreateRequestDto) {

        Member member = memberService.findById(memberId);


        Item item = itemRepository.save(
                Item.create(
                        member,
                        itemCreateRequestDto.title(),
                        itemCreateRequestDto.price(),
                        itemCreateRequestDto.description(),
                        City.valueOf(itemCreateRequestDto.city()),
                        ItemStatus.valueOf(itemCreateRequestDto.status())));

        return item.getId().toString();

    }
}
