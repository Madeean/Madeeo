package id.ac.umn.uts_00000044540_MadeReihanDivaSuarna;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData> {
    List<String> listData;
    LayoutInflater layoutInflater;
    String name;

    public AdapterData(Context context, List<String> listData, String name) {
        this.listData = listData;
        this.layoutInflater = LayoutInflater.from(context);
        this.name = name;
    }




    @NonNull
    @Override
    public AdapterData.HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_data, parent, false);
        return new HolderData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterData.HolderData holder, int position) {
        holder.textdata.setText(listData.get(position));
        int numberPosisi = position + 1;
        String nameVideo = "Video " + numberPosisi;
        Log.i("TAG" , "Posisi: " + nameVideo);
        holder.textdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Video " , Toast.LENGTH_SHORT).show();
            }
        });
        holder.listData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), DetailVideo.class);
                intent.putExtra("name", name);
                intent.putExtra("nameVideo", nameVideo);
                v.getContext().startActivity(intent);
            }
        });

        holder.DelData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "del data dipencet" , Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class HolderData extends RecyclerView.ViewHolder{
        TextView textdata;
        ImageView DelData;
        LinearLayout listData;
        public HolderData(@NonNull View itemView) {
            super(itemView);
            textdata = itemView.findViewById(R.id.namaList);
            DelData = itemView.findViewById(R.id.DelData);
            listData = itemView.findViewById(R.id.listData);

        }
    }
}
