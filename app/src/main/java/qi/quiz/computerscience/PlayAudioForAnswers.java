package qi.quiz.computerscience;

import android.content.Context;
import android.media.MediaPlayer;

public class PlayAudioForAnswers {


    private Context mContext;
    private MediaPlayer mediaPlayer;

    public PlayAudioForAnswers(Context mContext) {
        this.mContext = mContext;
    }


    public void setAudioforAnswer(int flag){

        switch (flag){

            case 1:

                int correctAudio = R.raw.success;
                playMusic(correctAudio);
                break;
            case 2:
                int wrongAudio = R.raw.error;
                playMusic(wrongAudio);
                break;
            case 3:
                int timerAudio = R.raw.timetick;
                playMusic(timerAudio);
                break;


        }

    }

    private void playMusic(int audiofile) {

        mediaPlayer = MediaPlayer.create(mContext,audiofile);

        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mediaPlayer.start();
            }
        });

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mediaPlayer.release();
            }
        });



    }

}
