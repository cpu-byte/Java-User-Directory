package directory.elements.user;

/**
 * Manager class is a Employee subclass, and generally used for users of high authority compared to Employee
 */
public class Manager extends Employee {

    /**
     * Complete constructor for the Manager class
     * @param managerId     immutable string identification value for the class
     * @param name          name of the employee
     * @param email         the email of the employee
     * @param password      the employee's password
     */
    public Manager(String managerId, String name, String email, String password) {
        super(managerId, name, email, password);
    }

    /**
     * Semi-generation constructor for the Manager class
     * @param name      name of the employee
     * @param email     the email of the employee
     * @param password  the employee's password
     */
    public Manager(String name, String email, String password) {
        super(name, email, password);
    }

    @Override
    public String toString() {
        return "Manager{} " + super.toString();
    }

}
