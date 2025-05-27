package training.tutorial;
import training.tutorial.exampleEnum.Status;
public class s_Enum2_Status {
    public static void main(String[] args) {
        Status s1 = Status.Running;
        System.out.println(s1);
        
        Status s2 = Status.Failed;
        switch(s2){
            case Running -> System.out.println("It is running");
            case Pending -> System.out.println("It is pending");
            case Failed -> System.out.println("It is failed");
            default -> System.out.println("It is success");
        }

        Status s3 = Status.Success;
        switch (s3) {
            case Running:
                System.out.println("It is running");
                break;
            case Pending:
                System.out.println("It is pending");
                break;
            case Failed:
                System.out.println("It is failed");
                break;
            default:
                System.out.println("It is success");
                break; 
        }

        System.out.println(s1.name());
        System.out.println(s2.ordinal());
        Status[] statuses = Status.values();
        for (Status s : statuses){
            System.out.println(s + ", at index:" + s.ordinal());
        }

        System.out.println(s3.getDescription());
    }
}
