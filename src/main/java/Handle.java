import org.pcollections.HashTreePMap;
import org.pcollections.HashTreePSet;
import org.pcollections.PMap;
import org.pcollections.PSet;

import java.util.Objects;

public class Handle {
    private final PMap<String, String> map;
    private final PMap<String, PSet<String>> reverseMap;

    public Handle() {
        this.map = HashTreePMap.empty();
        this.reverseMap = HashTreePMap.empty();
    }

    public Handle(PMap<String, String> map, PMap<String, PSet<String>> reverseMap) {
        this.map = Objects.requireNonNull(map);
        this.reverseMap = Objects.requireNonNull(reverseMap);
    }

    public Handle add(String key, String value) {
        PMap<String, String> retvalMap = this.map.plus(Objects.requireNonNull(key), Objects.requireNonNull(value));
        PMap<String, PSet<String>> retvalReverseMap = this.reverseMap.plus(value,
                this.reverseMap.containsKey(value) ? this.reverseMap.get(value).plus(key) : HashTreePSet.singleton(key));
        return new Handle(retvalMap, retvalReverseMap);
    }

    public Handle del(String key) {
        String existingValue = this.map.get(Objects.requireNonNull(key));
        if (existingValue == null) { // no change
            return this;
        }
        PMap<String, String> retvalMap = this.map.minus(key);
        PMap<String, PSet<String>> retvalReverseMap = this.reverseMap.plus(existingValue, this.reverseMap.get(existingValue).minus(key));
        return new Handle(retvalMap, retvalReverseMap);
    }

    @Override
    public String toString() {
        return "Handle{" +
                "map=" + this.map +
                ", reverseMap=" + this.reverseMap +
                '}';
    }
}

