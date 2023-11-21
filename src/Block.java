import java.awt.*;

// Block.java
public class Block {
    private int x, y, width, height;


    public Block(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

//    public boolean isCollision(ElementalCharacter character) {
//        int charX = character.getX();
//        int charY = character.getY();
//        int charSize = character.getCharacterSize();
//        // 간단한 사각형 기반 충돌 감지
//        return charX < x + width && charX + charSize > x && charY < y + height && charY + charSize > y;
//    }


    // 왼쪽 충돌 감지
    public boolean isLeftCollision(ElementalCharacter character) {
        int charX = character.getX();
        int charWidth = character.getCharacterSize();
        int charY = character.getY();
        int charHeight = character.getCharacterSize();

        boolean isToLeftOfBlockRight = charX < x && charX + charWidth > x;
        boolean isWithinBlockYRange = charY < y + height && charY + charHeight > y;

        return isToLeftOfBlockRight && isWithinBlockYRange;
    }

    // 오른쪽 충돌 감지
    public boolean isRightCollision(ElementalCharacter character) {
        int charX = character.getX();
        int charWidth = character.getCharacterSize();
        int charY = character.getY();
        int charHeight = character.getCharacterSize();

        boolean isToRightOfBlockLeft = charX < x + width && charX + charWidth > x + width;
        boolean isWithinBlockYRange = charY < y + height && charY + charHeight > y;

        return isToRightOfBlockLeft && isWithinBlockYRange;
    }


    public boolean isTopCollision(ElementalCharacter character) {
        int charX = character.getX();
        int charY = character.getY();
        int charWidth = character.getCharacterSize();
        int charHeight = character.getCharacterSize();

        // 캐릭터의 하단 Y 위치가 블록의 상단 Y 위치보다 높고,
        // 캐릭터의 상단 Y 위치가 블록의 하단 Y 위치보다 낮은 경우를 검사합니다.
        boolean isAboveBlockTop = charY + charHeight <= y;
        boolean isBelowBlockBottom = charY >= y + height;

        // 캐릭터의 X 위치가 블록의 X 위치 범위 안에 있는지 검사합니다.
        boolean isWithinBlockXRange = charX + charWidth > x && charX < x + width;

        // 모든 조건이 충족되면 상단 충돌로 판단합니다.
        return isAboveBlockTop && !isBelowBlockBottom && isWithinBlockXRange;
    }
    public boolean isBottomCollision(ElementalCharacter character) {
        int charX = character.getX();
        int charY = character.getY();
        int charWidth = character.getCharacterSize();
        int charHeight = character.getCharacterSize();

        // 캐릭터의 상단 Y 위치가 블록의 하단 Y 위치보다 낮고,
        // 캐릭터의 하단 Y 위치가 블록의 상단 Y 위치보다 높은 경우를 검사합니다.
        boolean isBelowBlockBottom = charY < y + height;
        boolean isAboveBlockTop = charY + charHeight > y;

        // 캐릭터의 X 위치가 블록의 X 위치 범위 안에 있는지 검사합니다.
        boolean isWithinBlockXRange = charX + charWidth > x && charX < x + width;

        // 모든 조건이 충족되면 하단 충돌로 판단합니다.
        return isBelowBlockBottom && isAboveBlockTop && isWithinBlockXRange;
    }


    public void draw(Graphics g) {
        g.setColor(Color.pink); // 블록 색상 설정
        g.fillRect(x, y, width, height);
    }
    // Define the getX() method to return the x coordinate

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
// Getter 메서드들...
}


