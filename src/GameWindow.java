import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    private GamePanel gamePanel;
    private JLabel player1Label;
    private JLabel player2Label;
    // 기타 GUI 구성 요소 추가

    public GameWindow(Player player1, Player player2) {
        super("별의 커비 게임"); // 창의 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(1280,720);
        setResizable(false); // 창 크기 변경 불가능하게 설정

        // GamePanel 인스턴스 생성 및 추가
        gamePanel = new GamePanel(player1.getCharacter());
        add(gamePanel, BorderLayout.CENTER);

        //pack(); // 컴포넌트에 맞게 창 크기 조절
        setLocationRelativeTo(null); // 창을 화면 중앙에 위치시킴

    }

    // 게임 루프 및 이벤트 처리 메소드 추가
}

// 나머지 클래스는 이전 메시지에서 설명한 것을 참고하여 추가