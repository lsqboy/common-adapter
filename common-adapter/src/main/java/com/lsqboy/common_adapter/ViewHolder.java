package com.lsqboy.common_adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Common ViewHolder
 * <p>
 * Created by lsqboy_lian on 16-11-21.
 * Email：g.lsqboy@gmail.com
 * Copyright (c) 2016,lsqboy.com All Rights Reserved.
 */
public class ViewHolder {
    private final SparseArray<View> mViews;
    private int mPosition;
    private View mConvertView;
    private Context mContext;

    private ViewHolder(Context context, ViewGroup parent, int layoutId,
                       int position) {
        this.mPosition = position;
        this.mContext = context;
        this.mViews = new SparseArray<>();
        mConvertView = LayoutInflater.from(context).inflate(layoutId, parent,
                false);
        // setTag
        mConvertView.setTag(this);
    }

    /**
     * 拿到一个ViewHolder对象
     *
     * @param context context
     * @param convertView convertView
     * @param parent parent
     * @param layoutId layoutId
     * @param position position
     * @return ViewHolder
     */
    public static ViewHolder get(Context context, View convertView,
                                 ViewGroup parent, int layoutId, int position) {
        if (convertView == null) {
            return new ViewHolder(context, parent, layoutId, position);
        }
        return (ViewHolder) convertView.getTag();
    }

    public View getConvertView() {
        return mConvertView;
    }

    /**
     * 通过控件的Id获取对于的控件，如果没有则加入views
     *
     * @param viewId viewId
     * @return <T extends View>
     */
    @SuppressWarnings("unchecked")
    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    /**
     * 为TextView设置字符串
     *
     * @param viewId viewId
     * @param text text
     * @return ViewHolder
     */
    public ViewHolder setText(int viewId, String text) {
        TextView view = getView(viewId);
        view.setText(text);
        return this;
    }

    /**
     * 为ImageView设置图片
     *
     * @param viewId viewId
     * @param drawableId drawableId
     * @return ViewHolder
     */
    public ViewHolder setImageResource(int viewId, int drawableId) {
        ImageView view = getView(viewId);
        view.setImageResource(drawableId);

        return this;
    }

    /**
     * 为ImageView设置图片
     *
     * @param viewId viewId
     * @param bm bm
     * @return ViewHolder
     */
    public ViewHolder setImageBitmap(int viewId, Bitmap bm) {
        ImageView view = getView(viewId);
        view.setImageBitmap(bm);
        return this;
    }

    /**
     * 为ImageView设置图片
     *
     * @param viewId viewId
     * @param url url
     * @return ViewHolder
     */
    public ViewHolder setImageByUrl(int viewId, String url) {
        ImageView view = getView(viewId);
        Glide.with(mContext).load(url).crossFade().error(android.R.drawable.stat_notify_error).into(view);
        return this;
    }

    /**
     * getPosition
     *
     * @return position
     */
    public int getPosition() {
        return mPosition;
    }

}
