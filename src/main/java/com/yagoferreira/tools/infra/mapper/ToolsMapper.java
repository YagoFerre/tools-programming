package com.yagoferreira.tools.infra.mapper;

import com.yagoferreira.tools.domain.entity.Tool;
import com.yagoferreira.tools.infra.entity.ToolEntity;
import org.springframework.stereotype.Component;

@Component
public class ToolsMapper {
    public ToolEntity toEntity(Tool toolsDomainObj) {
        return new ToolEntity(
                toolsDomainObj.getId(),
                toolsDomainObj.getTitle(),
                toolsDomainObj.getLink(),
                toolsDomainObj.getDescription(),
                toolsDomainObj.getTags()
        );
    }

    public Tool toDomainObj(ToolEntity toolEntity) {
        return new Tool(
                toolEntity.getId(),
                toolEntity.getTitle(),
                toolEntity.getLink(),
                toolEntity.getDescription(),
                toolEntity.getTags()
        );
    }
}
