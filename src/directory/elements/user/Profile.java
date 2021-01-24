package directory.elements.user;

/**
 * The profile class is used by an Employee (and all subclass of Employee) and will hold biography information
 */
public class Profile implements ProfileInterface {

    private String biography;


    // standard encapsulation and override methods

    /**
     * Constructor of the Profile class
     * @param biography biography stored in the profile
     */
    public Profile(String biography) {
        this.biography = biography;
    }

    /**
     * Getter method of the Profile's biography field
     * @return  current value of the biography field
     */
    public String getBiography() {
        return biography;
    }

    /**
     * Setter method of the Profile's biography field
     * @param biography new value of the biography field
     */
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
