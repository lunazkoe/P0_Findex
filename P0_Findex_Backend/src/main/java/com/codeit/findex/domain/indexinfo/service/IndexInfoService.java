package com.codeit.findex.domain.indexinfo.service;

import com.codeit.findex.domain.common.enums.SourceType;
import com.codeit.findex.domain.indexinfo.dto.IndexInfoCreateRequest;
import com.codeit.findex.domain.indexinfo.dto.IndexInfoDto;
import com.codeit.findex.domain.indexinfo.dto.IndexInfoMapper;
import com.codeit.findex.domain.indexinfo.entity.IndexInfo;
import com.codeit.findex.domain.indexinfo.repository.IndexInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class IndexInfoService {

    private final IndexInfoRepository indexInfoRepository;
    private final IndexInfoMapper indexInfoMapper;

    @Transactional
    public IndexInfoDto createIndexInfo(IndexInfoCreateRequest request) {
        if (indexInfoRepository.existsByIndexClassificationAndIndexName(
                request.getIndexClassification(), request.getIndexName()
        )) {
            throw new IllegalArgumentException("이미 동일한 지수 분류명과 지수명이 존재합니다.");
        }

        IndexInfo newIndexInfo = IndexInfo.create(
                request.getIndexClassification(),
                request.getIndexName(),
                request.getEmployedItemsCount(),
                request.getBasePointInTime(),
                request.getBaseIndex(),
                SourceType.USER,
                request.getFavorite()
        );

        IndexInfo savedInfo = indexInfoRepository.save(newIndexInfo);

        return indexInfoMapper.toDto(savedInfo);
    }
}
