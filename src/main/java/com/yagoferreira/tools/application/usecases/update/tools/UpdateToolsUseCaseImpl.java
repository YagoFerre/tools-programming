package com.yagoferreira.tools.application.usecases.update.tools;

import com.yagoferreira.tools.application.gateways.ToolsGateway;
import com.yagoferreira.tools.domain.entity.Tool;

public class UpdateToolsUseCaseImpl implements UpdateToolsUseCase {
    private final ToolsGateway toolsGateway;

    public UpdateToolsUseCaseImpl(ToolsGateway toolsGateway) {
        this.toolsGateway = toolsGateway;
    }

    @Override
    public Tool update(Long id, Tool tools) {
        return toolsGateway.update(id, tools);
    }
}
