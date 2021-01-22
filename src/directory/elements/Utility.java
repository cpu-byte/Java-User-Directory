package directory.elements;

import java.util.UUID;

public abstract class Utility {

    public static String uuidGenerate() {
        return UUID.randomUUID().toString();
    }

}
