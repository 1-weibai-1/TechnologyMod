package baubles.api.technology;

import java.util.Arrays;

public enum TechnologyType {

    AMULET(0, 12, 13, 14, 15), //项链
    BELT(3, 22, 23, 30, 31), //腰饰
    BODY(5, 18, 19, 26, 27), //服饰

    CHARM(6, 20, 21, 28, 29), //勋章
    HEAD(4, 16, 17, 24, 25), //头饰
    RING(1, 2, 7, 8, 9, 10, 11), //通用


    TRINKET(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31);

    int[] validSlots;

    TechnologyType(int... validSlots) {
        this.validSlots = validSlots;
    }

    public boolean hasSlot(int slot) {
        return Arrays.stream(validSlots).anyMatch(s -> s == slot);
    }

    public int[] getValidSlots() {
        return validSlots;
    }

    public static TechnologyType getFromString(String type) {
        return switch (type) {
            case "ring" -> TechnologyType.RING;
            case "amulet" -> TechnologyType.AMULET;
            case "belt" -> TechnologyType.BELT;
            case "head" -> TechnologyType.HEAD;
            case "body" -> TechnologyType.BODY;
            case "charm" -> TechnologyType.CHARM;
            default -> TRINKET;
        };
    }

}