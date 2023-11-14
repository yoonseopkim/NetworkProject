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

    public boolean isCollision(ElementalCharacter character) {
        int charX = character.getX();
        int charY = character.getY();
        int charSize = character.getCharacterSize();

        // 간단한 사각형 기반 충돌 감지
        return charX < x + width && charX + charSize > x && charY < y + height && charY + charSize > y;
    }

    public void draw(Graphics g) {
        g.setColor(Color.pink); // 블록 색상 설정
        g.fillRect(x, y, width, height);
    }
    // Define the getX() method to return the x coordinate
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    // Getter 메서드들...
}


