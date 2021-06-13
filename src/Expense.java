import java.util.List;

public interface Expense {

    public boolean calculate(User payer, double totalValue,
                             List<User> users,List<Double> values);
}
