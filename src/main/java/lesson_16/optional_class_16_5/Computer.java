package lesson_16.optional_class_16_5;

import java.util.Optional;

public class Computer {
    private SoundCard soundCard;

    public Computer(SoundCard soundCard) {
        this.soundCard = soundCard;
    }

    public SoundCard getSoundCard() {
        return soundCard;
    }

    public Optional<SoundCard> getSoundCard1() {                // меняем getter
        return Optional.ofNullable(soundCard);                 //метод может возвращать или null, или soundCard, но не исключение NullPointerException
    }


}
