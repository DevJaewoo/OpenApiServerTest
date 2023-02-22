package com.devjaewoo.openapiservertest.global.dto;

import org.springframework.data.domain.Page;

import java.util.List;

public record PageResponseDto<T>(
        int totalPages,
        long totalElements,
        List<T> content
) {
    public PageResponseDto(Page<T> page) {
        this(page.getTotalPages(), page.getTotalElements(), page.getContent());
    }
}
