import org.springframework.context.support.GenericXmlApplicationContext;
import ru.mitenev.dao.UserDao;
import ru.mitenev.domain.User;

import java.util.List;

public class Tester {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("app-context.xml");
        ctx.refresh();

        UserDao userDao = ctx.getBean("userDao", UserDao.class);
        if (userDao == null) {
            System.out.println("exit!!!");
        } else {
            List<User> users = userDao.getAll();
            listUsers(users);
        }
    }

    private static void listUsers(List<User> users) {
        System.out.println("");
        System.out.println("list of users");

        for (User u: users) {
            System.out.println(u);
            System.out.println();
        }
    }
}
