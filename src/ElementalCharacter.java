public class ElementalCharacter {
    private String element;
    private int power;
    private int health;
    private boolean onGround;
    private int x; // 캐릭터의 X 좌표
    private int y; // 캐릭터의 Y 좌표
    private final int CHARACTER_SIZE = 50; // 캐릭터의 크기

    private final int MAX_SPEED = 10; // 캐릭터의 최대 속도 (초기값 10)
    private final int ACCELERATION = 5; // 캐릭터의 가속도(초기값 2)
    private final int JUMP_POWER = 30; // 캐릭터의 점프 힘 (초기값 15)
    private final int GRAVITY = 2; // 중력의 힘
    private int velocityX = 0; // x축 속도
    private int velocityY = 0; // y축 속도

    private int panelHeight;

    public ElementalCharacter(String element, int power, int health, int startX, int startY) {

        this.element = element;
        this.power = power;
        this.health = health;
        this.x = startX;
        this.y = startY;

    }



    // 매 프레임마다 호출될 메소드
    public void applyGravity(int panelHeight) {
        velocityY += GRAVITY; // 중력 가속도 적용
        y += velocityY; // 속도에 따라 y 위치 업데이트

        // 바닥에 도달했는지 확인
        if (y > panelHeight - CHARACTER_SIZE) { // somePanelHeight는 패널의 높이를 나타냅니다.
            y = panelHeight - CHARACTER_SIZE; // 바닥에 위치 설정
            velocityY = 0; // 바닥에 닿으면 y축 속도 0
        }


    }

    // 캐릭터가 땅에 닿았는지 설정하는 메소드
    public void setOnGround(boolean onGround) {
        this.onGround = onGround;
        if (onGround) {
            velocityY = 0; // 땅에 닿으면 수직 속도를 0으로 설정
        }
    }

    public boolean isOnGround(int panelHeight) {
        return y == panelHeight - CHARACTER_SIZE;
    }



    // 캐릭터의 기능을 추가하세요 (예: 공격, 방어 등)

    // 캐릭터의 위치 getter
    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }


    public int getVelocityX() {
        return velocityX;
    }

    public void setVelocityX(int velocityX) {
        this.velocityX = velocityX;
    }

    public int getVelocityY() {
        return velocityY;
    }

    public void setVelocityY(int velocityY) {
        this.velocityY = velocityY;
    }

    // 캐릭터의 위치 setter
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

public void moveLeft() {
    if (velocityX > -MAX_SPEED) {
        velocityX -= ACCELERATION; // 왼쪽으로 가속
    }
    x += velocityX; // 속도에 따라 x 위치 업데이트
}

    public void moveRight() {
        if (velocityX < MAX_SPEED) {
            velocityX += ACCELERATION; // 오른쪽으로 가속
        }
        x += velocityX; // 속도에 따라 x 위치 업데이트
    }

    public void decelerate() {
        if (velocityX > 0) {
            velocityX -= ACCELERATION; // 오른쪽으로 이동 중이면 감속
        } else if (velocityX < 0) {
            velocityX += ACCELERATION; // 왼쪽으로 이동 중이면 감속
        }
    }
    public void jump(int panelHeight) {
        if (isOnGround(panelHeight)) {
            velocityY = -JUMP_POWER; // 위로 점프
        }
    }
    public void moveUp() {
        y -= 20;
    }

    public void moveDown() {
        y += 20;
    }

    // 캐릭터의 크기를 가져오는 메소드
    public int getCharacterSize() {
        return CHARACTER_SIZE;
    }
}



