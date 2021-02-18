package day13.inter.electro;

import static day13.inter.electro.RemoteControl.MAX_VOLUME;
import static day13.inter.electro.RemoteControl.MIN_VOLUME;
import static java.lang.System.out;

public class Television implements RemoteControl {

    private int volume;

    @Override
    public void turnOn() {
        out.println("TV를 켭니다.");
    }

    @Override
    public void turnOff() {
        out.println("TV를 끕니다.");
    }

    @Override
    public void setVolume(int volume) {
        if (volume > MAX_VOLUME) {
            this.volume = MAX_VOLUME;
        } else if(volume < MIN_VOLUME) {
            this.volume = MIN_VOLUME;
        } else {
            this.volume = volume;
        }
        out.println("현재 TV 볼륨: " + this.volume);
    }

    @Override
    public void setMute() {
        this.volume = 0;
    }
}