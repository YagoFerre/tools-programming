package com.yagoferreira.tools.infra.gateways;

import com.yagoferreira.tools.application.gateways.ToolsGateway;
import com.yagoferreira.tools.domain.entity.Tool;
import com.yagoferreira.tools.domain.entity.Tools;
import com.yagoferreira.tools.infra.repository.ToolsRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ToolsGatewayImpl implements ToolsGateway {
    private final ToolsRepository toolsRepository;

    public ToolsGatewayImpl(ToolsRepository toolsRepository) {
        this.toolsRepository = toolsRepository;
    }

    @Override
    public Tool create(Tool tool) {
        return toolsRepository.save(tool);
    }

    @Override
    public List<Tool> list() {
        return List.of();
    }

    @Override
    public Tool update(Long id, Tool tool) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Tool> listToolsByTag(String tag) {
        return toolsRepository.findByTagsContaining(tag);
    }
}
