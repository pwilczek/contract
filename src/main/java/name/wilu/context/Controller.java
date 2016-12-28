package name.wilu.context;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentServletMapping;

@RestController
public class Controller {

    private final Service service;

    public Controller(Service service) {
        this.service = service;
    }

    @PostMapping(value = "add", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> add(@RequestBody Entry entry) {
        Entry added = service.add(entry);
        return ResponseEntity
                .created(fromCurrentServletMapping().path("/get/{id}").buildAndExpand(added.getId()).toUri())
                .body(added);
    }

    @GetMapping(value = "get/{id}", produces = "application/json")
    public ResponseEntity<?> get(@PathVariable("id") String id) {
        return ResponseEntity.ok(service.get(UUID.fromString(id)));
    }

}
