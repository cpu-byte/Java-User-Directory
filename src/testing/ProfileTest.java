package testing;

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

}