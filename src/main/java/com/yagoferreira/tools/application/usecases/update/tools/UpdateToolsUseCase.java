package com.yagoferreira.tools.application.usecases.update.tools;

import com.yagoferreira.tools.domain.entity.Tool;

public interface UpdateToolsUseCase {
    Tool update(Long id, Tool tool);
}
