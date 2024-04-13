import java.util.*;

class Coin {
    private Integer value;

    public Coin(Integer value) {
        this.value = value;
    }

    Integer getValue() {
        return this.value;
    }
}

class Product {
    private String name;
    private Integer price;
    private Integer quantity;

    public Product(String name, Integer price, Integer quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    String getName() {
        return this.name;
    }

    Integer getPrice() {
        return this.price;
    }

    Integer getQuantity() {
        return this.quantity;
    }

    void setQuantity() {
        this.quantity--;
    }

}

class VendingMachine {
    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList<Coin> coins = new ArrayList<>();
    private Integer balance = 0;

    void addProducts(ArrayList<Product> products) {
        this.products.addAll(products);
    }

    void addCoin(ArrayList<Coin> coins) {
        this.coins.addAll(coins);
    }

    Integer insertCoin(Coin coin) {

        for (Coin x : coins) {
            if (x.getValue() == coin.getValue()) {
                this.balance += coin.getValue();
                System.out.println("Balance = " + this.balance);
                return balance;
            }
        }

        return balance;
    }

    void getProducts(int opt) {
        Product p = products.get(opt - 1);
        Integer pri = p.getPrice();
        Integer qt = p.getQuantity();

        if (qt > 0) {
            if (pri <= balance) {
                p.setQuantity();
                System.out.println("Enjoy the Drink");
                balance = balance - pri;
                if (balance > 0) {
                    System.out.println("Keep your change Rs :" + balance);
                }
            } else {
                System.out.println("Low balence" + balance + " Take Your Coin AND Please Try again");
            }
        } else {
            System.out.println("product out of Stock");
        }

    }

}

class Main {
    public static void main(String... args) {
        ArrayList<Product> product = new ArrayList<>();
        product.add(new Product("Coke", 50, 5));
        product.add(new Product("Pepsi", 40, 5));
        product.add(new Product("Wine", 60, 5));
        product.add(new Product("Water", 10, 5));
        product.add(new Product("Coffe", 30, 5));
        product.add(new Product("Kingfisher", 60, 5));

        ArrayList<Coin> coin = new ArrayList<>();
        coin.add(new Coin(10));
        coin.add(new Coin(25));
        coin.add(new Coin(5));
        coin.add(new Coin(50));

        VendingMachine v = new VendingMachine();
        v.addProducts(product);
        v.addCoin(coin);

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Vending Machine ");
        System.out.println("Please enter coin only of values 5,10,25,50 ");

        int x = sc.nextInt();
        Coin inputCoin = new Coin(x);
        if (v.insertCoin(inputCoin) > 0) {
            System.out.println("Balence Added");
            System.out.println("Do you want to Enter More coins IF yes Press 1 / If no press Any Button To Skip");
            x = 0;
            x = sc.nextInt();
            if (x == 1) {
                System.out.println("Enter new Coin ");
                x = 0;
                x = sc.nextInt();
                v.insertCoin(inputCoin);
            }
            System.out.println(
                    "Please select product press 1 for coke(Rs 50)" + "press 2 for pepsi(40)"
                            + "press 3 for wine(Rs 60)"
                            + "press 4 for water(Rs10)" + "press 5 for Coffe(Rs30)"
                            + "press 6 for KingFisher(Rs 60)");

            int opt = sc.nextInt();

            if (opt == 0 || opt > 6) {
                System.out.println("Envalid option Please Select a valid one");
            } else {
                v.getProducts(opt);
            }

        } else {
            System.out.println("Please Enter valid Coins");
        }

    }
}
