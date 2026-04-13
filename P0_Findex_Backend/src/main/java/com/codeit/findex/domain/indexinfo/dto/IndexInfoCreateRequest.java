package com.codeit.findex.domain.indexinfo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@NoArgsConstructor // JSON 직렬화를 위해 기본 생성자 필수
public class IndexInfoCreateRequest {

    @NotBlank(message = "지수 분류명은 필수입니다.")
    private String indexClassification;

    @NotBlank(message = "지수명은 필수입니다.")
    private String indexName;

    @NotNull(message = "채용 종목 수는 필수입니다.")
    private Integer employedItemsCount;

    @NotNull(message = "기준 시점은 필수입니다.")
    private LocalDate basePointInTime;

    @NotNull(message = "기준 지수는 필수입니다.")
    private BigDecimal baseIndex;

    private Boolean favorite = false;
}
