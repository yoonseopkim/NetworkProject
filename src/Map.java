// Map.java
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Map {
    List<Block> blocks;

    public Map() {
        blocks = new ArrayList<>();
        this.blocks = new ArrayList<Block>();
        // 블록 초기화
//        initializeBlocks(new Block());
    }



    public void checkCollisions(ElementalCharacter character) {
        int prevX = character.getX();
        int prevY = character.getY();
        boolean onTopOfBlock = false;

        for (Block block : blocks) {
            // 캐릭터가 블록의 위쪽에 있을 때만 onTopOfBlock을 true로 설정합니다.
            if (block.isCollision(character)) {
                if (prevY == block.getY()) {

//                if (prevY + character.getCharacterSize() <= block.getY() && character.getY() + character.getCharacterSize() > block.getY()) {
                    character.setVelocityY(0); // 캐릭터의 Y축 속도를 0으로 설정
                   // character.setY(block.getY() - character.getCharacterSize()); // 캐릭터를 블록 위로 올립니다.
                    character.setY(block.getY() ); // 캐릭터를 블록 위로 올립니다.
                    character.setOnGround(true);

                    onTopOfBlock = true;
                    System.out.println("Character is on top of the block.");
                } else {
                    character.setVelocityX(0); // 캐릭터의 X축 속도를 0으로 설정
                    character.setX(prevX); // 측면 충돌 시 캐릭터를 이전 X 위치로 되돌립니다.
                    character.setX(0);

                }
            } else if (!onTopOfBlock) {
                character.setOnGround(false);
              //  System.out.println("Character is not on top of any block.");
            }





        }



    }


    void initializeBlocks(int x, int y, int width, int height) {
       blocks.clear(); // 블록 리스트를 비웁니다.


        blocks.add(new Block(400, 650, 400, 50)); //이게 바닥블록
        blocks.add(new Block(1200, 650, 600, 50)); //이게 바닥블록
        blocks.add(new Block(1200, 550, 600, 50)); //이게 위
        blocks.add(new Block(100, 300, 50, 50));
        blocks.add(new Block(200, 250, 100, 50));
        blocks.add(new Block(300, 200, 150, 50)); // 추가 예시 블록
        blocks.add(new Block(450, 150, 50, 50));  // 추가 예시 블록;
        // ... 더 많은 블록 추가 가능 ...
    }



    public void draw(Graphics g) {
        for (Block block : blocks) {
            block.draw(g);
        }
    }

}
