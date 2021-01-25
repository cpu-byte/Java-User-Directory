package pattern.command;

public interface InvokerInterface {

    void invoke(Command command);
    void undo();

}
