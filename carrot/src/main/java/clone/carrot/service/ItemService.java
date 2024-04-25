package clone.carrot.service;

import clone.carrot.doamin.City;
import clone.carrot.doamin.Item;
import clone.carrot.doamin.ItemStatus;
import clone.carrot.doamin.Member;
import clone.carrot.doamin.dto.ItemCreateRequestDto;
import clone.carrot.doamin.dto.ItemFindDto;
import clone.carrot.doamin.dto.MemberFindDto;
import clone.carrot.exception.NotFoundException;
import clone.carrot.exception.message.ErrorMessage;
import clone.carrot.repository.ItemRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public List<ItemFindDto> findItemByCity(String cityName){
        ArrayList Name = new ArrayList<>(Arrays.asList(City.values()));

        if (Name.contains(cityName)) {
            List<ItemFindDto> itemFindLists = new ArrayList<>();
            List<Item> items = itemRepository.findByCity(City.valueOf(cityName));

            for (Item item : items) {
                itemFindLists.add(ItemFindDto.of(item));
            }
            return itemFindLists;
        }

        throw new NotFoundException(ErrorMessage.CITY_NOT_FOUND_BY_NAME_EXCEPTION);

    }
}
