package testing;

import directory.elements.user.Profile;
import directory.elements.user.ProfileInterface;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProfileTest {

    final private String basicBio = "No info provided.";
    final private ProfileInterface profile = new Profile(basicBio);

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

        ProfileInterface profile1 = new Profile("No info.");
        ProfileInterface profile2 = new Profile("No info.");
        assertEquals(profile1, profile2);

        assertEquals(profile2.hashCode(), profile1.hashCode());
    }

}