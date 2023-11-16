import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
//                // 초기 위치를 지정하여 캐릭터 생성
//                StartScreen startScreen = new StartScreen();
//                startScreen.setVisible(true); // 스타트 화면을 보이게 설정




                ElementalCharacter character1 = new ElementalCharacter("Fire", 10, 100, 300, 400);
                Player player1 = new Player("Player 1", character1);

                ElementalCharacter character2 = new ElementalCharacter("Water", 8, 120, 1000, 400);
                Player player2 = new Player("Player 2", character2);

                GameWindow gameWindow = new GameWindow(player1, player2);
                gameWindow.setVisible(true); // GameWindow를 보이게 설정

            }
        });
    }
}
