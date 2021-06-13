import java.util.List;

public class Exact implements Expense{

    @Override
    public boolean calculate(User payer, double totalValue, List<User> users, List<Double> values) {

        if(!validate(totalValue,values) || users.size() != values.size())
            return false;

        var payersMap=payer.getBalances();
        for(int i=0;i<users.size();i++){
            User user=users.get(i);
            double value=values.get(i);

            var loaneeMap=user.getBalances();
            double previousVal=payersMap.getOrDefault(user,0.0);
            payersMap.put(user,previousVal+value);
            previousVal=loaneeMap.getOrDefault(payer,0.0);
            loaneeMap.put(payer,previousVal-value);
        }
        return true;
    }
    private boolean validate(double totalValue,List<Double> values){
        return totalValue == values.stream().mapToDouble( i -> i).sum();
    }
}