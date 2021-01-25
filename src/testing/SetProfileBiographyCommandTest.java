package testing;

import directory.elements.user.Profile;
import directory.elements.user.ProfileInterface;
import directory.elements.user.SetProfileBiographyCommand;
import org.junit.jupiter.api.Test;
import pattern.command.Invoker;
import pattern.command.InvokerInterface;

import static org.junit.jupiter.api.Assertions.*;

class SetProfileBiographyCommandTest {

    @Test
    void lifeCycle() {
        // new profile and invoker setup
        ProfileInterface profile = new Profile("Hello world.");
        InvokerInterface profileInvoker = new Invoker();

        // update no. 1
        final var bioUpdateText1 = "Welcome to my profile!";
        final var bioUpdateCommand1 = new SetProfileBiographyCommand(profile, bioUpdateText1);
        profileInvoker.invoke(bioUpdateCommand1);

        // the biography should be set to the new string
        assertEquals(profile.getBiography(), bioUpdateText1);

        // update no. 2
        final var bioUpdateCommand2 = new SetProfileBiographyCommand(profile, "I work in HR.");
        profileInvoker.invoke(bioUpdateCommand2);

        // update no. 3
        final var bioUpdateCommand3 = new SetProfileBiographyCommand(profile, "I'm the CEO");
        profileInvoker.invoke(bioUpdateCommand3);

        profileInvoker.undo(); // removing update no. 3
        profileInvoker.undo(); // removing update no. 2

        // the biography should be the first one that is set from the command pattern, i.e. bioUpdateCommand1
        assertEquals(profile.getBiography(), bioUpdateText1);
    }

}