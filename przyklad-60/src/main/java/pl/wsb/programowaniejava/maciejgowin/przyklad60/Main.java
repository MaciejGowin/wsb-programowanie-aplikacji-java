package pl.wsb.programowaniejava.maciejgowin.przyklad60;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        try (SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Order.class)
                .buildSessionFactory()) {

            cleanup(sessionFactory);
            generateOrders(sessionFactory);

            orders(sessionFactory);
            products(sessionFactory);
            bookOrders(sessionFactory);
            ordersAbove(sessionFactory);
            topMostExpensiveOrders(sessionFactory);
            sumPerOrderProduct(sessionFactory);
        }
    }

    public static void orders(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            Query<Order> query = session.createQuery("FROM Order", Order.class);
            System.out.printf("Orders: %s%n", query.list());
        }
    }

    public static void products(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            Object products = session.createQuery("SELECT product FROM Order").stream()
                    .map(Object::toString)
                    .collect(Collectors.toSet());
            System.out.printf("Products: %s%n", products);
        }
    }

    public static void bookOrders(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            List<Order> orders = session.createQuery("FROM Order WHERE product = :product", Order.class)
                    .setParameter("product", "Book")
                    .list();
            System.out.printf("Book orders: %s%n", orders);
        }
    }

    public static void ordersAbove(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            List<Order> orders = session.createQuery("FROM Order WHERE value > :value", Order.class)
                    .setParameter("value", 50.0)
                    .list();
            System.out.printf("Orders obove: %s%n", orders);
        }
    }

    public static void topMostExpensiveOrders(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            List<Order> orders = session.createQuery("FROM Order ORDER BY value DESC", Order.class)
                    .setFirstResult(0)
                    .setMaxResults(3)
                    .list();
            System.out.printf("Most expensive: %s%n", orders);
        }
    }

    public static void sumPerOrderProduct(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            List<ProductTotal> productTotals = session
                    .createQuery("SELECT new pl.wsb.programowaniejava.maciejgowin.przyklad60.ProductTotal(product, sum(value)) FROM Order GROUP BY product", ProductTotal.class)
                    .list();
            System.out.printf("Sum per product: %s%n", productTotals);
        }
    }

    public static void generateOrders(SessionFactory sessionFactory) {
        List<String> products = List.of("Book", "Bread", "Milk");
        IntStream.range(0, 10)
                .mapToObj(i -> {
                    double value = Math.random() * 100;
                    return new Order(products.get((int) value % 3), value);
                })
                .forEach(order -> {
                    try (Session session = sessionFactory.openSession()) {
                        session.getTransaction().begin();
                        session.save(order);
                        session.getTransaction().commit();
                    }
                });
    }

    public static void cleanup(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            session.createQuery("DELETE FROM Order").executeUpdate();
            session.getTransaction().commit();
        }
    }
}
