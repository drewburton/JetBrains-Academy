class Time {

    private int hours;
    private int minutes;
    private int seconds;

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    @Override
    public String toString() {
       StringBuilder time = new StringBuilder();
       if (hours < 10) {
           time.append("0" + hours);
       } else {
           time.append(hours);
       }

       time.append(":");

       if (minutes < 10) {
           time.append("0" + minutes);
       } else {
           time.append(minutes);
       }

       time.append(":");

       if (seconds < 10) {
           time.append("0" + seconds);
       } else {
           time.append(seconds);
       }

       return time.toString();
    }
}