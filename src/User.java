import java.util.HashMap;
import java.util.Map;

public class User {
    private String name;
    private Map<User,Double> balances=new HashMap<>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Map<User, Double> getBalances() {
        return balances;
    }

    public void setBalances(Map<User, Double> balances) {
        this.balances = balances;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", balances=" + printBalance() +
                '}';
    }

    private String printBalance(){
        StringBuilder ans = new StringBuilder();
        for (Map.Entry mapElement : balances.entrySet()) {
            User key = (User) mapElement.getKey();
            ans.append(key.getName());
            ans.append(" ");

            double value = (double) mapElement.getValue();

            ans.append(value);
            ans.append(", ");
        }
        return ans.toString();
    }


}
