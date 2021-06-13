import java.util.List;

public class Percent implements Expense{

    @Override
    public boolean calculate(User payer, double totalValue, List<User> users, List<Double> values) {

        if(!validate(values) || users.size() != values.size())
            return false;

        var payersMap=payer.getBalances();
        for(int i=0;i<users.size();i++){
            User user=users.get(i);
            double value=values.get(i)/100.0 * totalValue;

            var loaneeMap=user.getBalances();
            double previousVal=payersMap.getOrDefault(user,0.0);
            payersMap.put(user,previousVal+value);
            previousVal=loaneeMap.getOrDefault(payer,0.0);
            loaneeMap.put(payer,previousVal-value);
        }
        return true;
    }
    private boolean validate(List<Double> values){
        return 100 == values.stream().mapToDouble( i -> i).sum();
    }
}