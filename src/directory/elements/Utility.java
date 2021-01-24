package directory.elements;

import java.util.UUID;

/**
 * Utility class holding all supporting methods for the project
 */
public abstract class Utility {

    /**
     * Generation of a UUID (unique universal identification) value
     * @return  a generated UUID value
     */
    public static String uuidGenerate() {
        // using the java.util.UUID's randomUUID()
        return UUID.randomUUID().toString();
    }

}
