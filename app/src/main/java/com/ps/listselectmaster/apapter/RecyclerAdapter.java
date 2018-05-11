package com.ps.listselectmaster.apapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ps.listselectmaster.R;
import com.ps.listselectmaster.bean.UserInfo;

import java.util.List;

/**
 * Created : 2018/5/11 16:40
 * Description :
 * Author : gengbaolong
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>{

    private Context mContext;
    private List<UserInfo> mList;

    public RecyclerAdapter(Context context, List<UserInfo> list){
        this.mContext = context;
        this.mList = list;
    }


    @Override
    public int getItemCount() {
        return mList==null?0:mList.size();
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_recycler, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, final int position) {
        UserInfo info = mList.get(position);
        holder.tv_name.setText(info.getName());
        holder.tv_phone.setText(info.getNumber());
        holder.iv_select.setImageResource(info.isSelectFlag()?R.mipmap.xuanze: R.mipmap.weixuanze);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mItemClickListener!=null){
                    mItemClickListener.onItemClick(position);
                }
            }
        });
    }


    public class RecyclerViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_name;
        private TextView tv_phone;
        private ImageView iv_select;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            tv_phone = (TextView) itemView.findViewById(R.id.tv_phone);
            iv_select = (ImageView) itemView.findViewById(R.id.iv_select);
        }
    }

    private OnItemClickListener mItemClickListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.mItemClickListener = listener;
    }

}
