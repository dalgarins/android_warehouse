package com.maxwell.warehouse.fragments;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.maxwell.warehouse.R;
import com.maxwell.warehouse.adapters.RVAdapter;
import com.maxwell.warehouse.models.Items;
import com.maxwell.warehouse.utils.Constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Maximiliano on 02/11/15.
 */
public class HomeListFragment extends Fragment {
    public static final String TYPE = "type";
    public static final String DEVS = "DEVS";
    public static final String SOCIAL = "SOCIAL";
    public static final String MULTIMEDIA = "MULTIMEDIA";
    public static final String UI = "UI";
    public static final String ANIMATIONS = "ANIMATIONS";
    public static final String LOC = "LOC";
    public static final String STORAGE = "STORAGE";

    private RVAdapter adapter;
    private static FragmentActivity fragmentActivity;
    private static ArrayList<ActivityInfo> mActivities;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentActivity = getActivity();
        initializator();
        adapter = new RVAdapter(getList(getArguments().getString(TYPE)), getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Context context = container.getContext();
        View v = LayoutInflater.from(context).inflate(R.layout.base_recycleview_wo_refresh, container, false);
        RecyclerView mRecyclerView = (RecyclerView) v.findViewById(R.id.customRecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(container.getContext()));
        mRecyclerView.setHasFixedSize(false);

        mRecyclerView.setAdapter(adapter);

        return v;
    }

        private HashMap<String, List<Items>> hashMap = new HashMap<>();

        public void initializator() {
            List<Items> animitemsList = new ArrayList<>();
            List<Items> devsitemsList = new ArrayList<>();
            List<Items> locitemsList = new ArrayList<>();
            List<Items> multimediaitemsList = new ArrayList<>();
            List<Items> socialitemsList = new ArrayList<>();
            List<Items> storageitemsList = new ArrayList<>();
            List<Items> uiitemsList = new ArrayList<>();

            try {
                PackageInfo pi = fragmentActivity.getPackageManager().getPackageInfo(
                        fragmentActivity.getPackageName(), PackageManager.GET_ACTIVITIES);

                mActivities = new ArrayList<>(Arrays.asList(pi.activities));

                for (ActivityInfo item:mActivities) {
                    String packageName = fragmentActivity.getPackageName() + ".activities";
                    Class cl = Class.forName(item.name);
                    if(item.name.contains(packageName + ".animations")){
                        String className = item.name.replace(packageName + ".animations.", "");
                        animitemsList.add(new Items(cl, className));
                    } else if(item.name.contains(packageName + ".devs")){
                        String className = item.name.replace(packageName + ".devs.", "");
                        devsitemsList.add(new Items(cl, className));
                    }else if(item.name.contains(packageName + ".location")){
                        String className = item.name.replace(packageName + ".location.", "");
                        locitemsList.add(new Items(cl, className));
                    }else if(item.name.contains(packageName + ".multimedia")){
                        String className = item.name.replace(packageName + ".multimedia.", "");
                        multimediaitemsList.add(new Items(cl, className));
                    }else if(item.name.contains(packageName + ".social")){
                        String className = item.name.replace(packageName + ".social.", "");
                        socialitemsList.add(new Items(cl, className));
                    }else if(item.name.contains(packageName + ".storage")){
                        String className = item.name.replace(packageName + ".storage.", "");
                        storageitemsList.add(new Items(cl, className));
                    }else if(item.name.contains(packageName + ".user_interface")){
                        String className = item.name.replace(packageName + ".user_interface.", "");
                        uiitemsList.add(new Items(cl, className));
                    }
                }

                hashMap.put(ANIMATIONS, animitemsList);
                hashMap.put(DEVS, devsitemsList);
                hashMap.put(LOC, locitemsList);
                hashMap.put(MULTIMEDIA, multimediaitemsList);
                hashMap.put(SOCIAL, socialitemsList);
                hashMap.put(STORAGE, storageitemsList);
                hashMap.put(UI, uiitemsList);
            } catch (PackageManager.NameNotFoundException e) {
                Log.e(Constants.DEBUG,e.getMessage());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        public List<Items> getList(String key) {
            return hashMap.get(key);
        }
}
