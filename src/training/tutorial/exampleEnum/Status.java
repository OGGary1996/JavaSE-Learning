package training.tutorial.exampleenum;

public enum Status {
    Running("In progress"), 
    Pending("Waiting for approval"), 
    Failed("Unsuccessful,try again"), 
    Success("Completed");

    private String description;

    private Status(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

}
