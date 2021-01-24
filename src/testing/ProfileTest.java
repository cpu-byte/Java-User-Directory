package testing;

import directory.DirectoryBase;
import directory.elements.user.Profile;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProfileTest {

    final private String basicBio = "No info provided.";
    final private Profile profile = new Profile(basicBio);

    @Test
    void initState() {
        assertEquals(profile.getBiography(), basicBio);
    }

    @Test
    void setters() {
        final var newBio = "I work in analytics on floor 3.";
        profile.setBiography(newBio);
        assertEquals(profile.getBiography(), newBio);
    }

    @Test
    void superMethods() {
        assertNotNull(profile.toString());

        var profile1 = new Profile("No info.");
        var profile2 = new Profile("No info.");
        assertEquals(profile1, profile2);

        assertEquals(profile2.hashCode(), profile1.hashCode());
    }

}