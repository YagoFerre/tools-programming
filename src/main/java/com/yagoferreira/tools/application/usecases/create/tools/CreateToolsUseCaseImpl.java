package com.yagoferreira.tools.application.usecases.create.tools;

import com.yagoferreira.tools.application.gateways.ToolsGateway;
import com.yagoferreira.tools.domain.entity.Tool;

public class CreateToolsUseCaseImpl implements CreateToolsUseCase {
    private final ToolsGateway toolsGateway;

    public CreateToolsUseCaseImpl(ToolsGateway toolsGateway) {
        this.toolsGateway = toolsGateway;
    }

    @Override
    public Tool create(Tool tool) {
        return toolsGateway.create(tool);
    }
}
