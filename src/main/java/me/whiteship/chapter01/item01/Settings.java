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

    public Settings(boolean useAutoSteering, boolean useABS, Difficulty difficulty) {
        this.useAutoSteering = useAutoSteering;
        this.useABS = useABS;
        this.difficulty = difficulty;
    }

    // 객체를 미리 생성해둔다.
    private static final Settings SETTINGS = new Settings();

    // 정적 팩토리 메서드를 통해서만 미리 생성해둔 Settings 객체를 반환하게 한다.
    public static Settings getInstance() {
        return SETTINGS;
    }

    /**
     * 정적 팩터리 메서드 네이밍 규칙
     *  - javadoc에서는 정적 팩터리 메서드를 통한 객체 생성/획득 시, 생성자가 필요한 부분을 알 수 없으니 public static Settings of(boolean useABS, ...)와 같이 명명한다.
     *  - 미리 만들어둔 객체를 받을 때는 getInstance
     *  - 새로운 객체를 생성할 때는 newInstance
     */

}
