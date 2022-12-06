package generics;

public class Main {
    public static void main(String[] args) {

        var list = new List();

        list.add(1);
        list.add("1");
        list.add(new User(10));

        // ClassCastException
//        int number = (int)list.get(1);

        // new GenericList<Integer>("a");

        var numbersList = new GenericList<Integer>();

        numbersList.add(1);
        int number = numbersList.get(0);

        var usersList = new GenericList<User>();
        usersList.add(new User(10));
        User user = usersList.get(0);

//        var onlyNumbersAllowedList = new GenericNumbersList<Float>();
        // errors when passed invalid type
        // var onlyNumbersAllowedList = new GenericNumbersList<String>();

        // compare users

        var user1 = new User(10);
        var user2 = new User(20);
        if (user1.compareTo(user2) > 0)
            System.out.println("user1 has more points than user2");
        else if (user1.compareTo(user2) == 0)
            System.out.println("user1 has same amount of points as user 2 ");
        else
            System.out.println("user1 has same less points as user 2 ");


        var max = Utils.max(1, 2);
        System.out.println(max);

        var userMax = Utils.max(user1, user2);
        System.out.println(userMax);

        Utils.print(1, "Test");

        User instructor = new Instructor(10);
        Utils.printUser(instructor);

        Utils.printUsers(new GenericList<Instructor>());

    }
}
