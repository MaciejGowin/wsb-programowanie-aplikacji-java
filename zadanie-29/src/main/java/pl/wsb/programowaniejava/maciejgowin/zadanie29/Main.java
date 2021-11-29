package pl.wsb.programowaniejava.maciejgowin.zadanie29;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        try (SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Order.class)
                .buildSessionFactory()) {

            cleanup(sessionFactory);
            generateOrders(sessionFactory);

            products(sessionFactory);
            bookOrders(sessionFactory);
            ordersAbove(sessionFactory);
            topMostExpensiveOrders(sessionFactory);
            sumPerOrderProduct(sessionFactory);
        }
    }

    public static void products(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<String> criteriaQuery = criteriaBuilder.createQuery(String.class);

            Root<Order> root = criteriaQuery.from(Order.class);
            criteriaQuery.select(root.get("product"));

            Set<String> products = session.createQuery(criteriaQuery)
                    .stream()
                    .collect(Collectors.toSet());
            System.out.printf("Products: %s%n", products);
        }
    }

    public static void bookOrders(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Order> criteriaQuery = criteriaBuilder.createQuery(Order.class);

            Root<Order> root = criteriaQuery.from(Order.class);
            criteriaQuery.select(root)
                    .where(criteriaBuilder.equal(root.get("product"), "Book"));

            List<Order> orders = session.createQuery(criteriaQuery)
                    .list();
            System.out.printf("Book orders: %s%n", orders);
        }
    }

    public static void ordersAbove(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Order> criteriaQuery = criteriaBuilder.createQuery(Order.class);

            Root<Order> root = criteriaQuery.from(Order.class);
            criteriaQuery.select(root)
                    .where(criteriaBuilder.gt(root.get("value"), 50.0));
            List<Order> orders = session.createQuery(criteriaQuery)
                    .list();
            System.out.printf("Orders obove: %s%n", orders);
        }
    }

    public static void topMostExpensiveOrders(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Order> criteriaQuery = criteriaBuilder.createQuery(Order.class);

            Root<Order> root = criteriaQuery.from(Order.class);
            criteriaQuery.select(root)
                    .orderBy(criteriaBuilder.desc(root.get("value")));

            List<Order> orders = session.createQuery(criteriaQuery)
                    .setMaxResults(3)
                    .list();
            System.out.printf("Most expensive: %s%n", orders);
        }
    }

    public static void sumPerOrderProduct(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<ProductTotal> criteriaQuery = criteriaBuilder.createQuery(ProductTotal.class);

            Root<Order> root = criteriaQuery.from(Order.class);
            criteriaQuery.select(criteriaBuilder.construct(ProductTotal.class, root.get("product"), criteriaBuilder.sum(root.get("value"))))
                    .groupBy(root.get("product"));

            List<ProductTotal> productTotals = session.createQuery(criteriaQuery).list();
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
