package com.yagoferreira.tools.infra.gateways;

import com.yagoferreira.tools.application.gateways.ToolsGateway;
import com.yagoferreira.tools.domain.entity.Tool;
import com.yagoferreira.tools.infra.entity.ToolEntity;
import com.yagoferreira.tools.infra.mapper.ToolsMapper;
import com.yagoferreira.tools.infra.repository.ToolsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToolsGatewayImpl implements ToolsGateway {
    private final ToolsRepository toolsRepository;
    private final ToolsMapper toolsMapper;

    public ToolsGatewayImpl(ToolsRepository toolsRepository, ToolsMapper toolsMapper) {
        this.toolsRepository = toolsRepository;
        this.toolsMapper = toolsMapper;
    }

    @Override
    public Tool create(Tool tool) {
        ToolEntity entity = toolsMapper.toEntity(tool);
        ToolEntity savedObject = toolsRepository.save(entity);

        return toolsMapper.toDomainObj(savedObject);
    }

    @Override
    public List<Tool> list() {
        List<ToolEntity> entities = toolsRepository.findAll();

        return entities.stream().map(toolsMapper::toDomainObj).toList();
    }

    @Override
    public Tool update(Long id, Tool tool) {
        ToolEntity currentEntity = toolsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tool not found"));

        currentEntity.setId(id);

        currentEntity.setTitle(tool.getTitle());
        currentEntity.setDescription(tool.getDescription());
        currentEntity.setLink(tool.getLink());
        currentEntity.setTags(tool.getTags());

        ToolEntity updatedEntity = toolsRepository.save(currentEntity);
        return toolsMapper.toDomainObj(updatedEntity);
    }

    @Override
    public void delete(Long id) {
        toolsRepository.deleteById(id);
    }

    @Override
    public List<Tool> listToolsByTag(String tag) {
        List<ToolEntity> entities = toolsRepository.findByTagsContaining(tag);

        return entities.stream().map(toolsMapper::toDomainObj).toList();
    }
}
