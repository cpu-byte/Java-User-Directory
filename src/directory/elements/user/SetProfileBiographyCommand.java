package directory.elements.user;

import pattern.command.Command;

/**
 * A concrete command for the setBiography() method belonging to the Profile class
 * Triggered by an Invoker class, it is in relation to the command design pattern
 */
public class SetProfileBiographyCommand implements Command {

    private final Profile profile;
    private final String newBiography;

    public SetProfileBiographyCommand(Profile profile, String newBiography) {
        this.profile = profile;
        this.newBiography = newBiography;
    }

    @Override
    public void execute() {
        this.profile.setBiography(this.newBiography);
    }
}