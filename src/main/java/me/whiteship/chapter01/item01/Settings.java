package me.whiteship.chapter01.item01;

/**
 * 이 클래스의 인스턴스는 #getInstance()를 통해 사용한다.
 * @see #getInstance()
 */
public class Settings {

    private boolean useAutoSteering;

    private boolean useABS;

    private Difficulty difficulty;

    // 기본 생성자 함수를 private으로 설정해 외부에서 무분별한 객체생성을 제한한다.
    private Settings() {}

    // 객체를 미리 생성해둔다.
    private static final Settings SETTINGS = new Settings();

    // 정적 팩토리 메서드를 통해서만 미리 생성해둔 Settings 객체를 반환하게 한다.
    public static Settings getInstance() {
        return SETTINGS;
    }

}
