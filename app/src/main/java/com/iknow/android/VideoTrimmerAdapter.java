package com.iknow.android;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.iknow.android.utils.TrimVideoUtil;
import java.util.ArrayList;
import java.util.List;

/**
 * author : J.Chou
 * e-mail : who_know_me@163.com
 * time   : 2018/05/30/4:20 PM
 * version: 1.0
 * description:
 */
public class VideoTrimmerAdapter extends RecyclerView.Adapter {
  private List<Bitmap> bitmaps = new ArrayList<>();
  private LayoutInflater inflater;
  private Context context;

  public VideoTrimmerAdapter(Context context) {
    this.context = context;
    this.inflater = LayoutInflater.from(context);
  }

  @NonNull @Override public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return new TrimmerViewHolder(inflater.inflate(R.layout.video_thumb_item_layout, parent, false));
  }

  @Override public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
    ((TrimmerViewHolder) holder).thumbImageView.setImageBitmap(bitmaps.get(position));
  }

  @Override public int getItemCount() {
    return bitmaps.size();
  }

  public void addBitmaps(Bitmap bitmap) {
    bitmaps.add(bitmap);
    notifyDataSetChanged();
  }

  private final class TrimmerViewHolder extends RecyclerView.ViewHolder {
    ImageView thumbImageView;

    TrimmerViewHolder(View itemView) {
      super(itemView);
      thumbImageView = itemView.findViewById(R.id.thumb);
      LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) thumbImageView.getLayoutParams();
      layoutParams.width = TrimVideoUtil.VIDEO_FRAMES_WIDTH / TrimVideoUtil.MAX_COUNT_RANGE;
      thumbImageView.setLayoutParams(layoutParams);
    }
  }
}
