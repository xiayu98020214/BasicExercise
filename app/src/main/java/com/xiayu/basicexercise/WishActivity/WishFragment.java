package com.xiayu.basicexercise.WishActivity;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.xiayu.basicexercise.Mode.WishesData;
import com.xiayu.basicexercise.R;
import com.xiayu.basicexercise.customview.VDHLayout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;


public class WishFragment extends Fragment implements WishContract.View {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String TAG = "WishFragment";
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private WishContract.Present mPresent;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

/*
    private OnFragmentInteractionListener mListener;
*/


    public WishFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WishFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WishFragment newInstance(String param1, String param2) {
        WishFragment fragment = new WishFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public static WishFragment newInstance() {
        WishFragment fragment = new WishFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private List<EditText> wishTvs = new ArrayList<>();
    private EditText addWishEt;
    private Button addWishBn;
    private RecyclerView wishListRv;
    private WishAadapter mAdapter;
    private List<WishesData> wishDatas = new ArrayList<>();
    private ItemTouchHelper mItemTouchHelper;
    private VDHLayout mAllwishes;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_wish, container, false);
        mAllwishes = (VDHLayout)view.findViewById(R.id.allwishes);
 /*       wishTvs.add((EditText) view.findViewById(R.id.wish1));
        wishTvs.add((EditText) view.findViewById(R.id.wish2));
        wishTvs.add((EditText) view.findViewById(R.id.wish3));*/

        initRv(view);

        //  addWishEt = (EditText)view.findViewById(R.id.newwish);


        addWishBn = (Button) view.findViewById(R.id.addwish);
        addWishBn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

/*                for (int i = 0; i < 5; i++) {

                    View view = wishListRv.getChildAt(i);
                    if (null != wishListRv.getChildViewHolder(view)) {
                        WishAadapter.MyViewHolder viewHolder = (WishAadapter.MyViewHolder) wishListRv.getChildViewHolder(view);
                        wishDatas.get(i).setContent(viewHolder.content.getText().toString());
                    }
                }*/
                wishDatas.clear();
                wishDatas.addAll(mAllwishes.getAllWishes());
                mPresent.saveWishes(wishDatas);
            }
        });

        Button move = (Button)view.findViewById(R.id.button);

        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG,"move");
                wishDatas.clear();
                wishDatas.addAll(mAllwishes.getAllWishes());
                mPresent.saveWishes(wishDatas);
            }
        });
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresent.start();
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
/*        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }*/
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
/*        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }*/
    }

    @Override
    public void onDetach() {
        super.onDetach();
        //mListener = null;
    }

    @Override
    public void showWishes(@NonNull List<WishesData> data) {

        checkNotNull(data);
  /*      List<WishesData> temp = new ArrayList<>();
        temp.add(new WishesData("nihao",100,100) );*/
        mAllwishes.setAllWishes(data);
/*        for (int i = 0; i < data.size(); i++) {
            wishTvs.get(i).setText(data.get(i).getContent());
        }*/
/*        wishDatas.clear();
        wishDatas.addAll(data);
        for (int i = wishDatas.size(); i < 5; i++) {
            wishDatas.add(new WishesData("请您输入第" + (i + 1) + "梦想"));
        }
        mAdapter.notifyDataSetChanged();*/


    }

    private void initwishDatas() {
/*        WishesData data = new WishesData();
        data.setContent("第一");
        wishDatas.add(data);
        data = new WishesData();
        data.setContent("第二");
        wishDatas.add(data);
        data = new WishesData();
        data.setContent("第三");
        wishDatas.add(data);
        mAdapter.notifyDataSetChanged();*/
    }

    private void initRv(View view) {
        wishListRv = (RecyclerView) view.findViewById(R.id.wishlist);
        wishListRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new WishAadapter(getActivity(), wishDatas);
        wishListRv.setAdapter(mAdapter);
        initwishDatas();
        mItemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.Callback() {

            @Override
            public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
                    final int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN |
                            ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
                    final int swipeFlags = 0;
                    return makeMovementFlags(dragFlags, swipeFlags);
                } else {
                    final int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
                    final int swipeFlags = 0;
                    return makeMovementFlags(dragFlags, swipeFlags);
                }
            }

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                //得到当拖拽的viewHolder的Position
                int fromPosition = viewHolder.getAdapterPosition();
                //拿到当前拖拽到的item的viewHolder
                int toPosition = target.getAdapterPosition();
                if (fromPosition < toPosition) {
                    for (int i = fromPosition; i < toPosition; i++) {
                        Collections.swap(wishDatas, i, i + 1);
                    }
                } else {
                    for (int i = fromPosition; i > toPosition; i--) {
                        Collections.swap(wishDatas, i, i - 1);
                    }
                }
                mAdapter.notifyItemMoved(fromPosition, toPosition);
                return true;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

            }

            @Override
            public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
                if (actionState != ItemTouchHelper.ACTION_STATE_IDLE) {
                    viewHolder.itemView.setBackgroundColor(Color.LTGRAY);
                }
                super.onSelectedChanged(viewHolder, actionState);
            }

            @Override
            public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                super.clearView(recyclerView, viewHolder);
                viewHolder.itemView.setBackgroundColor(0);
            }
        });
        mItemTouchHelper.attachToRecyclerView(wishListRv);
    }

    @Override
    public void showSaveSuc() {
        Snackbar.make(getView(), "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();

    }

    @Override
    public void showNoWish() {
        Snackbar.make(getView(), "No wishes", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    @Override
    public boolean isActive() {
        return isAdded();
    }

    @Override
    public void setPresenter(WishContract.Present presenter) {
        mPresent = presenter;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
/*    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }*/


    public static class WishAadapter extends RecyclerView.Adapter<WishAadapter.MyViewHolder> {

        private List<WishesData> wishData;
        private Context mContext;

        public WishAadapter(Context context, List<WishesData> data) {
            mContext = context;
            wishData = data;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                    mContext).inflate(R.layout.item_wish, parent,
                    false));
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            WishesData data = wishData.get(position);
            holder.content.setText(data.getContent());
        }

        @Override
        public int getItemCount() {
            return wishData.size();
        }


        public static class MyViewHolder extends RecyclerView.ViewHolder {
            private EditText content;

            public MyViewHolder(View itemView) {
                super(itemView);
                content = (EditText) itemView.findViewById(R.id.content);
            }
        }
    }

}
