// Player.java
public class Player {
    private String name;
    private ElementalCharacter character;

    public Player(String name, ElementalCharacter character) {
        this.name = name;
        this.character = character;


    }
    public ElementalCharacter getCharacter() {
        return this.character; // Return the ElementalCharacter instance
    }
    public String getName() {
        return this.name;
    }

    // 여기에 플레이어의 기능을 추가하세요 (예: 캐릭터 선택, 이동 등)
}
