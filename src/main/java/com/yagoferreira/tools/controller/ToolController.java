package com.yagoferreira.tools.controller;


import com.yagoferreira.tools.domain.entity.Tool;
import com.yagoferreira.tools.infra.entity.Tools;
import com.yagoferreira.tools.service.ToolsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tools")
public class ToolController {
    private final ToolsService toolsService;

    public ToolController(ToolsService toolsService) {
        this.toolsService = toolsService;
    }

    @GetMapping
    public ResponseEntity<List<Tool>> listAll(@RequestParam(required = false) String tag) {
        if (tag == null) {
            return new ResponseEntity<>(toolsService.list(), HttpStatus.OK);
        }

        return new ResponseEntity<>(toolsService.findToolsByTag(tag), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Tool> listTool(@PathVariable Long id) {
        return new ResponseEntity<>(toolsService.listById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Tool> createTools(@RequestBody Tool toolsEntity) {
        return new ResponseEntity<>(toolsService.create(toolsEntity), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Tool> updateTool(@PathVariable Long id, @RequestBody Tool tools) {
        return new ResponseEntity<>(toolsService.updateTool(id, tools), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> remove(@PathVariable Long id) {
        toolsService.removeById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
