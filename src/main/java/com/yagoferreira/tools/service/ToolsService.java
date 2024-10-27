package com.yagoferreira.tools.service;

import com.yagoferreira.tools.infra.entity.Tools;
import com.yagoferreira.tools.infra.repository.ToolsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToolsService {
    private final ToolsRepository toolsRepository;

    public ToolsService(ToolsRepository toolsRepository) {
        this.toolsRepository = toolsRepository;
    }

    public List<Tools> list() {
        return toolsRepository.findAll();
    }

    public Tools listById(Long id) {
        return toolsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tool not found."));
    }

    public Tools create(Tools toolsEntity) {
        return toolsRepository.save(toolsEntity);
    }

    public Tools updateTool(Long id, Tools toolEntity) {
        Tools currentTool = listById(id);

        currentTool.setId(currentTool.getId());

        currentTool.setTitle(toolEntity.getTitle());
        currentTool.setDescription(toolEntity.getDescription());
        currentTool.setLink(toolEntity.getLink());
        currentTool.setTags(toolEntity.getTags());

        return toolsRepository.save(currentTool);
    }

    public List<Tools> findToolsByTag(String tag) {
        return toolsRepository.findByTagsContaining(tag);
    }

    public void removeById(Long id) {
        toolsRepository.deleteById(id);
    }
}
