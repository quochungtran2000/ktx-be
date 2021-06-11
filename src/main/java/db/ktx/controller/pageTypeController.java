package db.ktx.controller;

import db.ktx.entity.PageType;
import db.ktx.entity.staticPageType;
import db.ktx.service.PagetypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/staticpage")
public class pageTypeController {

    @Autowired
    private PagetypeService service;

    @GetMapping()
    public List<PageType> pageTypes(){
        return service.pageTypes();

    }

    @GetMapping("/{type}")
    public PageType pageType(@PathVariable("type") staticPageType type){
        return service.getByType(type);
    }

    @PostMapping()
    public ResponseEntity<?> insertPageType(@RequestBody  PageType pageType){
        service.insertPageType(pageType);
        return ResponseEntity.ok("successfully");
    }

    @PutMapping()
    public ResponseEntity<?> updatePageType(@RequestBody PageType pageType){
        service.updatePageType(pageType);
        return ResponseEntity.ok("successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") int id){

        service.deleteById(id);
        return ResponseEntity.ok("successfully");
    }
}
