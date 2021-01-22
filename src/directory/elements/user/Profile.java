package directory.elements.user;

public class Profile implements ProfileInterface {

    private String biography;


    // standard encapsulation and override methods

    public Profile(String biography) {
        this.biography = biography;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "biography='" + biography + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Profile profile = (Profile) o;

        return biography.equals(profile.biography);
    }

    @Override
    public int hashCode() {
        return biography.hashCode();
    }
}
