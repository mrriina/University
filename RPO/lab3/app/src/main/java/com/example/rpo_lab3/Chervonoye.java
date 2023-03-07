package com.example.rpo_lab3;

        import android.net.Uri;
        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.ImageView;
        import android.widget.MediaController;
        import android.widget.TextView;
        import android.widget.VideoView;

        import androidx.annotation.NonNull;
        import androidx.annotation.Nullable;
        import androidx.appcompat.app.AppCompatActivity;
        import androidx.appcompat.widget.TooltipCompat;
        import androidx.fragment.app.Fragment;
        import androidx.fragment.app.FragmentActivity;
        import androidx.fragment.app.FragmentManager;
        import androidx.lifecycle.Lifecycle;
        import androidx.viewpager2.adapter.FragmentStateAdapter;
        import androidx.viewpager2.widget.ViewPager2;

        import java.util.ArrayList;
        import java.util.List;

public class Chervonoye extends AppCompatActivity {

    private Button backBut;

    private ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chervonoye);

        backBut = (Button) findViewById(R.id.back);
        View backButView = findViewById(R.id.back);
        TooltipCompat.setTooltipText(backButView, "Click if you want to go back");

        // Настройка ViewPager
        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new ViewPagerAdapter(this));

        backBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { finish(); }
        });
    }

    private List<Fragment> getFragments() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new FragmentPicture());
        fragments.add(new FragmentVideo());
        fragments.add(new FragmentMap());
        return fragments;
    }

    private static class ViewPagerAdapter extends FragmentStateAdapter {
        public ViewPagerAdapter(FragmentActivity fa) {
            super(fa);
        }


        @Override
        public int getItemCount() {
            //return fragments.size();
            return 3;
        }

        @Override
        public Fragment createFragment(int position) {
            switch (position) {
                case 0:
                    return new FragmentPicture();
                case 1:
                    return new FragmentVideo();
                case 2:
                    return new FragmentMap();
                default:
                    return null;
            }
        }
    }


    public static class FragmentPicture extends Fragment {
        public FragmentPicture() {
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.chervonoye_picture, container, false);

            ImageView imageView = view.findViewById(R.id.my_image_view);
            imageView.setImageResource(R.drawable.chervonoye);

            return view;
        }
    }

    public static class FragmentVideo extends Fragment {
        private VideoView videoView;
        public FragmentVideo() {
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.chervonoye_video, container, false);

            // Находим VideoView по ID
            videoView = (VideoView) view.findViewById(R.id.videoView);

            // Устанавливаем путь к видеофайлу
            String videoPath = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.chervonoye_video;
            Uri uri = Uri.parse(videoPath);
            videoView.setVideoURI(uri);

            MediaController mediaController = new MediaController(getActivity());
            videoView.setMediaController(mediaController);
            mediaController.setAnchorView(videoView);
            videoView.start();

            return view;
        }
    }

    public static class FragmentMap extends Fragment {
        public FragmentMap() {
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.chervonoye_map, container, false);
            TextView textAbout = (TextView) view.findViewById(R.id.about);
            textAbout.setText("Размеры Червоного озера - 12,1×5,2 км, вытянуто с северо-запада на юго-восток. " +
                    "Средняя глубина 0,7 м, максимальная — 2,9 м. Урез воды находится на высоте 136,4 м. " +
                    "Минерализация воды 180—185 мг/л, прозрачность 0,6 м.");

            return view;
        }
    }
}
