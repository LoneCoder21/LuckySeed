package name.luckyseed.luckyseed1_16_1;

public class GameRuleOption {
    public static GameRuleOption[] allowed_options = {new GameRuleOption(false)};
    public boolean allow_option;

    public GameRuleOption(boolean option) {
        this.allow_option = option;
    }

    public enum GameRule {
        KEEP_INVENTORY,
    }
}
