//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class StartScreen extends JFrame {
//    public StartScreen() {
//        // 스타트 화면 설정
//        setTitle("Game Start");
//        setSize(300, 200);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLocationRelativeTo(null); // 화면 중앙에 위치
//        setResizable(false); // 창 크기 변경 불가능하게 설정
//        // 스타트 버튼 추가
//        JButton startButton = new JButton("게임 시작하기!");
//        JButton creditButton = new JButton("제작진");
//        JButton exitButton = new JButton("게임 종료하기");
//        startButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // 버튼 클릭 시 게임 윈도우 생성
//                ElementalCharacter character1 = new ElementalCharacter("Fire", 10, 100, 300, 400);
//                Player player1 = new Player("Player 1", character1);
//
//                ElementalCharacter character2 = new ElementalCharacter("Water", 8, 120, 1000, 400);
//                Player player2 = new Player("Player 2", character2);
//
//                GameWindow gameWindow = new GameWindow(player1, player2);
//                gameWindow.setVisible(true);
//
//                // 스타트 화면은 숨깁니다.
//                setVisible(false);
//
//            }
//        });
//
//
////        // 레이아웃 설정 및 버튼 추가
////        setLayout(new FlowLayout());
////        add(startButton);
//        setLayout(new BorderLayout()); // 레이아웃 매니저를 BorderLayout으로 설정
//
//// 버튼을 담을 패널 생성
//        JPanel buttonPanel = new JPanel();
//        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS)); // 패널의 레이아웃 매니저를 BoxLayout으로 설정
//
//// 버튼들을 패널에 추가
//        buttonPanel.add(startButton);
//        buttonPanel.add(creditButton);
//        buttonPanel.add(exitButton);
//
//// 버튼 사이의 간격을 추가
//        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10))); // 버튼 사이의 간격 조정
//
//// 패널을 JFrame의 EAST에 추가
//        add(buttonPanel, BorderLayout.EAST);
//
//
//    }
//}
