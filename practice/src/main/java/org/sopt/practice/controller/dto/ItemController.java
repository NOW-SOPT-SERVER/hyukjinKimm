package org.sopt.practice.controller.dto;

import lombok.RequiredArgsConstructor;
import org.sopt.practice.service.ItemService;
import org.sopt.practice.service.MemberService;
import org.sopt.practice.service.dto.ItemCreateDto;
import org.sopt.practice.service.dto.MemberCreateDto;
import org.sopt.practice.service.dto.MemberFindDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/item")
public class ItemController {

    private final ItemService itemService;

    @PostMapping
    public ResponseEntity createItem(
            @RequestBody ItemCreateDto itemCreate
    ) {
        return ResponseEntity.created(URI.create(itemService.createItem(itemCreate))).build();

    }

}