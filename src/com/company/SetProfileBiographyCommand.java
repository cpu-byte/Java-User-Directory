package com.company;

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

//public class SetProfileBiographyCommand implements Command {
//
//    private Profile profile;
//
//    public SetProfileBiographyCommand(Profile profile) {
//        this.profile = profile;
//    }
//
//    @Override
//    public void execute(String newBiography) {
//        profile.setBiography(newBiography);
//    }
//
//}
