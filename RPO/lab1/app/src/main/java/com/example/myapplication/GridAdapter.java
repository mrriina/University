package com.example.myapplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class GridAdapter extends BaseAdapter {
    private Context mContext;
    private Integer mCols, mRows;

    private ArrayList<String> arrPict; // массив картинок
    private ArrayList<Integer> arrPictNumb; // массив номеров картинок троек

    private ArrayList<String> arrPictThird; // массив названий картинок троек
    private String PictureCollection; // Префикс набора картинок
    private Resources mRes; // Ресурсы приложени

    private static enum Status {CELL_OPEN, CELL_CLOSE, CELL_DELETE};
    private ArrayList<Status> arrStatus; // состояние ячеек

    private String motivText;

    public GridAdapter(Context context, int cols, int rows) {
        mContext = context;
        mCols = cols;
        mRows = rows;

        arrPict = new ArrayList<String>();
        arrPictNumb = new ArrayList<Integer>();
        arrStatus = new ArrayList<Status>();
        arrPictThird = new ArrayList<String>();
        // Пока определяем префикс так, позже он будет браться из настроек
        PictureCollection = "card";
        // Получаем все ресурсы приложения
        mRes = mContext.getResources();

        // Метод заполняющий массив vecPict
        makePictArray();
        // Метод устанавливающий всем ячейкам статус CELL_CLOSE
        closeAllCells();
    }

    private void closeAllCells() {
        arrStatus.clear();
        for (int i = 0; i < mCols * mRows; i++)
            arrStatus.add(Status.CELL_CLOSE);
    }

    private void makePictArray () {
        arrPict.clear();
        int countThree = (int) Math.ceil((Math.ceil(mRows*mCols/3))/3);
        //System.out.println(countThree);
        ArrayList<Integer> randomNum = new ArrayList<Integer>();

        for (int i=0; i< countThree; i++){
            randomNum.add(ThreadLocalRandom.current().nextInt(10, 21));
        }


        for(int i=0; i<randomNum.size(); i++){
            arrPictThird.add(PictureCollection + Integer.toString(randomNum.get(i)));
            arrPict.add(PictureCollection + Integer.toString(randomNum.get(i)));
            arrPict.add(PictureCollection + Integer.toString(randomNum.get(i)));
            arrPict.add(PictureCollection + Integer.toString(randomNum.get(i)));
        }

        for (int i=0; i < ((mRows*mCols-countThree*3)/2) ; i++){
            arrPict.add(PictureCollection + Integer.toString(i));
            arrPict.add(PictureCollection + Integer.toString(i));
            //System.out.println(PictureCollection + Integer.toString(i));
        }

        Collections.shuffle(arrPict); //перемешивает массив
    }

    @Override
    public int getCount() {
        return mCols * mRows;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView view; // для вывода картинки

        if (convertView == null)
            view = new ImageView(mContext);
        else
            view = (ImageView) convertView;

        switch (arrStatus.get(position)) {
            case CELL_OPEN:
                // Получаем идентификатор ресурса для картинки,
                // которая находится в векторе vecPict на позиции position
                Integer drawableId = mRes.getIdentifier(arrPict.get(position),
                        "drawable", mContext.getPackageName());
                view.setImageResource(drawableId);
                break;
            case CELL_CLOSE:
                view.setImageResource(R.drawable.close);
                break;
            default:
                view.setImageResource(R.drawable.none);
        }
        return view;
    }

    public void checkOpenCells() {
        int first = arrStatus.indexOf(Status.CELL_OPEN);
        int second = arrStatus.lastIndexOf(Status.CELL_OPEN);

        if (first == second)
            return;

        if (arrPict.get(first).equals(arrPict.get(second))) {

            ArrayList<Integer> number = new ArrayList<Integer>();

            for(int i=0; i< arrStatus.size(); i++){
                if (arrStatus.get(i).equals(Status.CELL_OPEN)){
                    number.add(i);
                }
            }

            if (arrPictThird.contains(arrPict.get(first))){
                if (number.size() == 3){
                    if(arrPict.get(number.get(0)).equals(arrPict.get(number.get(1))) &&
                            arrPict.get(number.get(1)).equals(arrPict.get(number.get(2)))){
                        arrStatus.set(number.get(0), Status.CELL_DELETE);
                        arrStatus.set(number.get(1), Status.CELL_DELETE);
                        arrStatus.set(number.get(2), Status.CELL_DELETE);
                        motivText = "Great!";
                    } else{
                        arrStatus.set(number.get(0), Status.CELL_CLOSE);
                        arrStatus.set(number.get(1), Status.CELL_CLOSE);
                        arrStatus.set(number.get(2), Status.CELL_CLOSE);
                        motivText = "Hmm..Try again!";
                    }
                }
                else{
                    return;
                }
            }
            else {
                arrStatus.set(first, Status.CELL_DELETE);
                arrStatus.set(second, Status.CELL_DELETE);
                motivText = "Good!";
            }
        }
        else {
            for(int i=0; i< arrStatus.size(); i++){
                if (arrStatus.get(i).equals(Status.CELL_OPEN)) arrStatus.set(i, Status.CELL_CLOSE);
            }
        }

        return;
    }

    public boolean openCell(int position) {
        if (arrStatus.get(position) == Status.CELL_DELETE
                || arrStatus.get(position) == Status.CELL_OPEN)
            return false;

        if (arrStatus.get(position) != Status.CELL_DELETE)
            arrStatus.set(position, Status.CELL_OPEN);

        notifyDataSetChanged();
        return true;
    }

    public boolean checkGameOver() {
        if (arrStatus.indexOf(Status.CELL_CLOSE) < 0)
            return true;
        return false;
    }

    public String getMotivText() {
        return motivText;
    }

}