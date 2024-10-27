package com.yagoferreira.tools.application.usecases.read.tools;

import com.yagoferreira.tools.domain.entity.Tool;

import java.util.List;

public interface ReadToolsUseCase {
    List<Tool> list();
    List<Tool> listToolsByTag(String tag);
}
