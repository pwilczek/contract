package name.wilu.context;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequestUri;

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
                .created(fromCurrentRequestUri().path("/get/{id}").buildAndExpand(added.getId()).toUri())
                .body(added);
    }

    @GetMapping(value = "dummy", produces = "application/json")
    public ResponseEntity<?> get() {
        return ResponseEntity.ok(new Entry().setName("dummy").setId(UUID.randomUUID()));
    }

}
