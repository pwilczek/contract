package name.wilu.context;

import java.util.UUID;

public class Entry {

    private String name;
    private UUID id;

    public String getId() {
        return id.toString();
    }

    public String getName() {
        return name;
    }

    public Entry setName(String name) {
        this.name = name;
        return this;
    }

    public Entry setId(UUID id) {
        this.id = id;
        return this;
    }
}
