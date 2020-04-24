package edu.uncc.domoapi.api;

import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/ddapi/sys")
public class SystemController {

    @GetMapping
    public EntityModel<Map<String,String>> healthCheck(){
        Map<String, String> resMap = new HashMap<>();
        resMap.put("healthy", "true");
        resMap.put("timestamp", Instant.now().toString());

        return new EntityModel<>(resMap,
                linkTo(methodOn(SystemController.class).healthCheck()).withSelfRel());
    }
}

