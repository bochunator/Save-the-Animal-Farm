package bochunator.savetheanimalfarm.object;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import bochunator.savetheanimalfarm.R;

public class Animal {
    private Animal() {
    }
    public static Bitmap getBitmap(AnimalName animalName, Context context) {
        return BitmapFactory.decodeResource(context.getResources(), getAnimalImageResource(animalName));
    }
    public static int getAnimalImageResource(AnimalName animalName) {
        switch (animalName) {
            case ZEBRA: return R.drawable.zebra;
            case RABBIT: return R.drawable.rabbit;
            case NARWHAL: return R.drawable.narwhal;
            case GOAT: return R.drawable.goat;
            case CROCODILE: return R.drawable.crocodile;
            case WHALE: return R.drawable.whale;
            case PIG: return R.drawable.pig;
            case MOOSE: return R.drawable.moose;
            case GIRAFFE: return R.drawable.giraffe;
            case COW: return R.drawable.cow;
            case WALRUS: return R.drawable.walrus;
            case PENGUIN: return R.drawable.penguin;
            case BEAR: return R.drawable.bear;
            case FROG: return R.drawable.frog;
            case CHICKEN: return R.drawable.chicken;
            case SNAKE: return R.drawable.snake;
            case HORSE: return R.drawable.horse;
            case ELEPHANT: return R.drawable.elephant;
            case CHICK: return R.drawable.chick;
            case SLOTH: return R.drawable.sloth;
            case PANDA: return R.drawable.panda;
            case HIPPO: return R.drawable.hippo;
            case DUCK: return R.drawable.duck;
            case BUFFALO: return R.drawable.buffalo;
            case RHINO: return R.drawable.rhino;
            case OWL: return R.drawable.owl;
            case GORILLA: return R.drawable.gorilla;
            case DOG: return R.drawable.dog;
            case MONKEY: return R.drawable.monkey;
            default: return R.drawable.parrot;
        }
    }
}
