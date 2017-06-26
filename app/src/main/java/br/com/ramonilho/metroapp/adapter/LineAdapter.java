package br.com.ramonilho.metroapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.ramonilho.metroapp.R;
import br.com.ramonilho.metroapp.api.APIUtils;
import br.com.ramonilho.metroapp.model.Line;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by logonrm on 26/06/2017.
 */

public class LineAdapter extends RecyclerView.Adapter<LineAdapter.LineViewHolder> {
    private List<Line> lines;

    public LineAdapter(List<Line> lines) {
        this.lines = lines;
    }

    @Override
    public LineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        // Inflates the layout
        View myLayout = inflater.inflate(R.layout.line_row, parent, false);

        return new LineViewHolder(myLayout);
    }

    @Override
    public void onBindViewHolder(LineViewHolder holder, int position) {

        holder.tvTitulo.setText(lines.get(position).getCor());
        holder.tvSubTitulo.setText(lines.get(position).getNumero());

        Picasso.with(holder.itemView.getContext())
                .load(APIUtils.BASE_URL+lines.get(position).getUrlImagem())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(holder.ivLogo);

    }

    @Override
    public int getItemCount() {
        return lines.size();
    }

    class LineViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.ivLogo) ImageView ivLogo;
        @BindView(R.id.tvTitulo) TextView tvTitulo;
        @BindView(R.id.tvSubtitulo) TextView tvSubTitulo;

        public LineViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }

    public void update(List<Line> lines) {
        this.lines = lines;
        notifyDataSetChanged();
    }
}
