package directory.elements.user;

import pattern.command.Command;

// ConcreteCommand
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