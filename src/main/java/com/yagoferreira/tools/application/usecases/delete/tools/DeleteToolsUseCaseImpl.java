package com.yagoferreira.tools.application.usecases.delete.tools;

import com.yagoferreira.tools.application.gateways.ToolsGateway;

public class DeleteToolsUseCaseImpl implements DeleteToolsUseCase {
    private final ToolsGateway toolsGateway;

    public DeleteToolsUseCaseImpl(ToolsGateway toolsGateway) {
        this.toolsGateway = toolsGateway;
    }

    @Override
    public void delete(Long id) {
        toolsGateway.delete(id);
    }
}
