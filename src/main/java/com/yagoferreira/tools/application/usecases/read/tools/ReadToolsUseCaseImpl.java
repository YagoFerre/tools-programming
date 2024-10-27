package com.yagoferreira.tools.application.usecases.read.tools;

import com.yagoferreira.tools.application.gateways.ToolsGateway;
import com.yagoferreira.tools.domain.entity.Tool;

import java.util.List;

public class ReadToolsUseCaseImpl implements ReadToolsUseCase {
    private final ToolsGateway toolsGateway;

    public ReadToolsUseCaseImpl(ToolsGateway toolsGateway) {
        this.toolsGateway = toolsGateway;
    }

    @Override
    public List<Tool> list() {
        return toolsGateway.list();
    }

    @Override
    public List<Tool> listToolsByTag(String tag) {
        return toolsGateway.listToolsByTag(tag);
    }
}
