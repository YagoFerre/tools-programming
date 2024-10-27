package com.yagoferreira.tools.infra.mapper;

import com.yagoferreira.tools.domain.entity.Tool;
import com.yagoferreira.tools.infra.entity.ToolEntity;

public class ToolsMapper {
    ToolEntity toEntity(Tool toolsDomainObj) {
        return new ToolEntity(
                toolsDomainObj.getId(),
                toolsDomainObj.getTitle(),
                toolsDomainObj.getLink(),
                toolsDomainObj.getDescription(),
                toolsDomainObj.getTags()
        );
    }
}
