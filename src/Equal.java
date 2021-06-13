import java.util.List;

public class Equal implements Expense{

    @Override
    public boolean calculate(User payer, double totalValue, List<User> users, List<Double> values) {

        double distribution=totalValue/users.size();
        distribution = (double) Math.round(distribution * 100) / 100;

        var payersMap=payer.getBalances();
        for(User user:users){
            var loaneeMap=user.getBalances();
            double previousVal=payersMap.getOrDefault(user,0.0);
            payersMap.put(user,previousVal+distribution);
            previousVal=loaneeMap.getOrDefault(payer,0.0);
            loaneeMap.put(payer,previousVal-distribution);
        }
        return true;
    }

}
