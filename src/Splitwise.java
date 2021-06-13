import java.util.List;

public class Splitwise {

    private List<User> users;

    public Splitwise(List<User> users) {
        this.users = users;
    }

    public void ShowForUser(User user){
        System.out.println(user);
    }

    public void ShowForAllUsers() {
        for (User user : users) {
            System.out.println(user);
        }
    }
    public boolean expenseCalc(Expense expense,
                     User user,double totalValue,List<User> users,
                     List<Double> values){

        return expense.calculate(user,totalValue,users,values);

    }

}
