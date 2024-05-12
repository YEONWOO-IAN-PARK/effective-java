package me.whiteship.chapter01.item01;

public class Order {

    private boolean prime;

    private boolean urgent;

    private Product product;

    private OrderStatus orderStatus;

    /*
    * 자바에서는 동일한 시그니처의 생성자 함수를 두 개 이상 만들 수 없다.
    * 하지만 특수한 목적으로 아래 처럼 동일한 타입의 다른 변수를 넣고 싶을 때는..?
    */
//    public Order(Product product, boolean prime) {
//        this.prime = prime;
//        this.product = product;
//    }
//
//    public Order(Product product, boolean urgent) {
//        this.prime = prime;
//        this.urgent = urgent;
//    }

    /*
    * 1. 동일한 시그니처의 생성자 함수를 두 개 이상 생성 할 수 있다.
    * 2. 정적 팩터리 메서드를 사용하면 생성할 객체의 특징을 함수명으로써 더 잘 표현할 수 있다.
    */
    public static Order primeOrder(Product product) {
        Order order = new Order();
        order.prime = true;
        order.product = product;

        return order;
    }

    public static Order urgentOrder(Product product) {
        Order order = new Order();
        order.urgent = true;
        order.product = product;
        return order;
    }

    public static void main(String[] args) {

        Order order = new Order();
        if (order.orderStatus == OrderStatus.DELIVERED) {
            System.out.println("delivered");
        }
    }
}
