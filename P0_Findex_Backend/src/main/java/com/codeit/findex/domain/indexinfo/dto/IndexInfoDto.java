package com.codeit.findex.domain.indexinfo.dto;

import com.codeit.findex.domain.common.enums.SourceType;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
public class IndexInfoDto {

    private Long id;
    private String indexClassification;
    private String indexName;
    private Integer employedItemsCount;
    private LocalDate basePointInTime;
    private BigDecimal baseIndex;
    private SourceType sourceType;
    private Boolean favorite;

    public IndexInfoDto(Long id, String indexClassification, String indexName,
                        Integer employedItemsCount, LocalDate basePointInTime,
                        BigDecimal baseIndex, SourceType sourceType, Boolean favorite) {
        this.id = id;
        this.indexClassification = indexClassification;
        this.indexName = indexName;
        this.employedItemsCount = employedItemsCount;
        this.basePointInTime = basePointInTime;
        this.baseIndex = baseIndex;
        this.sourceType = sourceType;
        this.favorite = favorite;
    }

    public static IndexInfoDto create(Long id, String indexClassification, String indexName,
                                      Integer employedItemsCount, LocalDate basePointInTime,
                                      BigDecimal baseIndex, SourceType sourceType, Boolean favorite) {
        return new IndexInfoDto(id, indexClassification, indexName, employedItemsCount, basePointInTime, baseIndex, sourceType, favorite);
    }
}