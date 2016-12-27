package name.wilu.context;

import java.util.UUID;

@org.springframework.stereotype.Service
public class Service {

    public Entry add(Entry entry) {
        entry.setId(UUID.randomUUID());
        return entry;
    }
}
