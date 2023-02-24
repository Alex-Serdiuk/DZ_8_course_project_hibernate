package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
//        test1(); //CREATE
//            test2(); //CREATE
//            test3(); //CREATE
//           test4(); //READ
//           test5(); //UPDATE
           test6(); //DELETE

    }

    public static void test1(){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Country.class)
                .addAnnotatedClass(Brand.class)
                .addAnnotatedClass(Car.class)
                .addAnnotatedClass(Service.class)
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Manager.class)
                .addAnnotatedClass(Order.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        session.beginTransaction();

        Country country = new Country("Italy");
        session.save(country); //добавил страну

        Brand brand1 = new Brand("Ferrari");
        Brand brand2 = new Brand("Fiat");
        Brand brand3 = new Brand("Maserati");
        country.addBrand(brand1);//добавил бренд
        country.addBrand(brand2);//добавил бренд
        country.addBrand(brand3);//добавил бренд
        session.save(country);

        session.getTransaction().commit();
    }

    public static void test2(){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Country.class)
                .addAnnotatedClass(Brand.class)
                .addAnnotatedClass(Car.class)
                .addAnnotatedClass(Service.class)
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Manager.class)
                .addAnnotatedClass(Order.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Добавление бренда к сущ-ей стране
        Country country = session.get(Country.class, 3);
        List<Country> countryList = session.createQuery("from Country where countryName = 'Italy'").getResultList();
        System.out.println(countryList.size());
        System.out.println(countryList.get(0).getId());
        Brand brand1 = new Brand("Alfa Romeo");
        Brand brand2 = new Brand("Lancia");
        countryList.get(0).addBrand(brand1);
        countryList.get(0).addBrand(brand2);



        session.getTransaction().commit();
    }

    public static void test3(){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Country.class)
                .addAnnotatedClass(Brand.class)
                .addAnnotatedClass(Car.class)
                .addAnnotatedClass(Service.class)
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Manager.class)
                .addAnnotatedClass(Order.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        session.beginTransaction();

        //Добавление моделей авто к сущ-ему бренду
//        Brand brand = session.get(Brand.class, 5); // Ford
//        System.out.println(brand);
//        Car car1 = new Car("GT Mustang", "XTA123456Y1234567", "123132");
//        Car car2 = new Car("Mondeo", "XTA321987Y98765412", "951234");
//        brand.addCar(car1);
//        brand.addCar(car2);

        // Добавление сервиса
//        Service service1 = new Service("Замена масла", 899);
//        session.save(service1);

        // Добавление клиента
//       Client client1 = new Client("Vasyl", "Vasylenko", "+380672222222", false);
//       Client client2 = new Client("Sergiy", "Ostapchuk", "+380561122334", true);
//       session.save(client1);
//       session.save(client2);

        // Добавление менеджера
//        Manager manager1 = new Manager("John", "Snow", "+380931234567");
//        session.save(manager1);

        //  Добавление заказа
        Order order = new Order(new GregorianCalendar(2023, Calendar.FEBRUARY, 22, 11, 00), new GregorianCalendar(2023, Calendar.SEPTEMBER, 25,  12, 00));
        Car car = session.get(Car.class, 3);
        Service service = session.get(Service.class, 1);
        Client client = session.get(Client.class, 1);
        Manager manager = session.get(Manager.class, 1);
        order.setCar(car);
        order.setService(service);
        order.setClient(client);
        order.setManager(manager);
        session.save(order);

        session.getTransaction().commit();
    }

    public static void test4(){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Country.class)
                .addAnnotatedClass(Brand.class)
                .addAnnotatedClass(Car.class)
                .addAnnotatedClass(Service.class)
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Manager.class)
                .addAnnotatedClass(Order.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        session.beginTransaction();

        List<Order> orders = session.createQuery("from Order").getResultList();
        System.out.println("\n---------- ORDERS ---------------");
        for (Order order : orders) {
            System.out.println(order);
            System.out.println("service - " + order.getService().getServiceName() + " - $" + order.getService().getServicePrice());
            System.out.println("car - " + order.getCar().getBrand().getBrandName() + " (" + order.getCar().getBrand().getCountry().getCountryName() + ") " + order.getCar().getModelName());
            System.out.println("client - " + order.getClient().getFirstName() + " " + order.getClient().getLastName() + (order.getClient().isVip()? " - VIP client !" : ""));
            System.out.println("manager - " + order.getManager().getFirstName() + " " + order.getManager().getLastName() + " " + order.getManager().getPhone());
            System.out.println("**********");
        }

        session.getTransaction().commit();
    }


    public static void test5(){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Country.class)
                .addAnnotatedClass(Brand.class)
                .addAnnotatedClass(Car.class)
                .addAnnotatedClass(Service.class)
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Manager.class)
                .addAnnotatedClass(Order.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        session.beginTransaction();

        Order order = session.get(Order.class, 1);
        //Обновляем дату завершения заказа
        order.setDateFinish(new GregorianCalendar(2023, Calendar.FEBRUARY, 23,  12, 00));
        System.out.println(order);
        session.save(order);

        session.getTransaction().commit();
    }

    public static void test6(){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Country.class)
                .addAnnotatedClass(Brand.class)
                .addAnnotatedClass(Car.class)
                .addAnnotatedClass(Service.class)
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Manager.class)
                .addAnnotatedClass(Order.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        session.beginTransaction();

        //Удаляем авто
        Car car = session.get(Car.class, 4); //Ford Mondeo
        session.delete(car);

        session.getTransaction().commit();
    }
}
