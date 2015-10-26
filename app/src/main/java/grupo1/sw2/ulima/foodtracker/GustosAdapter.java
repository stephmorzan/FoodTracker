package grupo1.sw2.ulima.foodtracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import grupo1.sw2.ulima.foodtracker.model.gustos.GustosRequest;

/**
 * Created by stmorzan on 05/10/2015.
 */
public class GustosAdapter extends BaseAdapter{

    private List<GustosRequest> gustosRequests;
    private LayoutInflater inflater;

    public GustosAdapter(List<GustosRequest> gustosRequests, Context context){
        this.gustosRequests = gustosRequests;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return gustosRequests.size();
    }

    @Override
    public Object getItem(int position) {
        return gustosRequests.get(position);
    }

    @Override
    public long getItemId(int position) {
        return gustosRequests.get(position).getIdCategoria();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if(convertView==null){
            convertView = inflater.inflate(R.layout.item_gusto, parent);

            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        GustosRequest gusto = gustosRequests.get(position);
        viewHolder.cboGusto.setText(gusto.getNombre());
        Picasso.with(inflater.getContext()).load(gusto.getUrl()).into(viewHolder.iviGusto);

        //llamar el nombre del gusto. De acuerdo al nombre, colocar la imagen.

        return convertView;
    }

    public class ViewHolder{
        @Bind(R.id.cboGusto)com.rey.material.widget.CheckBox cboGusto;
        @Bind(R.id.iviGusto) ImageView iviGusto;



        public ViewHolder(View v) {
            ButterKnife.bind(this,v);
        }
    }

}


