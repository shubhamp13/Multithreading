package completablefuture.exercise;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//📌 Problem Statement:
//
//Fetch a user ID asynchronously.
//Once the ID is available, fetch user details using another async call.
//Print the user details after fetching.
public class Question4
{
       public static List<User> users = new ArrayList<>();
    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();

        users.add(new User(1, "Alice"));
        users.add(new User(2, "Bob"));
        users.add(new User(3, "Charlie"));
        users.add(new User(4, "David"));
        users.add(new User(5, "Eve"));
        users.add(new User(6, "Frank"));
        users.add(new User(7, "Grace"));
        users.add(new User(8, "Hannah"));
        users.add(new User(9, "Isaac"));
        users.add(new User(10, "Jack"));
        CompletableFuture<User>user1=CompletableFuture.supplyAsync(()->getUser(113),service).
                thenCompose((user)->CompletableFuture.
                         supplyAsync(()->user.join()));
        System.out.println(user1.join());
        service.shutdown();
    }
    private static CompletableFuture<User>getUser(int id)
    {
        return CompletableFuture.supplyAsync(()->{
            for(User user : users)
            {
                if (user.getId() == id)
                    return user;
            }
            return null;
        });
    }
}
class User
{
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "id:" + id +
                ", name='" + name;
    }
}
