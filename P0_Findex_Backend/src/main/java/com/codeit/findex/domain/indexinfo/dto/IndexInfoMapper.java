package com.codeit.findex.domain.indexinfo.dto;

import com.codeit.findex.domain.indexinfo.entity.IndexInfo;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IndexInfoMapper {

    IndexInfoDto toDto(IndexInfo indexInfo);
}
