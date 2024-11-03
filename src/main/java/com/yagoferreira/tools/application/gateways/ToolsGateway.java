package com.yagoferreira.tools.application.gateways;

import com.yagoferreira.tools.domain.entity.Tool;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToolsGateway {
    Tool create(Tool tool);
    List<Tool> list();
    Tool update(Long id, Tool tool);
    void delete(Long id);

    List<Tool> listToolsByTag(String tag);
}
