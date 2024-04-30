package me.whiteship.chapter01.item01;

public enum OrderStatus {

    PREPARING(0), SHIPPED(1), DELIVERING(2), DELIVERED(3);

    // enum은 상태 또는 데이터를 저장하는 필드를 가질 수 있다. 이 필드들은 각 상수가 생성될 때 초기화될 수 있다.
    private int number;

    // enum에 생성자를 정의할 수 있으며, 이는 주로 enum 상수가 초기화될 때 내부적으로 사용된다.
    // enum의 생성자는 항상 private 이며, 외부에서 enum 인스턴스를 직접 생성할 수 없고, enum 정의에 포함된 상수를 통해서만 인스턴스가 생성된다.
    OrderStatus(int number) {
        this.number = number;
    }

    public int getStatusValue() {
        return number;
    }

}
