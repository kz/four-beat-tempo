package in.iamkelv.fourbeattempo;

public class Marking {
    // Member variables
    private String mMarking;

    // Methods
    public String getMarking(int Tempo) {
        // These tempo markings are based on the markings found on a Wittner metronome.
        if (Tempo < 40) {
            mMarking = "Larghissimo";
        } else if (Tempo < 60) {
            mMarking = "Largo";
        } else if (Tempo < 66) {
            mMarking = "Larghetto";
        } else if (Tempo < 76) {
            mMarking = "Adagio";
        } else if (Tempo < 120) {
            mMarking = "Moderato";
        } else if (Tempo < 168) {
            mMarking = "Allegro";
        } else if (Tempo < 208) {
            mMarking = "Presto";
        } else {
            mMarking = "Prestissimo";
        }

        return mMarking;

    }

}
