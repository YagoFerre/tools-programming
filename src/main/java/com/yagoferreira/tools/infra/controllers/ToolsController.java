package com.yagoferreira.tools.infra.controllers;

import com.yagoferreira.tools.domain.entity.Tool;
import com.yagoferreira.tools.infra.gateways.ToolsGatewayImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tools")
public class ToolsController {
    private final ToolsGatewayImpl gateway;

    public ToolsController(ToolsGatewayImpl gateway) {
        this.gateway = gateway;
    }

    @GetMapping
    public ResponseEntity<List<Tool>> listAll(@RequestParam(required = false) String tag) {
        if (tag == null) {
            return new ResponseEntity<>(gateway.list(), HttpStatus.OK);
        }

        return new ResponseEntity<>(gateway.listToolsByTag(tag), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Tool> createTools(@RequestBody Tool toolsEntity) {
        return new ResponseEntity<>(gateway.create(toolsEntity), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Tool> updateTool(@PathVariable Long id, @RequestBody Tool tools) {
        return new ResponseEntity<>(gateway.update(id, tools), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> remove(@PathVariable Long id) {
        gateway.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
