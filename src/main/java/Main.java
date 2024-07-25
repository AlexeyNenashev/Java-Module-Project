import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String autoName;
        int autoVelocity;

        Scanner scanner = new Scanner(System.in);
        Gonka gonka = new Gonka();

        for (int i = 1; i <= 3; i++) {
            System.out.println("Enter name of auto # " + i + ":");
            autoName = scanner.next();
            while (true) {
                System.out.println("Enter velocity of auto # " + i + ":");
                autoVelocity = scanner.nextInt();
                if (autoVelocity < 0 || autoVelocity > 250) {
                    System.out.println("Wrong velocity.");
                } else {
                    break;
                }
            }
            gonka.findLeader(new Automobil(autoName, autoVelocity));
        }

        System.out.println("the fastest auto is: " + gonka.leader);

    }
}

class Automobil {
    String name;
    int velocity;

    Automobil(String name, int velocity) {
        this.name = name;
        this.velocity = velocity;
    }
}

class Gonka {
    String leader = "";
    int leaderDistance = 0;

    void findLeader(Automobil newAuto) {
        int time = 24;
        int newAutoDistance = time * newAuto.velocity;
        if (newAutoDistance > leaderDistance) {
            leader = newAuto.name;
            leaderDistance = newAutoDistance;
        }
    }
}
