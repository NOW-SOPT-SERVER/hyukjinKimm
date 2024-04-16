package org.sopt.practice.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.sopt.practice.domain.Item;
import org.sopt.practice.domain.Member;
import org.sopt.practice.repository.ItemRepository;
import org.sopt.practice.repository.MemberRepository;
import org.sopt.practice.service.dto.ItemCreateDto;
import org.sopt.practice.service.dto.ItemFindDto;
import org.sopt.practice.service.dto.MemberCreateDto;
import org.sopt.practice.service.dto.MemberFindDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public String createItem(
            final ItemCreateDto itemCreate
    ){
        Item item = Item.create(itemCreate.title(), itemCreate.price(), itemCreate.description());
        itemRepository.save(item);
        return item.getId().toString();
    }

    public ItemFindDto findItemById(Long itemId){
        return ItemFindDto.of(itemRepository.findById(itemId).orElseThrow(
                () -> new EntityNotFoundException("ID에 해당하는 상품이 존재하지 않습니다.")
        ));

    }

    @Transactional
    public void deleteItemById(
            Long itemId
    ) {
        Item item = itemRepository.findById(itemId).orElseThrow(
                () -> new EntityNotFoundException("ID에 해당하는 상품이 존재하지 않습니다.")
        );
        itemRepository.delete(item);
    }
    public List<ItemFindDto> findAllItem(){


        List<ItemFindDto> itemFindDtoList = new ArrayList<>();
        List<Item> itemEntityList = itemRepository.findAll();

        for (Item item : itemEntityList) {

            itemFindDtoList.add(ItemFindDto.of(itemRepository.findById(item.getId()).orElseThrow(() -> new EntityNotFoundException("ID에 해당하는 상품이 존재하지 않습니다."))));

        }
        return itemFindDtoList;

    }
}