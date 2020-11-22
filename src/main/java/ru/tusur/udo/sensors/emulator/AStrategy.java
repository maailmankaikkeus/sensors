package ru.tusur.udo.sensors.emulator;

public class AStrategy implements EmulationStrategy {

    private int direction = 1;

    private int ticks = 0;
    private int value;

    private int counter;
    private int max;
    private int min;
    
    public AStrategy() {
    	min = 0;
    	max = 100;
    	ticks = 2;
    	
    }

    @Override
    public void doEmulate(FakeSensor sensor) {
        this.ticks ++;
        if (this.ticks == this.counter) {
            this.ticks = 0;
            this.value += this.calcDirection();
        }
        sensor.setValue(this.value);
    }

    private int calcDirection() {
        if (this.value >= this.max) {
            this.direction = -1;
        }
        if (this.value <= this.min) {
            this.direction = 1;
        }
        return this.direction;
    }

}
