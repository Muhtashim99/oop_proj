package com.test.kaarigar;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.test.kaarigar.categories.AcrepairCategory;
import com.test.kaarigar.categories.AppliancesCategory;
import com.test.kaarigar.categories.BeautyCategory;
import com.test.kaarigar.categories.CleaningCategory;
import com.test.kaarigar.categories.ElectronicsCategory;
import com.test.kaarigar.categories.PaintingCategory;
import com.test.kaarigar.categories.PlumbingCategory;
import com.test.kaarigar.categories.ShiftingCategory;
import com.test.kaarigar.detailpage.APdetails3;
import com.test.kaarigar.detailpage.Cldetails4;
import com.test.kaarigar.detailpage.Elcdetails3;
import com.test.kaarigar.detailpage.Pntdetails2;
import com.test.kaarigar.detailpage.Shftdetails4;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private CardAdapter cardAdapter;
    private ImageSlider imageSlider;
    private Button searchButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Setup RecyclerView
        recyclerView = view.findViewById(R.id.recyclerView);
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManager);

        List<CardItem> cardItemList = new ArrayList<>();
        cardItemList.add(new CardItem(R.drawable.microwave, "Microwave \nRepairing", "4.7", "Rs 1000"));
        cardItemList.add(new CardItem(R.drawable.furniture_shifting, "Furniture \nShifting", "4.2", "Rs 1800"));
        cardItemList.add(new CardItem(R.drawable.sofa, "Sofa  \nCleaning", "4.2", "Rs 1800"));
        cardItemList.add(new CardItem(R.drawable.exterior, "Exterior \npainting", "4.0", "Rs 20000"));
        cardItemList.add(new CardItem(R.drawable.tv, "Tv \nRepair", "4.2", "Rs 18000"));

        cardAdapter = new CardAdapter(cardItemList, new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                // Handle item click
               switch (position){
                   case 0:
                       Intent intent0 = new Intent(getActivity(), APdetails3.class);
                       startActivity(intent0);
                       break;
               case 1:
                   Intent intent1 = new Intent(getActivity(), Shftdetails4.class);
                   startActivity(intent1);
                   break;
               case 2:
                   Intent intent2 = new Intent(getActivity(), Cldetails4.class);
                   startActivity(intent2);
                   break;
                   case 3:
                       Intent intent3 = new Intent(getActivity(), Pntdetails2.class);
                       startActivity(intent3);
                       break;
                   case 4:
                       Intent intent4 = new Intent(getActivity(), Elcdetails3.class);
                       startActivity(intent4);
                       break;
               }
            }
        });
        recyclerView.setAdapter(cardAdapter);

        // Setup ImageSlider
        imageSlider = view.findViewById(R.id.image_slider);

        List<SlideModel> imageList = new ArrayList<>();
        imageList.add(new SlideModel(R.drawable.banner1, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.banner2, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.banner3, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.banner4, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.banner5, ScaleTypes.FIT));

        imageSlider.setImageList(imageList, ScaleTypes.FIT);

        // Setup Search Button
        searchButton = view.findViewById(R.id.searchButton);
        searchButton.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), SearchActivity.class);
            startActivity(intent);
        });

        ImageView notify = view.findViewById(R.id.notificationmain);
        notify.setOnClickListener(v -> {
            Intent gotonotifypage = new Intent(getActivity(), notificationActivity.class);
            startActivity(gotonotifypage);
        });

        ImageView ac = view.findViewById(R.id.acrepair);
        ImageView bty = view.findViewById(R.id.beauty);
        ImageView apl = view.findViewById(R.id.appliance);
        ImageView elc = view.findViewById(R.id.electronics);
        ImageView cln = view.findViewById(R.id.cleaning);
        ImageView paint = view.findViewById(R.id.painting);
        ImageView plum = view.findViewById(R.id.plumbing);
        ImageView shft = view.findViewById(R.id.shifting);

        ac.setOnClickListener(v -> {
            Intent goac = new Intent(getActivity(), AcrepairCategory.class);
            startActivity(goac);
        });
        bty.setOnClickListener(v -> {
            Intent gobty = new Intent(getActivity(), BeautyCategory.class);
            startActivity(gobty);
        });

        apl.setOnClickListener(v -> {
            Intent goapl = new Intent(getActivity(), AppliancesCategory.class);
            startActivity(goapl);
        });

        elc.setOnClickListener(v -> {
            Intent goelc = new Intent(getActivity(), ElectronicsCategory.class);
            startActivity(goelc);
        });

        cln.setOnClickListener(v -> {
            Intent gocln = new Intent(getActivity(), CleaningCategory.class);
            startActivity(gocln);
        });

        paint.setOnClickListener(v -> {
            Intent gopaint = new Intent(getActivity(), PaintingCategory.class);
            startActivity(gopaint);
        });

        plum.setOnClickListener(v -> {
            Intent goplum = new Intent(getActivity(), PlumbingCategory.class);
            startActivity(goplum);
        });

        shft.setOnClickListener(v -> {
            Intent goshft = new Intent(getActivity(), ShiftingCategory.class);
            startActivity(goshft);
        });

        return view;
    }
}
