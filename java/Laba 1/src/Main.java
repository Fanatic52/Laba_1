

public class Main
{
    public static void main(String[] args) {
        try {
            //System.out.println(Tasks.taskOne(30));
            //Tasks.taskTwo(-10,10, 1);
            //System.out.println("sum = " + Tasks.taskThreeOne(1));
            //System.out.println("sum2 = " + Tasks.taskThreeTwo(100));
            Tasks.taskFour(4,2);

        }
        catch (IllegalArgumentException ex){
            System.err.println(ex.getMessage());
        }
    }
}
