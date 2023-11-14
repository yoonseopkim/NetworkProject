// Map.java
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Map {
    private List<Block> blocks;

    public Map() {
        blocks = new ArrayList<>();
        // 블록 초기화
//        initializeBlocks();
    }

    void initializeBlocks(int width, int height) {
//        blocks.clear(); // 블록 리스트를 비웁니다.


        blocks.add(new Block(400, 850, 400, 50)); //이게 바닥블록
        blocks.add(new Block(1200, 850, 600, 50)); //이게 바닥블록
        blocks.add(new Block(100, 300, 50, 50));
        blocks.add(new Block(200, 250, 100, 50));
        blocks.add(new Block(300, 200, 150, 50)); // 추가 예시 블록
        blocks.add(new Block(450, 150, 50, 50));  // 추가 예시 블록;
        // ... 더 많은 블록 추가 가능 ...
    }


    public void checkCollisions(ElementalCharacter character) {
        int prevX = character.getX();
        int prevY = character.getY();
        boolean onTopOfBlock = false;

        for (Block block : blocks) {
//            if (block.isCollision(character)) {
//                if (prevY + character.getCharacterSize() <= block.getY()) {
//                    // 캐릭터가 블록 위로 올라갔다는 것을 의미합니다.
//                    character.setY(block.getY() - character.getCharacterSize());
//                    character.setOnGround(true); // 캐릭터가 땅에 닿았다고 설정
//                    onTopOfBlock = true;
//                } else {
//                    // 측면 충돌 처리
//                    character.setX(prevX);
//                }
//                break;
//            }
//        }
//
//        if (!onTopOfBlock) {
//            character.setOnGround(false); // 캐릭터가 공중에 있다고 설정
//        }
            System.out.println("Checking collision with block at x=" + block.getX() + ", y=" + block.getY()); // 로그 추가
            if (block.isCollision(character)) {
                System.out.println("Collision detected with block at x=" + block.getX() + ", y=" + block.getY()); // 로그 추가
                if (prevY + character.getCharacterSize() <= block.getY()) {
                    // 캐릭터가 블록 위로 올라갔다는 것을 의미합니다.
                    character.setY(block.getY() - character.getCharacterSize());
                    character.setOnGround(true); // 캐릭터가 땅에 닿았다고 설정
                    onTopOfBlock = true;
                    System.out.println("Character is on top of the block."); // 로그 추가
                } else {
                    // 측면 충돌 처리
                    character.setX(prevX);
                    System.out.println("Side collision, moving character back to previous position."); // 로그 추가
                }
                break;
            }
        }

        if (!onTopOfBlock) {
            character.setOnGround(false); // 캐릭터가 공중에 있다고 설정
            System.out.println("Character is not on top of any block."); // 로그 추가
        }
    }




    public void draw(Graphics g) {
        for (Block block : blocks) {
            block.draw(g);
        }
    }

}
