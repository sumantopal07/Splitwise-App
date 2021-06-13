import java.util.List;

public class Driver {
        public static void main(String[] args) {
                User u1= new User();
                u1.setName("u1");
                User u2= new User();
                u2.setName("u2");
                User u3= new User();
                u3.setName("u3");
                User u4= new User();
                u4.setName("u4");

//              These 4 classes can be made singleton services
                Expense equal = new Equal();
                Expense exact = new Exact();
                Expense percent = new Percent();
                Splitwise app =new Splitwise(List.of(u1,u2,u3,u4));

                app.expenseCalc(equal,u1,1000.0,List.of(u1,u2,u3,u4),null);

                app.expenseCalc(exact,u1,1250.0,List.of(u2,u3),List.of(370.0,880.0));

                app.expenseCalc(percent,u4,1200.0,List.of(u1,u2,u3,u4),List.of(40.0,20.0,20.0,20.0));

                app.ShowForAllUsers();


        }
}
//Input: u1 1000 4 u1 u2 u3 u4 EQUAL
//Input: u1 1250 2 u2 u3 EXACT 370 880
//Input: u4 1200 4 u1 u2 u3 u4 PERCENT 40 20 20 20
//

