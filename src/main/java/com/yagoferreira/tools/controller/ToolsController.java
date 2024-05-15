package com.yagoferreira.tools.controller;


import com.yagoferreira.tools.entity.Tools;
import com.yagoferreira.tools.service.ToolsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tools")
public class ToolsController {
    private final ToolsService toolsService;

    public ToolsController(ToolsService toolsService) {
        this.toolsService = toolsService;
    }

    @GetMapping
    public ResponseEntity<List<Tools>> listAll(@RequestParam(required = false) String tag) {
        if (tag == null) {
            return new ResponseEntity<>(toolsService.list(), HttpStatus.OK);
        }

        return new ResponseEntity<>(toolsService.findToolsByTag(tag), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Tools> listTool(@PathVariable Long id) {
        return new ResponseEntity<>(toolsService.listById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Tools> createTools(@RequestBody Tools toolsEntity) {
        return new ResponseEntity<>(toolsService.create(toolsEntity), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Tools> updateTool(@PathVariable Long id, @RequestBody Tools tools) {
        return new ResponseEntity<>(toolsService.updateTool(id, tools), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> remove(@PathVariable Long id) {
        toolsService.removeById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
