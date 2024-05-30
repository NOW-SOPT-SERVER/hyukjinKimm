package clone.carrot.service;

import clone.carrot.doamin.City;
import clone.carrot.doamin.Item;
import clone.carrot.doamin.ItemStatus;
import clone.carrot.doamin.Member;
import clone.carrot.doamin.dto.ItemCreateRequestDto;
import clone.carrot.doamin.dto.ItemDeleteRequestDto;
import clone.carrot.doamin.dto.ItemFindDto;
import clone.carrot.doamin.dto.MemberFindDto;
import clone.carrot.exception.NotFoundException;
import clone.carrot.exception.message.ErrorMessage;
import clone.carrot.external.S3Service;
import clone.carrot.repository.ItemRepository;
import jakarta.transaction.Transactional;
import java.io.IOException;
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
    private static final String ITEM_S3_UPLOAD_FOLER = "item/";

    private final S3Service s3Service;


    @Transactional

    public String create(Long memberId, ItemCreateRequestDto itemCreateRequestDto) {

        Member member = memberService.findById(memberId);
        try{
            Item item = itemRepository.save(
                    Item.create(
                            member,
                            itemCreateRequestDto.title(),
                            itemCreateRequestDto.price(),
                            itemCreateRequestDto.description(),
                            City.valueOf(itemCreateRequestDto.city()),
                            ItemStatus.valueOf(itemCreateRequestDto.status()),
                            s3Service.uploadImage(ITEM_S3_UPLOAD_FOLER, itemCreateRequestDto.image())));

            return item.getId().toString();
        } catch (RuntimeException | IOException exception) {
            throw new RuntimeException(exception.getMessage());

        }






    }

    public String delete(Long memberId, ItemDeleteRequestDto itemDeleteRequestDto) {
        Member member = memberService.findById(memberId);
        try{
            Item item = itemRepository.findByImageUrl(itemDeleteRequestDto.key());
            itemRepository.delete(item);
            s3Service.deleteImage(itemDeleteRequestDto.key());

            return "삭제 성공";
        } catch (RuntimeException | IOException exception) {
            throw new RuntimeException(exception.getMessage());

        }

    }

        public List<ItemFindDto> findItemByCity(String cityName){


        if (Arrays.stream(City.values()).anyMatch(v -> v.name().equals(cityName))) {
            List<ItemFindDto> itemFindLists = new ArrayList<>();
            List<Item> items = itemRepository.findByCity(City.SEOUL);

            for (Item item : items) {
                itemFindLists.add(ItemFindDto.of(item));
            }
            return itemFindLists;
        }

        throw new NotFoundException(ErrorMessage.CITY_NOT_FOUND_BY_NAME_EXCEPTION);

    }
}
