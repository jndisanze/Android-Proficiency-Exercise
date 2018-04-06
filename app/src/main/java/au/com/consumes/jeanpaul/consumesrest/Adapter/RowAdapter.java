package au.com.consumes.jeanpaul.consumesrest.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import au.com.consumes.jeanpaul.consumesrest.R;
import au.com.consumes.jeanpaul.consumesrest.Row;

public class RowAdapter extends RecyclerView.Adapter<RowAdapter.CustomViewHolder> {
    private ArrayList<Row> rowListList;
    private Context context;

    public RowAdapter(ArrayList<Row> rowList, Context context){
           this.rowListList = rowList;
           this.context = context;
    }
    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_rows, parent, false);

        return new CustomViewHolder(itemView);
    }
    @Override
    public int getItemCount() {
        return this.rowListList.size();
    }
    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        Row aRow = this.rowListList.get(position);
        holder.titleTextView.setText(aRow.getTitle());
        holder.descriptionTextView.setText(aRow.getDescription());
        Picasso.with(this.context).load(aRow.getImageHref()).into(holder.imageView);
    }
    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public TextView urlImageTextView,descriptionTextView,titleTextView;
        public ImageView imageView;

        public CustomViewHolder(View view) {
            super(view);
            titleTextView = (TextView) view.findViewById(R.id.title);
            descriptionTextView = (TextView) view.findViewById(R.id.description);
            imageView = (ImageView) view.findViewById(R.id.urlImage);

        }
    }

}
