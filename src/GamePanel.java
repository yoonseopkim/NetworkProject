import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.EnumSet;

public class GamePanel extends JPanel implements KeyListener {
    private ElementalCharacter character;
    private EnumSet<Key> pressedKeys = EnumSet.noneOf(Key.class);
    private Image backgroundImage;
    private Image characterImage;
    private Map gameMap; // 게임 맵 추가



    enum Key {
        UP, DOWN, LEFT, RIGHT
    }


    public GamePanel(ElementalCharacter character) {
        this.character = character;
        setFocusable(true); // KeyListener가 작동하려면 패널이 포커스를 가질 수 있어야 함
        addKeyListener(this); // 이 패널에 KeyListener를 추가
//        backgroundImage = new ImageIcon("배경.jpg").getImage();
//        characterImage = new ImageIcon("캐릭터.png").getImage();
        backgroundImage = new ImageIcon(getClass().getResource("/임시맵.png")).getImage();
        characterImage = new ImageIcon(getClass().getResource("/캐릭터.png")).getImage();

//        // 블록 리스트 초기화
//        blocks = new ArrayList<>();
//        // 예시 블록 추가
//        blocks.add(new Block(100, 300, 50, 50));
//        blocks.add(new Block(200, 250, 100, 50));
//        blocks.add(new Block(300, 200, 150, 50)); // 추가 예시 블록
//        blocks.add(new Block(450, 150, 50, 50));  // 추가 예시 블록
//        // 충돌 감지 후 처리
//        for (Block block : blocks) {
//            if (block.isCollision(character)) {
//                // 충돌 발생 시 캐릭터를 이전 위치로 되돌림
//                character.setX(prevX);
//                character.setY(prevY);
//                break;
//            }
//        }

        gameMap = new Map(); // 맵 초기화
//        // 패널의 크기가 결정되면 블록을 초기화하도록 요청
//        addComponentListener(new ComponentAdapter() {
//            @Override
//            public void componentResized(ComponentEvent e) {
//                gameMap.initializeBlocks(getWidth(), getHeight()); // 맵 객체에게 초기화 요청
//            }
//        });

        // 패널의 크기가 결정되면 블록을 초기화하도록 요청
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                gameMap.initializeBlocks(getX(), getY(), getWidth(), getHeight()); // 맵 객체에게 초기화 요청
            }
        });


        // 타이머를 사용하여 게임 루프 구현
        Timer timer = new Timer(1000 / 60, e -> {
            updateCharacter();
            character.applyGravity(getHeight()); // 중력 적용
            character.decelerate(); // 캐릭터 감속
            repaint(); // 화면 다시 그리기
        });
        timer.start();
    }

    private void updateCharacter() {
        if (pressedKeys.contains(Key.LEFT)) {
            character.moveLeft();
        }
        if (pressedKeys.contains(Key.RIGHT)) {
            character.moveRight();
        }
        if (pressedKeys.contains(Key.UP)) {
            character.jump(getHeight());
        }
        // No need to handle DOWN as it's not typically used for jumping
        character.decelerate();


        // 이동 전 캐릭터 위치 저장
        int prevX = character.getX();
        int prevY = character.getY();

        // 캐릭터 움직임 처리
        // ...

        gameMap.checkCollisions(character); // 충돌 검사

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // 배경 이미지 그리기 (화면 전체에 맞춤)
        g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);


        // 캐릭터 이미지 그리기
        g.drawImage(characterImage, character.getX(), character.getY(), character.getCharacterSize(), character.getCharacterSize(), this);
        gameMap.draw(g); // 맵 그리기

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
            switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                pressedKeys.add(Key.LEFT);
                break;
            case KeyEvent.VK_RIGHT:
                pressedKeys.add(Key.RIGHT);
                break;
            case KeyEvent.VK_UP:
                pressedKeys.add(Key.UP);
                break;
        }
        // 캐릭터가 창 밖으로 나가지 않도록 경계 확인
        if (character.getX() < 0) {
            character.setX(0);
        } else if (character.getX() + character.getCharacterSize() > getWidth()) {
            character.setX(getWidth() - character.getCharacterSize());
        }

        if (character.getY() < 0) {
            character.setY(0);
        } else if (character.getY() + character.getCharacterSize() > getHeight()) {
            character.setY(getHeight() - character.getCharacterSize());
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                pressedKeys.remove(Key.LEFT);
                break;
            case KeyEvent.VK_RIGHT:
                pressedKeys.remove(Key.RIGHT);
                break;
            case KeyEvent.VK_UP:
                pressedKeys.remove(Key.UP);
                break;
        }
    }
}
