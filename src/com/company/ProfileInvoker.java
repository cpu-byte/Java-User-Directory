package com.company;

// Invoker
public class ProfileInvoker {

    private Command setBio;

    public void setBioCommand(Command setBio) {
        this.setBio = setBio;
    }

    public void invokeSetBio() {
        this.setBio.execute();
    }

}


//// Invoker
//public class Controller {
//
//    private Command command;
//
//    public void setCommand(Command command) {
//        this.command = command;
//    }
//
//    public void executeCommand() {
//        command.execute();
//    }
//}
