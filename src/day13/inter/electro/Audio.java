package day13.inter.electro;

public class Audio implements RemoteControl {

    private int volume;

    @Override
    public void turnOn() {
        System.out.println("오디오를 켭니다.");
    }

    @Override
    public void turnOff() {
        System.out.println("오디오를 끕니다.");
    }

    @Override
    public void setVolume(int volume) {
        if (volume > MAX_VOLUME) {
            this.volume = MAX_VOLUME;
        } else if(volume < MIN_VOLUME) {
            this.volume = MIN_VOLUME;
        } else {
            this.volume =volume;
        }
        System.out.println("현재 오디오 볼륨: " + this.volume);
    }
}
