package test.data;

import model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderData {
    public static final Order[] ORDERS= {
            new Order("Иван", "Иванов", "Москва", 1, "1234567890", 1, "2020-06-06", "Комментарий", new String[]{"BLACK"}),
            new Order("Петр", "Петров", "Москва", 2, "1234567890", 1, "2020-06-06", "Комментарий", new String[]{"GREY"}),
            new Order("Сидор", "Сидоров", "Москва", 3, "1234567890", 1, "2020-06-06", "Комментарий", new String[]{"BLACK","GREY"}),
            new Order("Петр", "Петров", "Москва", 2, "1234567890", 1, "2020-06-06", "Комментарий", new String[]{}),
    };

}
