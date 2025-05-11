import java.util.ArrayList;
import java.util.List;


public final class ImmutableClass {

    private final int id;
    private final String name;
    private final List<Object> list;

    public ImmutableClass(int id, String name, List<Object> list) {
        this.id = id;
        if(name == null){
            throw new IllegalArgumentException("Name cannot be null");
        }
        this.name = name;
        this.list = new ArrayList<>(list);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public List<Object> getList() {
        return new ArrayList<>(list);
    }
}
